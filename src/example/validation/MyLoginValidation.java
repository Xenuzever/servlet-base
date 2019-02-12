package example.validation;


import com.expcube.validation.AbstractValidation;

import javax.servlet.http.HttpServletRequest;

public class MyLoginValidation extends AbstractValidation {

    @Override
    public boolean validate(HttpServletRequest req) {
        // 具体的な処理
        return true;
    }

}