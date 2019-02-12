package example.servlet;

import com.expcube.servlet.AbstractServlet;
import example.validation.MyLoginValidation;

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
