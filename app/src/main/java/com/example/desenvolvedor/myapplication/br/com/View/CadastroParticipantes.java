package com.example.desenvolvedor.myapplication.br.com.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.desenvolvedor.myapplication.R;

public class CadastroParticipantes extends AppCompatActivity {


    private Button btnSalvar;
    private Button btnCancelar;
    private EditText txtNome;
    private EditText txtEmail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_participantes);

        btnCancelar = (Button) findViewById(R.id.btnCancelar);
        btnSalvar = (Button) findViewById(R.id.btnSalvar);
        txtNome = (EditText) findViewById(R.id.txtNome);
        txtEmail = (EditText) findViewById(R.id.txtEmail);


        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(CadastroParticipantes.this,Principal.class);
                intent.putExtra("Nome",txtNome.getText().toString());
                intent.putExtra("Email",txtEmail.getText().toString());
                startActivity(intent);
        }

        });

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent enviarDadosParaAuxiliar1 = new Intent(
                        CadastroParticipantes.this,Principal.class

                );
                startActivity(enviarDadosParaAuxiliar1);
            }

        });



    }
}
