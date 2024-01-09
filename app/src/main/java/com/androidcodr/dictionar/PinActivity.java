package com.androidcodr.dictionar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.androidcodr.dictionar.R;

public class PinActivity extends AppCompatActivity {
    private StringBuilder enteredPin;
    private static final String CORRECT_PIN = "1234"; // PIN-ul corect

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initializare butoane si alte elemente UI
        Button button1 = findViewById(R.id.button_1);
        Button button2 = findViewById(R.id.button_2);
        Button button3 = findViewById(R.id.button_3);
        Button button4 = findViewById(R.id.button_4);
        Button button5 = findViewById(R.id.button_5);
        Button button6 = findViewById(R.id.button_6);
        Button button7 = findViewById(R.id.button_7);
        Button button8 = findViewById(R.id.button_8);
        Button button9 = findViewById(R.id.button_9);
        Button buttonDelete = findViewById(R.id.button_delete);
        Button buttonConfirm = findViewById(R.id.button_confirm);

        EditText editTextPinDisplay = findViewById(R.id.editText_pinDisplay);

        enteredPin = new StringBuilder();

        // programare evenimente butoane pentru introducerea PIN-ului
        View.OnClickListener buttonClickListener = v -> {
            Button button = (Button) v;
            String number = button.getText().toString();
            if (enteredPin.length() < 4) {
                enteredPin.append(number);
                editTextPinDisplay.setText(enteredPin.toString());
            }
        };


        button1.setOnClickListener(buttonClickListener);
        button2.setOnClickListener(buttonClickListener);
        button3.setOnClickListener(buttonClickListener);
        button4.setOnClickListener(buttonClickListener);
        button5.setOnClickListener(buttonClickListener);
        button6.setOnClickListener(buttonClickListener);
        button7.setOnClickListener(buttonClickListener);
        button8.setOnClickListener(buttonClickListener);
        button9.setOnClickListener(buttonClickListener);

        buttonDelete.setOnClickListener(v -> {
            if (enteredPin.length() > 0) {
                enteredPin.deleteCharAt(enteredPin.length() - 1);
                editTextPinDisplay.setText(enteredPin.toString());
            }
        });

        buttonConfirm.setOnClickListener(v -> {
            if (enteredPin.length() == 4 && enteredPin.toString().equals(CORRECT_PIN)) {
                // PIN-ul este corect, treceti la urmatoarea activitate
                Intent intent = new Intent(PinActivity.this, SearchActivity.class);
                startActivity(intent);
                finish(); // pentru a inchide activitatea curenta
            } else {
                // PIN-ul este incorect, puteti afisa un mesaj sau actiuni suplimentare
                Toast.makeText(this, "PIN incorect. Reincercati.", Toast.LENGTH_SHORT).show();
                enteredPin.setLength(0); // Reseteaza PIN-ul introdus
                editTextPinDisplay.setText("");
            }
        });
    }
}
