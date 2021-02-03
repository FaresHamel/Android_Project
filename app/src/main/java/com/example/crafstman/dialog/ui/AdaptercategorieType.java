package com.example.crafstman.dialog.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.crafstman.R;

import java.util.ArrayList;

public class AdaptercategorieType extends RecyclerView.Adapter<AdaptercategorieType.MyviewHolder> {

    public ArrayList<String> arrayList;
    Context context;

    public AdaptercategorieType(ArrayList<String> arrayList) {

        this.arrayList = arrayList;

    }

    @NonNull
    @Override
    public AdaptercategorieType.MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.categorie_type, parent, false);

        AdaptercategorieType.MyviewHolder myviewHolder = new AdaptercategorieType.MyviewHolder(view);

        return myviewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final AdaptercategorieType.MyviewHolder holder, int position) {
        String text = arrayList.get(position);
        MyviewHolder.text_categorieType.setText(text);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class MyviewHolder extends RecyclerView.ViewHolder {

        public static TextView text_categorieType;

        public MyviewHolder(@NonNull View itemView) {
            super(itemView);

            text_categorieType = (TextView) itemView.findViewById(R.id.text_categorie_type);
        }
    }
}
