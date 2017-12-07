package com.example.desenvolvedor.myapplication.br.com.DAO;

/**
 * Created by Desenvolvedor on 05/12/2017.
 */

public class ReservaDocumento {

    private ReservaDocumento() { }

    static final String TABELA_RESERVA = "tb_reserva";
    static final String COLUNA_PARTICIPANTE_ID = "id_participante";
            static final String COLUNA_LIVRO_ID = "id_livro";

    static final String CREATE_TABLE_RESERVA = "CREATE TABLE IF NOT EXISTS " + TABELA_RESERVA + " ( " +
            COLUNA_PARTICIPANTE_ID + " INTEGER REFERENCES " + ParticipanteDocumento.TABELA_PARTICIPANTE +"(" + ParticipanteDocumento.COLUNA_ID+ "), " +
            COLUNA_LIVRO_ID + " INTEGER REFERENCES " + LivroDocumento.TABELA_LIVRO +"(" + LivroDocumento.COLUNA_ID+ ") " +
            ");";
}
