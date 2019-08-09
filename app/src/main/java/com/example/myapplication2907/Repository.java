package com.example.myapplication2907;

import android.content.Context;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;

import static com.example.myapplication2907.LoadData.getStringFromAssetFile;

class Repository {

    private static Db db;

    void initQuestions(Context context) {

        String s = null;
        ArrayList<Question> questions;
        try {
            s = (String) getStringFromAssetFile(context);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();
        db = gson.fromJson(s, Db.class);
    }

    Db getDb() {
        return db;
    }

}
