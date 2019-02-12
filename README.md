# servlet-base
This software is released under the MIT License, see LICENSE.
## Overview
In order to improve readability, it provide a mechanism to implement servlet and validation separately.
## Classes reration
AbstractServlet has AbstractValidation.
## Example
MyLoginValidation
~~~
package com.expcube.test.validation;


import com.expcube.main.validation.AbstractValidation;

import javax.servlet.http.HttpServletRequest;

public class MyLoginValidation extends AbstractValidation {

    @Override
    public boolean validate(HttpServletRequest req) {
        // 具体的な処理
        return true;
    }

}
~~~

MyLoginServlet
~~~
package com.expcube.test.servlet;

import com.expcube.main.servlet.AbstractServlet;
import com.expcube.test.validation.MyLoginValidation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyLoginServlet extends AbstractServlet<MyLoginValidation> {

    @Override
    protected void succeeded(HttpServletRequest req, HttpServletResponse res) {
        // 具体的な処理
    }

    @Override
    protected void failed(HttpServletRequest req, HttpServletResponse res) {
        // 具体的な処理
    }

    @Override
    protected Class<MyLoginValidation> getValidationClass() {
        return MyLoginValidation.class;
    }

}
~~~
