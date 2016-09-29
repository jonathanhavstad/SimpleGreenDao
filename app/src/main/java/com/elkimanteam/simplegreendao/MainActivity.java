package com.elkimanteam.simplegreendao;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        writeData();
        readData();
    }

    private void writeData() {
        SQLiteDatabase db = new DaoMaster.DevOpenHelper(this, "simplegreendao.db")
                .getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(db);
        DaoSession daoSession = daoMaster.newSession();
        DataDao dataDao = daoSession.getDataDao();
        Data data = new Data();
        data.setX("Hello World");
        data.setY(20);
        dataDao.insert(data);
        db.close();
        Log.d(TAG, "Data in: " + data.toString());
    }

    private void readData() {
        SQLiteDatabase db = new DaoMaster.DevOpenHelper(this, "simplegreendao.db")
                .getReadableDatabase();
        DaoMaster daoMaster = new DaoMaster(db);
        DaoSession daoSession = daoMaster.newSession();
        DataDao dataDao = daoSession.getDataDao();
        List<Data> dataList = dataDao.queryBuilder().build().list();
        for (Data data : dataList) {
            Log.d(TAG, "Data out: " + data.toString());
        }
    }
}
