package com.example.master.vktestapp.Api.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseAudioVk {

    @JsonProperty("response")
    List<Audio> mAudioList;

    @JsonProperty("count")
    String mCount;

    public String getCount() {
        return mCount;
    }

    public List<Audio> getAudioList() {
        return mAudioList;

    }

    @Override
    public String toString() {
        return "ResponseVk{" +
                "mListUser=" + mAudioList +
                '}';
    }
}
