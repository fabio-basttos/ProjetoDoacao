package com.example.fabio.projetodoacao;

import android.app.Activity;
import android.content.Intent;
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
        final TextView mensagemBoasVindas = (TextView) findViewById(R.id.tvWelcomeMsg);

        Intent intent = getIntent();
        String nome = intent.getStringExtra("nome");
        String nome_usuario = intent.getStringExtra("nome_usuario");
        int idade = intent.getIntExtra("idade", -1);

        String mensagem = nome + " bem vindo a sua área de usuário";
        mensagemBoasVindas.setText(mensagem);
        etNomeUsuario.setText(nome_usuario);
        etIdade.setText(idade + ""); //ADICIONAR ASPAS VAZIAS CONVERTE A IDADE (INT) EM UMA STRING PORQUE NÃO É POSSÍVEL MOSTRAR UM INT EM UM TEXT FIELD DIRETAMENTE




    }
}
