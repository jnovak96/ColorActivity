package edu.temple.coloractivity;

import android.app.Activity;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Bundle;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.widget.RelativeLayout;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;
import android.content.Intent;
import android.content.Context;

public class MainActivity extends FragmentActivity implements PaletteFragment.OnColorSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Context context = getApplicationContext();
        setTitle(context.getResources().getString(R.string.title1));

        displayPaletteFragment();

    }

    public void displayPaletteFragment() {
        PaletteFragment palFrag = new PaletteFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .add(R.id.pLayout, palFrag)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void changeColor(String color) {
        CanvasFragment canFrag = CanvasFragment.newInstance(color);
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                    .add(R.id.cLayout, canFrag)
                    .addToBackStack(null)
                    .commit();
            findViewById(R.id.cLayout).setBackgroundColor(Color.parseColor(color));
    }

    @Override
    public void onAttachFragment(Fragment fragment) {
        if (fragment instanceof PaletteFragment) {
            PaletteFragment palFrag = (PaletteFragment) fragment;
            palFrag.OnColorSelectedListener(this);
        }
    }
}