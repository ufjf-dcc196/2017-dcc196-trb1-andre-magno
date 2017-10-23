package com.example.desenvolvedor.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class CadastroLivro extends AppCompatActivity {


    private Button btnInseir;
    private Button btnVoltar;
    private EditText txtTitulo;
    private EditText txtEditora;
    private EditText txtAno;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_livro);




        final ListView listView = (ListView) findViewById(R.id.ListaLivros);


        btnInseir= (Button) findViewById(R.id.btnInserir_l);
        btnVoltar= (Button) findViewById(R.id.btnVoltar_l);
        txtEditora= (EditText) findViewById(R.id.txtEditora);
        txtTitulo= (EditText) findViewById(R.id.txtTitulo_l);
        txtAno= (EditText) findViewById(R.id.txtAno);




        listView.setAdapter(updateListView());




        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                Toast.makeText(getApplicationContext(), "toque curto", Toast.LENGTH_SHORT).show();
            }
        });



        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(getApplicationContext(), "Paticipante Longo:" , Toast.LENGTH_SHORT).show();

                return false;
            }
        });



        btnInseir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LivrosDados.getInstance().getdadosLivros().add(new Livro(LivrosDados.getInstance().getdadosLivros().size(),txtTitulo.getText().toString(),txtEditora.getText().toString(),Integer.parseInt(txtAno.getText().toString())));
                listView.setAdapter(updateListView());
            }

        });

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent enviarDadosParaAuxiliar1 = new Intent(
                        CadastroLivro.this,Principal.class
                );
                startActivity(enviarDadosParaAuxiliar1);
            }

        });



    }

    public ArrayAdapter updateListView(){
        ArrayAdapter<Livro> arrayAdapter = new ArrayAdapter<Livro>(this, android.R.layout.simple_list_item_1, LivrosDados.getInstance().getdadosLivros());
        return arrayAdapter;



    }
}
