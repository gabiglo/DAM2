package com.example.gabi.p05_mathdice_final;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.pm.ActivityInfo;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.Window;
import android.widget.Toast;


import static com.example.gabi.p05_mathdice_final.R.id.fragment_container;

/*Este Activity contendra los dos fragment el estatico y el dinamico extiende de activity
*A ser una activity y le implementamos el fragment ListFragment para pasarle nuestro Listener
*Y nuestros datos*/
public class ActivityFragment extends Activity implements ListFragment.ListFragmentListener, FragmentPerfil.OnFragmentBotonListener {
    private MyDBAdapter myDBAdapter;
    String name = "";
    String apellido = "";
    String path = "";
    private MenuItem item;
    final static String TAG = "P05_FINAL";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // con esto quitamos el titulo
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //Checkamos si estamos en un dispositivo grande o no
        setContentView(R.layout.activity_activity_fragment);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        //Checkamos si estamos en un dispositivo grande o no
        if (findViewById(fragment_container) != null) {
            //Coloco el fragment lista en su contenedor estatico
            ListFragment lf = (ListFragment) getFragmentManager().findFragmentById(R.id.list_fragment);
            /*
            * Recojo los datos que he enviado con el intent que pasaba a esta activity y se los asigno
            *a dos variables.(Los datos los envio a traves de un intent creado en el perfil fragment)
            *Aqui en el ACTIVITY nos encargamos de hacer la logica que consideemos con los datos.
            */
            Bundle bundle = getIntent().getExtras();
            //Recojo los datos y los asignoo a dos variables
            String nombre = bundle.getString("nombre");
            String edad = bundle.getString("edad");
            //Muestro en consola los datos recibidos con el intent
            Log.v(TAG, "recibido nombre: " + nombre + " y edad: " + edad);
            //Declaramos nuestro FragmentVacio
            FragmentVacio vacio = new FragmentVacio();
            //LLamamos al manager para comenzar la transaccion
            getFragmentManager().beginTransaction().add(R.id.fragment_container,vacio).commit();
        } else {
            //Dispositivo pequeño
            Toast.makeText(this, "ERES PEQUEÑO", Toast.LENGTH_LONG).show();
        }

    }

    //Nuestro listener
    public void onListSelected(int position) {

        //Definimos lo que haran
        // si es tableta
        //Perfil
        if (position == 0) {

            if (findViewById(fragment_container) != null) {
                //Declaramos nuestro fragment
                FragmentPerfil perfil = new FragmentPerfil();
                //Creamos un objeto fragment manager y inicia la transaccion
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                //Reempazamos el conteniddo de nuestro contenedor
                transaction.replace(fragment_container, perfil);
                //Limpiamos el contenedor
                transaction.addToBackStack(null);
                //Lo cargamos
                transaction.commit();
            }else {
                Intent intent = new Intent(this, ActivityPerfil.class);
                startActivity(intent);
            }
            // si la posición es cero , cargamos el Fragment Perfil.
            //Cragamos el fragment juego
        } else if (position == 1) {
            //Si fragment_container no es nulo
            if (findViewById(fragment_container) != null) {
                //Declaramos nuestro fragment
                JuegoFragment juego = new JuegoFragment();
                //Creamos un objeto fragment manager y inicia la transaccion
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                //Reempazamos el conteniddo de nuestro contenedor
                transaction.replace(fragment_container, juego);
                //Limpiamos el contenedor
                transaction.addToBackStack(null);
                //Lo cargamos
                transaction.commit();
            } else {
                //Si es nulo pasara a una pantalla pequeña , por lo tanto  una activity
                Intent intent = new Intent(this, MainPqGame.class);
                startActivity(intent);
            }
        } else if (position == 2) {
            //Instrucciones
            Toast.makeText(this, "Danos tiempo para implementar " + item, Toast.LENGTH_SHORT).show();
        } else if (position == 3) {
            //Informacion
            Toast.makeText(this, "Danos tiempo para implementar " + item, Toast.LENGTH_SHORT).show();
        }
    }

   //Este es el interfaz definido en nuestro interface
    @Override
    public void onFragmentInteraction(String A, String B) {
        // Comprobación del paso correcto de los parametros desde actividad Perfil a act Main:
        Toast.makeText(this,"Pasamos bien la info del Fragment a la Act Main " + A + B , Toast.LENGTH_SHORT).show();
    }
    /*
     //Este el Listener de nuestro fragment, aqui le pasamos los parametros recogidos a nuestra clase
    //MyDBAdapter
    PRUEBA CON SQLITE
    @Override
    public void onClick(String nombreUsuario, String apellidoUsuario, String rutaUsuario) {
        //Declaramos nuestro objeto de la clase que contiene nuestra Bd
        myDBAdapter = new MyDBAdapter(this);
        //Abrimos nuestra BD
        myDBAdapter.open();
        this.name = nombreUsuario;
        this.apellido = apellidoUsuario;
        this.path = rutaUsuario;
        myDBAdapter.recuperarUsuarios();
        Log.i("Aqui  llego:", this.name);
        myDBAdapter.insertarUsuario(name, apellido, path);




    }*/
}
