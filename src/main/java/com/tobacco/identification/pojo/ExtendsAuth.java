package com.tobacco.identification.pojo;

import java.io.Serializable;

public class ExtendsAuth implements Serializable {

    private static final long serialVersionUID = 3864518570982188069L;
    private HandleUser editor;
    private int authopt;

    public ExtendsAuth() {
    }

    public HandleUser getEditor() {
        return this.editor;
    }

    public ExtendsAuth setEditor(HandleUser editor) {
        this.editor = editor;
        return this;
    }

    public int getAuthopt() {
        return this.authopt;
    }

    public ExtendsAuth setAuthopt(int authopt) {
        this.authopt = authopt;
        return this;
    }
}