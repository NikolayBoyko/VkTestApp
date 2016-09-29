package com.example.master.vktestapp.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.master.vktestapp.Api.Api;
import com.example.master.vktestapp.Api.ResponseVk;
import com.example.master.vktestapp.Api.VkService;
import com.example.master.vktestapp.R;
import com.example.master.vktestapp.RecyclerItemClickListener;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private FragmentTransaction fragmentTransaction;

    VkService service = Api.getClient().create(VkService.class);

    public static UserFragment newInstance(Integer integer) {

        UserFragment mainListQuestionFragment = new UserFragment();
       // mData = mainList;
        Bundle args = new Bundle();
        args.putInt("someInt", integer);
        mainListQuestionFragment.setArguments(args);
        return mainListQuestionFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recycler, container, false);
        return view;
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
    }

    public void getUser() {
        Call<ResponseVk> responseVkCall = service.getUser("133508072", "bdate", "5.53");
        responseVkCall.enqueue(new Callback<ResponseVk>() {
            @Override
            public void onResponse(Call<ResponseVk> call, Response<ResponseVk> response) {
                Log.d("TAG", "onResponse" + response.body().getListUser().toString());
            }

            @Override
            public void onFailure(retrofit2.Call<ResponseVk> call, Throwable t) {
                Log.d("TAG", "onFailure" + t);
            }
        });
    }

}
