package edu.temple.coloractivity;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link PaletteFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PaletteFragment extends Fragment {
    OnColorSelectedListener callback;


    public void OnColorSelectedListener(Activity activity) {
        callback = (OnColorSelectedListener) activity;
    }

    public interface OnColorSelectedListener {
        public void changeColor(String color);
    }
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    //private static final String ARG_PARAM1 = "param1";
    //private static final String ARG_PARAM2 = "param2";

    public PaletteFragment() {
        // Required empty public constructor
    }

    public static PaletteFragment newInstance() {
        PaletteFragment fragment = new PaletteFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.fragment_palette, container, false);
        Context context = getActivity();
        final Resources res = context.getResources();
        final String[] colors = context.getResources().getStringArray(R.array.colorparse);  //array of color values in format #XXXXXX
        final String[] translated = context.getResources().getStringArray(R.array.colorlang);   //array of color descriptions localized
        CustomAdapter colorAdapter = new CustomAdapter(context, colors, translated);
        Spinner spinner = v.findViewById(R.id.spinner2);
        spinner.setAdapter(colorAdapter);

        AdapterView.OnItemSelectedListener colorListener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String color = colors[position];
                String colorString = translated[position];
                Toast.makeText(v.getContext(), res.getString(R.string.format) + " " + colorString, Toast.LENGTH_SHORT).show();
                callback.changeColor(color);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        };
        spinner.setOnItemSelectedListener(colorListener);
        return v;
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
}
