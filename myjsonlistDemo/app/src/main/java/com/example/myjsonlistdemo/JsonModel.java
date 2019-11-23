package com.example.myjsonlistdemo;

import android.provider.ContactsContract;

import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.Result;

public class JsonModel {

    public List<String> html_attributions;

    public List<ResultData> getResult() {
        return result;
    }

    public void setResult(List<ResultData> result) {
        this.result = result;
    }

    public List<ResultData> result;
    public String status;


    public static class ResultData{
        public String long_name;
        public String short_name;
        public List<String> types;

        public String  lat;
        public String lng;

        public String icon;

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getVicinity() {
            return vicinity;
        }

        public void setVicinity(String vicinity) {
            this.vicinity = vicinity;
        }

        public String vicinity;

        public String getLong_name() {
            return long_name;
        }

        public void setLong_name(String long_name) {
            this.long_name = long_name;
        }

        public String getShort_name() {
            return short_name;
        }

        public void setShort_name(String short_name) {
            this.short_name = short_name;
        }

        public List<String> getTypes() {
            return types;
        }

        public void setTypes(List<String> types) {
            this.types = types;
        }

        public String getLat() {
            return lat;
        }

        public void setLat(String lat) {
            this.lat = lat;
        }

        public String getLng() {
            return lng;
        }

        public void setLng(String lng) {
            this.lng = lng;
        }

        /*  public Northeast northeast;
        public Southwest southwest;


        public Location location;
        public Viewport viewport;


        public int day;
        public String time;


        public Open open;


        public bool open_now;
        public List<Period> periods;
        public List<String> weekday_text;


        public int height;
        public List<String> html_attributions;
        public String photo_reference;
        public int width;


        public String compound_code;
        public String global_code;


        public String author_name;
        public String author_url;
        public String language;
        public String profile_photo_url;
        public int rating;
        public String relative_time_description;
        public String text;
        public int time;


        public List<AddressComponent> address_components;
        public String adr_address;
        public String formatted_address;
        public String formatted_phone_number;
        public Geometry geometry;
        public String icon;
        public String id;
        public String international_phone_number;
        public String name;
        public OpeningHours opening_hours;
        public List<ContactsContract.CommonDataKinds.Photo> photos;
        public String place_id;
        public PlusCode plus_code;
        public double rating;
        public String reference;
        public List<Review> reviews;
        public String scope;
        public List<String> types;
        public String url;
        public int user_ratings_total;
        public int utc_offset;
        public String vicinity;
        public String website;*/
    }

}