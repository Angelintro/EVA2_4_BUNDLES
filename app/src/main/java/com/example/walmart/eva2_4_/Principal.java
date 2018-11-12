package com.example.walmart.eva2_4_;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Principal extends AppCompatActivity implements View.OnClickListener, CheckBox.OnCheckedChangeListener,RadioGroup.OnCheckedChangeListener {
   EditText EditNombre,EditApellido,EditEdad,EditSalario;
   RadioGroup Rdg1;
    CheckBox CnEmpleado;
    Button btnenv;
   Intent Enviar;
    String sGenero;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        Enviar = new Intent(this,Secundaria.class);
        EditNombre = findViewById(R.id.EditNombre);
        EditApellido = findViewById(R.id.EditApellido);
        EditEdad = findViewById(R.id.EditEdad);
        EditSalario = findViewById(R.id.EditSalario);
        EditSalario.setEnabled(false);
        CnEmpleado = findViewById(R.id.CnEmpleado);
        CnEmpleado.setOnCheckedChangeListener(this);
        Rdg1 = findViewById(R.id.Rdg1);
        Rdg1.setOnCheckedChangeListener(this);
        btnenv = findViewById(R.id.btnenv);
        btnenv.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        Bundle miBundle = new Bundle();
        miBundle.putString("Nombre",EditNombre.getText().toString());
        miBundle.putString("Apellido",EditApellido.getText().toString());
        miBundle.putInt("Edad", Integer.parseInt(EditEdad.getText().toString()));
        if(EditSalario.isEnabled()){
            miBundle.putBoolean("Empleado",true);
            miBundle.putDouble("Salario", Double.parseDouble(EditSalario.getText().toString()));
        }else{
            miBundle.putBoolean("Empleado",false);
            miBundle.putDouble("Salario", 0);
        }
        miBundle.putString("Genero",sGenero);
        Enviar.putExtras(miBundle);
        startActivity(Enviar);

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if(CnEmpleado.isChecked()){
            EditSalario.setEnabled(true);
        }else{
            EditSalario.setEnabled(false);
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if(checkedId==R.id.rgHombre){
            sGenero = "Hombre";
        }else{
            if(checkedId==R.id.rgMujer){
                sGenero = "Mujer";
            }else{
                sGenero = "otro";
            }
        }
    }
}


