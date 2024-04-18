package com.example.ass1_1190618;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class Invertebrates extends AppCompatActivity {

    private Spinner spinner;
    private ListView listView;
    private SharedPreferences sharedPreferences;
    private static final String PREFS_NAME = "MyPrefs";
    private static final String KEY_SELECTED_INVERTEBRATE = "SelectedInvertebrate";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invertebrates);

        spinner = findViewById(R.id.spinner);
        listView = findViewById(R.id.listView);
        sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);

        List<String> invertebrateOptions = new ArrayList<>();
        invertebrateOptions.add("Choose");
        invertebrateOptions.add("Insects");
        invertebrateOptions.add("Arachnids");
        invertebrateOptions.add("Molluscs");
        invertebrateOptions.add("Annelids");
        invertebrateOptions.add("Crustaceans");
        invertebrateOptions.add("Echinoderms");

        // Create an ArrayAdapter using the invertebrate options list and a default spinner layout
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, invertebrateOptions);

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        String savedInvertebrate = sharedPreferences.getString(KEY_SELECTED_INVERTEBRATE, "Choose");
        int selectedIndex = invertebrateOptions.indexOf(savedInvertebrate);
        spinner.setSelection(selectedIndex);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedInvertebrate = (String) parent.getItemAtPosition(position);
                if (!selectedInvertebrate.equals("Choose")) {
                    listView.setVisibility(View.VISIBLE);
                    populateListView(selectedInvertebrate);
                    // Save selected invertebrate type to SharedPreferences
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(KEY_SELECTED_INVERTEBRATE, selectedInvertebrate);
                    editor.apply();
                } else {
                    listView.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


    }

    private void populateListView(String invertebrateType) {
        List<String> examples = new ArrayList<>();
        switch (invertebrateType) {
            case "Insects":
                examples.add("Ant");
                examples.add("Bee");
                examples.add("Butterfly");
                examples.add("Grasshopper");
                break;
            case "Arachnids":
                examples.add("Spider");
                examples.add("Scorpion");
                examples.add("Tick");
                examples.add("Mite");
                break;
            case "Molluscs":
                examples.add("Snail");
                examples.add("Octopus");
                examples.add("Squid");
                examples.add("Clam");
                break;
            case "Annelids":
                examples.add("Earthworm");
                examples.add("Leech");
                examples.add("Ragworm");
                examples.add("Tube worm");
                break;
            case "Crustaceans":
                examples.add("Crab");
                examples.add("Shrimp");
                examples.add("Lobster");
                examples.add("Crayfish");
                break;
            case "Echinoderms":
                examples.add("Starfish");
                examples.add("Sea urchin");
                examples.add("Sea cucumber");
                examples.add("Sand dollar");
                break;
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, examples);

        listView.setAdapter(adapter);
    }
}
