package com.example.servicefeign.dto;

public class ResponseDto<T> {
    public ResponseDto() {
        code = "0";
        msg = "";
    }

    public ResponseDto(String code) {
        this.code = code;
        msg = "";
    }

    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    private T content;

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }
}
