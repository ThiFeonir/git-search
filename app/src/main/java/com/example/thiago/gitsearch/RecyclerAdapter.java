package com.example.thiago.gitsearch;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.security.CryptoPrimitive;
import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.AdapterViewHolder> {
    private ArrayList<CardItem> mCardlist;

    public static class AdapterViewHolder extends RecyclerView.ViewHolder {
        public ImageView mImageView;
        public TextView mTextView;
        public TextView mTextView2;
        public TextView mTextView3;

        public AdapterViewHolder(View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.image_view);
            mTextView = itemView.findViewById(R.id.textView);
            mTextView2 = itemView.findViewById(R.id.textView_2);
            mTextView3 = itemView.findViewById(R.id.textView_star);
        }
    }

    public RecyclerAdapter(ArrayList<CardItem> cardlist){
        mCardlist = cardlist;
    }

    @NonNull
    @Override
    public AdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item, parent, false);
        AdapterViewHolder avh = new AdapterViewHolder(v);

        return avh;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterViewHolder holder, int position) {
        CardItem currentCard = mCardlist.get(position);

        holder.mImageView.setImageResource(currentCard.getImageResource());
        holder.mTextView.setText(currentCard.getText1());
        holder.mTextView2.setText(currentCard.getText2());
        holder.mTextView3.setText(currentCard.getText3());
    }

    @Override
    public int getItemCount() {
        return mCardlist.size();
    }
}
