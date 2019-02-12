# servlet-base
## 概要
ServletとValidationを完全分離させ、可読性を向上させるためのライブラリ。
## クラス関係
AbstractServlet has AbstractValidation.
## 実装例
バリデーションクラス「MyLoginValidation」
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
---
サーブレットクラス「MyLoginServlet」
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
