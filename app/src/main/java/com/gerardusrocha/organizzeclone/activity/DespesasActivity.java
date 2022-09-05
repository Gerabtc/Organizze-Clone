package com.gerardusrocha.organizzeclone.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.gerardusrocha.organizzeclone.R;
import com.gerardusrocha.organizzeclone.helper.DateCustom;
import com.gerardusrocha.organizzeclone.model.Movimentacao;
import com.google.android.material.textfield.TextInputEditText;

public class DespesasActivity extends AppCompatActivity {

    private TextInputEditText campoData, campoCategoria, campoDescricao;
    private EditText campoValor;
    private Movimentacao movimentacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_despesas);

        campoValor = findViewById(R.id.editValor);
        campoData = findViewById(R.id.editData);
        campoCategoria = findViewById(R.id.editCategoria);
        campoDescricao = findViewById(R.id.editDescricao);

        campoData.setText(DateCustom.dataAtual());

    }

    public void salvarDespesa(View view) {

        movimentacao = new Movimentacao();
        String data = campoData.getText().toString();
        movimentacao.setValor(Double.parseDouble(campoValor.getText().toString()));
        movimentacao.setCategoria(campoCategoria.getText().toString());
        movimentacao.setDescricao(campoDescricao.getText().toString());
        movimentacao.setData(data);
        movimentacao.setTipo("d");

        movimentacao.salvar(data);

    }
}