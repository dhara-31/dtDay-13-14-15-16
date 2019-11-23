package com.example.food_bill;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Food_resource {

    public static class Data  {

        @SerializedName("restaurant_id")
        @Expose
        private String restaurantId;
        @SerializedName("user_id")
        @Expose
        private String userId;
        @SerializedName("contact_no")
        @Expose
        private String contactNo;
        @SerializedName("address")
        @Expose
        private String address;
        @SerializedName("status")
        @Expose
        private String status;
        @SerializedName("start_time")
        @Expose
        private String startTime;
        @SerializedName("end_time")
        @Expose
        private String endTime;
        @SerializedName("order")
        @Expose
        private List<Order> order = new ArrayList<>();
        @SerializedName("comment")
        @Expose
        private String comment;

        public String getRestaurantId() {
            return restaurantId;
        }

        public void setRestaurantId(String restaurantId) {
            this.restaurantId = restaurantId;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
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

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
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

        public List<Order> getOrder() {
            return order;
        }

        public void setOrder(List<Order> order) {
            this.order = order;
        }

        public String getComment() {
            return comment;
        }

        public void setComment(String comment) {
            this.comment = comment;
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
        private Data data;

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

        public Data getData() {
            return data;
        }

        public void setData(Data data) {
            this.data = data;
        }



    public static class Order {

        @SerializedName("food_id")
        @Expose
        private String foodId;
        @SerializedName("quantity")
        @Expose
        private String quantity;
        @SerializedName("original_price")
        @Expose
        private String originalPrice;
        @SerializedName("total_price")
        @Expose
        private String totalPrice;

        public String getFoodId() {
            return foodId;
        }

        public void setFoodId(String foodId) {
            this.foodId = foodId;
        }

        public String getQuantity() {
            return quantity;
        }

        public void setQuantity(String quantity) {
            this.quantity = quantity;
        }

        public String getOriginalPrice() {
            return originalPrice;
        }

        public void setOriginalPrice(String originalPrice) {
            this.originalPrice = originalPrice;
        }

        public String getTotalPrice() {
            return totalPrice;
        }

        public void setTotalPrice(String totalPrice) {
            this.totalPrice = totalPrice;
        }

    }
}