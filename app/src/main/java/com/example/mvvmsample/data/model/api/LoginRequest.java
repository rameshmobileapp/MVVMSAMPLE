package com.example.mvvmsample.data.model.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginRequest {


    @Expose
    @SerializedName("user_name")
    private String userName;

    @Expose
    @SerializedName("email")
    private String Email;

    @Expose
    @SerializedName("mobile_number")
    private String mobileNumber;

    @Expose
    @SerializedName("password")
    private String password;


    public LoginRequest(String userName, String email, String mobileNumber, String password) {
        this.userName = userName;
        Email = email;
        this.mobileNumber = mobileNumber;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
