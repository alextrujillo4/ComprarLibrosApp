package itesm.mx.a01328426_primerparcial_android_feb17;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class DetalleLibroActivity extends AppCompatActivity  implements View.OnClickListener , AdapterView.OnItemSelectedListener{

    String isbn,titulo, precio;
    int image, existencia;
    double precioDouble, precioTotal;
    TextView tvIsbn, tvTitulo, tvExistencia,tvCantidadAComprar, tvPrecio;
    ImageView ivLibro;
    Button btnAceptar, btnCancelar;
    Spinner spNumeroLibros;


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



        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.numero_de_libros,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spNumeroLibros.setAdapter(adapter);

        Intent intent = getIntent();
        if(intent.getExtras() != null){

            isbn = intent.getStringExtra("isbn");
            titulo = intent.getStringExtra("titulo");
            existencia = Integer.parseInt(intent.getStringExtra("cantidad"));
            precio = intent.getStringExtra("precio");
            image = intent.getIntExtra("imagen", R.mipmap.ic_launcher);

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
        switch (v.getId()){
            case R.id.button_comprar_libro:
                finish();
                break;
            case  R.id.button_cancelar:
                finish();
                break;
        }

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        int nLibros = position;
        precioTotal = precioDouble*(nLibros);
        btnAceptar.setText("COMPRAR: "+nLibros+" LIBROS POR: $" + precioTotal);
        Toast.makeText(getApplicationContext(),"Comprar: " + nLibros + " libro(s)", Toast.LENGTH_LONG).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

}
