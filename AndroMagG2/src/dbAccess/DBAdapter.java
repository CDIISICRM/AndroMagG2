/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dbAccess;

import android.content.ContentValues;
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
    
    public long insertMagazine(String nom, long prix, long idContenu){
        
        //insérer un magazine
        ContentValues initialValueMagazine = new ContentValues();
        initialValueMagazine.put("nom", nom);
        initialValueMagazine.put("prix", prix);
        initialValueMagazine.put("idContenu", idContenu);
        
        //insertion
        db = databaseHelper.getWritableDatabase();
        long idMag=  db.insert(DBHelper.DATABASE_TABLE_MAGAZINES, null, initialValueMagazine);
        databaseHelper.close();
        return idMag;
    }
    
    public long insertTheme(String nomTheme){
         //insérer un contenu
        ContentValues initialValuesContenu = new ContentValues();
        initialValuesContenu.put("nom", nomTheme);
        db = databaseHelper.getWritableDatabase();
        long idContenu =  db.insert(DBHelper.DATABASE_TABLE_THEMES, null, initialValuesContenu);
        databaseHelper.close();
        return idContenu;
    }
}
