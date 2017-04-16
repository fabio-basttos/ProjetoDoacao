package com.example.fabio.projetodoacao;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;


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

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String nome_usuario = etUsuario.getText().toString();
                final String senha = etSenha.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean sucesso = jsonResponse.getBoolean("sucesso");

                            if (sucesso){
                                String nome = jsonResponse.getString("nome");
                                int idade = jsonResponse.getInt("idade");

                                Intent intent = new Intent(LoginActivity.this, AreaUsuarioActivity.class);
                                intent.putExtra("nome", nome);
                                intent.putExtra("nome_usuário", nome_usuario);
                                intent.putExtra("idade", idade);

                                LoginActivity.this.startActivity(intent);

                            }else{
                                AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                                builder.setMessage("Não foi possivel Logar")
                                        .setNegativeButton("Tente novamente", null)
                                        .create()
                                        .show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                LoginRequest loginRequest = new LoginRequest(nome_usuario, senha, responseListener);
                RequestQueue queue = Volley.newRequestQueue(LoginActivity.this);
                queue.add(loginRequest);


            }
        });
    }
}
