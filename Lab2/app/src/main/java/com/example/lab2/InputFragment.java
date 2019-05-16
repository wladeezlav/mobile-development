package com.example.lab2;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class InputFragment extends Fragment {

    String[] dishes = {"Palet", "Fork", "Spoon", "Pan"};

    String result;

    Spinner spinner;
    Button button;
    CheckBox price_range1, price_range2, price_range3, manufacturer1, manufacturer2, manufacturer3;
    TextView result_textView;
    String selection = "";

    private OnFragmentInteractionListener mListener;

    interface OnFragmentInteractionListener {
        void onFragmentInteraction(String link);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_input, container, false);

        spinner = (Spinner) view.findViewById(R.id.dishlist1); //присвоение id (R - класс, который хранит объекты)
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item, dishes);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        price_range1 = (CheckBox) view.findViewById(R.id.price_range1);
        price_range2 = (CheckBox) view.findViewById(R.id.price_range2);
        price_range3 = (CheckBox) view.findViewById(R.id.price_range3);

        manufacturer1 = (CheckBox) view.findViewById(R.id.manufacturer1);
        manufacturer2 = (CheckBox) view.findViewById(R.id.manufacturer2);
        manufacturer3 = (CheckBox) view.findViewById(R.id.manufacturer3);

        button = (Button) view.findViewById(R.id.button);

        result_textView = (TextView) view.findViewById(R.id.result_textView);

        AdapterView.OnItemSelectedListener itemSelectedListener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                // Получаем выбранный объект
                String item = (String)parent.getItemAtPosition(position);
                selection = item;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        };
        spinner.setOnItemSelectedListener(itemSelectedListener);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder builder = new StringBuilder();
                builder.append(selection);
                builder.append("\nPrice range: ");
                if (price_range1.isChecked()) {
                    builder.append(price_range1.getText());
                    builder.append(" ");
                }
                if (price_range2.isChecked()){
                    builder.append(price_range2.getText());
                    builder.append(" ");
                }
                if(price_range3.isChecked())
                    builder.append(price_range3.getText());

                builder.append("\nManufacturer: ");
                if(manufacturer1.isChecked()) {
                    builder.append(manufacturer1.getText());
                    builder.append(" ");
                }
                if(manufacturer2.isChecked()) {
                    builder.append(manufacturer2.getText());
                    builder.append(" ");
                }
                if(manufacturer3.isChecked()) {
                    builder.append(" ");
                    builder.append(manufacturer3.getText());
                }
                if(!manufacturer3.isChecked() && !manufacturer2.isChecked() && !manufacturer1.isChecked()){
                    builder.append("-");
                }

                result = builder.toString();
                mListener.onFragmentInteraction(result);
                Toast.makeText(getActivity(), "Не выгоняйте плииз", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

    //интерфейс для соединения фрагментов
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mListener = (OnFragmentInteractionListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " должен реализовывать интерфейс OnFragmentInteractionListener");
        }
    }

    public void updateOutput() {
        String inputText = result;
        mListener.onFragmentInteraction(inputText);
    }
}
