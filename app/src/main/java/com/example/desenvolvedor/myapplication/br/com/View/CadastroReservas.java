package com.example.desenvolvedor.myapplication.br.com.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.desenvolvedor.myapplication.R;
import com.example.desenvolvedor.myapplication.br.com.DAO.LivroDAO;
import com.example.desenvolvedor.myapplication.br.com.DAO.ParticipanteDAO;
import com.example.desenvolvedor.myapplication.br.com.DAO.ReservaDAO;
import com.example.desenvolvedor.myapplication.br.com.Model.Livro;
import com.example.desenvolvedor.myapplication.br.com.Model.Participante;
import com.example.desenvolvedor.myapplication.br.com.Model.Reserva;

import static com.example.desenvolvedor.myapplication.br.com.View.Principal.db;

public class CadastroReservas extends AppCompatActivity {


    private Button btnSalvar;
    private Button btnVoltar;
    private Spinner spiParticipantes;
    private Spinner spiLivros;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_reservas);


        spiParticipantes = (Spinner) findViewById(R.id.spPessoa);
        spiLivros = (Spinner) findViewById(R.id.spLivro);
        btnSalvar = (Button) findViewById(R.id.btnS);
        btnVoltar = (Button) findViewById(R.id.btnV);


        ArrayAdapter<Livro> arrayAdapter = new ArrayAdapter<Livro>(this, android.R.layout.simple_list_item_1, new LivroDAO(db).getLivros());
        arrayAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spiLivros.setAdapter(arrayAdapter);




    ArrayAdapter<Participante> arrayAdapter2;
    arrayAdapter2 = new ArrayAdapter<Participante>(this, android.R.layout.simple_list_item_1, new ParticipanteDAO(db).getParticipantes());
        arrayAdapter2.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spiParticipantes.setAdapter(arrayAdapter2);


        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(spiLivros.getSelectedItemPosition()==-1){
                    Toast.makeText(getApplicationContext(), "Selecione um Livro", Toast.LENGTH_SHORT).show();
                }else if(spiParticipantes.getSelectedItemPosition()==-1){
                    Toast.makeText(getApplicationContext(), "Selecione um Participante", Toast.LENGTH_SHORT).show();
                } else {
                    Participante participante = (Participante) spiParticipantes.getSelectedItem();
                    Livro livro = (Livro) spiLivros.getSelectedItem();
                    new ReservaDAO(db).inserirReserva(new Reserva(participante,livro));

                    spiParticipantes.setSelection(0);
                    spiLivros.setSelection(0);

                    Toast.makeText(getApplicationContext(), "Livro: " + livro.getTitulo()+"  Reservado por: "+participante, Toast.LENGTH_SHORT).show();
                }

            }
        });
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent enviarDadosParaAuxiliar1 = new Intent(
                        CadastroReservas.this, Principal.class

                );
                startActivity(enviarDadosParaAuxiliar1);

            }
        });




    }

}
