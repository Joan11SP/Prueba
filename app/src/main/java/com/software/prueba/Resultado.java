package com.software.prueba;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class Resultado extends AppCompatActivity {
    private Button btnVolver;
    private TextView txtResultado;
    private final String extras = "extra";
    private String colores []= {"rojo","verde","amarillo","azul"};
    private Spinner spin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);
        btnVolver=(Button) findViewById(R.id.btnVolver);
        txtResultado=(TextView)findViewById(R.id.lblVolver);
        spin=(Spinner)findViewById(R.id.spinner);
        Contar();
        //validarColor();
        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Resultado.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }

    public void validarColor(){
        Bundle extra = getIntent().getExtras();
        String valor = extra.getString(extras,"");
        txtResultado.setText("Acertaste");
        for (String color1: colores) {
            if (valor.equals(color1)) {
                txtResultado.setText("Acertaste");
            } else {
                txtResultado.setText("Vuelve a intentarlo");
            }
        }
    }
    //funciona
    public void Contar(){
        Bundle extra = getIntent().getExtras();
        String contar = extra.getString(extras,"");

        char cadena[];
        cadena = contar.toCharArray();
        int i=0;
            for (char c : cadena) {
                i++;
                txtResultado.setText("Hay " + i + " Caracteres");
            }


    }
}
