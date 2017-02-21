package itesm.mx.a01328426_primerparcial_android_feb17;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrarActivity extends AppCompatActivity implements View.OnClickListener {
    EditText etUser = null;
    EditText etConfirmUser = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);
        etUser = (EditText) findViewById(R.id.edit_user);
        etConfirmUser = (EditText) findViewById(R.id.edit_Confirmuser);
        Button btnRegistrarse = (Button) findViewById(R.id.button_registrarse);
        btnRegistrarse.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if (etUser.getText() != null && etUser.getText() != null && etConfirmUser.getText() != null &&
                etUser.getText().toString().equals(etConfirmUser.getText().toString()) && !etUser.getText().toString().equals("")) {

            Toast.makeText(this.getApplicationContext(), "El usuario se ha registrado exitosamente", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent();
            intent.putExtra("user", etUser.getText().toString());
            setResult(RESULT_OK, intent);
            finish();

        } else {
            Toast.makeText(this.getApplicationContext(), "Usuario Inválido, porfavor inténtalo de nuevo", Toast.LENGTH_SHORT).show();

        }
    }

}

