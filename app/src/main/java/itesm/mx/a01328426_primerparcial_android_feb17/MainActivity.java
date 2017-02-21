package itesm.mx.a01328426_primerparcial_android_feb17;
/*
 * Autor(es): Valentin Alexandro Trujillo García  <A01328426>
 *
 * Fecha de creación: 17/Feb/2017
 *
 * Fecha de última modificación: 17/Feb/2017
 *
 */


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etUser;
    String user;
    static final int REQUEST_CODE_REGISTRAR = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUser = (EditText) findViewById(R.id.edit_usuario);
        Button btIniciarSesion = (Button) findViewById(R.id.bt_ingresar);
        Button  btRegistrarse = (Button) findViewById(R.id.bt_registrarse);

        btIniciarSesion.setOnClickListener(this);
        btRegistrarse.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {

        Intent intent;

        switch (v.getId()){
            case R.id.bt_ingresar:
                intent = new Intent(MainActivity.this,CatalogoActivity.class);

                if(etUser.getText().toString().equals(user) && user != null){
                    intent.putExtra("user", user);
                    startActivity(intent);
                }else {
                    Toast.makeText(this.getApplicationContext(), "Usuario Incorrecto", Toast.LENGTH_SHORT).show();
                    etUser.requestFocus();
                }
                break;
            case R.id.bt_registrarse:
                intent = new Intent(MainActivity.this,RegistrarActivity.class);
                startActivityForResult(intent, REQUEST_CODE_REGISTRAR);
                break;
        }
    }

    @Override
    public void onActivityResult (int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK)
            if (requestCode==REQUEST_CODE_REGISTRAR){
                Bundle datos = data.getExtras();
                user = datos.getString("user");
            }
    }


}


