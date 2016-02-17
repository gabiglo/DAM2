package com.example.gabi.p05_mathdice_final;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;

import java.util.Timer;
import java.util.TimerTask;

public class Splash_Activity extends Activity {

    /*
          *Definimos una constante que sera la encarda de recoger el tiempo
          *que durara nuestro splash o ativity Principal en pantalla
          */
    private static final long SPLASH_SCREEN_DELAY = 5000;
    /*
    *Generamos el metodo OnCreate para crear o mostrar nuestro
    * Activity Principal, en ella a traves de una funcion como
    *es Timer, definiremos el tiempo que se mostrara , y tambien
    * haciendo uso de nuestra constante.
    */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*
         *Con este funcion configuramos nuestra pantalla vertical
         * y a pantalla completa ocultando la barra del titulo.
         */
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //Definimos la variable que contendra nuestro Layout R
        setContentView(R.layout.activity_splash_);
        /*
         *Definimos nuestro Reloj de cuenta atras ( TimerTask,Clase
         * que representa una tarea para ejecutarse a una hora detreminada),
         * y dentro de una Metodo Run de puesta en marcha donde
         * definimos un intent explicito y generamos un startActivity
         */
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Intent i = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(i);
            }
        };
        // Simular un proceso de carga en el arranque de la aplicación.
        Timer timer = new Timer();
        timer.schedule(task, SPLASH_SCREEN_DELAY);
    }

    /*
        Generamos el ciclo de vida de nuestro Splash
     */
    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_splash_, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

