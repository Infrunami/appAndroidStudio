package com.example.pomodoro;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.sql.Time;

public class Tiempos extends Fragment {

    FirebaseDatabase database;
    NumberPicker sesiones_minute, sesiones_seconds;
    NumberPicker descansos_minute, descansos_seconds;
    Button inicio_sesiones;
    Button inicio_descansos;

   @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        View vista_principal = inflater.inflate(R.layout.fragment_tiempos, container, false);

        sesiones_minute = vista_principal.findViewById(R.id.sesiones_minute);
        sesiones_seconds = vista_principal.findViewById(R.id.sesiones_seconds);
        descansos_minute = vista_principal.findViewById(R.id.descansos_minute);
        descansos_seconds = vista_principal.findViewById(R.id.descansos_seconds);
        inicio_sesiones = vista_principal.findViewById(R.id.inicio_sesiones);
        inicio_descansos = vista_principal.findViewById(R.id.inicio_descansos);

        sesiones_minute.setMinValue(0);
        sesiones_minute.setMaxValue(25);
        sesiones_seconds.setMinValue(0);
        sesiones_seconds.setMaxValue(59);
        descansos_minute.setMinValue(0);
        descansos_minute.setMaxValue(25);
        descansos_seconds.setMinValue(0);
        descansos_seconds.setMaxValue(59);

        /*inicio_sesiones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertSesionTime();
            }
        });*/


        database = FirebaseDatabase.getInstance();
        DatabaseReference minuteSesion = database.getReference();
        minuteSesion.child("MinutosSesiones").setValue(sesiones_minute.getValue());
        DatabaseReference secondsSesion = database.getReference();
        secondsSesion.child("SegundosSesiones").setValue(sesiones_seconds.getValue());
        inicio_sesiones.setOnClickListener(boton2 -> {
            minuteSesion.child("MinutosSesiones").setValue(sesiones_minute.getValue());
            secondsSesion.child("SegundosSesiones").setValue(sesiones_seconds.getValue());
        });

       DatabaseReference minuteDescanso = database.getReference();
       minuteDescanso.child("MinutosDescanso").setValue(descansos_minute.getValue());
       DatabaseReference secondsDescanso = database.getReference();
       secondsDescanso.child("SegundosDescanso").setValue(descansos_seconds.getValue());
       inicio_descansos.setOnClickListener(boton2 -> {
           minuteSesion.child("MinutosDescanso").setValue(descansos_minute.getValue());
           secondsSesion.child("SegundosDescanso").setValue(descansos_seconds.getValue());
       });


        ;
       return vista_principal;

    }
}