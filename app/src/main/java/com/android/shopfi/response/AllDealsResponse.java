package com.android.shopfi.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by inzimam.islam on 30/12/17.
 */

public class AllDealsResponse {

    @SerializedName("outlets")
    @Expose
    private List<Outlet> outlets = null;

    public List<Outlet> getOutlets() {
        return outlets;
    }

    public void setOutlets(List<Outlet> outlets) {
        this.outlets = outlets;
    }
}
