package com.example.demo_retrofit.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class  rest_resource implements Serializable
{

    @SerializedName("ResponseCode")
    @Expose
    private String responseCode;
    @SerializedName("ResponseMessage")
    @Expose
    private String responseMessage;
    @SerializedName("data")
    @Expose
    private ArrayList<Datum> data = null;

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public ArrayList<Datum> getData() {
        return data;
    }

    public void setData(ArrayList<Datum> data) {
        this.data = data;
    }




    public class Datum implements Serializable {

        @SerializedName("order_id")
        @Expose
        private Integer orderId;
        @SerializedName("user_id")
        @Expose
        private Integer userId;
        @SerializedName("restaurant_id")
        @Expose
        private Integer restaurantId;
        @SerializedName("user_name")
        @Expose
        private String userName;
        @SerializedName("restaurant_name")
        @Expose
        private String restaurantName;
        @SerializedName("contact_no")
        @Expose
        private String contactNo;
        @SerializedName("address")
        @Expose
        private String address;
        @SerializedName("restaurant_address")
        @Expose
        private String restaurantAddress;
        @SerializedName("status")
        @Expose
        private String status;
        @SerializedName("product_code")
        @Expose
        private String productCode;
        @SerializedName("start_time")
        @Expose
        private String startTime;
        @SerializedName("end_time")
        @Expose
        private String endTime;
        @SerializedName("restaurant_image")
        @Expose
        private String restaurantImage;
        @SerializedName("latitude")
        @Expose
        private String latitude;
        @SerializedName("longitude")
        @Expose
        private String longitude;
        @SerializedName("food_detail")
        @Expose
        private List<FoodDetail> foodDetail = null;

        public Integer getOrderId() {
            return orderId;
        }

        public void setOrderId(Integer orderId) {
            this.orderId = orderId;
        }

        public Integer getUserId() {
            return userId;
        }

        public void setUserId(Integer userId) {
            this.userId = userId;
        }

        public Integer getRestaurantId() {
            return restaurantId;
        }

        public void setRestaurantId(Integer restaurantId) {
            this.restaurantId = restaurantId;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getRestaurantName() {
            return restaurantName;
        }

        public void setRestaurantName(String restaurantName) {
            this.restaurantName = restaurantName;
        }

        public String getContactNo() {
            return contactNo;
        }

        public void setContactNo(String contactNo) {
            this.contactNo = contactNo;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getRestaurantAddress() {
            return restaurantAddress;
        }

        public void setRestaurantAddress(String restaurantAddress) {
            this.restaurantAddress = restaurantAddress;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getProductCode() {
            return productCode;
        }

        public void setProductCode(String productCode) {
            this.productCode = productCode;
        }

        public String getStartTime() {
            return startTime;
        }

        public void setStartTime(String startTime) {
            this.startTime = startTime;
        }

        public String getEndTime() {
            return endTime;
        }

        public void setEndTime(String endTime) {
            this.endTime = endTime;
        }

        public String getRestaurantImage() {
            return restaurantImage;
        }

        public void setRestaurantImage(String restaurantImage) {
            this.restaurantImage = restaurantImage;
        }

        public String getLatitude() {
            return latitude;
        }

        public void setLatitude(String latitude) {
            this.latitude = latitude;
        }

        public String getLongitude() {
            return longitude;
        }

        public void setLongitude(String longitude) {
            this.longitude = longitude;
        }

        public List<FoodDetail> getFoodDetail() {
            return foodDetail;
        }

        public void setFoodDetail(List<FoodDetail> foodDetail) {
            this.foodDetail = foodDetail;
        }

    }

    public class FoodDetail implements Serializable
    {

        @SerializedName("food_id")
        @Expose
        private Integer foodId;
        @SerializedName("food_name")
        @Expose
        private String foodName;
        @SerializedName("description")
        @Expose
        private String description;
        @SerializedName("quantity")
        @Expose
        private Integer quantity;
        @SerializedName("original_price")
        @Expose
        private Integer originalPrice;
        @SerializedName("total_price")
        @Expose
        private Integer totalPrice;
        @SerializedName("food_image")
        @Expose
        private String foodImage;

        public Integer getFoodId() {
            return foodId;
        }

        public void setFoodId(Integer foodId) {
            this.foodId = foodId;
        }

        public String getFoodName() {
            return foodName;
        }

        public void setFoodName(String foodName) {
            this.foodName = foodName;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public Integer getQuantity() {
            return quantity;
        }

        public void setQuantity(Integer quantity) {
            this.quantity = quantity;
        }

        public Integer getOriginalPrice() {
            return originalPrice;
        }

        public void setOriginalPrice(Integer originalPrice) {
            this.originalPrice = originalPrice;
        }

        public Integer getTotalPrice() {
            return totalPrice;
        }

        public void setTotalPrice(Integer totalPrice) {
            this.totalPrice = totalPrice;
        }

        public String getFoodImage() {
            return foodImage;
        }

        public void setFoodImage(String foodImage) {
            this.foodImage = foodImage;
        }

    }

}