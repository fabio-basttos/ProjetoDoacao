package com.example.fabio.projetodoacao;

/**
 * Created by fabio on 16/04/2017.
 */

public class Usuario {
    private long id_usuario;
    private String nome;
    private String sobrenome;
    private String nome_usuario;
    private String senha;
    private int idade;

    public Usuario() {
    }

    public Usuario(long id_usuario, String nome, String sobrenome, String nome_usuario, String senha, int idade) {
        this.id_usuario = id_usuario;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.nome_usuario = nome_usuario;
        this.senha = senha;
        this.idade = idade;
    }

    public long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getNome_usuario() {
        return nome_usuario;
    }

    public void setNome_usuario(String cidade) {
        this.nome_usuario = nome_usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String cidade) {
        this.senha = senha;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int ano) {
        this.idade = idade;
    }
}
