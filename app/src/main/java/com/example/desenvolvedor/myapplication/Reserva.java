package com.example.desenvolvedor.myapplication;

import java.util.ArrayList;

/**
 * Created by Desenvolvedor on 22/10/2017.
 */

public class Reserva {
    private Participante participante;
    private Livro livro;

    public Reserva(Participante participante, Livro livro) {
        this.participante = participante;
        this.livro = livro;
    }

    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "participante=" + participante +
                ", livro=" + livro +
                '}';
    }
}
