package com.lzb.ormlitedemo.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lvzhenbin on 2016/3/9.
 */
public class DBHelper extends OrmLiteSqliteOpenHelper {

    private static final String TABLE_NAME = "ormlite-test.db";
    private Map<String, Dao> daos = new HashMap<String, Dao>();

    public DBHelper(Context context) {
        super(context, TABLE_NAME, null, 1);
    }

    public DBHelper(Context context, String databaseName, SQLiteDatabase.CursorFactory factory, int databaseVersion) {
        super(context, databaseName, factory, databaseVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource, int i, int i1) {

    }
}
