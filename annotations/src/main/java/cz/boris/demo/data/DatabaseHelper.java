package cz.boris.demo.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Boris Musatov on 2.3.14.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "sample_database.db";
    public static final int DATABASE_VERSION = 1;

    private static DatabaseHelper instance = null;
    private Context context;

    public synchronized static DatabaseHelper newInstance(Context context) {
        if(instance == null) {
            instance = new DatabaseHelper(context.getApplicationContext());
        }
        return instance;
    }

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.beginTransaction();
            db.execSQL("CREATE TABLE topics (_id INTEGER PRIMARY KEY, name TEXT, description TEXT);");
            db.setTransactionSuccessful();
        } finally {
            db.endTransaction();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        throw new RuntimeException("Not implemented");
    }
}
