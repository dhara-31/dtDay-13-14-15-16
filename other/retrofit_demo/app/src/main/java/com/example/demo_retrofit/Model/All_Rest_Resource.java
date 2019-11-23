package com.example.demo_retrofit.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class All_Rest_Resource
{


    public class Datum {

        @SerializedName("restaurant_id")
        @Expose
        private Integer restaurantId;
        @SerializedName("is_favourite")
        @Expose
        private String isFavourite;
        @SerializedName("restaurant_name")
        @Expose
        private String restaurantName;
        @SerializedName("address")
        @Expose
        private String address;
        @SerializedName("latitude")
        @Expose
        private String latitude;
        @SerializedName("longitude")
        @Expose
        private String longitude;
        @SerializedName("home_delivery")
        @Expose
        private Integer homeDelivery;
        @SerializedName("pickup_time")
        @Expose
        private String pickupTime;
        @SerializedName("pickup_start_time")
        @Expose
        private String pickupStartTime;
        @SerializedName("pickup_end_time")
        @Expose
        private String pickupEndTime;
        @SerializedName("restaurant_image")
        @Expose
        private String restaurantImage;
        @SerializedName("color")
        @Expose
        private String color;
        @SerializedName("temp_start_time")
        @Expose
        private Integer tempStartTime;
        @SerializedName("temp_end_time")
        @Expose
        private Integer tempEndTime;
        @SerializedName("hours")
        @Expose
        private List<Hour> hours = null;
        @SerializedName("distance")
        @Expose
        private Double distance;
        @SerializedName("food_price")
        @Expose
        private List<FoodPrice> foodPrice = null;

        public Integer getRestaurantId() {
            return restaurantId;
        }

        public void setRestaurantId(Integer restaurantId) {
            this.restaurantId = restaurantId;
        }

        public String getIsFavourite() {
            return isFavourite;
        }

        public void setIsFavourite(String isFavourite) {
            this.isFavourite = isFavourite;
        }

        public String getRestaurantName() {
            return restaurantName;
        }

        public void setRestaurantName(String restaurantName) {
            this.restaurantName = restaurantName;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
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

        public Integer getHomeDelivery() {
            return homeDelivery;
        }

        public void setHomeDelivery(Integer homeDelivery) {
            this.homeDelivery = homeDelivery;
        }

        public String getPickupTime() {
            return pickupTime;
        }

        public void setPickupTime(String pickupTime) {
            this.pickupTime = pickupTime;
        }

        public String getPickupStartTime() {
            return pickupStartTime;
        }

        public void setPickupStartTime(String pickupStartTime) {
            this.pickupStartTime = pickupStartTime;
        }

        public String getPickupEndTime() {
            return pickupEndTime;
        }

        public void setPickupEndTime(String pickupEndTime) {
            this.pickupEndTime = pickupEndTime;
        }

        public String getRestaurantImage() {
            return restaurantImage;
        }

        public void setRestaurantImage(String restaurantImage) {
            this.restaurantImage = restaurantImage;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public Integer getTempStartTime() {
            return tempStartTime;
        }

        public void setTempStartTime(Integer tempStartTime) {
            this.tempStartTime = tempStartTime;
        }

        public Integer getTempEndTime() {
            return tempEndTime;
        }

        public void setTempEndTime(Integer tempEndTime) {
            this.tempEndTime = tempEndTime;
        }

        public List<Hour> getHours() {
            return hours;
        }

        public void setHours(List<Hour> hours) {
            this.hours = hours;
        }

        public Double getDistance() {
            return distance;
        }

        public void setDistance(Double distance) {
            this.distance = distance;
        }

        public List<FoodPrice> getFoodPrice() {
            return foodPrice;
        }

        public void setFoodPrice(List<FoodPrice> foodPrice) {
            this.foodPrice = foodPrice;
        }

    }



        @SerializedName("ResponseCode")
        @Expose
        private String responseCode;
        @SerializedName("ResponseMessage")
        @Expose
        private String responseMessage;
        @SerializedName("data")
        @Expose
        private List<Datum> data = null;

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

        public List<Datum> getData() {
            return data;
        }

        public void setData(List<Datum> data) {
            this.data = data;
        }


    public class FoodPrice {

        @SerializedName("price")
        @Expose
        private String price;

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

    }

    public class Hour {

        @SerializedName("day_of_week")
        @Expose
        private String dayOfWeek;
        @SerializedName("start_time")
        @Expose
        private String startTime;
        @SerializedName("end_time")
        @Expose
        private String endTime;
        @SerializedName("offered")
        @Expose
        private String offered;

        public String getDayOfWeek() {
            return dayOfWeek;
        }

        public void setDayOfWeek(String dayOfWeek) {
            this.dayOfWeek = dayOfWeek;
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

        public String getOffered() {
            return offered;
        }

        public void setOffered(String offered) {
            this.offered = offered;
        }

    }


}