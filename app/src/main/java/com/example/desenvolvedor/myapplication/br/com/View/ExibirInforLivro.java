package com.example.desenvolvedor.myapplication.br.com.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.desenvolvedor.myapplication.R;
import com.example.desenvolvedor.myapplication.br.com.Model.Livro;
import com.example.desenvolvedor.myapplication.br.com.Model.Participante;
import com.example.desenvolvedor.myapplication.br.com.Persistencia.LivrosDados;
import com.example.desenvolvedor.myapplication.br.com.Persistencia.ParticipantesDados;
import com.example.desenvolvedor.myapplication.br.com.Persistencia.ReservaDados;

import java.util.ArrayList;

public class ExibirInforLivro extends AppCompatActivity {

    private TextView txtTitulo;
    private TextView txtEditora;
    private TextView txtAno;
    private ListView particiantes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exibir_infor_livro);

        Bundle extras = getIntent().getExtras();

        particiantes= (ListView) findViewById(R.id.listP);
        txtTitulo= (TextView) findViewById(R.id.txtt);
        txtEditora= (TextView) findViewById(R.id.txte);
        txtAno= (TextView) findViewById(R.id.txta);


        if (extras != null) {
            boolean isNew = extras.getBoolean("isNewItem", false);
            if (isNew){
                Toast.makeText(getApplicationContext(), "asdasdasdad", Toast.LENGTH_SHORT).show();
            } else {

                Livro l = LivrosDados.getInstance().get(extras.getInt("posicao"));

                txtTitulo.setText(l.getTitulo());
                txtEditora.setText(l.getEditora());
                txtAno.setText(l.getAno());


                ArrayList<String> participantes=new ArrayList<>();
                for(int i=0;i<ReservaDados.getInstance().getdadosReserva().size();i++) {

                    if(ReservaDados.getInstance().getdadosReserva().get(i).getLivro().equals(l)){
                       participantes.add(ReservaDados.getInstance().getdadosReserva().get(i).getParticipante().getNome());


                    }

                }


               ArrayAdapter<String> arrayAdapterEntrada = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,participantes);

                particiantes.setAdapter(arrayAdapterEntrada);


            }


        }









    }
}
