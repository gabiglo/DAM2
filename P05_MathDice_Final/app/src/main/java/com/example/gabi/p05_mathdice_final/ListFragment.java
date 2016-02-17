package com.example.gabi.p05_mathdice_final;

import android.app.Activity;
import android.app.Fragment;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

//Este Fragment contendra las acciones que ejecutamos en el fragment estatico
public class ListFragment extends Fragment {
    //Definimos el objeto de llamada
    ListFragmentListener mCallback;
    // Implementamos la Interface que contendra nuestro Listener
    public interface ListFragmentListener {
        public void onListSelected(int position);
    }
    //Contructor de nuestra clase principal
    public ListFragment() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    //Generamos la vista
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //Devolvemos la vista inflada
        return inflater.inflate(R.layout.fragment_list, container, false);
    }
    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
    }
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        try {
            mCallback = (ListFragmentListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnHeadlineSelectedListener");
        }
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //En primer lugar definimos el Array de Strings y lo convertimos a una Lista, en este caso ArrayList
        //DATOS
        String[] opciones = new String[]{"PERFIL", "JUEGO", "INSTRUCCIONES", "INFO"};
        //Convertios nuestros datos en una lista
        ArrayList<String> listOpciones = new ArrayList<String>(Arrays.asList(opciones));
        //Utilizamos nuestro Adapter customizado y le añadimos los datos
        MenuAdapter adapter = new MenuAdapter(getActivity(), listOpciones);
        //INTERFAZ o la VISION
        final ListView listview = (ListView) getActivity().findViewById(R.id.listView);
        //Por último enchufamos el adaptador a la Vista que es el LsitView
        listview.setAdapter(adapter);
        //INTERACTUANDO ( Definimos nuestros Listener (INNERCLASS)
        listview.setOnItemClickListener(new nuestroListener());
    }
    //Para evitar errores tendremmos que definnir nuestra mCallback que nos sirve de comunicacion
    @Override
    public void onDetach() {
        super.onDetach();
        mCallback = null;
    }
    //Implementamos el listener para nuestro listView
    //INNER CLASS
    private class nuestroListener implements AdapterView.OnItemClickListener {
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            //String de la posicion clickada
            //String item = (String) parent.getItemAtPosition(position);
            //Paso de informacion
            mCallback.onListSelected(position);
        }
    }
}
