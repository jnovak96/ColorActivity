package edu.temple.coloractivity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import android.content.Intent;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner spinner = findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.colors, android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String color = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), "Color changed to " + color, Toast.LENGTH_SHORT).show();
        Intent startCanvas = new Intent(this, CanvasActivity.class);
        String colorString = "#000000";
        switch (color) {
            case "Red": colorString = "#FF0000";
                break;
            case "Green":  colorString ="#00FF00";
                break;
            case "Blue":  colorString = "#0000FF";
                break;
            case "Orange":  colorString = "#FFA500";
                break;
            case "Purple": colorString = "#800080";
                break;
            case "Cyan": colorString = "#00FFFF";
                break;
            case "Maroon": colorString = "#800000";
                break;
            case "Magenta": colorString = "#FF00FF";
                break;
            case "Black":  colorString = "#000000";
                break;
            case "White": colorString = "#FFFFFF";
                break;
            case "Pink": colorString = "#EE82EE";
                break;
            default:
                break;
        }
        startCanvas.putExtra("color", colorString);
        startActivity(startCanvas);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}


