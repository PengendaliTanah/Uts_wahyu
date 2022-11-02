package com.wahyu.myapplication;

import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    private RecyclerView rvHandphone;
    private final ArrayList<Handphone> list = new ArrayList<>();


    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();

        return fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        rvHandphone = view.findViewById(R.id.rv_Handphone);
        rvHandphone.setHasFixedSize(true);

        list.addAll(getListHandphone());
        showRecyclerList();

    }

    public ArrayList<Handphone> getListHandphone() {
        String[] dataName = getResources().getStringArray(R.array.data_name);
        String[] dataDescription = getResources().getStringArray(R.array.data_description);
        TypedArray dataPhoto = getResources().obtainTypedArray(R.array.data_photo);
        ArrayList<Handphone> listHandphone = new ArrayList<>();
        for (int i = 0; i < dataName.length; i++) {
            Handphone Handphone = new Handphone();
            Handphone.setName(dataName[i]);
            Handphone.setDescription(dataDescription[i]);
            Handphone.setPhoto(dataPhoto.getResourceId(i, -1));
            listHandphone.add(Handphone);
        }
        return listHandphone;
    }

    private void showRecyclerList() {
        rvHandphone.setLayoutManager(new LinearLayoutManager(getContext()));
        ListHandphone listHandphone= new ListHandphone(list);
        rvHandphone.setAdapter(listHandphone);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

}