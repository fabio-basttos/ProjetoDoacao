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

    private static final String REQUEST_REGISTRO_URL = "http://doevida.pe.hu/registro.php";
    private Map<String, String> params;

    public RegistroRequest(String nome, String sobrenome, String nome_usuario, String senha, int idade, Response.Listener<String> listener) {
        super(Method.POST, REQUEST_REGISTRO_URL, listener, null);
        params = new HashMap<>();
        params.put("nome", nome);
        params.put("sobrenome", sobrenome);
        params.put("nome_usuario", nome_usuario);
        params.put("senha", senha);
        params.put("idade", idade + "");
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
