package android.curso.samsungchallenge.datasource;

import android.content.ContentValues;
import android.content.Context;
import android.curso.samsungchallenge.datamodel.TaskDataModel;
import android.curso.samsungchallenge.datamodel.UserDataModel;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataSource extends SQLiteOpenHelper {
    private static final String DB_NAME = "samsung_challenge.sqlite";
    private static final int DB_VERSION = 1;

    SQLiteDatabase db;

    public DataSource(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        db = getWritableDatabase();
        try {
            db.execSQL(UserDataModel.getQueryCreateTable());
            db.execSQL(TaskDataModel.getQueryCreateTable());
        } catch (Exception e) {
            Log.e("User table", "DB----> ERRO:" + e.getMessage());
        }
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
//        try {
//            db.execSQL(UserDataModel.getQueryCreateTable());
//        } catch (Exception e) {
//            Log.e("User table", "DB----> ERRO:" + e.getMessage());
//        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean insert(String table, ContentValues data) {
        boolean success = true;
        try {
            success = db.insert(table, null, data) > 0;
        } catch(Exception e) {
            success = false;
        }
        return success;
    }
}
