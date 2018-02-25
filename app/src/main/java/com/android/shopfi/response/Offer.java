package com.android.shopfi.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Offer {

@SerializedName("offer_end_date")
@Expose
private String offerEndDate;
@SerializedName("offer_start_date")
@Expose
private String offerStartDate;
@SerializedName("offer_conditions")
@Expose
private String offerConditions;
@SerializedName("offer_description")
@Expose
private String offerDescription;
@SerializedName("offer_promo_image")
@Expose
private String offerPromoImage;
@SerializedName("offer_logo")
@Expose
private String offerLogo;
@SerializedName("offer_title")
@Expose
private String offerTitle;
@SerializedName("offer_id")
@Expose
private String offerId;

public String getOfferEndDate() {
return offerEndDate;
}

public void setOfferEndDate(String offerEndDate) {
this.offerEndDate = offerEndDate;
}

public String getOfferStartDate() {
return offerStartDate;
}

public void setOfferStartDate(String offerStartDate) {
this.offerStartDate = offerStartDate;
}

public String getOfferConditions() {
return offerConditions;
}

public void setOfferConditions(String offerConditions) {
this.offerConditions = offerConditions;
}

public String getOfferDescription() {
return offerDescription;
}

public void setOfferDescription(String offerDescription) {
this.offerDescription = offerDescription;
}

public String getOfferPromoImage() {
return offerPromoImage;
}

public void setOfferPromoImage(String offerPromoImage) {
this.offerPromoImage = offerPromoImage;
}

public String getOfferLogo() {
return offerLogo;
}

public void setOfferLogo(String offerLogo) {
this.offerLogo = offerLogo;
}

public String getOfferTitle() {
return offerTitle;
}

public void setOfferTitle(String offerTitle) {
this.offerTitle = offerTitle;
}

public String getOfferId() {
return offerId;
}

public void setOfferId(String offerId) {
this.offerId = offerId;
}

}