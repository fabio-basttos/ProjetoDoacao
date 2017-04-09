package com.example.fabio.projetodoacao;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by fabio on 09/04/2017.
 */

public class AreaUsuarioActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area_usuario);

        final EditText etNomeUsuario = (EditText) findViewById(R.id.etUsuario);
        final EditText etIdade = (EditText) findViewById(R.id.etIdade);
        final TextView tvWelcome = (TextView) findViewById(R.id.tvWelcomeMsg);


    }
}
