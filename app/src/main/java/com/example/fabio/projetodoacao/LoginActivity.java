package com.example.fabio.projetodoacao;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * Created by fabio on 09/04/2017.
 */
public class LoginActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText etUsuario = (EditText) findViewById(R.id.etUsuario);
        final EditText etSenha = (EditText) findViewById(R.id.etSenha);
        final Button btnLogin = (Button) findViewById(R.id.btnLogin);
        final TextView registrarLink = (TextView) findViewById(R.id.tvRegistrar);

        registrarLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registarIntent = new Intent(LoginActivity.this, RegistroActivity.class);
                LoginActivity.this.startActivity(registarIntent);
            }
        });
    }
}
