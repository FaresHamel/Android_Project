package com.example.crafstman.explain;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.crafstman.R;


public class FragmentViewPager extends Fragment {


    public FragmentViewPager() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static FragmentViewPager newInstance(String param1, int param2) {

        FragmentViewPager fragment = new FragmentViewPager();

        Bundle args = new Bundle();

        args.putString("title", param1);
        args.putInt("img", param2);

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
        View view = inflater.inflate(R.layout.fragment_view_pager, container, false);

        TextView textView = (TextView) view.findViewById(R.id.title_text_view_pager);
        ImageView imageView = (ImageView) view.findViewById(R.id.img_view_pager);

        textView.setText(getArguments().getString("title"));
        imageView.setBackgroundResource(getArguments().getInt("img"));

        return view;
    }
}