package dev.corp.formulario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Confirmar extends AppCompatActivity {

    TextView tv_nombre,tv_fecha,tv_telefono,tv_mail;
    Button btn_ir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar);
        Bundle parametros = getIntent().getExtras();
        final String nombre,fecha,telefono,mail;
        nombre = parametros.getString("nombre");
        fecha = parametros.getString("fecha");
        telefono = parametros.getString("telefono");
        mail = parametros.getString("mail");
        btn_ir = findViewById(R.id.btnIr);

        btn_ir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                putData(nombre,fecha,telefono,mail);
            }
        });

        setData(nombre,fecha,telefono,mail);

    }

    public void setData(String nombre, String fecha, String telefono,String mail){
        tv_nombre = findViewById(R.id.tv_name);
        tv_fecha = findViewById(R.id.tv_date);
        tv_telefono = findViewById(R.id.tv_pone);
        tv_mail = findViewById(R.id.tv_mail);

        tv_nombre.setText(nombre);
        tv_fecha.setText(fecha);
        tv_telefono.setText(telefono);
        tv_mail.setText(mail);
    }

    public void putData(String nombre, String fecha, String telefono,String mail){
        Intent i = new Intent(Confirmar.this,MainActivity.class);
        i.putExtra("nombre",nombre);
        i.putExtra("fecha",fecha);
        i.putExtra("telefono",telefono);
        i.putExtra("mail",mail);
        startActivity(i);
        finish();
    }
}
