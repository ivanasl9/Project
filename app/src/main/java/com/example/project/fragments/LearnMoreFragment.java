package com.example.project.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.project.Data;
import com.example.project.ListAdapter;
import com.example.project.R;

import java.util.ArrayList;


public class LearnMoreFragment extends Fragment implements ListAdapter.ItemClickListener {
    private final ArrayList<Data> arrayList = new ArrayList<>();


    public LearnMoreFragment() {
        // Required empty public constructor
    }

    public static LearnMoreFragment newInstance() {
        LearnMoreFragment fragment = new LearnMoreFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_learn_more, container, false);

        initRecyclerView(view);
        listData();
        return view;
    }

    private void listData() {
        arrayList.add(new Data("Naslov 1"));
        arrayList.add(new Data("Naslov 2"));
        arrayList.add(new Data("Naslov 3"));
        arrayList.add(new Data("Naslov 4"));
        arrayList.add(new Data("Naslov 5"));
    }

    private void initRecyclerView(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.recView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        ListAdapter listAdapter = new ListAdapter(arrayList, this);
        recyclerView.setAdapter(listAdapter);

        recyclerView.postDelayed(new Runnable() {
            public void run() {
                recyclerView.smoothScrollToPosition(0);
            }
        }, 500);
    }

    @Override
    public void onItemClick(Data data) {

    }
}