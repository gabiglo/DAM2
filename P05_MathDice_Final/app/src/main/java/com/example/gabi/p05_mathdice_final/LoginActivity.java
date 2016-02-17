package com.example.gabi.p05_mathdice_final;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //DECLARAMOS NUESTROS VIEWS
        final EditText Edad = (EditText)findViewById(R.id.editTextEdad);
        final EditText Nombre = (EditText)findViewById(R.id.editTextNombre);

        TextView TEdad =(TextView)findViewById(R.id.TextoEdadPerfil);
        TextView TNombre = (TextView)findViewById(R.id.TextoNombrePerfil);

        Button BtnJugar = (Button)findViewById(R.id.BotonJugar);
        BtnJugar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String name = Nombre.getText().toString();
                String edad = Edad.getText().toString();
                Intent i = new Intent(getApplicationContext(),ActivityFragment.class);
                i.putExtra("nombre", name);
                i.putExtra("edad", edad);
                startActivity(i);
            }
        });
    }

}
