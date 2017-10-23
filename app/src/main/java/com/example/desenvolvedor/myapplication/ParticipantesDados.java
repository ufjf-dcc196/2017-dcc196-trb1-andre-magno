package com.example.desenvolvedor.myapplication;

import java.util.ArrayList;

/**
 * Created by Desenvolvedor on 22/10/2017.
 */

public class ParticipantesDados {


        private static ArrayList<Participante> dadosPaticipantes = new ArrayList<>();
        private static ParticipantesDados instance;

        private ParticipantesDados() {

        }

        public static ParticipantesDados getInstance() {

            if (instance == null) {
                instance = new ParticipantesDados();
                dadosPaticipantes.add(new Participante(dadosPaticipantes.size(),"Pedro","asdf@gmail.com"));
                dadosPaticipantes.add(new Participante(dadosPaticipantes.size(),"Jóse","iuytrriu@gmail.com"));
                dadosPaticipantes.add(new Participante(dadosPaticipantes.size(),"Joao","adsfgsg@gmail.com"));
            }
            return instance;
        }


        public void add(Participante p){
            dadosPaticipantes.add(p);
        }

        public Participante get(int i){

           return dadosPaticipantes.get(i);
        }


    public  ArrayList<Participante> getDadosPaticipantes() {
        return dadosPaticipantes;
    }

    public  void setDadosPaticipantes(ArrayList<Participante> dadosPaticipantes) {
        ParticipantesDados.dadosPaticipantes = dadosPaticipantes;
    }

    public  void setInstance(ParticipantesDados instance) {
        ParticipantesDados.instance = instance;
    }



}
