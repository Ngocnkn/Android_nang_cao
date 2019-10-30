package com.example.assigment;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class TinTucHolder extends RecyclerView.ViewHolder {
    public TextView tvTitle, tvDesc;

    public TinTucHolder(@NonNull View itemView) {
        super(itemView);
        tvTitle = itemView.findViewById(R.id.tvTitle);
        tvDesc = itemView.findViewById(R.id.tvDesc);
    }
}
