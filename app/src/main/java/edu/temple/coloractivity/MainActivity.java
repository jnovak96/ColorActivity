package edu.temple.coloractivity;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;
import android.content.Intent;
import android.content.Context;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Context context = getApplicationContext();
        setTitle(context.getResources().getString(R.string.title1));
        final Intent startCanvas = new Intent(this, CanvasActivity.class);
        final String[] colors = context.getResources().getStringArray(R.array.colorparse);  //array of color values in format #XXXXXX
        final String[] translated = context.getResources().getStringArray(R.array.colorlang);   //array of color descriptions localized
        CustomAdapter colorAdapter = new CustomAdapter(this, colors, translated);
        Spinner spinner = findViewById(R.id.spinner1);
        spinner.setAdapter(colorAdapter);
        AdapterView.OnItemSelectedListener colorListener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String color = colors[position];
                String colorString = translated[position];
                Toast.makeText(parent.getContext(), context.getResources().getString(R.string.format) + " " + colorString, Toast.LENGTH_SHORT).show();
                startCanvas.putExtra("color", color);
                startActivity(startCanvas);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        };
        spinner.setOnItemSelectedListener(colorListener);
    }
}