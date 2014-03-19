/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dbAccess;

import fr.cdig2.androMag.metier.Commentaire;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import fr.cdig2.androMag.metier.Numero;

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
        open();
        long idMag=  db.insert(DBHelper.DATABASE_TABLE_MAGAZINES, null, initialValueMagazine);
        close();
        return idMag;
    }
    
    public long insertCommentaire(Commentaire monCommentaire){
        
        //insérer un magazine
        ContentValues initialiserCommentaire = new ContentValues();
        initialiserCommentaire.put("rate", monCommentaire.getNote());
        initialiserCommentaire.put("texte", monCommentaire.getTexte());
        
        //insertion
        open();
        long idCommentaire=  db.insert(DBHelper.DATABASE_TABLE_COMMENTAIRES, null, initialiserCommentaire);
        close();
        return idCommentaire;
    }
    
    public void supprimerCommentaire(Commentaire monCommentaire) {
        
        open();
        db.delete("commentaires", "id="+monCommentaire.getId(), null);
        close();
    }
    
    public long insertTheme(String nomTheme){
         //insérer un contenu
        ContentValues initialValuesContenu = new ContentValues();
        initialValuesContenu.put("nom", nomTheme);
        open();
        long idContenu =  db.insert(DBHelper.DATABASE_TABLE_THEMES, null, initialValuesContenu);
        close();
        return idContenu;
    }
    
    public long insertNo(Numero numero){
        ContentValues initialValuesNumero = new ContentValues();
        
        initialValuesNumero.put("no", numero.getNo());
        initialValuesNumero.put("idMag", numero.getIdMag());
        open();
        long idNumero = db.insert(DBHelper.DATABASE_TABLE_NUMEROS, null, initialValuesNumero);
        close();
        return idNumero;
        
    }
    
    public Numero selectNumero(long id){
        String sql = "SELECT * FROM " + DBHelper.DATABASE_TABLE_NUMEROS + " WHERE id = "+id;
        Cursor cur = ExecuteQuery(sql, null);
        Numero unNumero = new Numero(cur.getLong(0), cur.getInt(1), cur.getLong(2));
        return unNumero;
    }
}
