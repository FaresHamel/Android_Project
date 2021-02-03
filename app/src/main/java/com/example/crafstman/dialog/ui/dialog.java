package com.example.crafstman.dialog.ui;

import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.crafstman.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class dialog extends AppCompatActivity {

    public EditText EditextSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);

//        EditextSearch = (EditText) findViewById(R.id)


        //  search edit text
//      editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
//      @Override
//      public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
//          if (actionId == EditorInfo.IME_ACTION_SEARCH) {
//             performSearch();
//             return true;
//         }
//        return false;
//    }
//});
        String[] forcastData = {
                "Heute - Sonne",
                "Sonntag  Sonne",
                "Samstag  Sonne",
                "Montag  Sonne",
                "Dienstga  Sonne",
                "Mitwoch  Sonne",
                "Donnerstag  Sonne",
                "Dienstga  Sonne",
                "Mitwoch  Sonne",
                "Montag  Sonne",
                "Dienstga  Sonne",
                "Mitwoch  Sonne",
                "Donnerstag  Sonne",
                "Dienstga  Sonne",
                "Mitwoch  Sonne",
                "Montag  Sonne",
                "Dienstga  Sonne",
                "Mitwoch  Sonne",
                "Donnerstag  Sonne",
                "Dienstga  Sonne",
                "Mitwoch  Sonne",
                "Montag  Sonne",
                "Dienstga  Sonne",
                "Mitwoch  Sonne",
                "Donnerstag  Sonne",
                "Dienstga  Sonne",
                "Mitwoch  Sonne",
                "Montag  Sonne",
                "Dienstga  Sonne",
                "Mitwoch  Sonne",
                "Donnerstag  Sonne",
                "Dienstga  Sonne",
                "Mitwoch  Sonne",
                "Donnerstag  Sonne"
        };


        List<String> wochenende = new ArrayList<>(Arrays.asList(forcastData));

        //Create the RecycleView
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recucleview_worker_list);

        //Create the LinearLayoutManager
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);

        //set RecycleView the LinearLayoutManager
        recyclerView.setLayoutManager(linearLayoutManager);

        //InitialisE THE Addapter
        AdapterrecycleViewMacon recycleAddapter = new AdapterrecycleViewMacon((ArrayList<String>) wochenende);

        //set RecycleView the Addapter
        recyclerView.setAdapter(recycleAddapter);


        String[] categorie = {
                "Popular",
                "Bäcker",
                "Verkäufer",
                "Händler",
                "Mitarbeiter",
                "Arbeitgeber",
                "Arbeitnehmer",
                "Chef",
                "Koch",
                "Köchin",
        };
        List<String> categorieList = new ArrayList<>(Arrays.asList(categorie));
        //Create the RecycleView Categorie Worker
        RecyclerView recyclerViewWorkerType = (RecyclerView) findViewById(R.id.recucleview_worker_type_categorie);
        //Create the LinearLayoutManager
        LinearLayoutManager linearLayoutManagerworkercategorie = new LinearLayoutManager(this.getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerViewWorkerType.setLayoutManager(linearLayoutManagerworkercategorie);
        AdaptercategorieType categorieType = new AdaptercategorieType((ArrayList<String>) categorieList);
        recyclerViewWorkerType.setAdapter(categorieType);

        String[] popular = {
                "Popular",
                "Bäcker",
                "Verkäufer",
                "Händler",
                "Mitarbeiter",
                "Arbeitgeber",
                "Arbeitnehmer",
                "Chef",
                "Koch",
                "Köchin",
        };
        List<String> popularList = new ArrayList<>(Arrays.asList(categorie));
        //Create the RecycleView Categorie Worker
        RecyclerView recyclerViewPopular = (RecyclerView) findViewById(R.id.recucleview_popular_list);
        //Create the LinearLayoutManager
        LinearLayoutManager linearLayoutManagerPopular = new LinearLayoutManager(this.getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerViewPopular.setLayoutManager(linearLayoutManagerPopular);
        AdapterrecycleviewPopular adapterrecycleviewPopular = new AdapterrecycleviewPopular((ArrayList<String>) categorieList);
        recyclerViewPopular.setAdapter(adapterrecycleviewPopular);
    }
}