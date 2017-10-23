package com.example.desenvolvedor.myapplication;

import android.content.Intent;

/**
 * Created by Desenvolvedor on 22/10/2017.
 */

class Livro {
    private int id;
    private String titulo;
    private String editora;
    private int ano;


    public Livro(int id, String titulo, String editora, int ano) {
        this.id = id;
        this.titulo = titulo;
        this.editora = editora;
        this.ano = ano;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    @Override
    public String toString() {
        return titulo ;
    }
}
