package com.example.alcoolougasolina;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editPrecoAlcool;
    private EditText editPrecoGasolina;
    private TextView textResultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editPrecoAlcool = findViewById(R.id.editAlcool);
        editPrecoGasolina = findViewById(R.id.editGaoslina);
    }

    public void calcularPreco(View view) {

        if (editPrecoAlcool.getText().length() == 0 || editPrecoGasolina.getText().length() == 0) {
            Toast.makeText(this, "Favor preencher campo(s) em branco", Toast.LENGTH_SHORT).show();
        } else {
            Double precoAlcool = Double.parseDouble(editPrecoAlcool.getText().toString());
            Double precoGasolina = Double.parseDouble(editPrecoGasolina.getText().toString());

            if (precoAlcool < 0.1 || precoGasolina < 0.1) {
                Toast.makeText(this, "Valor inválido! Preencha corretamente!", Toast.LENGTH_SHORT).show();
            } else {

                Double resultado = precoAlcool / precoGasolina;

                if (resultado >= 0.7) {
                    Toast.makeText(this, "Melhor abastecer com Gasolina", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(this, "Melhor abastecer com Álcool", Toast.LENGTH_LONG).show();
                }
            }
        }
    }

    public void zerarValores(View view) {
        editPrecoAlcool.setText("");
        editPrecoGasolina.setText("");
        Toast.makeText(this, "Valores zerados", Toast.LENGTH_SHORT).show();
    }

}