package com.example.assigment;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TinTucAdapter extends RecyclerView.Adapter<TinTucHolder> {
    private List<TinTuc> tinTucs;
    private Context context;

    public TinTucAdapter(List<TinTuc> tinTucs, Context context) {
        this.tinTucs = tinTucs;
        this.context = context;
    }

    @NonNull
    @Override
    public TinTucHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tintuc, parent, false);

        TinTucHolder tinTucHolder = new TinTucHolder(view);
        return tinTucHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TinTucHolder holder, int position) {
        final TinTuc tinTuc = tinTucs.get(position);

        holder.tvTitle.setText(tinTuc.title);
        holder.tvDesc.setText(tinTuc.description);

        holder.tvTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, WebviewActivity.class);
                intent.putExtra("link",tinTuc.links);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return tinTucs.size();
    }
}
