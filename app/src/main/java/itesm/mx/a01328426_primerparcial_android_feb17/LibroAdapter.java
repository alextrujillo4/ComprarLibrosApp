package itesm.mx.a01328426_primerparcial_android_feb17;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * Created by alextrujillo on 18/02/17.
 */
public class LibroAdapter extends ArrayAdapter<Libro> {

    public LibroAdapter(Context context, ArrayList<Libro> libros ){
        super (context , 0, libros );
    }

    public View getView (int position, View convertView, ViewGroup parent){

        Libro libro = getItem(position);


        if(convertView == null ){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row, parent, false);
        }

        TextView tvIsbn = (TextView)convertView.findViewById(R.id.tv_isbn);
        TextView tvTitulo = (TextView)convertView.findViewById(R.id.tv_titulo);
        TextView tvExistencia = (TextView)convertView.findViewById(R.id.tv_existencia);
        TextView tvPrecio = (TextView)convertView.findViewById(R.id.tv_precio);
        ImageView ivLibro = (ImageView)convertView.findViewById(R.id.image_libro);

        tvIsbn.setText(libro.getisbn());
        tvTitulo.setText(libro.getTitulo());
        tvExistencia.setText(libro.getCantidad());
        tvPrecio.setText(libro.getPrecio());
        ivLibro.setImageResource(libro.getIdImagen());


        return  convertView;
    }


}
