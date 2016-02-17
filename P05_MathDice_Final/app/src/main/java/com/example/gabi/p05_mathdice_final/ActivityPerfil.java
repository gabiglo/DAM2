package com.example.gabi.p05_mathdice_final;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.Toast;

/*****************************************************************
**EN ESTA ACTIVITY IMPLEMENTAMOS LA INTERFAZ DE NUESTRO FRAGMENT**
******************************************************************/
public class ActivityPerfil extends Activity implements FragmentPerfil.OnFragmentBotonListener{
    //Metodo de creacion de nuestra activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_fragment);
    }

    //Declaramos la interfaz de nuestro fragment , donde recojo la informacion y la puedo almacear
    public void onFragmentInteraction(String uno, String dos) {
        //Declaramos un Toast para comprobar que llega hasta donde quiero la informacion
        Toast.makeText(this, "Aqui llega la info del FRAGMENT_PERFIL a la ACTIVITY_PERFIL " + uno
                                                            + " " + dos, Toast.LENGTH_SHORT).show();
        //INTENT PARA PASAR AL LA ATIVITY_FRAGMENT QUE ES NUESTRO MAIN ACTIVITY
        Intent mainIntent = new Intent(getApplicationContext(), ActivityFragment.class);
        // Aqui pasamos la inormacion entre las dos Activitys (de Act_Perfil a Act_fragment)
        mainIntent.putExtra("nombre",uno); //nombre
        mainIntent.putExtra("apellido",dos);  //edad
        startActivity(mainIntent);

    }

    /*
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_perfil);
        FragmentPerfil perfil = new FragmentPerfil();
        //Creamos un objeto "transaction" que recoge el fragment manager y inicia la transaccion
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        //Remplaza lo que haya en el contenedor por el "gameFragment"
        transaction.replace(R.id.fragment_container_entero, perfil);
        //Esto permite que el usuario pueda volver atras
        //Esta parte es un problema ya que manda todos los fragments creados detras de forma que
        //si inicias 20 juegos nuevos, tienes 21 fragments escondidos detras
        transaction.addToBackStack(null);
        //Lanzamos la transaccion
        transaction.commit();
    }*/

}
