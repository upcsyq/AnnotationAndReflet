package com.jacky.myapplication;

/**
 * Created by jackyshu at 2019/5/13
 *
 * @description:
 */
public class MessageEvent {
    private String message;
    public  MessageEvent(String message){
        this.message=message;
    }
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
