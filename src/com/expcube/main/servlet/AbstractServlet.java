package com.expcube.main.servlet;

import com.expcube.main.exception.ValidationNotFoundException;
import com.expcube.main.validation.AbstractValidation;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class AbstractServlet<V extends AbstractValidation> extends HttpServlet {

    // リクエスト検証用インスタンス
    protected final V validation;

    /**
     * コンストラクタです。<br></>
     */
    public AbstractServlet() {
        try {
            // 検証用クラスをインスタンス化する。
            validation = getValidationClass().newInstance();
        }
        // リフレクション関連の例外は、ValidationNotFoundExceptionに集約する。
        catch (InstantiationException | IllegalAccessException e) {
            throw new ValidationNotFoundException(e);
        }
    }

    /**
     * 検証成功時のサーブレット処理を行います。<br></>
     * 当メソッドは、検証クラスにて処理が続行できると判断された場合に呼ばれます。<br></>
     * @param req リクエストを渡します。
     * @param res レスポンスを渡します。
     */
    protected abstract void succeeded(HttpServletRequest req, HttpServletResponse res);

    /**
     * 検証失敗時のサーブレット処理を行います。<br></>
     * 当メソッドは、検証クラスにて処理が続行できないと判断された場合に呼ばれます。<br></>
     * @param req リクエストを渡します。
     * @param res レスポンスを渡します。
     */
    protected abstract void failed(HttpServletRequest req, HttpServletResponse res);

    /**
     * 検証用クラスを取得します。<br></>
     * @return 検証用クラスを返却します。
     */
    protected abstract Class<V> getValidationClass();

    @Override
    protected final void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        if (validation.validate(req)) succeeded(req, res);
        else failed(req, res);
    }

    @Override
    protected final void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        doGet(req, res);
    }

}
