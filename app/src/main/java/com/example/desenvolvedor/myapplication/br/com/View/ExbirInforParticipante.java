package com.example.desenvolvedor.myapplication.br.com.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.desenvolvedor.myapplication.R;
import com.example.desenvolvedor.myapplication.br.com.Model.Participante;
import com.example.desenvolvedor.myapplication.br.com.Persistencia.ParticipantesDados;

public class ExbirInforParticipante extends AppCompatActivity {


    private ListView listaEntrada;
    private ListView listaSaida;
    private TextView txtNome;
    private TextView txtEmail;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exbir_infor_participante);

        Bundle extras = getIntent().getExtras();

        listaEntrada = (ListView) findViewById(R.id.ListaEntrada);
        listaSaida = (ListView) findViewById(R.id.listaSaida);
        txtNome = (TextView) findViewById(R.id.txtNome);
        txtEmail = (TextView) findViewById(R.id.txtEmail);



        if (extras != null) {
            boolean isNew = extras.getBoolean("isNewItem", false);
            if (isNew){
                Toast.makeText(getApplicationContext(), "asdasdasdad", Toast.LENGTH_SHORT).show();
            } else {

                Participante p = ParticipantesDados.getInstance().get(extras.getInt("posicao"));
                txtNome.setText(p.getNome());
                txtEmail.setText(p.getEmail());

                ArrayAdapter<String> arrayAdapterEntrada = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, p.getEntrada());

                listaEntrada.setAdapter(arrayAdapterEntrada);
                ArrayAdapter<String> arrayAdapterSaida = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, p.getSaida());

                listaSaida.setAdapter(arrayAdapterSaida);

            }
        }





    }
}
