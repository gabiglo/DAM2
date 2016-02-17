package com.example.gabi.p05_mathdice_final;

/**
 * Created by Gabi on 22/01/2016.
 */

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

//Esta clase extiende del ArrayAdapter para poder hacer uso de ella
public class MenuAdapter extends ArrayAdapter<String> {
    //Definimos nuestros objetos
    private Context context;
    private ArrayList<String> datos;
    //Al contructor de la clase principal le pasamos nuestros objetos
    public MenuAdapter(Context context, ArrayList<String> datos) {
        super(context, 0, datos);
        this.context = context;
        this.datos = datos;
    }
    //Recogemos el view
    public View getView(int position, View convertView, ViewGroup parent) {
        //Inflamos el Layout
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //Ponemos una condicion si existe lo inflara
        if (convertView == null) {
            //Inflamos el layout lista
            convertView = inflater.inflate(R.layout.lista_item, parent, false);
        }
        //Instaciamos nuestros objetos
        ImageView imagen = (ImageView) convertView.findViewById(R.id.imageView3);
        TextView texto = (TextView) convertView.findViewById(R.id.textView);
        //Insertamos los datos en el settext
        texto.setText(datos.get(position));
        //Dependiendo de los datos recibidos segun la posicion, asignamos colores y imagenes
        if(datos.get(position) == "PERFIL"){ //Si es Perfil
            imagen.setImageDrawable(context.getDrawable(R.drawable.ic_face_black_24dp));//Recuperamos la imagen Drawable
            imagen.setBackgroundColor(Color.argb(255, 102, 51, 0));//Asignamos el color al fondo imagen
            texto.setBackgroundColor(Color.argb(255, 236, 213, 193));//signamos color al fondo texto
        }else
            //Asignamos los datos en la posicion juego
            if(datos.get(position) =="JUEGO"){//si es juego
                imagen.setImageDrawable(context.getDrawable(R.drawable.ic_extension_black_24dp));
                imagen.setBackgroundColor(Color.argb(255,204, 51, 0));
                texto.setBackgroundColor(Color.argb(255, 255, 176, 150));
            }else
                //Asignamos los datos en la posicion Instrucciones
                if(datos.get(position) =="INSTRUCCIONES"){
                    imagen.setImageDrawable(context.getDrawable(R.drawable.ic_description_black_24dp));
                    imagen.setBackgroundColor(Color.argb(255,108, 153, 0));
                    texto.setBackgroundColor(Color.argb(255, 234, 255, 193));
                }else
                    //Asignamos los datos segun la posicion info
                    if(datos.get(position) =="INFO"){
                        imagen.setImageDrawable(context.getDrawable(R.drawable.ic_info_black_24dp));
                        imagen.setBackgroundColor(Color.argb(255,0, 153, 153));
                        texto.setBackgroundColor(Color.argb(255, 193, 255, 255));
                    }
        //Revolvemos el convertView
        return convertView;
    }
}