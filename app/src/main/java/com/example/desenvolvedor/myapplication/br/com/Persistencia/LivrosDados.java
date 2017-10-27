package com.example.desenvolvedor.myapplication.br.com.Persistencia;

import com.example.desenvolvedor.myapplication.br.com.Model.Livro;

import java.util.ArrayList;

/**
 * Created by Desenvolvedor on 22/10/2017.
 */

public class LivrosDados {


        private static ArrayList<Livro> dadosLivros = new ArrayList<>();
        private static LivrosDados instance;

        private LivrosDados() {

        }

        public static LivrosDados getInstance() {

            if (instance == null) {
                instance = new LivrosDados();
                dadosLivros.add(new Livro(dadosLivros.size(),"O Mar", "Peason","2017"));
                dadosLivros.add(new Livro(dadosLivros.size(),"A Mare", "Peason","2012" ));
            }
            return instance;
        }


        public void add(Livro p){
            dadosLivros.add(p);
        }

        public Livro get(int i){

           return dadosLivros.get(i);
        }


    public  ArrayList<Livro> getdadosLivros() {
        return dadosLivros;
    }

    public  void setdadosLivros(ArrayList<Livro> dadosLivros) {
        LivrosDados.dadosLivros = dadosLivros;
    }

    public  void setInstance(LivrosDados instance) {
        LivrosDados.instance = instance;
    }



}
