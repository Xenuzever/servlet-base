# servlet-base
This library is released under the MIT License, see LICENSE.
## Overview
In order to improve readability, it provide a mechanism to implement servlet and validation separately.
## Classes relation
AbstractServlet has AbstractValidation.
## Environment
JDK1.8.0
## Example
MyLoginServlet
~~~
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

MyLoginValidation
~~~
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
