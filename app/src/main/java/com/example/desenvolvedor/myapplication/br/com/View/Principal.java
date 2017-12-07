package com.example.desenvolvedor.myapplication.br.com.View;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.desenvolvedor.myapplication.R;
import com.example.desenvolvedor.myapplication.br.com.DAO.Banco;
import com.example.desenvolvedor.myapplication.br.com.DAO.ParticipanteDAO;
import com.example.desenvolvedor.myapplication.br.com.DAO.ParticipantesDados;
import com.example.desenvolvedor.myapplication.br.com.Model.Participante;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Principal extends AppCompatActivity {

    static final String NOME_BD = "banco";


    private Button CadastroParticipante;
    private Button CadastroLivro;
    private Button CadastroReserva;
    private Button Update;


    private EditText txtEntrada;
    private EditText txtSaida;

    static SQLiteDatabase db ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);


        final ListView listView1 = (ListView) findViewById(R.id.listView12);


        CadastroParticipante = (Button) findViewById(R.id.btnCadastroParticipante);
        CadastroReserva = (Button) findViewById(R.id.blnCadastroReserva);
        txtEntrada = (EditText) findViewById(R.id.txtEntrada);
        txtSaida = (EditText) findViewById(R.id.txtSaida);
        CadastroLivro = (Button) findViewById(R.id.bltCadastroLivro);
        Update = (Button) findViewById(R.id.Update);


        if(db==null) {
            db = openOrCreateDatabase(NOME_BD, MODE_APPEND, null);
            Banco.criarTabelas(db);
        }
        Update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listView1.setAdapter(updateListView());

            }
        });




        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent1 = new Intent(Principal.this, ExbirInforParticipante.class);
                intent1.putExtra("posicao",position);
                startActivity(intent1);
            }
        });





        listView1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
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
                listView1.setAdapter(updateListView());
                Intent intent = new Intent(Principal.this, CadastroParticipantes.class);
                startActivity(intent);

            }
        });


        CadastroReserva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent enviarDadosParaAuxiliar1 = new Intent(
                        Principal.this, CadastroReservas.class

                );
                startActivity(enviarDadosParaAuxiliar1);

            }
        });

        CadastroLivro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent enviarDadosParaAuxiliar1 = new Intent(
                        Principal.this, com.example.desenvolvedor.myapplication.br.com.View.CadastroLivro.class

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
