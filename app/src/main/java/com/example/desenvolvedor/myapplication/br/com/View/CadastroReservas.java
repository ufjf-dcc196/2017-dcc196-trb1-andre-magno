package com.example.desenvolvedor.myapplication.br.com.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.desenvolvedor.myapplication.R;
import com.example.desenvolvedor.myapplication.br.com.Model.Livro;
import com.example.desenvolvedor.myapplication.br.com.Model.Participante;
import com.example.desenvolvedor.myapplication.br.com.Model.Reserva;
import com.example.desenvolvedor.myapplication.br.com.Persistencia.LivrosDados;
import com.example.desenvolvedor.myapplication.br.com.Persistencia.ParticipantesDados;
import com.example.desenvolvedor.myapplication.br.com.Persistencia.ReservaDados;

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


        ArrayAdapter<Livro> livro = new ArrayAdapter<Livro>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, LivrosDados.getInstance().getdadosLivros());
        livro.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spiLivros.setAdapter(livro);

        ArrayAdapter<Participante> participanteAdapter = new ArrayAdapter<Participante>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, ParticipantesDados.getInstance().getDadosPaticipantes());
        participanteAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spiParticipantes.setAdapter(participanteAdapter);


        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(spiLivros.getSelectedItemPosition()==0){
                    Toast.makeText(getApplicationContext(), "Selecione um Livro", Toast.LENGTH_SHORT).show();
                }else if(spiParticipantes.getSelectedItemPosition()==0){
                    Toast.makeText(getApplicationContext(), "Selecione um Participante", Toast.LENGTH_SHORT).show();
                } else {
                    Participante participante = (Participante) spiParticipantes.getSelectedItem();
                    Livro livro = (Livro) spiLivros.getSelectedItem();
                    ReservaDados.getInstance().add(new Reserva(participante,livro));

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
