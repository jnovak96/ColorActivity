package edu.temple.coloractivity;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.content.Context;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {

    private String[] colors;
    private String[] translated;
    private Context context;

    public CustomAdapter(Context context, String[] colors, String[] translated) {
        this.context = context;
        this.colors = colors;
        this.translated = translated;
    }

    @Override
    public int getCount() {
        return colors.length;
    }

    @Override
    public Object getItem(int position) {
        return colors[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        TextView t = new TextView(context);
        t.setText(translated[position]);
        t.setBackgroundColor(Color.parseColor(colors[position]));
        if (colors[position].equals("#000000"))
            t.setTextColor(Color.parseColor("#FFFFFF"));
        return t;
    }
}
