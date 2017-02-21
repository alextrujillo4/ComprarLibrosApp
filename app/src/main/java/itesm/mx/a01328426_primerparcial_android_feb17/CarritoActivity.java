package itesm.mx.a01328426_primerparcial_android_feb17;


import android.app.ListActivity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CarritoActivity extends ListActivity {
    ArrayList<Libro> libros = new ArrayList<Libro>();
    ArrayList<Libro> librosComprados ;

    Button bClear;
    Button bComprar;
    TextView totalPrice;
    String isbn,titulo, precio, existenciaString;
    int existencia,image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrito);

        totalPrice = (TextView) findViewById(R.id.tvTotalPrice);
        bClear = (Button) findViewById(R.id.bBorrar);
        bComprar = (Button) findViewById(R.id.bComprar);

        Bundle bundle = this.getIntent().getExtras();

        Libro productoComprar = (Libro) bundle.getSerializable("productoComprado");
        isbn = productoComprar.getisbn();
        titulo = productoComprar.getTitulo();
        existencia = Integer.parseInt(productoComprar.getCantidad());
        existenciaString = productoComprar.getCantidad();
        precio = productoComprar.getPrecio();
        image = productoComprar.getIdImagen();
        totalPrice.setText(precio);


            librosComprados = getDataForListView(isbn,titulo,existenciaString,precio,image);
            libros.addAll(librosComprados);
            LibroAdapter adapterLibros = new LibroAdapter(this, libros);
            setListAdapter(adapterLibros);



    }

    public ArrayList<Libro> getDataForListView(String isbn, String titulo , String  existenciaString, String precio, int image) {
        Libro libro;

        ArrayList<Libro> listLibros = new ArrayList<>();

        libro = new Libro (isbn, titulo,existenciaString,precio, image);
        listLibros.add(libro);

        return  listLibros;
    }



}
