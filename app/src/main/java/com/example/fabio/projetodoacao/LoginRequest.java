package com.example.fabio.projetodoacao;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by fabio on 15/04/2017.
 */

public class LoginRequest extends StringRequest {

    private static final String REQUEST_LOGIN_URL = "http://doevida.pe.hu/login.php";
    private Map<String, String> params;

    public LoginRequest (String nome_usuario, String senha, Response.Listener<String> listener) {
        super(Method.POST, REQUEST_LOGIN_URL, listener, null);
        params = new HashMap<>();
        params.put("nome_usuario", nome_usuario);
        params.put("senha", senha);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
