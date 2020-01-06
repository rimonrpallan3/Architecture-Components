package com.voyager.architecturecomponents.activity.ApiTestBarsti.model;

import com.google.gson.annotations.SerializedName;
import com.voyager.architecturecomponents.activity.Bloger.model.Blog;

import java.util.ArrayList;
import java.util.List;

public class TestWrapper {

    @SerializedName("data")
    private ArrayList<TestList> mData;
    @SerializedName("error")
    private Boolean mError;
    @SerializedName("message")
    private String mMessage;
    @SerializedName("status")
    private String mStatus;

    public ArrayList<TestList> getTesstTestLists() {
        return mData;
    }

    public ArrayList<TestList> getmData() {
        return mData;
    }

    public void setmData(ArrayList<TestList> mData) {
        this.mData = mData;
    }

    public Boolean getmError() {
        return mError;
    }

    public void setmError(Boolean mError) {
        this.mError = mError;
    }

    public String getmMessage() {
        return mMessage;
    }

    public void setmMessage(String mMessage) {
        this.mMessage = mMessage;
    }

    public String getmStatus() {
        return mStatus;
    }

    public void setmStatus(String mStatus) {
        this.mStatus = mStatus;
    }
}
