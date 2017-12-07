package com.example.desenvolvedor.myapplication.br.com.DAO;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;

import com.example.desenvolvedor.myapplication.br.com.Model.Reserva;

import java.util.ArrayList;
import java.util.List;

import static com.example.desenvolvedor.myapplication.br.com.DAO.LivroDocumento.TABELA_LIVRO;
import static com.example.desenvolvedor.myapplication.br.com.DAO.ParticipanteDocumento.TABELA_PARTICIPANTE;
import static com.example.desenvolvedor.myapplication.br.com.DAO.ReservaDocumento.COLUNA_LIVRO_ID;
import static com.example.desenvolvedor.myapplication.br.com.DAO.ReservaDocumento.COLUNA_PARTICIPANTE_ID;
import static com.example.desenvolvedor.myapplication.br.com.DAO.ReservaDocumento.TABELA_RESERVA;

/**
 * Created by Desenvolvedor on 07/12/2017.
 */

public class ReservaDAO {

    private final SQLiteDatabase db;

    public ReservaDAO(SQLiteDatabase db) {
        this.db = db;
    }



    public List<Reserva> getReservas(int livro) {
        String selectQuery = getSelectJoinQuery();
        return getReservasFromQuery(livro,selectQuery);
    }


    public List<Reserva> getReservasComLivro(int id) {
        String selectQuery = getSelectJoinQuery() +
                " WHERE tl." + LivroDocumento.COLUNA_ID + " = " + id;
        return getReservasFromQuery(selectQuery);
    }

    public void inserirReserva(Reserva reserva) {
        ContentValues contentValues = getContentValuesFromReserva(reserva);
        db.insert(TABELA_RESERVA, null, contentValues);
    }

    public void updateReserva(Reserva reserva) {
        ContentValues contentValues = getContentValuesFromReserva(reserva);
        db.update(TABELA_RESERVA, contentValues, COLUNA_PARTICIPANTE_ID + "=? AND " + COLUNA_LIVRO_ID + "=?",
                new String[]{ String.valueOf(reserva.getParticipante().getId()), String.valueOf(reserva.getLivro().getId()) });
    }

    public void deletarReserva(int id) {
        db.delete(TABELA_RESERVA, "id=?", new String[] { String.valueOf(id) });
    }

    @NonNull
    private String getSelectJoinQuery() {
        return "SELECT  * FROM " + TABELA_RESERVA + " tr " +
                "INNER JOIN " + TABELA_LIVRO + " tl ON tr." + COLUNA_LIVRO_ID + " = tl." +
                LivroDocumento.COLUNA_ID + " INNER JOIN " + TABELA_PARTICIPANTE + " tp ON tr." +
                COLUNA_PARTICIPANTE_ID + " = tp." + ParticipanteDocumento.COLUNA_ID;
    }

    @NonNull
    private List<Reserva> getReservasFromQuery(int livro,String selectQuery) {
        final Cursor c = db.rawQuery(selectQuery, null);
        c.moveToFirst();
        List<Reserva> reservas = new ArrayList<>(c.getCount());
        if (c.moveToFirst()){
            do {

                    Reserva reserva = new Reserva(
                            ParticipanteDAO.getParticipanteFromCursor(c), LivroDAO.getLivroFromCursor(c));
                if(reserva.getLivro().getId()==livro) {
                    reservas.add(reserva);
                }
            } while(c.moveToNext());
        }
        c.close();
        return reservas;
    }



    @NonNull
    private List<Reserva> getReservasFromQuery(String selectQuery) {
        final Cursor c = db.rawQuery(selectQuery, null);
        c.moveToFirst();
        List<Reserva> reservas = new ArrayList<>(c.getCount());
        if (c.moveToFirst()){
            do {
                Reserva reserva = new Reserva(
                        ParticipanteDAO.getParticipanteFromCursor(c), LivroDAO.getLivroFromCursor(c));
                reservas.add(reserva);
            } while(c.moveToNext());
        }
        c.close();
        return reservas;
    }

    @NonNull
    private ContentValues getContentValuesFromReserva(Reserva reserva) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUNA_PARTICIPANTE_ID, reserva.getParticipante().getId());
        contentValues.put(COLUNA_LIVRO_ID, reserva.getLivro().getId());
        return contentValues;
    }

}
