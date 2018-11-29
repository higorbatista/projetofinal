package com.lourdinas.finalaplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    SharedPreferences meusDados;
    public  static final  String mypreference ="call";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        meusDados = getSharedPreferences(mypreference, Context.MODE_PRIVATE);

        Button login = findViewById(R.id.login);
        TextView registro = findViewById(R.id.registro);
        final EditText email = findViewById(R.id.emaila);
        final EditText senha = findViewById(R.id.senhaB);

        login .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String meuEmail = email.getText().toString();
                String minhaSenha = senha.getText().toString();

                if (meusDados.contains("email") && meusDados.contains("senha")){

                    if (meuEmail.equals(meusDados.getString("email",""))
                            &&minhaSenha.equals(meusDados.getString("senha", ""))){
                        Intent intent = new Intent( Login.this,
                                MainActivity.class);
                        startActivity(intent);
                        finish();
                    }else {
                        Toast.makeText(getApplicationContext(),
                                "Email e senha invalidos! ",Toast.LENGTH_SHORT).show();
                    }

                }else {
                    Toast.makeText(getApplicationContext(),
                            "nao existe cadastro",Toast.LENGTH_SHORT).show();
                }

                Intent intent =  new Intent(Login.this, MainActivity.class);
                startActivity(intent);


            }
        });
        registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, Registro.class);
                startActivity(intent);
                finish();
            }
        });
    }
}

