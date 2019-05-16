package com.example.lab3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Objects;

public class ResultActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        textView = findViewById(R.id.result_view);

        Dao dao = new Dao(getBaseContext());
        List<Dto> result = dao.findAll();
        if(result.size() == 0) {
            textView.setText("Database is empty");
        }
        else {
            StringBuilder builder = new StringBuilder();
            System.out.println(result.size());
            for(Dto item : result) {
                builder.append(item.toString() + "\n");
            }
            System.out.println(Objects.isNull(builder));
            textView.setText(builder.toString());
        }
    }
}
