package com.example.food_bill;

public class food_data
{
    String id,qty,price,total;

    public food_data(String id, String qty, String price, String total) {
        this.id = id;
        this.qty = qty;
        this.price = price;
        this.total = total;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}