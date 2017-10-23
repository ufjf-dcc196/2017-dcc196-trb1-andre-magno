package com.example.desenvolvedor.myapplication;

import java.util.ArrayList;

/**
 * Created by Desenvolvedor on 22/10/2017.
 */

public class Participante {

    private int id;
    private String email;
    private String nome;
    private ArrayList<String> entrada;
    private ArrayList<String> saida;


    public Participante(int id,String nome,String email) {
        this.id = id;
        this.email = email;
        this.nome = nome;
        entrada=new ArrayList<>();
        saida= new ArrayList<>();
        entrada.add("");
        saida.add("");
    }

    public Participante() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<String> getEntrada() {
        return entrada;
    }

    public void setEntrada(ArrayList<String> entrada) {
        this.entrada = entrada;
    }

    public ArrayList<String> getSaida() {
        return saida;
    }

    public void setSaida(ArrayList<String> saida) {
        this.saida = saida;
    }


    @Override
    public String toString() {
        return  nome ;
    }
}
