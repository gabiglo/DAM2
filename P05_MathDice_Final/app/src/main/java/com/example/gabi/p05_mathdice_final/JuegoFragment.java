package com.example.gabi.p05_mathdice_final;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class JuegoFragment extends Fragment {
    private AudioManager audioManager;
    private MediaPlayer MPlayer;
    private int sonando = 0;
    private boolean Reproducir;

    public JuegoFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Declaramos el servicio de audio.
        audioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);
        //Cargamos la cancion
        MPlayer = MediaPlayer.create(getActivity(), R.raw.heavy);
        //Como no he puesto botones para controlar el audio, solo tengo que poner en marcha el
        //audio.
        MPlayer.start();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflamos nuestro layout
        View v = inflater.inflate(R.layout.fragment_juego, container, false);
        return v;
    }



    //Generamos el metodo para retornar
    @Override
    public void onResume() {
        Log.d("AUDIO", "VOLVIENDO A TOCAR");
        super.onResume();


    }

    //Creamos el metodo para pausar
    @Override
    public void onPause() {
        Log.d("AUDIO", "EN PAUSA");
        //Lo ponemos en pause
        MPlayer.pause();
        super.onPause();
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

    }
    //Construyo este metodo para que cuando pulsemos otra vez en el list la cancion no se me vuelva a cargar encima de la que tengo
    @Override
    public void onDetach() {
        super.onDetach();
        /*Con este metodo , nos aseguramos que cuando se vuelva a pulsar en el lisview la cancion,
         empezara de cero*/
        MPlayer.release();
    }

}