/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dbAccess;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/**
 *
 * @author crm
 */
public class DBAdapter {
    private static final String TAG = "DBAdapter";
    private final Context context;
    private DBHelper databaseHelper;
    private SQLiteDatabase db;

    public DBAdapter(Context ctx)
    {
        this.context = ctx;
        databaseHelper = new DBHelper(context);
    }

    //Open the database
    public DBAdapter open() throws SQLException
    {
        db = databaseHelper.getWritableDatabase();
        return this;
    }

    //Close the database
    public void close()
    {
    	databaseHelper.close();
    }

    public Cursor ExecuteQuery(String Query, String[] selectionArgs)
    {
    	Cursor mCursor = null;

    	// Open Android Database
    	db = databaseHelper.getWritableDatabase();

    	mCursor = db.rawQuery(Query, selectionArgs);

    	if (mCursor != null) {
            mCursor.moveToFirst();
        }

	// Close Android Database
    	databaseHelper.close();

    	return mCursor;
    }
}
