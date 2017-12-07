package com.example.desenvolvedor.myapplication.br.com.View;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.desenvolvedor.myapplication.R;
import com.example.desenvolvedor.myapplication.br.com.DAO.LivroDAO;
import com.example.desenvolvedor.myapplication.br.com.DAO.ReservaDAO;
import com.example.desenvolvedor.myapplication.br.com.Model.Livro;
import com.example.desenvolvedor.myapplication.br.com.Model.Reserva;

import java.util.ArrayList;

import static com.example.desenvolvedor.myapplication.br.com.View.Principal.db;

public class ExibirInforLivro extends AppCompatActivity {

    private TextView txtTitulo;
    private TextView txtEditora;
    private TextView txtAno;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exibir_infor_livro);

        Bundle extras = getIntent().getExtras();

        final ListView  particiantes= (ListView) findViewById(R.id.listP);
        txtTitulo= (TextView) findViewById(R.id.txtt);
        txtEditora= (TextView) findViewById(R.id.txte);
        txtAno= (TextView) findViewById(R.id.txta);


        if (extras != null) {
            boolean isNew = extras.getBoolean("isNewItem", false);
            if (isNew){
                Toast.makeText(getApplicationContext(), "asdasdasdad", Toast.LENGTH_SHORT).show();
            } else {

                ArrayList<Livro> livros = (ArrayList<Livro>) new LivroDAO(db).getLivros();
                for(int i=0; i<livros.size();i++){
                    if(livros.get(i).getId()==extras.getInt("posicao"));
                    {
                        txtEditora.setText(livros.get(i).getEditora());
                        txtTitulo.setText(livros.get(i).getTitulo());
                        txtAno.setText(livros.get(i).getAno());

                    }

                }
                ArrayList<String> participantes=new ArrayList<>();
                ArrayList<Reserva> reservas= (ArrayList<Reserva>) new ReservaDAO(db).getReservas(extras.getInt("posicao"));
                for(int i = 0; i<reservas.size(); i++) {

                    participantes.add(reservas.get(i).getParticipante().getNome());


                }


                ArrayAdapter<String> arrayAdapterEntrada = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,participantes);

                particiantes.setAdapter(arrayAdapterEntrada);


            }


        }









    }
}
