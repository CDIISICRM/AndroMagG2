/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dbAccess;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.Locale;

/**
 *
 * @author crm
 */
public class DBHelper extends SQLiteOpenHelper{
    private static final String TAG = "DBHelper";
    private static final String DATABASE_NAME = "dbAndromag";
    private static final int DATABASE_VERSION = 1;
    
    public static final String DATABASE_TABLE_MAGAZINES = "magazines";
    public static final String DATABASE_TABLE_THEMES  = "themes";
    public static final String DATABASE_TABLE_COMMENTAIRES = "commentaires";
    public static final String DATABASE_TABLE_COMMENTAIRE_NUMERO = "commentaire_numero";
    public static final String DATABASE_TABLE_COMMENTAIRE_RUBRIQUE = "commentaire_rubrique";
    public static final String DATABASE_TABLE_COMMENTAIRE_ARTICLE = "commentaire_article";
    public static final String DATABASE_TABLE_RUBRIQUES = "rubriques";
    public static final String DATABASE_TABLE_NUMEROS = "numeros";
    public static final String DATABASE_TABLE_ARTICLES = "articles";
    
    
    //set encodig
    public static final String DATABASE_ENCODE = "PRAGMA " + DATABASE_NAME + ".encoding = 'UTF-8';";
    //table magazines
    public static final String DATABASE_CREATE_MAGAZINES = "CREATE TABLE " + DATABASE_TABLE_MAGAZINES + " (" +
            "id INTEGER PRIMARY KEY, " + 
            "nom VARCHAR(45) NOT NULL, " +
            "idTheme INTEGER NOT NULL, " +
            "prix REAL NOT NULL, " +
            "FOREIGN KEY(idTheme) REFERENCES " + DATABASE_TABLE_THEMES + "(id));";
    
    //table commentaires
    public static final String DATABASE_CREATE_COMMENTAIRES = "CREATE TABLE " + DATABASE_TABLE_COMMENTAIRES + " (" + 
            "id INTEGER PRIMARY KEY, " +  
            "rate INTEGRER, " + 
            "texte TEXT);";
    
    //table contenus
     public static final String DATABASE_CREATE_THEMES = "CREATE TABLE " + DATABASE_TABLE_THEMES + " (" + 
             "id INTEGER PRIMARY KEY, " +
             "nom VARCHAR(45)); ";
    
     
     public static final String DATABASE_CREATE_COMMENTAIRE_NUMERO = "CREATE TABLE " + DATABASE_TABLE_COMMENTAIRE_NUMERO + " (" + 
             "idCommentaire INTEGER, " + 
             "idNumero INTEGER, " +
             "FOREIGN KEY(idCommentaire) REFERENCES " + DATABASE_TABLE_COMMENTAIRES + "(id), "
             + "FOREIGN KEY(idNumero) REFERENCES " + DATABASE_TABLE_NUMEROS + "(id), "
             + "PRIMARY KEY(idCommentaire, idNumero));";
     
    public static final String DATABASE_CREATE_COMMENTAIRE_ARTICLE = "CREATE TABLE " + DATABASE_TABLE_COMMENTAIRE_ARTICLE + " (" + 
             "idCommentaire INTEGER, " + 
             "idArticle INTEGER, " +
             "FOREIGN KEY(idCommentaire) REFERENCES " + DATABASE_TABLE_COMMENTAIRES + "(id), "
             + "FOREIGN KEY(idArticle) REFERENCES " + DATABASE_TABLE_ARTICLES + "(id),"
            + " PRIMARY KEY (idCommentaire, idArticle));";
           
    public static final String DATABASE_CREATE_ARTICLE = "CREATE TABLE " + DATABASE_TABLE_ARTICLES + " ("
            + "id INTEGER PRIMARY KEY, "
            + "titre VARCHAR(45) NOT NULL, "
            + "idNo INTEGER NOT NULL, "
            + "FOREIGN KEY(idNo) REFERENCES " + DATABASE_TABLE_NUMEROS + "(id));";
    
    public static final String DATABASE_CREATE_NUMEROS = "CREATE TABLE " + DATABASE_TABLE_NUMEROS + " ("
            + "id INTEGER PRIMARY KEY, "
            + "no INTEGER NOT NULL, "
            + "idMag INTEGER NOT NULL, "
            + "FOREIGN KEY(idMag) REFERENCES " + DATABASE_TABLE_MAGAZINES + "(id));";
    
    public static final String DATABASE_CREATE_RUBRIQUES = "CREATE TABLE " + DATABASE_TABLE_RUBRIQUES + " ("
            + "id INTEGER PRIMARY KEY, "
            + "nom VARCHAR(45) NOT NULL);";

    public static final String DATABASE_CREATE_COMMENTAIRE_RUBRIQUE = "CREATE TABLE " + DATABASE_TABLE_COMMENTAIRE_RUBRIQUE + " ("
            + "idRubrique INTEGER, "
            + "idCommentaire INTEGER, "
            + "FOREIGN KEY(idRubrique) REFERENCES " + DATABASE_TABLE_RUBRIQUES + "(id), "
            + "FOREIGN KEY(idCommentaire) REFERENCES " + DATABASE_TABLE_COMMENTAIRES + "(id),"
            + " PRIMARY KEY(idRubrique, idCommentaire));";
    
    public static final String DATABASE_INSERT_DEFAULTS_THEMES = "INSERT INTO "+ DATABASE_TABLE_THEMES + "(nom) "
            + "VALUES('Jardin'),('TV'), ('Maison'),('Déco');"; 
    
    public static final String DATABASE_INSERT_DEFAULTS_MAGAZINES = "INSERT INTO "+ DATABASE_TABLE_MAGAZINES + "(nom, prix, idTheme) "
            + "VALUES('J''aimes les plantes vertes', 10, 1), ('Passer une soirée', 2, 2), ('Le ménage pour les débutants', 1, 3), ('Décorer un élève ingénieur', 8, 4);";
    
    public static final String DATABASE_INSERT_NUMERO = "INSERT INTO " + DBHelper.DATABASE_TABLE_NUMEROS + " ( no, idMag) "
            + "VALUES (1,1), (2,1);";
    
    public static final String DATABASE_INSERT_ARTICLES = "INSERT INTO " + DBHelper.DATABASE_TABLE_ARTICLES + " (titre, idNo) "
            + "VALUES ('un bel article', 1), ('un article intéressant', 1), ('un article dans le numéro 2', 2), ('un quatrieme article', 2);";
    
    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.setLocale(Locale.FRANCE);
        db.execSQL(DATABASE_CREATE_COMMENTAIRES);
        db.execSQL(DATABASE_CREATE_RUBRIQUES);
        db.execSQL(DATABASE_CREATE_THEMES);
        db.execSQL(DATABASE_CREATE_MAGAZINES);
        db.execSQL(DATABASE_CREATE_NUMEROS);
        db.execSQL(DATABASE_CREATE_ARTICLE);
        db.execSQL(DATABASE_CREATE_COMMENTAIRE_ARTICLE);
        db.execSQL(DATABASE_CREATE_COMMENTAIRE_NUMERO);
        db.execSQL(DATABASE_CREATE_COMMENTAIRE_RUBRIQUE);
        db.execSQL(DATABASE_INSERT_DEFAULTS_THEMES);
        db.execSQL(DATABASE_INSERT_DEFAULTS_MAGAZINES);
        db.execSQL(DATABASE_INSERT_NUMERO);
        db.execSQL(DATABASE_INSERT_ARTICLES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        
    }
    
}
