/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dbAccess;

import fr.cdig2.androMag.metier.Commentaire;
import fr.cdig2.androMag.metier.Magazine;
import android.R.string;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import fr.cdig2.androMag.metier.Article;
import fr.cdig2.androMag.metier.Numero;
import fr.cdig2.androMag.metier.Rubrique;

import java.util.ArrayList;

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
    
    public ArrayList<Magazine> selectTousLesMagazines(){
    	ArrayList<Magazine> lesMagazines = new ArrayList<Magazine>();
    	String sql = "SELECT * FROM " + DBHelper.DATABASE_TABLE_MAGAZINES;
    	Cursor cur = ExecuteQuery(sql, null);
    	while(!cur.isAfterLast()){
            
            Magazine unMagazine = new Magazine(cur.getLong(0), cur.getString(1), cur.getLong(2), cur.getInt(3), null);
            
            ArrayList<Numero> lesNumeros = selectNumeroParIdMagazine(cur.getLong(0));
            ArrayList lesIdNumero = new ArrayList();
            for(Numero unNumero : lesNumeros){
                lesIdNumero.add(unNumero.getId());
            }
            unMagazine.setLesIdNumeros(lesIdNumero);
            lesMagazines.add(unMagazine);
            cur.moveToNext();
    	}
        
    	return lesMagazines;
    }
    public ArrayList<Article> selectArticleParIdNo(long idNo){
        ArrayList<Article> lesArticles = new ArrayList<Article>();
        String sql = "SELECT * FROM " + DBHelper.DATABASE_TABLE_ARTICLES + " WHERE idNo = " + idNo;
        
        Cursor cur = ExecuteQuery(sql, null);
        while(!cur.isAfterLast()){
            ArrayList<Commentaire> lesCommentaires = selectLesCommentairesParNumero(idNo);
            Article unArticle = new Article(cur.getLong(0), cur.getString(1), cur.getLong(2), lesCommentaires);
            unArticle.setLesCommentaire(selectLesCommentairesParArticle(cur.getLong(0)));
            lesArticles.add(unArticle);
            cur.moveToNext();
        }
        
        return lesArticles;
    }
    
    public ArrayList<Commentaire> selectLesCommentairesParArticle(long idArticle){
        ArrayList<Commentaire> lesCommentaires = new ArrayList<Commentaire>();
        String sql = "SELECT " +  DBHelper.DATABASE_TABLE_COMMENTAIRES + ".* FROM " + DBHelper.DATABASE_TABLE_COMMENTAIRES + ", " + DBHelper.DATABASE_TABLE_ARTICLES + ", " + DBHelper.DATABASE_TABLE_COMMENTAIRE_ARTICLE
                + " WHERE " + DBHelper.DATABASE_TABLE_COMMENTAIRE_ARTICLE + ".idArticle = " + DBHelper.DATABASE_TABLE_ARTICLES + ".id "
                + " AND " + DBHelper.DATABASE_TABLE_ARTICLES + ".id = " + idArticle;
        Cursor cur = ExecuteQuery(sql, null);
        while(!cur.isAfterLast()){
            Commentaire unCommentaire = new Commentaire(cur.getLong(0),cur.getInt(1),cur.getString(2));
            lesCommentaires.add(unCommentaire);
            cur.moveToNext();
        }
        return lesCommentaires;
    }
    
    public ArrayList<Commentaire> selectLesCommentairesParNumero(long idNo){
        ArrayList<Commentaire> lesCommentaires = new ArrayList<Commentaire>();
        String sql = "SELECT " +  DBHelper.DATABASE_TABLE_COMMENTAIRES + ".* FROM " + DBHelper.DATABASE_TABLE_COMMENTAIRES + ", " + DBHelper.DATABASE_TABLE_NUMEROS + ", " + DBHelper.DATABASE_TABLE_COMMENTAIRE_NUMERO
                + " WHERE " + DBHelper.DATABASE_TABLE_COMMENTAIRE_NUMERO + ".idNumero = " + DBHelper.DATABASE_TABLE_NUMEROS + ".id "
                + " AND " + DBHelper.DATABASE_TABLE_NUMEROS + ".id = " + idNo;
        Cursor cur = ExecuteQuery(sql, null);
        while(!cur.isAfterLast()){
            Commentaire unCommentaire = new Commentaire(cur.getLong(0),cur.getInt(1),cur.getString(2));
            lesCommentaires.add(unCommentaire);
            cur.moveToNext();
        }
        return lesCommentaires;
    }
    
    public ArrayList<Commentaire> selectLesCommentairesParRubrique(long idRubrique){
        ArrayList<Commentaire> lesCommentaires = new ArrayList<Commentaire>();
        String sql = "SELECT " +  DBHelper.DATABASE_TABLE_COMMENTAIRES + ".* FROM " + DBHelper.DATABASE_TABLE_COMMENTAIRES + ", " + DBHelper.DATABASE_TABLE_RUBRIQUES + ", " + DBHelper.DATABASE_TABLE_COMMENTAIRE_RUBRIQUE
                + " WHERE " + DBHelper.DATABASE_TABLE_COMMENTAIRE_RUBRIQUE + ".idRubrique = " + DBHelper.DATABASE_TABLE_RUBRIQUES + ".id "
                + " AND " + DBHelper.DATABASE_TABLE_RUBRIQUES + ".id = " + idRubrique;
        Cursor cur = ExecuteQuery(sql, null);
        while(!cur.isAfterLast()){
            Commentaire unCommentaire = new Commentaire(cur.getLong(0),cur.getInt(1),cur.getString(2));
            lesCommentaires.add(unCommentaire);
            cur.moveToNext();
        }
        return lesCommentaires;
    }
    
    public ArrayList<Numero> selectNumeroParIdMagazine(long idMagazine){
        ArrayList<Numero> lesNumeros = new ArrayList<Numero>();
        
        String sql = "SELECT * FROM " + DBHelper.DATABASE_TABLE_NUMEROS + " WHERE idMag = " + idMagazine;
        open();
        Cursor cur = ExecuteQuery(sql, null);
        //on vas récuperer apartir de la table numéro une liste d'article et sont numéro associer.
        while(!cur.isAfterLast()){
            ArrayList<Commentaire> lesCommentaires = selectLesCommentairesParNumero(cur.getLong(0));
            ArrayList<Article> lesArticles = new ArrayList<Article>();
            
            lesArticles = selectArticleParIdNo(cur.getLong(0));
            ArrayList lesIdArticle = new ArrayList();
            for(Article unArticle : lesArticles){
                lesIdArticle.add(unArticle.getId());
            }
            Numero unNumero = new Numero(cur.getLong(0), cur.getInt(1), cur.getLong(2),lesIdArticle, lesCommentaires);
            
            lesNumeros.add(unNumero);
            cur.moveToNext();
        }
        close();
        return lesNumeros;
    }
    

    public Magazine selectMagazine(long id){
        String sql="SELECT * FROM " + DBHelper.DATABASE_TABLE_MAGAZINES + " WHERE id = " + id;
        
        ArrayList<Numero> lesNumeros = selectNumeroParIdMagazine(id);
        ArrayList lesIdNumero = new ArrayList();
        for(Numero unNumero : lesNumeros){
            lesIdNumero.add(unNumero.getId());
        }
        open();
        Cursor cur = ExecuteQuery(sql, null);
        
        Magazine leMagazine = new Magazine(cur.getLong(0), cur.getString(1),cur.getLong(2), cur.getInt(3), lesIdNumero);
        close();
        return leMagazine;
    }
    
    public long insertCommentaireNumero(Commentaire monCommentaire, long idNumero){
        
        //insérer un magazine
        ContentValues initialiserCommentaire = new ContentValues();
        initialiserCommentaire.put("rate", monCommentaire.getNote());
        initialiserCommentaire.put("texte", monCommentaire.getTexte());
        
        //insertion
        open();
        long idCommentaire=  db.insert(DBHelper.DATABASE_TABLE_COMMENTAIRES, null, initialiserCommentaire);
        ContentValues assoc = new ContentValues();
        assoc.put("idNumero", idNumero);
        assoc.put("idCommentaire", idCommentaire);
        db.insert(DBHelper.DATABASE_TABLE_COMMENTAIRE_NUMERO, null, assoc);
        close();
        return idCommentaire;
    }
    
     public long insertCommentaireArticle(Commentaire monCommentaire, long idArticle){
        
        //insérer un magazine
        ContentValues initialiserCommentaire = new ContentValues();
        initialiserCommentaire.put("rate", monCommentaire.getNote());
        initialiserCommentaire.put("texte", monCommentaire.getTexte());
        
        //insertion
        open();
        long idCommentaire=  db.insert(DBHelper.DATABASE_TABLE_COMMENTAIRES, null, initialiserCommentaire);
        ContentValues assoc = new ContentValues();
        assoc.put("idArticle", idArticle);
        assoc.put("idCommentaire", idCommentaire);
        db.insert(DBHelper.DATABASE_TABLE_COMMENTAIRE_NUMERO, null, assoc);
        close();
        return idCommentaire;
    }
    
    public void supprimerCommentaire(Commentaire monCommentaire) {
        
        open();
        db.delete(DBHelper.DATABASE_TABLE_COMMENTAIRES, "id="+monCommentaire.getId(), null);
        close();
        
    }
    
    
   
    
    public long insertMagazine(Magazine monMagazine)
    {
    	//insérer un magazine
        ContentValues intitaliserMagazine = new ContentValues();
        intitaliserMagazine.put("nom", monMagazine.getNom());
        intitaliserMagazine.put("idTheme", monMagazine.getIdTheme());
        intitaliserMagazine.put("prix", monMagazine.getPrix());
        
        //insertion
        open();
        long idMagazine = db.insert(DBHelper.DATABASE_TABLE_MAGAZINES, null, intitaliserMagazine);
        close();
        return idMagazine;
    }
    
    public void supprimerMagazine(Magazine monMagazine) {
        
        open();
        db.delete("magazines", "id="+monMagazine.getId(), null);
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
        ArrayList<Commentaire> lesCommentaires = selectLesCommentairesParNumero(id);
        ArrayList<Article> lesArticles = selectArticleParIdNo(id);
        ArrayList lesIdArticles = new ArrayList();
        for(Article unArticle : lesArticles){
            lesIdArticles.add(unArticle.getId());
        }
        Numero unNumero = new Numero(cur.getLong(0), cur.getInt(1), cur.getLong(2),lesIdArticles, lesCommentaires);
        return unNumero;
    }
    
    
    public long insertArticle(Article article)
    {
        ContentValues initialValuesArticle = new ContentValues();
        
         initialValuesArticle.put("titre", article.getTitre());
         initialValuesArticle.put("idNo", article.getIdNo());
         
         open();
         
         long idArticle = db.insert(DBHelper.DATABASE_TABLE_ARTICLES, null, initialValuesArticle);
         close();
         return idArticle;
    }
    
    
    
    public Article selectArticle(long id)
    {
        String sql = "SELECT * FROM " + DBHelper.DATABASE_TABLE_ARTICLES +" WHERE id =" +id;
        Cursor cur = ExecuteQuery(sql, null);
        ArrayList<Commentaire> lesCommentaires = selectLesCommentairesParArticle(id);
        Article unArticle = new Article(cur.getLong(0),cur.getString(1),cur.getLong(2), lesCommentaires);
        return unArticle;
        
    }
    
    public long insertRubruque(Rubrique rubrique)
    {
        ContentValues initialValuesRubrique = new ContentValues();
        
        initialValuesRubrique.put("nom", rubrique.getNom());
        
        open();
        long idRubrique = db.insert(DBHelper.DATABASE_TABLE_RUBRIQUES, null, initialValuesRubrique);
        close();
        return idRubrique;
    }
    
    public Rubrique selectRubrique(long id)
    {
        String sql = "SELECT * FROM " + DBHelper.DATABASE_TABLE_RUBRIQUES + " WHERE id=" + id;
        
        Cursor cur = ExecuteQuery(sql, null);
        ArrayList<Commentaire> lesCommentaires = selectLesCommentairesParRubrique(id);
        
        Rubrique maRubrique = new Rubrique(cur.getLong(0), cur.getString(1), lesCommentaires);
        return maRubrique;
        
        
    }
    
    public long supprimerRuprique(Rubrique rubrique)
    {
        
       
        
        open();
        int delete = db.delete(DBHelper.DATABASE_TABLE_RUBRIQUES,  "id= " + rubrique.getId(),null);
        close();
        return delete;
        
    }
   
}
