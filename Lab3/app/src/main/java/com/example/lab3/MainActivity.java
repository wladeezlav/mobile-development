package com.example.lab3;

import android.content.Intent;
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

    String[] dishes = {"Fork", "Pan", "Palete", "Spoon"};
    //getString(R.string.spinner_element1), getString(R.string.spinner_element2), getString(R.string.spinner_element3), getString(R.string.spinner_element4)

    Spinner spinner;
    Button button, button_save;
    CheckBox price_range1, price_range2, price_range3, manufacturer1, manufacturer2, manufacturer3;
    TextView result_textView;
    String selection = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = (Spinner) findViewById(R.id.dishlist); //присвоение id (R - класс ресурсов)
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, dishes);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);

        button_save = (Button) findViewById(R.id.button_save);

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

        StringBuilder builder_manufacturer = new StringBuilder();

        StringBuilder builder_prices = new StringBuilder();

        builder.append("\nPrice range: ");
        if (price_range1.isChecked()) {
            builder.append(price_range1.getText());
            builder.append(" ");
            builder_prices.append(price_range1.getText() + " ");
        }
        if (price_range2.isChecked()){
            builder.append(price_range2.getText());
            builder.append(" ");
            builder_prices.append(price_range2.getText() + " ");
        }
        if(price_range3.isChecked()) {
            builder.append(price_range3.getText());
            builder_prices.append(price_range1.getText());
        }

        if(!price_range3.isChecked() && !price_range2.isChecked() && !price_range1.isChecked()){
            builder.append("-");
            builder_prices.append("-");
        }

        builder.append("\nManufacturer: ");
        if(manufacturer1.isChecked()) {
            builder.append(manufacturer1.getText());
            builder.append(" ");
            builder_manufacturer.append(manufacturer1.getText() + " ");
        }
        if(manufacturer2.isChecked()) {
            builder.append(manufacturer2.getText());
            builder.append(" ");
            builder_manufacturer.append(manufacturer2.getText() + " ");
        }
        if(manufacturer3.isChecked()) {
            builder.append(manufacturer3.getText());
            builder_manufacturer.append(manufacturer3.getText());
        }

        if(!manufacturer3.isChecked() && !manufacturer2.isChecked() && !manufacturer1.isChecked()){
            builder.append("-");
            builder_manufacturer.append("-");
        }
        Dto dto = new Dto(selection, builder_prices.toString(), builder_manufacturer.toString());

        Dao dao = new Dao(getBaseContext());
        String hint = dao.create(dto);
        Toast.makeText(getBaseContext(), hint, Toast.LENGTH_SHORT);

        result_textView.setText(builder.toString());
    }

    public void outputputOnclickListner(View view){
        Intent intent = new Intent(this, ResultActivity.class);
        startActivity(intent);
    }
}
