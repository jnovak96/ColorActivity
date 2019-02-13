package edu.temple.coloractivity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

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
        View colorView = findViewById(R.id.main_layout);
        switch (color) {
            case "Red": colorView.setBackgroundColor(Color.parseColor("#FF0000"));
                break;
            case "Green":  colorView.setBackgroundColor(Color.parseColor("#00FF00"));
                break;
            case "Blue":  colorView.setBackgroundColor(Color.parseColor("#0000FF"));
                break;
            case "Orange":  colorView.setBackgroundColor(Color.parseColor("#FFA500"));
                break;
            case "Purple": colorView.setBackgroundColor(Color.parseColor("#800080"));
                break;
            case "Cyan": colorView.setBackgroundColor(Color.parseColor("#00FFFF"));
                break;
            case "Maroon": colorView.setBackgroundColor(Color.parseColor("#800000"));
                break;
            case "Magenta":  colorView.setBackgroundColor(Color.parseColor("#FF00FF"));
                break;
            case "Black":  colorView.setBackgroundColor(Color.parseColor("#FFFFFF"));
                break;
            case "White": colorView.setBackgroundColor(Color.parseColor("#000000"));
                break;
            case "Pink": colorView.setBackgroundColor(Color.parseColor("#EE82EE"));
                break;
            default:
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}


