package com.android.shopfi.rest;

import com.android.shopfi.response.AllDealsResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface ApiInterface {
    @POST("deals_near_me")
    Call<AllDealsResponse> getMyDeals(@Body DealsRequest jsonBody);

    @GET("movie/{id}")
    Call<AllDealsResponse> getDealsDetails(@Path("id") int id, @Query("api_key") String apiKey);
}
