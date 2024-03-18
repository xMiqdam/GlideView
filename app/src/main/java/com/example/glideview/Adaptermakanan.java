package com.example.glideview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class Adaptermakanan extends RecyclerView.Adapter<Adaptermakanan.ViewHolder> {
    private List<makananmodel> listMakanan;
    private ItemClickListener mClickListener;

    public Adaptermakanan(List<makananmodel> listMakanan) {
        this.listMakanan = listMakanan;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final makananmodel makan = this.listMakanan.get(position);
        holder.textView1.setText(makan.getTitle());
        holder.textView2.setText(makan.getDescription());
        Glide.with(holder.itemView.getContext()).load(makan.getImage()).into(holder.image);
    }


    @Override
    public int getItemCount() {
        return listMakanan.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView image;
        TextView textView1;
        TextView textView2;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.ivMakanan);
            textView1 = itemView.findViewById(R.id.tvNamaMakanan);
            textView2 = itemView.findViewById(R.id.tvDeskripsiMakanan);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (mClickListener != null) mClickListener.onItemClick(v, getAdapterPosition());
        }
    }


    makananmodel getItem(int id) {
        return listMakanan.get(id);
    }

    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}
