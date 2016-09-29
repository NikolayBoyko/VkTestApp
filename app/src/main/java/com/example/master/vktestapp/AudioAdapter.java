package com.example.master.vktestapp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.master.vktestapp.Api.Models.AudioItem;

import java.util.List;

public class AudioAdapter extends RecyclerView.Adapter<AudioAdapter.ViewHolder> {

    private List<AudioItem> audioList;

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView mAudioArtist;
        private TextView mAudioTitle;
        private TextView mAudioUrl;

        public ViewHolder(View v) {
            super(v);
            mAudioArtist = (TextView) v.findViewById(R.id.audioArtist);
            mAudioTitle = (TextView) v.findViewById(R.id.audioTitle);
            mAudioUrl = (TextView) v.findViewById(R.id.audioUrl);
        }
    }

    public AudioAdapter(List<AudioItem> audioList) {
        this.audioList = audioList;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.audio_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        for (int i = 0; i <= audioList.size(); i++) {
            holder.mAudioArtist.setText(audioList.get(i).getArtist());
            holder.mAudioTitle.setText(audioList.get(i).getTitle());
            holder.mAudioUrl.setText(audioList.get(i).getUrl());
        }

    }

    @Override
    public int getItemCount() {
        return audioList.size();
    }

}

