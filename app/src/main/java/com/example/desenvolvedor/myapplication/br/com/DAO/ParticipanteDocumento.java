package com.example.desenvolvedor.myapplication.br.com.DAO;

/**
 * Created by Desenvolvedor on 05/12/2017.
 */

public class ParticipanteDocumento {

    private ParticipanteDocumento() { }

    static final String TABELA_PARTICIPANTE = "tb_participante";
    static final String COLUNA_ID = "id";
    static final String COLUNA_NOME = "nome";
    static final String COLUNA_EMAIL = "email";


    static final String CREATE_TABLE_PARTICIPANTE = "CREATE TABLE IF NOT EXISTS " + TABELA_PARTICIPANTE + " ( " +
            COLUNA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COLUNA_NOME + " TEXT NOT NULL, " +
            COLUNA_EMAIL + " TEXT NOT NULL" +
            ");";
}
