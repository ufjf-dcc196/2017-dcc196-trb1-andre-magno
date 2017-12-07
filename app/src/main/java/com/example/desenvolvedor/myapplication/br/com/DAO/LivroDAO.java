package com.example.desenvolvedor.myapplication.br.com.DAO;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;

import com.example.desenvolvedor.myapplication.br.com.Model.Livro;

import java.util.ArrayList;
import java.util.List;

import static com.example.desenvolvedor.myapplication.br.com.DAO.LivroDocumento.COLUNA_ANO;
import static com.example.desenvolvedor.myapplication.br.com.DAO.LivroDocumento.COLUNA_EDITORA;
import static com.example.desenvolvedor.myapplication.br.com.DAO.LivroDocumento.COLUNA_ID;
import static com.example.desenvolvedor.myapplication.br.com.DAO.LivroDocumento.COLUNA_TITULO;
import static com.example.desenvolvedor.myapplication.br.com.DAO.LivroDocumento.TABELA_LIVRO;


/**
 * Created by Desenvolvedor on 06/12/2017.
 */

public class LivroDAO {

    private final SQLiteDatabase db;




    public LivroDAO(SQLiteDatabase db) {
        this.db = db;
    }



    public List<Livro> getLivros() {
        String querySelect = "SELECT * FROM " + TABELA_LIVRO + ";";
        final Cursor c = db.rawQuery(querySelect, null);
        c.moveToFirst();
        List<Livro> livros = new ArrayList<>(c.getCount());
        if (c.moveToFirst()){
            do {
                Livro livro = getLivroFromCursor(c);
                livros.add(livro);
            } while(c.moveToNext());
        }
        c.close();
        return livros;
    }

    @NonNull
    static Livro getLivroFromCursor(Cursor c) {
        int id = c.getInt(c.getColumnIndex(COLUNA_ID));
        String titulo = c.getString(c.getColumnIndex(COLUNA_TITULO));
        String editora = c.getString(c.getColumnIndex(COLUNA_EDITORA));
        String anoPublicacao = c.getString(c.getColumnIndex(COLUNA_ANO));
        return new Livro(id, titulo, editora, anoPublicacao);
    }

    public void inserirLivro(Livro livro) {
        ContentValues contentValues = getContentValuesFromLivro(livro);
        db.insert(TABELA_LIVRO, null, contentValues);
    }


    @NonNull
    private ContentValues getContentValuesFromLivro(Livro livro) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUNA_TITULO, livro.getTitulo());
        contentValues.put(COLUNA_EDITORA, livro.getEditora());
        contentValues.put(COLUNA_ANO, livro.getAno());
        return contentValues;
    }



}
