package dev.corp.formulario;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    private int dia,mes,ano;
    private EditText et_name, et_date, et_phone, et_mail;
    Button btn_ir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_name = findViewById(R.id.et_nombre);
        et_date = findViewById(R.id.et_date);
        et_phone = findViewById(R.id.et_phone);
        et_mail = findViewById(R.id.et_email);
        btn_ir = findViewById(R.id.btnIr);

        Bundle parametros = getIntent().getExtras();
        if(parametros!=null)
        {
            final String nombre,fecha,telefono,mail;
            nombre = parametros.getString("nombre");
            fecha = parametros.getString("fecha");
            telefono = parametros.getString("telefono");
            mail = parametros.getString("mail");

            setData(nombre,fecha,telefono,mail);
        }


        LinearLayout ll = findViewById(R.id.llfecha);
        ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDateDialog();
            }
        });

        et_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDateDialog();
            }
        });
        btn_ir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre,fecha,telefono,mail;
                nombre = et_name.getText().toString();
                fecha = et_date.getText().toString();
                telefono = et_phone.getText().toString();
                mail = et_mail.getText().toString();
                Intent i = new Intent(MainActivity.this,Confirmar.class);
                i.putExtra("nombre",nombre);
                i.putExtra("fecha",fecha);
                i.putExtra("telefono",telefono);
                i.putExtra("mail",mail);
                startActivity(i);
                finish();
            }
        });
    }

    private void showDateDialog(){
        DatePickerDialog datePickerDialog = new DatePickerDialog(this,this,
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
        );
        datePickerDialog.show();
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        String date = dayOfMonth+"/"+month+"/"+year;
        et_date.setText(date);
    }



    public void setData(String nombre, String fecha, String telefono, String mail){
        et_name.setText(nombre);
        et_date.setText(fecha);
        et_phone.setText(telefono);
        et_mail.setText(mail);
    }
}
