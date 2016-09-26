package com.example.master.vktestapp.Api.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Audio {

    @JsonProperty("id")
    private String mId;

    @JsonProperty("owner_id")
    private String mOwner_id;

    @JsonProperty("artist")
    private String mArtist;

    @JsonProperty("title")
    private String mTitle;

    @JsonProperty("duration")
    private String mDuration;

    @JsonProperty("date")
    private String mDate;

    @JsonProperty("url")
    private String mUrl;

    @JsonProperty("genre_id")
    private String mGenre_id;

    public String getId() {
        return mId;
    }

    public String getOwner_id() {
        return mOwner_id;
    }

    public String getArtist() {
        return mArtist;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getDuration() {
        return mDuration;
    }

    public String getDate() {
        return mDate;
    }

    public String getUrl() {
        return mUrl;
    }

    public String getGenre_id() {
        return mGenre_id;
    }

    @Override
    public String toString() {
        return "Audio{" +
                "mId='" + mId + '\'' +
                ", mOwner_id='" + mOwner_id + '\'' +
                ", mArtist='" + mArtist + '\'' +
                ", mTitle='" + mTitle + '\'' +
                ", mDuration='" + mDuration + '\'' +
                ", mDate='" + mDate + '\'' +
                ", mUrl='" + mUrl + '\'' +
                ", mGenre_id='" + mGenre_id + '\'' +
                '}';
    }
    /*response: {
count: 385,
items: [{
id: 456239052,
owner_id: 19393076,
artist: 'Bigstar',
title: 'Amazing People (vladimirock mix)',
duration: 322,
date: 1472113638,
url: 'https://cs7-3v4.v...3J--RXWIajqfcPqqqrg',
genre_id: 18
}]
}*/
}
