package com.example.desenvolvedor.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class CadastroReserva extends AppCompatActivity {


    private Button btnSalvar;
    private Button btnVoltar;
    private Spinner spiParticipantes;
    private Spinner spiLivros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_reserva);


        spiParticipantes = (Spinner) findViewById(R.id.spiP);
        spiLivros = (Spinner) findViewById(R.id.spiL);
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
                        CadastroReserva.this, Principal.class

                );
                startActivity(enviarDadosParaAuxiliar1);

            }
        });




    }

}
