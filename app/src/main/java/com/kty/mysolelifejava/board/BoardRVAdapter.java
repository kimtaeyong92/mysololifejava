package com.kty.mysolelifejava.board;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kty.mysolelifejava.R;

public class BoardRVAdapter extends RecyclerView.Adapter<BoardRVAdapter.ViewHolder> {

    @NonNull
    @Override
    public BoardRVAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.board_rv_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BoardRVAdapter.ViewHolder holder, int position) {
        holder.binding();
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View view) {
            super(view);
        }

        void binding(){

        }

    }
}
