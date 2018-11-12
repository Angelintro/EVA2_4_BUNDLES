package com.example.walmart.eva2_4_;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Secundaria extends AppCompatActivity implements Button.OnClickListener{
    TextView TxtDatos;
    Button btnCerrar;
    Intent inRecibido;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secundaria);
        TxtDatos = findViewById(R.id.TxtDatos);
        btnCerrar = findViewById(R.id.btnCerrar);
        btnCerrar.setOnClickListener(this);
        inRecibido = getIntent();
        Bundle datosRecibidos = inRecibido.getExtras();
        TxtDatos.append("Nombre: "+datosRecibidos.get("Nombre")+"\n");
        TxtDatos.append("Apellido: "+datosRecibidos.get("Apellido")+"\n");
        TxtDatos.append("Edad: "+datosRecibidos.get("Edad")+"\n");

        if(datosRecibidos.getBoolean("Empleado")){
            TxtDatos.append("Trabaja: Si"+"\n");
            TxtDatos.append("Salario: "+datosRecibidos.getDouble("Salario")+"\n");
        }else
            TxtDatos.append("Trabaja: No"+"\n");
        TxtDatos.append("Genero: "+datosRecibidos.get("Genero")+"\n");

    }


    @Override
    public void onClick(View v) {
        Toast.makeText(this, "Has salido  "+inRecibido.getStringExtra("Nombre"), Toast.LENGTH_LONG).show();
        finish();
    }
}
