package com.example.registerlogin.response;

public class LoginResponse {

    String message;
    Boolean statues;

    public LoginResponse(String message, Boolean statues) {
        this.message = message;
        this.statues = statues;
    }

    public LoginResponse() {
    }

    public String getMessage() {
        return message;
    }

    public Boolean getStatues() {
        return statues;
    }


    public void setMessage(String message) {
        this.message = message;
    }

    public void setStatues(Boolean statues) {
        this.statues = statues;
    }

    @Override
    public String toString() {
        return "LoginResponse{" +
                "message='" + message + '\'' +
                ", statues=" + statues +
                '}';
    }
}
