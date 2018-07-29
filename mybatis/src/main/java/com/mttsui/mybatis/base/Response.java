package com.mttsui.mybatis.base;

public class Response {

    private int status;

    private String message;

    public static Response OK(){
        Response response = new Response();
        response.setStatus(200);
        response.setMessage("操作成功");
        return response;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
