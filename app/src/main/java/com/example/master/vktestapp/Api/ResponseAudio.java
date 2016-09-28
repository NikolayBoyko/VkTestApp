package com.example.master.vktestapp.Api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseAudio {

    @JsonProperty("response")
    List<ResponseAudioVk> mListResponseAudioVk;

    public List<ResponseAudioVk> getListResponseAudioVk() {
        return mListResponseAudioVk;
    }

    @Override
    public String toString() {
        return "ResponseVk{" +
                "mListUser=" + mListResponseAudioVk +
                '}';
    }

}
