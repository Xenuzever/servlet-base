package com.expcube.validation;

import javax.servlet.http.HttpServletRequest;

public abstract class AbstractValidation {

    /**
     * リクエストを元に検証を行います。<br></>
     * @param req リクエストを渡します。
     * @return 処理の続行が可能な場合trueを返却します。
     */
    public abstract boolean validate(HttpServletRequest req);

}
