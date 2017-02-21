package itesm.mx.a01328426_primerparcial_android_feb17;

import android.app.ListActivity;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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
    ArrayList<Libro> arrayLibro2 = null;

    Bundle bundle;
    String b1="5", b2="8", b3="6", b4="3", b5="10";
    static final int REFRESHDATA = 1;
    static final int COMPRASCODE = 2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalogo);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            if(bundle != null){
                Intent intent = new Intent(CatalogoActivity.this, CarritoActivity.class);
                Bundle bundleCarritos = new Bundle();
                bundleCarritos.putSerializable("productoCompradoArray",arrayLibro);
                intent.putExtras(bundleCarritos);
                startActivity(intent);

            }else{
                Snackbar.make(view, "No hay objetos en el Carrito de Compras", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }

            }
        });


        arrayLibro = getDataForListView();
        LibroAdapter adapterLibros = new LibroAdapter(this, arrayLibro);
        setListAdapter(adapterLibros);
        getListView().setOnItemClickListener(this);
    }


    public ArrayList<Libro> getDataForListView() {
        Libro libro;
        ArrayList<Libro> listLibros = new ArrayList<Libro>();

        libro = new Libro ("013438945X", "Introduction to Android Application Development: Android Essentials",
                b1,"39.99", R.drawable.book1);
        listLibros.add(libro);

        libro = new Libro ("01785886193", "Android Application Development: Cookbook 2nd Edition",
                b2,"44.99", R.drawable.book2);
        listLibros.add(libro);

        libro = new Libro ("9781785889035", "Android Programming for Beginners",
                b3,"48.00", R.drawable.book3);
        listLibros.add(libro);

        libro = new Libro ("1430264543", "Learn Java for Android  Development ",
                b4,"56.00", R.drawable.book4);
        listLibros.add(libro);

        libro = new Libro ("9781329747517", "Android: App  Development & Programming Guide: Learn In A Day",
                b5,"39.49", R.drawable.book5);
        listLibros.add(libro);


        return  listLibros;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Libro libro = (Libro)parent.getItemAtPosition(position);
        Intent intent = new Intent(this, DetalleLibroActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("arrayLibro",libro);
        intent.putExtras(bundle);
        startActivityForResult(intent,REFRESHDATA);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case REFRESHDATA:
                if (resultCode == RESULT_OK) {
                    Intent intent = this.getIntent();
                    Bundle bundleLibros = intent.getExtras();
                    Libro productoComprado = (Libro) bundleLibros.getSerializable("arrayLibro");
                    bundle = bundleLibros;
                    
                }

                break;

            case COMPRASCODE:
                Intent intent = this.getIntent();
                bundle = intent.getExtras();
                bundle = getIntent().getExtras();
                bundle = data.getExtras();

        }
    }

    }



