package com.khavronsky.searchtest;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.VHolder> {

    List<String> list = new ArrayList<>();

    public RVAdapter(final List<String> list) {
        this.list = list;
    }

    public void setList(final List<String> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @Override
    public VHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item, parent, false);
        return new VHolder(view);
    }

    @Override
    public void onBindViewHolder(final VHolder holder, final int position) {
        holder.setText(list.get(position));
//        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return list == null? 0 : list.size();
    }

    class VHolder extends RecyclerView.ViewHolder {

        TextView mTextView;

        public VHolder(final View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.rv_item);
        }

        public TextView getTextView() {
            return mTextView;
        }

        public void setText(final String text) {
            mTextView.setText(text);
        }
    }

}
