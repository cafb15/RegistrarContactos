package com.example.android.datepicker;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends Activity {

    private Button btnNext;
    private EditText nameComplete, telephone, email, descriptionContact;
    private TextView tv;
    private int DayOfMonth, Month, Year;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameComplete = (EditText) findViewById(R.id.ET_nombre);
        telephone = (EditText) findViewById(R.id.ET_telefono);
        email = (EditText) findViewById(R.id.ET_email);
        descriptionContact = (EditText) findViewById(R.id.ET_descripcion);

        Calendar c= Calendar.getInstance();
        final int year = c.get(c.YEAR);
        final int month = c.get(c.MONTH);
        final int dayOfMonth = c.get(c.DAY_OF_MONTH);

        DatePicker dp = (DatePicker) findViewById(R.id.dpFechaNacimiento);
        //init(int year, int monthOfYear, int dayOfMonth, DatePicker.OnDateChangedListener onDateChangedListener) Initialize the state.
        
        dp.init(year, month, dayOfMonth, new DatePicker.OnDateChangedListener() {

                    @Override
                    public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth)
                    {
                        //Display the changed date to app interface
                        DayOfMonth = dayOfMonth;
                        Month = monthOfYear + 1;
                        Year = year;
                    }
                });

        Intent editContact = getIntent();
        Bundle editExtras = editContact.getExtras();

        if(editExtras != null){
            String dateName = (String) editExtras.get("editName");
            String datePhone = (String) editExtras.get("editPhone");
            String dateEmail = (String) editExtras.get("editEmail");
            String dateDescription = (String) editExtras.get("editDescription");

            nameComplete.setText(dateName);
            telephone.setText(datePhone);
            email.setText(dateEmail);
            descriptionContact.setText(dateDescription);
        }

        btnNext = (Button) findViewById(R.id.botonSiguiente);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerContact = new Intent(MainActivity.this, ConfirmacionActivity.class);

                String Name = nameComplete.getText().toString();
                String Phone = telephone.getText().toString();
                String Email = email.getText().toString();
                String Description = descriptionContact.getText().toString();

                registerContact.putExtra("Name", Name);
                registerContact.putExtra("Phone", Phone);
                registerContact.putExtra("Email", Email);
                registerContact.putExtra("Description", Description);
                registerContact.putExtra("DayOfMonth", DayOfMonth);
                registerContact.putExtra("Month", Month);
                registerContact.putExtra("Year", Year);

                startActivity(registerContact);
            }
        });
    }
}