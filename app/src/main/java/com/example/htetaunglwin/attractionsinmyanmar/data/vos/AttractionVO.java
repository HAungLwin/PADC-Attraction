package com.example.htetaunglwin.attractionsinmyanmar.data.vos;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Htet Aung Lwin on 09-Jul-16.
 */
public class AttractionVO {

    @SerializedName("title")
    private String title;

    @SerializedName("desc")
    private String desc;

    @SerializedName("images")
    private String[] images;

    public AttractionVO(String title, String desc, String[] images) {
        this.title = title;
        this.desc = desc;
        this.images = images;
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }

    public String[] getImages() {
        return images;
    }
}
