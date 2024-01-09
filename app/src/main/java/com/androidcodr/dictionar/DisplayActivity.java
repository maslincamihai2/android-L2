package com.androidcodr.dictionar;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class DisplayActivity extends AppCompatActivity {
    TextView explanationTextView;
    ImageView wordImageView;
    Button editButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        // Initializare TextView si ImageView
        explanationTextView = findViewById(R.id.textView_explanation);
        wordImageView = findViewById(R.id.imageView_wordImage);
        editButton = findViewById(R.id.button_edit);

        // Primirea cuvantului sau informatiilor asociate din activitatea anterioara
        String searchedWord = getIntent().getStringExtra("searched_word");

        explanationTextView.setText("Informatii despre " + searchedWord);
        wordImageView.setImageResource(R.drawable.download__2_); // Incarcati o imagine corespunzatoare din resurse

        // Gestionati evenimentul butonului de modificare pentru editarea textului
        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(DisplayActivity.this);
                builder.setTitle("Introduceti noul text");

                // Setam o caseta de editare pentru introducerea noului text
                final EditText input = new EditText(DisplayActivity.this);
                input.setInputType(InputType.TYPE_CLASS_TEXT);
                builder.setView(input);

                // Adaugam butonul de confirmare
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String newText = input.getText().toString();
                        explanationTextView.setText(newText);
                    }
                });

                // Adaugam butonul de anulare
                builder.setNegativeButton("Anulare", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                // Afisam dialogul
                builder.show();
            }
        });
    }
}

