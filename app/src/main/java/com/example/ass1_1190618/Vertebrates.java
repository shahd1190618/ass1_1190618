package com.example.ass1_1190618;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class Vertebrates extends AppCompatActivity {

    private Spinner spinner;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vertebrates);

        spinner = findViewById(R.id.spinner);
        listView = findViewById(R.id.listView);

        List<String> vertebrateOptions = new ArrayList<>();
        vertebrateOptions.add("Choose"); // Add default text
        vertebrateOptions.add("Mammals");
        vertebrateOptions.add("Birds");
        vertebrateOptions.add("Fish");
        vertebrateOptions.add("Reptiles");
        vertebrateOptions.add("Amphibians");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, vertebrateOptions);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);

        spinner.setSelection(0);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedVertebrate = (String) parent.getItemAtPosition(position);
                if (selectedVertebrate.equals("Choose")) {
                    listView.setVisibility(View.GONE);
                } else {
                    listView.setVisibility(View.VISIBLE);
                    populateListView(selectedVertebrate);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

    }
    private void populateListView(String vertebrateType) {
        List<String> examples = new ArrayList<>();
        switch (vertebrateType) {
            case "Mammals":
                examples.add("Bat");
                examples.add("Fox");
                examples.add("Dolphin");
                examples.add("Tiger");
                break;
            case "Birds":
                examples.add("Eagle");
                examples.add("Owl");
                examples.add("Ostrich");
                break;
            case "Fish":
                examples.add("Salmon");
                examples.add("Goldfish");
                examples.add("Angelfish");
                examples.add("Seahorse");
                break;
            case "Reptiles":
                examples.add("Snake");
                examples.add("Turtle");
                examples.add("Crocodile");
                break;
            case "Amphibians":
                examples.add("Frog");
                examples.add("Toad");
                examples.add("Salamander");
                break;
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, examples);

        listView.setAdapter(adapter);
    }
}
