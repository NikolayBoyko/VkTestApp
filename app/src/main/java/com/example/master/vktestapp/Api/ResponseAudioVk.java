package com.example.master.vktestapp.Api;

import com.example.master.vktestapp.Api.Models.AudioItem;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseAudioVk {

    @JsonProperty("count")
    private long mCount;

    @JsonProperty("items")
    private List<AudioItem> mAudioFileList;

    public long getCount() {
        return mCount;
    }

    public List<AudioItem> getAudioList() {
        return mAudioFileList;

    }

    @Override
    public String toString() {
        return "ResponseVk{" +
                "mListUser=" + mAudioFileList +
                '}';
    }
}
