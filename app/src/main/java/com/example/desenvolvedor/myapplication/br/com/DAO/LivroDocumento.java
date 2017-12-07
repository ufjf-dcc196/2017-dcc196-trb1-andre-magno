package com.example.desenvolvedor.myapplication.br.com.DAO;

/**
 * Created by Desenvolvedor on 05/12/2017.
 */

public class LivroDocumento {

    private LivroDocumento() { }

    static final String TABELA_LIVRO = "tb_livro";
    static final String COLUNA_ID = "id";
    static final String COLUNA_TITULO = "titulo";
    static final String COLUNA_EDITORA = "editora";
    static final String COLUNA_ANO = "ano";

    static final String CREATE_TABLE_LIVRO = "CREATE TABLE IF NOT EXISTS " + TABELA_LIVRO + " ( " +
            COLUNA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COLUNA_TITULO + " TEXT NOT NULL, " +
            COLUNA_EDITORA + " TEXT NOT NULL, " +
            COLUNA_ANO + " TEXT NOT NULL " +
            ");";
}