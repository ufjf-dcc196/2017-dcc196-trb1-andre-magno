package com.example.desenvolvedor.myapplication.br.com.DAO;

import android.database.sqlite.SQLiteDatabase;

import static com.example.desenvolvedor.myapplication.br.com.DAO.EntradaSaidaDocumento.TABELA_ENTRADA_SAIDA;
import static com.example.desenvolvedor.myapplication.br.com.DAO.LivroDocumento.TABELA_LIVRO;
import static com.example.desenvolvedor.myapplication.br.com.DAO.ParticipanteDocumento.TABELA_PARTICIPANTE;
import static com.example.desenvolvedor.myapplication.br.com.DAO.ReservaDocumento.TABELA_RESERVA;



public class Banco{

    static final String DATE_FORMAT = "dd-MM-yyyy HH:mm:ss";

    public static void criarTabelas(SQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS " + TABELA_PARTICIPANTE);
        db.execSQL("DROP TABLE IF EXISTS " + TABELA_LIVRO);
        db.execSQL("DROP TABLE IF EXISTS " + TABELA_RESERVA);
        db.execSQL("DROP TABLE IF EXISTS " + TABELA_ENTRADA_SAIDA);
        db.execSQL(ParticipanteDocumento.CREATE_TABLE_PARTICIPANTE);
        db.execSQL(LivroDocumento.CREATE_TABLE_LIVRO);
        db.execSQL(ReservaDocumento.CREATE_TABLE_RESERVA);
        db.execSQL(EntradaSaidaDocumento.CREATE_TABLE_ENTRADA_SAIDA);

    }


}

