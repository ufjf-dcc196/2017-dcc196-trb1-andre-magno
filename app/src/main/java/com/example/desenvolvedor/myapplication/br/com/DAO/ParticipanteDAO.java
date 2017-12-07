package com.example.desenvolvedor.myapplication.br.com.DAO;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;

import com.example.desenvolvedor.myapplication.br.com.Model.Participante;

import java.util.ArrayList;
import java.util.List;

import static com.example.desenvolvedor.myapplication.br.com.DAO.ParticipanteDocumento.COLUNA_EMAIL;
import static com.example.desenvolvedor.myapplication.br.com.DAO.ParticipanteDocumento.COLUNA_ID;
import static com.example.desenvolvedor.myapplication.br.com.DAO.ParticipanteDocumento.COLUNA_NOME;
import static com.example.desenvolvedor.myapplication.br.com.DAO.ParticipanteDocumento.TABELA_PARTICIPANTE;



public class ParticipanteDAO{


    private final SQLiteDatabase db;

    public ParticipanteDAO(SQLiteDatabase db) {
        this.db = db;
    }

    public List<Participante> getParticipantes() {
        String querySelect = "SELECT * FROM " + TABELA_PARTICIPANTE + ";";
        final Cursor c = db.rawQuery(querySelect, null);
        c.moveToFirst();
        List<Participante> participantes = new ArrayList<>(c.getCount());
        if (c.moveToFirst()){
            do {
                Participante Participante = getParticipanteFromCursor(c);
                participantes.add(Participante);
            } while(c.moveToNext());
        }
        c.close();
        return participantes;
    }

    @NonNull
    static Participante getParticipanteFromCursor(Cursor c) {
        int id = c.getInt(c.getColumnIndex(COLUNA_ID));
        String nome = c.getString(c.getColumnIndex(COLUNA_NOME));
        String email = c.getString(c.getColumnIndex(COLUNA_EMAIL));
        Participante Participante = new Participante(id, nome, email);
        return Participante;
    }

    public void inserirParticipante(Participante Participante) {
        ContentValues contentValues = getContentValuesFromParticipante(Participante);
        db.insert(TABELA_PARTICIPANTE, null, contentValues);
    }

    public void updateParticipante(Participante Participante) {
        ContentValues contentValues = getContentValuesFromParticipante(Participante);
        db.update(TABELA_PARTICIPANTE, contentValues, "id=?", new String[]{ String.valueOf(Participante.getId()) });
    }

    public void deletarParticipante(int id) {
        db.delete(TABELA_PARTICIPANTE, "id=?", new String[] { String.valueOf(id) });
    }

    @NonNull
    private ContentValues getContentValuesFromParticipante(Participante Participante) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUNA_NOME, Participante.getNome());
        contentValues.put(COLUNA_EMAIL, Participante.getEmail());
        return contentValues;
    }


}
