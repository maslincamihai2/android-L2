package com.androidcodr.dictionar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import java.util.List;

public class SearchActivity extends AppCompatActivity {
    Button searchButton;
    EditText wordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        // Initializare buton si caseta de text
        searchButton = findViewById(R.id.button_search);
        wordEditText = findViewById(R.id.editText_word);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String searchedWord = wordEditText.getText().toString().trim();

                // Verificarea cuvantului in lista predefinita
                List<String> predefinedWords = Arrays.asList("cookie", "biscuit", "desert"); // Lista cuvintelor predefinite

                if (predefinedWords.contains(searchedWord)) {
                    // Daca cuvantul este gasit, se lanseaza activitatea de afisare a informatiilor
                    Intent intent = new Intent(SearchActivity.this, DisplayActivity.class);
                    intent.putExtra("searched_word", searchedWord); // Trimite cuvantul catre activitatea de afisare
                    startActivity(intent);
                } else {
                    // Cuvantul nu a fost gasit, se afiseaza un mesaj corespunzator
                    Toast.makeText(SearchActivity.this, "Cuvantul nu a fost gasit.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

