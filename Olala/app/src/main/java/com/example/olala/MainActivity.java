package com.example.olala;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button_clicked;
    EditText destination_input, date_input, description_input, name_input;
    RadioGroup radio_group;
    RadioButton yes_radio;
    RadioButton no_radio;

    private void getInputs(){
        destination_input = findViewById(R.id.destination_input);
        date_input = findViewById(R.id.date_input);
        description_input = findViewById(R.id.description_input);
        name_input = findViewById(R.id.name_input);
        radio_group = findViewById(R.id.radio_group);
        yes_radio = findViewById(R.id.yes_radio);
        no_radio = findViewById(R.id.no_radio);

        String destination = destination_input.getText().toString();
        String date = date_input.getText().toString();
        String description = description_input.getText().toString();
        String name = name_input.getText().toString();
        String radio = yes_radio.getText().toString();
        String radio2 = no_radio.getText().toString();

        displayNextAlert(destination, date, description, name, radio, radio2);
    }
    public void displayNextAlert(String destination, String date, String description, String name, String radio, String radio2) {
        if (destination.isEmpty() || date.isEmpty() || description.isEmpty() || name.isEmpty()) {
            // Show error dialog for missing input
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("Error");
            builder.setMessage("You need to fill all required fields.");
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Toast.makeText(MainActivity.this, "You clicked OK", Toast.LENGTH_SHORT).show();
                }
            });
            builder.show();
        } else {
            // Show confirmation dialog with all the information
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("Confirmation");
            builder.setMessage("Are you sure you want to submit?\n\n" +
                    "Destination: " + destination + "\n" +
                    "Date: " + date + "\n" +
                    "Description: " + description + "\n" +
                    "Name: " + name + "\n" +
                    "Radio: " + radio + "\n" +
                    "Radio2: " + radio2);

            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    // Handle 'Yes' button click here (if needed)
                    Toast.makeText(MainActivity.this, "You clicked Yes", Toast.LENGTH_SHORT).show();
                }
            });

            builder.setNegativeButton("No", null);

            builder.show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_clicked = findViewById(R.id.button_clicked);
        button_clicked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getInputs();
            }
        });
    }

}
