package itesm.mx.a01328426_primerparcial_android_feb17;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.view.View;
import android.view.ViewDebug;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.data;

public class DetalleLibroActivity extends AppCompatActivity  implements View.OnClickListener , AdapterView.OnItemSelectedListener{

    String isbn,titulo, precio;
    int image, existencia, nLibros, position;
    double precioDouble, precioTotal;

    TextView tvIsbn, tvTitulo, tvExistencia,tvCantidadAComprar, tvPrecio;
    ImageView ivLibro;
    Button btnAceptar, btnCancelar;
    Spinner spNumeroLibros;

    Libro producto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_libro);


        tvIsbn = (TextView)findViewById(R.id.isbn_libro);
        tvTitulo = (TextView)findViewById(R.id.titulo_libro);
        tvExistencia = (TextView)findViewById(R.id.existencia_libro);
        tvPrecio = (TextView)findViewById(R.id.precio_libro);
        ivLibro = (ImageView)findViewById(R.id.image_libro);
        spNumeroLibros = (Spinner)findViewById(R.id.numero_de_libros_spiner) ;//****SPINER****
        tvCantidadAComprar = (TextView)findViewById(R.id.libro_cantidadAComprar);
        btnAceptar = (Button)findViewById(R.id.button_comprar_libro) ;
        btnCancelar = (Button)findViewById(R.id.button_cancelar) ;

        // GET DATA FROM BLUNDLE (JUST ONE PRODUCT FROM LIST)
        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();
        producto = (Libro) bundle.getSerializable("arrayLibro");
        tvIsbn.setText(producto.getisbn());
        tvTitulo.setText(producto.getTitulo());
        tvExistencia.setText(producto.getCantidad());
        tvPrecio.setText(producto.getPrecio());
        ivLibro.setImageResource(producto.getIdImagen());


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.numero_de_libros,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spNumeroLibros.setAdapter(adapter);

        if(intent.getExtras() != null){

            isbn = producto.getisbn();
            titulo = producto.getTitulo();
            existencia = Integer.parseInt(producto.getCantidad());
            precio = producto.getPrecio();
            image = producto.getIdImagen();

            precioDouble = Double.parseDouble(precio);
            tvIsbn.setText(isbn);
            tvTitulo.setText(titulo);
            tvExistencia.setText(String.valueOf(existencia));
            tvPrecio.setText(precio);
            tvExistencia.setText("Cantidad de libros disponibles: "+existencia);
            Drawable drawable= ContextCompat.getDrawable(this, image);
            ivLibro.setImageDrawable(drawable);
            btnAceptar.setText("Comprar: 0 libro(s) por: $ 0.00");
            spNumeroLibros.setOnItemSelectedListener(this);
            btnAceptar.setOnClickListener(this);
            btnCancelar.setOnClickListener(this);

        }


    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_comprar_libro:
               if (nLibros>existencia){
                    Toast.makeText(getApplicationContext(),"No puedes comprar ésta cantidad de libros, libros insuficientes", Toast.LENGTH_LONG).show();
                }else if (nLibros == 0) {
                   Toast.makeText(getApplicationContext(),"No has agregado nada al carrito de compras", Toast.LENGTH_LONG).show();
                   finish();
               }else {
                   Toast.makeText(getApplicationContext(),"Libro(s) gregado(s) al carrito de compras", Toast.LENGTH_LONG).show();
                   Intent intent = new Intent(DetalleLibroActivity.this, CatalogoActivity.class);
                   Bundle bundle = new Bundle();
                   bundle.putSerializable("productoComprado",producto);
                   intent.putExtras(bundle);
                   setResult(CatalogoActivity.RESULT_OK, intent);
                   finish();
                }
                break;
            case  R.id.button_cancelar:
                finish();
                break;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        nLibros = position;
        precioTotal = precioDouble*(nLibros);
        btnAceptar.setText("COMPRAR: "+nLibros+" LIBROS POR: $" + (int) precioTotal+".00");

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }





}
