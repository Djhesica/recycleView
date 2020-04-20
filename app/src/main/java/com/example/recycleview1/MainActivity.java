package com.example.recycleview1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    RecycleAdapter adapter;
    private List<Pessoa> pessoasListas = new ArrayList<>();
    private FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setaRecyclerView();

        setaButtons();
        listenersButtons();

    }

    public void setaRecyclerView(){

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_recyclerteste);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        adapter = new RecycleAdapter(this, pessoasListas, (ClickRecyclerView_Interface) this);
        mRecyclerView.setAdapter(adapter);
    }

    public void setaButtons(){
        floatingActionButton = (FloatingActionButton) findViewById(R.id.fab_fabteste);

    }

    /**
     * Aqui é o método onde trata o clique em um item da lista
     */
    public void onCustomClick(Object object) {
        Pessoa pessoa = (Pessoa) object;
        String nome = pessoa.getNome();
    }

    /**
     * Chama os listeners para os botões
     */
    public void listenersButtons() {

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Pessoa pessoa1 = new Pessoa();
                pessoa1.setNome("Renan Teles");

                pessoasListas.add(pessoa1);
                adapter.notifyDataSetChanged();

            }
        });
    }
}
