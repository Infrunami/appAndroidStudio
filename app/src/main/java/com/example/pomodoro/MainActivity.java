package com.example.pomodoro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.NumberPicker;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabLayout tl = (TabLayout) findViewById(R.id.menu);
        tl.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                switch (position) {
                    case 0:
                        Tiempos t = new Tiempos();
                        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor,t).commit();
                        break;
                    case 1:
                        Control c = new Control();
                        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor,c).commit();
                        break;
                    case 2:
                        Estadisticas e = new Estadisticas();
                        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor,e).commit();
                        break;
                    case 3:
                        Notas n = new Notas();
                        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor,n).commit();
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}