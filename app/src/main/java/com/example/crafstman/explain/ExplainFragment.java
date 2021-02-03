package com.example.crafstman.explain;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.crafstman.create.ui.CreateNewUserActivity;
import com.example.crafstman.dialog.ui.dialog;
import com.example.crafstman.login.ui.LoginActivity;

import static com.example.crafstman.R.drawable;
import static com.example.crafstman.R.id;
import static com.example.crafstman.R.layout.fragment_explain;
import static com.example.crafstman.R.string;

public class ExplainFragment extends Fragment {


    public ExplainFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // ..... Inflate the layout for this fragment

        final View view = inflater.inflate(fragment_explain, container, false);

        // ..... Get the View Pager
        ViewPager viewPager = (ViewPager) view.findViewById(id.view_pager_explain);

        // ........ Set TO the view Pager The Addapter
        viewPager.setAdapter(new ViewPagerAdapter(getChildFragmentManager()));

        // ...... Login Button to get you to Login Page
        Button buttonLogin = (Button) view.findViewById(id.login_btn);
        //........ Add Event Click Listener
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), LoginActivity.class);
                view.getContext().startActivity(intent);

            }
        });

        // ....... Skip Button for Skip Alle New Acount Create Or Login Option
        final Button btnSkip = (Button) view.findViewById(id.skip_btn);
        btnSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), dialog.class);
                view.getContext().startActivity(intent);
            }
        });

        // ......... Create New Acount Button Create new Acount Account
        final Button btnCreateNewAcountBtn = view.findViewById(id.btn_create_acount_explain_acitivity);
        btnCreateNewAcountBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CreateNewUserActivity.class);
                view.getContext().startActivity(intent);
            }
        });


        return view;
    }


    public class ViewPagerAdapter extends FragmentPagerAdapter {


        public ViewPagerAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {

            switch (position) {

                case 0:
                    return FragmentViewPager.newInstance(getString(string.title_drei), drawable.best_company);
                case 1:
                    return FragmentViewPager.newInstance(getString(string.title_eins), drawable.search_jobs);
                case 2:
                    return FragmentViewPager.newInstance(getString(string.title_vier), drawable.workers_mason);
                case 3:
                    return FragmentViewPager.newInstance("Help you to finde solution", drawable.findsolution);
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return 4;
        }
    }

}