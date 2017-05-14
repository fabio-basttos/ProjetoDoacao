package com.example.fabio.projetodoacao;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by fabio on 13/05/2017.
 */

public class DoacaoActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doacao);

        final Spinner spTipoDoacao = (Spinner) findViewById(R.id.spTipoDoacao);
        final EditText etQuantidade = (EditText) findViewById(R.id.etQuantidade);
        final EditText etEnderecoDoacao = (EditText) findViewById(R.id.etEnderecoDoacao);
        final EditText etBairroDoacao = (EditText) findViewById(R.id.etBairroDoacao);
        final EditText etCidadeDoacao = (EditText) findViewById(R.id.etCidadeDoacao);
        final EditText etObservacao = (EditText) findViewById(R.id.etObservacao);
        final Button btnDoar = (Button) findViewById(R.id.btnDoar);

        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(DoacaoActivity.this
                , android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.tipo_doacao));
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spTipoDoacao.setAdapter(spinnerAdapter);

        btnDoar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String tipo_doacao = spTipoDoacao.getSelectedItem().toString();
                final int quantidade = Integer.parseInt(etQuantidade.getText().toString());
                final String endereco_doacao = etEnderecoDoacao.getText().toString();
                final String bairro_doacao = etBairroDoacao.getText().toString();
                final String cidade_doacao = etCidadeDoacao.getText().toString();
                final String observacao = etObservacao.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean sucesso = jsonResponse.getBoolean("sucesso");

                            if (sucesso) {
                                Toast.makeText(getApplicationContext(),"Doação Registrada",Toast.LENGTH_LONG);
                                Intent intent = new Intent(DoacaoActivity.this, AreaUsuarioActivity.class);
                                DoacaoActivity.this.startActivity(intent);
                            } else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(DoacaoActivity.this);
                                builder.setMessage("Não foi possivel registrar a Doação")
                                        .setNegativeButton("Tente novamente", null)
                                        .create()
                                        .show();
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                DoacaoRequest doacaoRequest = new DoacaoRequest(tipo_doacao, quantidade, endereco_doacao, bairro_doacao, cidade_doacao, observacao, responseListener);
                RequestQueue queue = Volley.newRequestQueue(DoacaoActivity.this);
                queue.add(doacaoRequest);
            }
        });
    }
}

