package com.example.master.vktestapp.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.master.vktestapp.Api.Api;
import com.example.master.vktestapp.Api.Models.AudioItem;
import com.example.master.vktestapp.Api.ResponseAudio;
import com.example.master.vktestapp.Api.VkService;
import com.example.master.vktestapp.AudioAdapter;
import com.example.master.vktestapp.R;
import com.example.master.vktestapp.RecyclerItemClickListener;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AudioFragment extends Fragment {

    VkService service = Api.getClient().create(VkService.class);

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private FragmentTransaction fragmentTransaction;

    private  List<AudioItem> mAudioList;
    //private int argument;

    public static AudioFragment newInstance(Integer integer) {

        AudioFragment mainListQuestionFragment = new AudioFragment();
        Bundle args = new Bundle();
        args.putInt("someInt", integer);
        mainListQuestionFragment.setArguments(args);
        return mainListQuestionFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recycler, container, false);
        /*argument = getArguments().getInt("someInt");
        Log.d("log", "arguments = " + argument);*/
        return view;
    }
    public void getAudio() {
        Call<ResponseAudio> responseAudioVkCall = service.getAudio("133508072", "3", " ТОКЕН  ", "5.53");
        responseAudioVkCall.enqueue(new Callback<ResponseAudio>() {
            @Override
            public void onResponse(Call<ResponseAudio> call, Response<ResponseAudio> response) {
                Log.d("TAG", "onResponse responseAudioVkCall " + response.body().getResponse().getAudioList().get(0).getArtist());
            }

            @Override
            public void onFailure(Call<ResponseAudio> call, Throwable t) {
                Log.d("TAG", "onFailure responseAudioVkCall " + t);
            }
        });
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        mRecyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                switch (position) {
                    case 0:
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                }
            }
        }));
        mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new AudioAdapter(mAudioList);
        mRecyclerView.setAdapter(mAdapter);
    }

    public void replaceFragment(Fragment fragment) {
        fragmentTransaction = getActivity()
                .getSupportFragmentManager()
                .beginTransaction();
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.replace(R.id.main_content, fragment).commit();
    }
}
