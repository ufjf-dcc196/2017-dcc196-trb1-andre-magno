package com.example.desenvolvedor.myapplication.br.com.DAO;

/**
 * Created by Desenvolvedor on 05/12/2017.
 */

public class EntradaSaidaDocumento {
    private EntradaSaidaDocumento() { }

    static final String TABELA_ENTRADA_SAIDA = "tb_entradaSaida";

    static final String COLUNA_ID = "id";
    static final String COLUNA_ENTRADA = "entrada";
    static final String COLUNA_SAIDA = "saida";
    static final String COLUNA_PARTICIPANTE_ID = "participante_id";


    static final String CREATE_TABLE_ENTRADA_SAIDA = "CREATE TABLE IF NOT EXISTS " + TABELA_ENTRADA_SAIDA + " ( " +
            COLUNA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COLUNA_ENTRADA + " TEXT NOT NULL, " +
            COLUNA_SAIDA + " TEXT NOT NULL, " +
            COLUNA_PARTICIPANTE_ID + " INTEGER REFERENCES " + LivroDocumento.TABELA_LIVRO +"(" + LivroDocumento.COLUNA_ID+ ") " +
            ");";
}


