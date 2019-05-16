package com.example.lab1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    String[] dishes = {"Palet", "Fork", "Spoon", "Pan"};

    Spinner spinner;
    Button button;
    CheckBox price_range1, price_range2, price_range3, manufacturer1, manufacturer2, manufacturer3;
    TextView result_textView;
    String selection = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Создание спиннера
        spinner = (Spinner) findViewById(R.id.dishlist1); //присвоение id (R - класс ресурсов)
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, dishes);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        price_range1 = (CheckBox) findViewById(R.id.price_range1);
        price_range2 = (CheckBox) findViewById(R.id.price_range2);
        price_range3 = (CheckBox) findViewById(R.id.price_range3);

        manufacturer1 = (CheckBox) findViewById(R.id.manufacturer1);
        manufacturer2 = (CheckBox) findViewById(R.id.manufacturer2);
        manufacturer3 = (CheckBox) findViewById(R.id.manufacturer3);

        result_textView = (TextView) findViewById(R.id.result_textView);

        AdapterView.OnItemSelectedListener itemSelectedListener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                // Получаем выбранный объект
                String item = (String) parent.getItemAtPosition(position);
                selection = item;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        };
        spinner.setOnItemSelectedListener(itemSelectedListener);
    }
    public void buttonListener(View view) {
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

        result_textView.setText(builder.toString());
        Toast.makeText(this, "Не выгоняйте плииз", Toast.LENGTH_SHORT).show();
    }

}
