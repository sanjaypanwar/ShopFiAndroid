package com.android.shopfi.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Outlet {

@SerializedName("_id")
@Expose
private String id;
@SerializedName("outlet_wifi_bssid")
@Expose
private String outletWifiBssid;
@SerializedName("outlet_wifi_ssid")
@Expose
private String outletWifiSsid;
@SerializedName("outlet_wifi_name")
@Expose
private String outletWifiName;
@SerializedName("outlet_geo_latitude")
@Expose
private double outletGeoLatitude;
@SerializedName("outlet_geo_longitude")
@Expose
private double outletGeoLongitude;
@SerializedName("outlet_title_name")
@Expose
private String outletTitleName;
@SerializedName("outlet_description")
@Expose
private String outletDescription;
@SerializedName("outlet_brand_image")
@Expose
private String outletBrandImage;
@SerializedName("outlet_web_site")
@Expose
private String outletWebSite;
@SerializedName("outlet_contact_number1")
@Expose
private String outletContactNumber1;
@SerializedName("outlet_contact_number2")
@Expose
private String outletContactNumber2;
@SerializedName("outlet_email")
@Expose
private String outletEmail;
@SerializedName("outlet_type")
@Expose
private String outletType;
@SerializedName("address1")
@Expose
private String address1;
@SerializedName("address2")
@Expose
private String address2;
@SerializedName("city")
@Expose
private String city;
@SerializedName("state")
@Expose
private String state;
@SerializedName("postal_code")
@Expose
private String postalCode;
@SerializedName("country")
@Expose
private String country;
@SerializedName("outlet_avg_user_rating")
@Expose
private double outletAvgUserRating;
@SerializedName("opening_time")
@Expose
private Object openingTime;
@SerializedName("closing_time")
@Expose
private Object closingTime;
@SerializedName("offers")
@Expose
private List<Offer> offers = null;
@SerializedName("created_at")
@Expose
private String createdAt;

public String getId() {
return id;
}

public void setId(String id) {
this.id = id;
}

public String getOutletWifiBssid() {
return outletWifiBssid;
}

public void setOutletWifiBssid(String outletWifiBssid) {
this.outletWifiBssid = outletWifiBssid;
}

public String getOutletWifiSsid() {
return outletWifiSsid;
}

public void setOutletWifiSsid(String outletWifiSsid) {
this.outletWifiSsid = outletWifiSsid;
}

public String getOutletWifiName() {
return outletWifiName;
}

public void setOutletWifiName(String outletWifiName) {
this.outletWifiName = outletWifiName;
}

public double getOutletGeoLatitude() {
return outletGeoLatitude;
}

public void setOutletGeoLatitude(double outletGeoLatitude) {
this.outletGeoLatitude = outletGeoLatitude;
}

public double getOutletGeoLongitude() {
return outletGeoLongitude;
}

public void setOutletGeoLongitude(double outletGeoLongitude) {
this.outletGeoLongitude = outletGeoLongitude;
}

public String getOutletTitleName() {
return outletTitleName;
}

public void setOutletTitleName(String outletTitleName) {
this.outletTitleName = outletTitleName;
}

public String getOutletDescription() {
return outletDescription;
}

public void setOutletDescription(String outletDescription) {
this.outletDescription = outletDescription;
}

public String getOutletBrandImage() {
return outletBrandImage;
}

public void setOutletBrandImage(String outletBrandImage) {
this.outletBrandImage = outletBrandImage;
}

public String getOutletWebSite() {
return outletWebSite;
}

public void setOutletWebSite(String outletWebSite) {
this.outletWebSite = outletWebSite;
}

public String getOutletContactNumber1() {
return outletContactNumber1;
}

public void setOutletContactNumber1(String outletContactNumber1) {
this.outletContactNumber1 = outletContactNumber1;
}

public String getOutletContactNumber2() {
return outletContactNumber2;
}

public void setOutletContactNumber2(String outletContactNumber2) {
this.outletContactNumber2 = outletContactNumber2;
}

public String getOutletEmail() {
return outletEmail;
}

public void setOutletEmail(String outletEmail) {
this.outletEmail = outletEmail;
}

public String getOutletType() {
return outletType;
}

public void setOutletType(String outletType) {
this.outletType = outletType;
}

public String getAddress1() {
return address1;
}

public void setAddress1(String address1) {
this.address1 = address1;
}

public String getAddress2() {
return address2;
}

public void setAddress2(String address2) {
this.address2 = address2;
}

public String getCity() {
return city;
}

public void setCity(String city) {
this.city = city;
}

public String getState() {
return state;
}

public void setState(String state) {
this.state = state;
}

public String getPostalCode() {
return postalCode;
}

public void setPostalCode(String postalCode) {
this.postalCode = postalCode;
}

public String getCountry() {
return country;
}

public void setCountry(String country) {
this.country = country;
}

public double getOutletAvgUserRating() {
return outletAvgUserRating;
}

public void setOutletAvgUserRating(double outletAvgUserRating) {
this.outletAvgUserRating = outletAvgUserRating;
}

public Object getOpeningTime() {
return openingTime;
}

public void setOpeningTime(Object openingTime) {
this.openingTime = openingTime;
}

public Object getClosingTime() {
return closingTime;
}

public void setClosingTime(Object closingTime) {
this.closingTime = closingTime;
}

public List<Offer> getOffers() {
return offers;
}

public void setOffers(List<Offer> offers) {
this.offers = offers;
}

public String getCreatedAt() {
return createdAt;
}

public void setCreatedAt(String createdAt) {
this.createdAt = createdAt;
}

}