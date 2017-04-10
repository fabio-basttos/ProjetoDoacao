package com.example.fabio.projetodoacao;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by fabio on 09/04/2017.
 */

public class RegistroActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        final EditText etNome = (EditText) findViewById(R.id.etNome);
        final EditText etSobrenome = (EditText) findViewById(R.id.etSobrenome);
        final EditText etUsuario = (EditText) findViewById(R.id.etUsuario);
        final EditText etSenha = (EditText) findViewById(R.id.etSenha);
        final EditText etIdade = (EditText) findViewById(R.id.nIdade);
        final Button btnRegistro = (Button) findViewById(R.id.btnRegistrar);

        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String nome = etNome.getText().toString();
                final String sobrenome = etSobrenome.getText().toString();
                final String nome_usuario = etUsuario.getText().toString();
                final String senha = etSenha.getText().toString();
                final int idade = Integer.parseInt(etIdade.getText().toString());

                Response.Listener<String> responseListener = new Response.Listener<String>(){

                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean sucesso = jsonResponse.getBoolean("sucesso");

                            if (sucesso){
                                Intent intent = new Intent(RegistroActivity.this, RegistroActivity.class);
                                RegistroActivity.this.startActivity(intent);
                            }
                            else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(RegistroActivity.this);
                                builder.setMessage("Não foi possivel gravar registros")
                                        .setNegativeButton("Tente novamente", null)
                                        .create()
                                        .show();
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                RegistroRequest registroRequest = new RegistroRequest(nome, sobrenome, nome_usuario, senha, idade, responseListener);
                RequestQueue queue = Volley.newRequestQueue(RegistroActivity.this);
                queue.add(registroRequest);
            }
        });
    }
}
