package com.example.most601.counter;

import android.app.SharedElementCallback;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String best_score = "com.example.most601.counter.BEST";
    private static final String best_score_KEY = "BESTKEY";
    private TextView m_textviewpoints ;
    private int m_points;
    private SharedPreferences m_shared;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        m_textviewpoints = findViewById(R.id.textpoint);
        m_shared = getSharedPreferences(best_score , Context.MODE_PRIVATE);
        m_points = m_shared.getInt(best_score_KEY , 0 ) ;



        updatePointeDisplay();

    }

    @Override
    protected void onPause(){
        super.onPause();

        SharedPreferences.Editor editor = m_shared.edit();
        editor.putInt(best_score_KEY , m_points);

        // editor.apply() - save on disc only when needed
        // editor.commit()  - save on disc all the time
        editor.apply();

    }

    private void updatePointeDisplay() {
        m_textviewpoints.setText(Integer.toString(m_points));
    }

    public void addbutten(View view) {
        m_points++;
        updatePointeDisplay();
    }

    public void reset(View view) {
        m_points = 0 ;
        updatePointeDisplay();


    }
}
