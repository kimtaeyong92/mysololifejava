package com.kty.mysolelifejava.mainfm;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.kty.mysolelifejava.R;
import com.kty.mysolelifejava.board.BoardRVAdapter;

public class MainFragment extends Fragment {

    RecyclerView mainRV;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_main, container, false);

        mainRV = view.findViewById(R.id.mainRV);

        BoardRVAdapter boardRVAdapter = new BoardRVAdapter();
        mainRV.setAdapter(boardRVAdapter);

        mainRV.setLayoutManager(new GridLayoutManager(getContext(), 2));



        return view;
    }


}