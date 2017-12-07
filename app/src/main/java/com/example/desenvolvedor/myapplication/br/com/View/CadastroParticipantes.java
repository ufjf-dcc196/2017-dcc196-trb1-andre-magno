package com.example.desenvolvedor.myapplication.br.com.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.desenvolvedor.myapplication.R;
import com.example.desenvolvedor.myapplication.br.com.DAO.ParticipanteDAO;
import com.example.desenvolvedor.myapplication.br.com.Model.Participante;

import static com.example.desenvolvedor.myapplication.br.com.View.Principal.db;

public class CadastroParticipantes extends AppCompatActivity {


    private Button btnSalvar;
    private Button btnCancelar;
    private EditText txtNome;
    private EditText txtEmail;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_participantes);

        btnCancelar = (Button) findViewById(R.id.btnCancelar);
        btnSalvar = (Button) findViewById(R.id.salvar);
        txtNome = (EditText) findViewById(R.id.txtNome);
        txtEmail = (EditText) findViewById(R.id.txtEmail);

        final ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(updateListView());

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParticipanteDAO participanteDAO=new ParticipanteDAO(db);
                participanteDAO.inserirParticipante(new Participante(0, txtNome.getText().toString(), txtEmail.getText().toString()));


                listView.setAdapter(updateListView());

        }

        });

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent enviarDadosParaAuxiliar1 = new Intent(
                        CadastroParticipantes.this,Principal.class

                );
                startActivity(enviarDadosParaAuxiliar1);
            }

        });



    }

    public ArrayAdapter updateListView(){

        ArrayAdapter<Participante> arrayAdapter2;
        arrayAdapter2 = new ArrayAdapter<Participante>(this, android.R.layout.simple_list_item_1, new ParticipanteDAO(db).getParticipantes());
        return arrayAdapter2;
    }
}
