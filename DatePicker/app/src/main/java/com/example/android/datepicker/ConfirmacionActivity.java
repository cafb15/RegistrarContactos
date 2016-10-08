package com.example.android.datepicker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ConfirmacionActivity extends AppCompatActivity {

    TextView tvName, tvBirthdate, tvPhone, tvEmail, tvDescription;
    int dateDay, dateMonth, dateYear;
    String dateName, datePhone, dateEmail, dateDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmacion);

        tvName = (TextView) findViewById(R.id.tv_nombre);
        tvBirthdate = (TextView) findViewById(R.id.tv_nacimiento);
        tvPhone = (TextView) findViewById(R.id.tv_telefono);
        tvEmail = (TextView) findViewById(R.id.tv_email);
        tvDescription = (TextView) findViewById(R.id.tv_descripcion);

        Intent confirmContact = getIntent();
        Bundle extras = confirmContact.getExtras();

        if(extras != null){
            dateName = (String) extras.get("Name");
            datePhone = (String) extras.get("Phone");
            dateEmail = (String) extras.get("Email");
            dateDescription = (String) extras.get("Description");
            dateDay = (int) extras.get("DayOfMonth");
            dateMonth = (int) extras.get("Month");
            dateYear = (int) extras.get("Year");

            tvName.setText("Nombres: " + dateName);
            tvBirthdate.setText("Fecha de nacimiento: " + dateDay + "/" + dateMonth + "/" + dateYear);
            tvPhone.setText("Teléfono: " + datePhone);
            tvEmail.setText("Email: " + dateEmail);
            tvDescription.setText("Descripción: " + dateDescription);
        }

        Button editarDatos = (Button) findViewById(R.id.btn_editar);
        editarDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentEditarDatos = new Intent(ConfirmacionActivity.this, MainActivity.class);

                String editName = dateName;
                String editPhone = datePhone;
                String editEmail = dateEmail;
                String editDescription = dateDescription;
                int Day = dateDay;
                int Month = dateMonth;
                int Year = dateYear;

                intentEditarDatos.putExtra("editName", editName);
                intentEditarDatos.putExtra("editPhone", editPhone);
                intentEditarDatos.putExtra("editEmail", editEmail);
                intentEditarDatos.putExtra("editDescription", editDescription);
                intentEditarDatos.putExtra("editDay", Day);
                intentEditarDatos.putExtra("editMonth", Month);
                intentEditarDatos.putExtra("editYear", Year);

                startActivity(intentEditarDatos);
            }
        });
    }
}