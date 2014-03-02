package cz.boris.demo.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import org.androidannotations.annotations.EBean;

/**
 * Created by Boris Musatov on 2.3.14.
 */
@EBean
public class DB {

    private final Context context;
    private DatabaseHelper databaseHelper;
    private SQLiteDatabase database;

    public DB(Context context) {
        this.context = context;
    }

    public void open() {
        databaseHelper = DatabaseHelper.newInstance(context);
        database = databaseHelper.getWritableDatabase();
    }

    public void close() {
        if(database != null) database.close();
    }

    public Cursor getAll(String tableName) {
        return database.query(tableName, null, null, null, null, null, null);
    }

    public void addTopic(String name, String description) {
        ContentValues cv = new ContentValues();
        cv.put("name", name);
        cv.put("description", description);
        database.insert("topics", null, cv);
    }
}
