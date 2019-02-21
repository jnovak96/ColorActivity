package edu.temple.coloractivity;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class CanvasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas);

        Bundle extras = getIntent().getExtras();
        String colorString = extras.getString("color");

        View colorView = findViewById(R.id.canvas_layout);
        colorView.setBackgroundColor(Color.parseColor(colorString));
    }
}
