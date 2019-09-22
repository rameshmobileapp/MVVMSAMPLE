package com.example.mvvmsample.data.model.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginResponse {


    @Expose
    @SerializedName("user_id")
    private String userId;

    @Expose
    @SerializedName("user_name")
    private String userName;

    @Expose
    @SerializedName("password")
    private String password;

    @Expose
    @SerializedName("message")
    private String message;

    @Expose
    @SerializedName("status_ode")
    private String statusCode;


    public LoginResponse(String userId, String userName, String password, String message, String statusCode) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.message = message;
        this.statusCode = statusCode;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }
}
