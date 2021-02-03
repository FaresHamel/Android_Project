package com.example.crafstman.dialog.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.crafstman.R;

import java.util.ArrayList;

public class AdapterrecycleViewMacon extends RecyclerView.Adapter<AdapterrecycleViewMacon.MyviewHolder> {

    public ArrayList<String> arrayList;
    Context context;

    public AdapterrecycleViewMacon(ArrayList<String> arrayList) {

        this.arrayList = arrayList;

    }

    @NonNull
    @Override
    public MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.content_dialog, parent, false);

        MyviewHolder myviewHolder = new MyviewHolder(view);

        return myviewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyviewHolder holder, int position) {

        String text = arrayList.get(position);
        MyviewHolder.text_View_worker_usermame_dialog.setText(text);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class MyviewHolder extends RecyclerView.ViewHolder {

        public static TextView text_View_worker_usermame_dialog;
        public static TextView text_view_work_worker_type_dialog;
        public static ImageView image_View_worker_image_dialog;
        public static TextView text_view_worker_prosontag_dialog;


        public MyviewHolder(@NonNull View itemView) {
            super(itemView);

            text_View_worker_usermame_dialog = (TextView) itemView.findViewById(R.id.text_view_worker_username_dialog);
//              text_view_work_worker_type_dialog = (TextView) itemView.findViewById(R.id.type_work);
//              image_View_worker_image_dialog =(ImageView) itemView.findViewById(R.id.image_craftsman);
//              text_view_worker_prosontag_dialog = (TextView) itemView.findViewById(R.id.number_procentage);


        }
    }
}
