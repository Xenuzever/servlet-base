package com.expcube.validation;

import javax.servlet.http.HttpServletRequest;

public abstract class AbstractValidation {

    // 検証結果のメッセージ
    private String message;

    /**
     * コンストラクタです。<br></>
     */
    public AbstractValidation() {
        clearMessage();
    }

    /**
     * リクエストを元に検証を行います。<br></>
     * @param req リクエストを渡します。
     * @return 処理の続行が可能な場合trueを返却します。
     */
    public abstract boolean validate(HttpServletRequest req);

    /**
     * 検証結果のメッセージを設定します。<br></>
     * @param message 検証結果のメッセージを渡します。
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * 検証結果のメッセージを取得します。<br></>
     * @return 検証結果のメッセージを返却します。
     */
    public String getMessage() {
        return message;
    }

    /**
     * 検証結果のメッセージをブランクにします。<br></>
     */
    public void clearMessage() {
        message = "";
    }

    /**
     * 検証結果のメッセージが存在しているかを取得します。<br></>
     * @return 存在している場合trueを返却します。
     */
    public boolean hasMessage() {
        return !message.isEmpty();
    }

}
