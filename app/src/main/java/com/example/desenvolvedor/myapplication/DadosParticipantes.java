package com.example.desenvolvedor.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.*;

import java.util.ArrayList;

public class DadosParticipantes extends AppCompatActivity {


    private ListView listaEntrada;
    private ListView listaSaida;
    private TextView txtNome;
    private TextView txtEmail;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados_participantes);

        Bundle extras = getIntent().getExtras();

        listaEntrada = (ListView) findViewById(R.id.listaView);
        listaSaida = (ListView) findViewById(R.id.listaSaida);





        txtNome = (EditText) findViewById(R.id.txtNome_d);
        txtEmail = (EditText) findViewById(R.id.txtDados_d);





        if (extras != null) {
            boolean isNew = extras.getBoolean("isNewItem", false);
            if (isNew){
                Toast.makeText(getApplicationContext(), "asdasdasdad", Toast.LENGTH_SHORT).show();
            } else {

                Participante p = ParticipantesDados.getInstance().get(extras.getInt("posicao"));

                ArrayAdapter<String> entrada = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, p.getEntrada());
                ArrayAdapter<String> saida = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, p.getSaida());


                txtNome.setText(p.getNome());
                txtEmail.setText(p.getEmail());
                listaEntrada.setAdapter(entrada);
                listaSaida.setAdapter(saida);

            }
        }













    }
}
