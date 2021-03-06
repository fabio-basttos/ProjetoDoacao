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
        final EditText etEndereco = (EditText) findViewById(R.id.etEndereco);
        final EditText etCEP = (EditText) findViewById(R.id.etCEP);
        final EditText etCidade = (EditText) findViewById(R.id.etCidade);
        final EditText etBairro = (EditText) findViewById(R.id.etBairro);
        final Button btnRegistro = (Button) findViewById(R.id.btnRegistrar);

        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String nome = etNome.getText().toString();
                final String sobrenome = etSobrenome.getText().toString();
                final String nome_usuario = etUsuario.getText().toString();
                final String senha = etSenha.getText().toString();
                final int idade = Integer.parseInt(etIdade.getText().toString());
                final String endereco = etEndereco.getText().toString();
                final int cep = Integer.parseInt(etCEP.getText().toString());
                final String cidade = etCidade.getText().toString();
                final String bairro = etBairro.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>(){

                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean sucesso = jsonResponse.getBoolean("sucesso");

                            if (sucesso){
                                Intent intent = new Intent(RegistroActivity.this, LoginActivity.class);
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

                RegistroRequest registroRequest = new RegistroRequest(nome, sobrenome, nome_usuario, senha, idade, endereco, cep, cidade, bairro, responseListener);
                RequestQueue queue = Volley.newRequestQueue(RegistroActivity.this);
                queue.add(registroRequest);
            }
        });
    }
}
