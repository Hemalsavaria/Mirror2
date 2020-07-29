package com.e.mirror.Model;

import com.google.gson.annotations.SerializedName;

public class Result {


    @SerializedName("status")
    private Boolean success;

    @SerializedName("message")
    private String message;


    @SerializedName("userData")
    private Profile_data data;


    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Profile_data getData() {
        return data;
    }

    public void setData(Profile_data data) {
        this.data = data;
    }
}
