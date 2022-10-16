package com.example.pomodoro;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.NumberPicker;
import android.widget.TextView;


public class Control extends Fragment {

    TextView textView;
    NumberPicker numberPicker;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista_principal = inflater.inflate(R.layout.fragment_control, container, false);

        textView = vista_principal.findViewById(R.id.textView);
        numberPicker = vista_principal.findViewById(R.id.numberPicker);

        numberPicker.setMinValue(0);
        numberPicker.setMaxValue(10);
        textView.setText(String.format("Numero de sesiones: %s", numberPicker.getValue()));

        numberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
        @Override
        public void onValueChange(NumberPicker numberPicker, int oldVal, int newVal) {
            textView.setText(String.format("Numero de sesiones: %s", newVal));
        }});
        return vista_principal;
    }
}