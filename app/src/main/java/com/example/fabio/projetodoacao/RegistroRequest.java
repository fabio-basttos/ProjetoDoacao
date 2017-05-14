package com.example.fabio.projetodoacao;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by fabio on 09/04/2017.
 */

public class RegistroRequest extends StringRequest {

    private static final String REQUEST_REGISTRO_URL = "http://doevida.pe.hu/insertUsuario.php";
    private Map<String, String> params;

    public RegistroRequest(String nome, String sobrenome, String nome_usuario, String senha, int idade, String endereco, int cep, String cidade, String bairro, Response.Listener<String> listener) {
        super(Method.POST, REQUEST_REGISTRO_URL, listener, null);
        params = new HashMap<>();
        params.put("nome", nome);
        params.put("sobrenome", sobrenome);
        params.put("nome_usuario", nome_usuario);
        params.put("senha", senha);
        params.put("idade", idade + " ");
        params.put("endereco", endereco);
        params.put("cep", cep + " ");
        params.put("cidade", cidade);
        params.put("bairro", bairro);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
