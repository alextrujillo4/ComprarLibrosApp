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

public class CarritoActivity extends ListActivity  implements View.OnClickListener{
    ArrayList<Libro> librosComprados ;

    Button bClear;
    Button bComprar;
    TextView totalPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrito);



        totalPrice = (TextView) findViewById(R.id.tvTotalPrice);
        bClear = (Button) findViewById(R.id.bBorrar);
        bComprar = (Button) findViewById(R.id.bComprar);

        Bundle bundle = this.getIntent().getExtras();
        librosComprados = (ArrayList<Libro>)  getIntent().getSerializableExtra("productoCompradoArray");

            //libros.addAll(librosComprados);
            LibroAdapter adapterLibros = new LibroAdapter(this, librosComprados);
            setListAdapter(adapterLibros);

    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bComprar:
                Toast.makeText(getApplicationContext(),"Gracias por su compra ! :)", Toast.LENGTH_LONG).show();
                break;
            case  R.id.bBorrar:
                Toast.makeText(getApplicationContext(),"Articulos Borrados", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(this, DetalleLibroActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("productoComprado",null);
                intent.putExtras(bundle);
                setResult(CatalogoActivity.RESULT_OK, intent);
                finish();
                break;
        }
    }
}
