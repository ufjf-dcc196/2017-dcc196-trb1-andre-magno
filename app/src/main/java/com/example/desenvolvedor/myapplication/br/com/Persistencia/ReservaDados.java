package com.example.desenvolvedor.myapplication.br.com.Persistencia;

import com.example.desenvolvedor.myapplication.br.com.Model.Livro;
import com.example.desenvolvedor.myapplication.br.com.Model.Participante;
import com.example.desenvolvedor.myapplication.br.com.Model.Reserva;

import java.util.ArrayList;

/**
 * Created by Desenvolvedor on 22/10/2017.
 */

public class ReservaDados {


        private static ArrayList<Reserva> dadosReserva = new ArrayList<>();
        private static ReservaDados instance;

        private ReservaDados() {

        }

        public static ReservaDados getInstance() {

            if (instance == null) {
                instance = new ReservaDados();
                dadosReserva.add(new Reserva(new Participante(1,"Pedro","asdf@gmail.com"),new Livro(LivrosDados.getInstance().getdadosLivros().size(),"O Mar", "Peason","2017")));

            }
            return instance;
        }


        public void add(Reserva l){
            dadosReserva.add(l);
        }

        public Reserva get(int i){

           return dadosReserva.get(i);
        }


    public  ArrayList<Reserva> getdadosReserva() {
        return dadosReserva;
    }

    public  void setdadosReserva(ArrayList<Reserva> dadosReserva) {
        ReservaDados.dadosReserva = dadosReserva;
    }

    public  void setInstance(ReservaDados instance) {
        ReservaDados.instance = instance;
    }



}
