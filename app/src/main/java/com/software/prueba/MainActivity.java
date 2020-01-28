package com.software.prueba;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private Button mButtonSend;
    private EditText mEditTextDate;
    private Spinner spinner;
    private  final String extra ="extra";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setViews();
    }
    private void setViews() {
        // Button
        mButtonSend = (Button) findViewById(R.id.button);
        mEditTextDate = (EditText) findViewById(R.id.editText);
        mButtonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String color = mEditTextDate.getText().toString();
                Intent intent = new Intent(MainActivity.this,Resultado.class);
                intent.putExtra(extra,color);
                startActivity(intent);
            }
        });
        // EditText
        spinner = (Spinner) findViewById(R.id.spinner);

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.spinner_data, android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
    }
}

