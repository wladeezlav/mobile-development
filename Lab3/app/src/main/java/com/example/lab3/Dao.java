package com.example.lab3;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;

public class Dao {
    private SQLiteDatabase database;

    public Dao(Context context) {
        database = context.openOrCreateDatabase("dish.db", MODE_PRIVATE, SQLiteCursor::new);
        database.execSQL("CREATE TABLE IF NOT EXISTS dish (name TEXT, price_range TEXT, manufacturer TEXT)");
    }

    public String create(Dto dto) {
        System.out.println("In create ");
        database.execSQL("INSERT INTO dish values ('"+dto.getName()+"', '"+dto.getPrice_range()+"', '"+dto.getManufacturer()+"') ");
        System.out.println("Inserted");
        return "Inserted into database";
    }

    public List<Dto> findAll() {
        List<Dto> resultList = new ArrayList<>();
        Cursor dtoCursor = database.rawQuery("select * from dish", null);
        if(dtoCursor.moveToFirst()) {
            do {
                Dto dto = new Dto(dtoCursor.getString(0), dtoCursor.getString(1), dtoCursor.getString(2));
                resultList.add(dto);
            } while (dtoCursor.moveToNext());
        }

        return resultList;
    }
}
