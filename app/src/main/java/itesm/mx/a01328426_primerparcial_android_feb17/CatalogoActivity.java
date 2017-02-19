package itesm.mx.a01328426_primerparcial_android_feb17;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;


public class CatalogoActivity  extends ListActivity implements AdapterView.OnItemClickListener  {
    ArrayList<Libro> arrayLibro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalogo);
        arrayLibro = getDataForListView();
        LibroAdapter adapterLibros = new LibroAdapter(this, arrayLibro);
        setListAdapter(adapterLibros);

        getListView().setOnItemClickListener(this);

    }


    public ArrayList<Libro> getDataForListView() {
        Libro libro;
        ArrayList<Libro> listLibros = new ArrayList<Libro>();

        libro = new Libro ("013438945X", "Introduction to Android Application Development: Android Essentials",
        "5","39.99", R.drawable.book1);
        listLibros.add(libro);

        libro = new Libro ("01785886193", "Android Application Development: Cookbook 2nd Edition",
                "8","44.99", R.drawable.book2);
        listLibros.add(libro);

        libro = new Libro ("9781785889035", "Android Programming for Beginners",
                "6","48.00", R.drawable.book2);
        listLibros.add(libro);

        libro = new Libro ("1430264543", "Learn Java for Android  Development ",
                "3","56.00", R.drawable.book2);
        listLibros.add(libro);

        libro = new Libro ("9781329747517", "Android: App  Development & Programming Guide: Learn In A Day",
                "10","39.49", R.drawable.book2);
        listLibros.add(libro);


        return  listLibros;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Libro libro = (Libro)   parent.getItemAtPosition(position);
        Toast.makeText(this, libro.getTitulo(), Toast.LENGTH_LONG).show();

        Intent intent = new Intent(this, DetalleLibroActivity.class);

        intent.putExtra("isbn", libro.getisbn());
        intent.putExtra("titulo", libro.getTitulo());
        intent.putExtra("cantidad", libro.getCantidad());
        intent.putExtra("precio", libro.getPrecio());
        intent.putExtra("imagen", libro.getIdImagen());

        startActivity(intent);
    }

}
