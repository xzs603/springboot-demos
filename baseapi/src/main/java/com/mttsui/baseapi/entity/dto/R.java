package com.mttsui.baseapi.entity.dto;

import org.springframework.http.HttpStatus;

import java.io.Serializable;

/**
 * @Author: zsxu2
 * @Date 2018/11/13 11:28
 */
public class R<T> implements Serializable {

    private int code;

    private String message;

    private T data;

    public static R success(){
        R r = new R();
        r.setCode(HttpStatus.OK.value());
        r.setMessage("操作成功！");
        return r;
    }

    public static R success(Object data){
        R r = new R();
        r.setCode(HttpStatus.OK.value());
        r.setMessage("操作成功！");
        return r;
    }

    public static R clientFail(String message){
        R r = new R();
        r.setCode(HttpStatus.BAD_REQUEST.value());
        r.setMessage(message);
        return r;
    }

    public static R serverFail(String message){
        R r = new R();
        r.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        r.setMessage(message);
        return r;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "R{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
