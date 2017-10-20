package com.example.desenvolvedor.myapplication;

import android.content.Intent;
import android.opengl.EGLExt;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Principal extends AppCompatActivity {



    private Button CadastroParticipante;
    private Button CadastroLivro;
    private Button CadastroReserva;
    private ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        listView = (ListView) findViewById(R.id.listaView);



        CadastroParticipante = (Button) findViewById(R.id.btnCadastroParticipante);
        CadastroReserva = (Button) findViewById(R.id.blnCadastroReserva);
        CadastroLivro = (Button) findViewById(R.id.bltCadastroLivro);

        final ArrayList<String> participantes = preencherDados();

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,participantes);
        listView.setAdapter(arrayAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "Paticipante Curto:" + participantes.get(position).toString(), Toast.LENGTH_SHORT).show();
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "Paticipante Longo:" + participantes.get(position).toString(), Toast.LENGTH_SHORT).show();
                return false;
            }
        });


        CadastroParticipante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent enviarDadosParaAuxiliar1 = new Intent(
                        Principal.this, CadastroParticipantes.class

                );
                startActivity(enviarDadosParaAuxiliar1);

            }
        });


        CadastroReserva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent enviarDadosParaAuxiliar1 = new Intent(
                        Principal.this, CadastroReserva.class

                );
                startActivity(enviarDadosParaAuxiliar1);

            }
        });

        CadastroLivro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent enviarDadosParaAuxiliar1 = new Intent(
                        Principal.this, CadastroLivro.class

                );
                startActivity(enviarDadosParaAuxiliar1);

            }
        });



    }

    public ArrayList<String> preencherDados(){
        ArrayList<String> dados = new ArrayList<>();
        dados.add("Pedro");
        dados.add("Moises");
        dados.add("Paulo");
        return dados;

    }






}
