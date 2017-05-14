package com.example.fabio.projetodoacao;

import android.widget.Spinner;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by fabio on 13/05/2017.
 */

public class DoacaoRequest extends StringRequest {

    private static final String REQUEST_DOACAO_URL = "http://doevida.pe.hu/insertDoacao.php";
    private Map<String, String> params;

    public DoacaoRequest(String tipo_doacao, int quantidade, String observacao, Response.Listener<String> listener){
        super(Method.POST, REQUEST_DOACAO_URL, listener, null);
        params = new HashMap<>();
        params.put("tipo_doacao", tipo_doacao);
        params.put("quantidade", quantidade + "");//ADICIONAR ASPAS VAZIAS CONVERTE A IDADE (INT) EM UMA STRING PORQUE NÃO É POSSÍVEL MOSTRAR UM INT EM UM TEXT FIELD DIRETAMENTE
        params.put("observacao", observacao);

    }

    @Override
    public Map<String, String> getParams() {return params ;};

}

