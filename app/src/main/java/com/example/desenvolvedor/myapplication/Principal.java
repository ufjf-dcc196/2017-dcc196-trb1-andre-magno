package com.example.desenvolvedor.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Principal extends AppCompatActivity {





    private Button CadastroParticipante;
    private Button CadastroLivro;
    private Button CadastroReserva;
    private ListView listView;

    private EditText txtEntrada;
    private EditText txtSaida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        listView = (ListView) findViewById(R.id.listaView);



        CadastroParticipante = (Button) findViewById(R.id.btnCadastroParticipante);
        CadastroReserva = (Button) findViewById(R.id.blnCadastroReserva);
        CadastroLivro = (Button) findViewById(R.id.bltCadastroLivro);
        txtEntrada = (EditText) findViewById(R.id.txtEntrada);
        txtSaida = (EditText) findViewById(R.id.txtSaida);





        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            boolean isNew = extras.getBoolean("isNewItem", false);
            if (isNew) {
                Toast.makeText(getApplicationContext(), "Dados incorretos", Toast.LENGTH_SHORT).show();
            } else {

                ParticipantesDados.getInstance().add(new Participante(ParticipantesDados.getInstance().getDadosPaticipantes().size(), extras.getString("Nome"), extras.getString("Email")));

            }
        }



        ArrayAdapter<Participante> arrayAdapter = new ArrayAdapter<Participante>(this, android.R.layout.simple_list_item_1, ParticipantesDados.getInstance().getDadosPaticipantes());

        listView.setAdapter(arrayAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent1 = new Intent(Principal.this, DadosParticipantes.class);

                intent1.putExtra("posicao",position);
                startActivity(intent1);



            }
        });





        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
            if(txtEntrada.getText().toString().equals("")) {
                SimpleDateFormat dateFormat_hora = new SimpleDateFormat("HH:mm:ss");
                Date data = new Date();
                Calendar cal = Calendar.getInstance();
                cal.setTime(data);
                Date data_atual = cal.getTime();
                String hora=dateFormat_hora.format(data_atual);
                txtEntrada.setText(hora);
                ParticipantesDados.getInstance().get(position).getEntrada().add(hora);
            }else if(txtSaida.getText().toString().equals("")){
                SimpleDateFormat dateFormat_hora = new SimpleDateFormat("HH:mm:ss");
                Date data = new Date();
                Calendar cal = Calendar.getInstance();
                cal.setTime(data);
                Date data_atual = cal.getTime();
                String hora=dateFormat_hora.format(data_atual);
                txtSaida.setText(hora);
                ParticipantesDados.getInstance().get(position).getSaida().add(hora);
            }else {
                txtEntrada.setText("");
                txtSaida.setText("");
            }

                return false;
            }
        });


        //Botões


        CadastroParticipante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent enviarDadosParaAuxiliar1 = new Intent(
                        Principal.this,CadastroParticipantes.class

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











}
