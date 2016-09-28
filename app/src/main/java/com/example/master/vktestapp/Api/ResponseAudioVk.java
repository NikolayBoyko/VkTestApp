package com.example.master.vktestapp.Api;

import com.example.master.vktestapp.Api.Models.AudioFile;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseAudioVk {

    @JsonProperty("count")
    String mCount;

    @JsonProperty("items")
    List<AudioFile> mAudioFileList;

    public String getCount() {
        return mCount;
    }

    public List<AudioFile> getAudioList() {
        return mAudioFileList;

    }

    @Override
    public String toString() {
        return "ResponseVk{" +
                "mListUser=" + mAudioFileList +
                '}';
    }
}
