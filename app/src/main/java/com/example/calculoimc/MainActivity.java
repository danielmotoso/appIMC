package com.example.calculoimc;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    NumberFormat formatar = new DecimalFormat("#0.00");
    float peso;
    float altura;
    String resultadoIMC;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final float[] imc = new float[1];                           // Declaração da variável para usar nos IFs e apresentar o resultado no campo de texto
        Button btCalcular = (Button) findViewById(R.id.btCalcular); // Pegando o evento do botão
        btCalcular.setOnClickListener(new OnClickListener() { // Programação para calcular o IMC, com os dados inseridos nos campos de peso e altura
            @Override
            public void onClick(View v) {
                TextView editPeso = (TextView) findViewById(R.id.editPeso);
                TextView editAltura = (TextView) findViewById(R.id.editAltura);

                if (editPeso.getText().toString().equals("") || editAltura.getText().toString().equals("") || editAltura.getText().toString().equals(".") || editPeso.getText().toString().equals(".")) {

                    AlertDialog.Builder alerta = new AlertDialog.Builder(MainActivity.this);
                    alerta.setTitle("Aviso");
                    alerta
                            .setMessage(" Por favor preenças os campos corretamente")
                            .setCancelable(false)
                            .setNegativeButton("TESTE", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                    TextView editPeso = (TextView) findViewById(R.id.editPeso);
                                    TextView editAltura = (TextView) findViewById(R.id.editAltura);
                                    editPeso.setText("");
                                    editAltura.setText("");

                                }
                            });

                    AlertDialog alertDialog = alerta.create();
                    alertDialog.show();


                }else
                   {
                    peso = Float.parseFloat(editPeso.getText().toString());
                    altura = Float.parseFloat(editAltura.getText().toString());
                    imc[0] = peso / (altura * altura);


                    if (imc[0] < 10) {

                        resultadoIMC = formatar.format(imc[0]) + " Desnutrição Grau V";
                    } else if (imc[0] < 13) {

                        resultadoIMC = formatar.format(imc[0]) + " Desnutrição Grau IV";
                    } else if (imc[0] < 16) {

                        resultadoIMC = formatar.format(imc[0]) + " Desnutrição Grau III";
                    } else if (imc[0] < 17) {

                        resultadoIMC = formatar.format(imc[0]) + " Desnutrição Grau II";
                    } else if (imc[0] < 18.5) {

                        resultadoIMC = formatar.format(imc[0]) + " Abaixo do Peso";
                    } else if (imc[0] < 25) {

                        resultadoIMC = formatar.format(imc[0]) + " Peso adequado";
                    } else if (imc[0] < 30) {

                        resultadoIMC = formatar.format(imc[0]) + " Pré-obesidade";
                    } else if (imc[0] < 35) {

                        resultadoIMC = formatar.format(imc[0]) + " Obesidade Grau II";
                    } else {

                        resultadoIMC = formatar.format(imc[0]) + " Obesidade Grau III";
                    }
                    AlertDialog.Builder alerta = new AlertDialog.Builder(MainActivity.this);
                    alerta.setTitle("IMC Resultado:   ");
                    alerta
                            .setMessage("IMC: " + resultadoIMC)

                            //.setMessage(" Por favor preenças os campos corretamente"+ )
                            .setCancelable(true)
                            .setNegativeButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                    //  TextView editPeso = (TextView) findViewById(R.id.editPeso);
                                    // TextView editAltura = (TextView) findViewById(R.id.editAltura);
                                    //  editPeso.setText("");
                                    //   editAltura.setText("");

                                }
                            });
                    AlertDialog alertDialog = alerta.create();
                    alertDialog.show();

                }


            }
        });
        String limparCampo = "";
        Button btLimpar = (Button) findViewById(R.id.btLimpar);
        btLimpar.setOnClickListener(new

                                            OnClickListener() {
                                                @Override
                                                public void onClick(View v) {

                                                    TextView editPeso = (TextView) findViewById(R.id.editPeso);
                                                    TextView editAltura = (TextView) findViewById(R.id.editAltura);
                                                    editPeso.setText("");
                                                    editAltura.setText("");


                                                }
                                            });

    }


}