package fr.cdig2.androMag.controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import dbAccess.DBAdapter;
import fr.cdig2.androMag.metier.Commentaire;
import fr.cdig2.androMag.metier.Magazine;





public class AndroMag extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.andromag);
        
        //Créér la base de donnée
        DBAdapter dba= new DBAdapter(this);
//        
//        //insérer un theme
//       dba.insertTheme("Maison");
//        
        //insérer un magazine
//        Magazine unMagazine = new Magazine(0, "Playboy", 1, 10, null);
//        dba.insertMagazine(unMagazine);
//        Commentaire nosCommentaire = new Commentaire(0, "Commentaire 2");
//        nosCommentaire.EnregistrerCommentaire(this.getApplicationContext());
//        
//        //creer numero
//        Numero unNumero = new Numero(10, 2);
//        long idNumero = dba.insertNo(unNumero);
//        Numero leNumeroSauvegarde = dba.selectNumero(idNumero);
//        Log.i("unNumero", leNumeroSauvegarde.toString()); 
//        
//        //recuperation
//        
//        Cursor cur = dba.ExecuteQuery("SELECT * FROM magazines", null);
//        while(!cur.isAfterLast()){
//            Log.i("unMagazine", cur.getString(1));
//            
//            cur.moveToNext();
//        }
//        
//        dba.supprimerCommentaire(nosCommentaire);
//        
//        Cursor cur2 = dba.ExecuteQuery("SELECT * FROM "+DBHelper.DATABASE_TABLE_COMMENTAIRES, null);
//        while(!cur2.isAfterLast()) {
//        	Toast.makeText(this, cur2.getString(2), Toast.LENGTH_LONG).show();
//        	cur2.moveToNext();
//        }
//        
//        System.out.println(cur2.toString());
//   
        
//        Article unArticle = new Article("Stella", 1);
//        
//        long idArticle = dba.insertArticle(unArticle);
//        
//        Article AffArticle = dba.selectArticle(idArticle);
//        
//        Log.i("Affiche Article", AffArticle.toString());
//        
//        Rubrique uneRubrique = new  Rubrique(1,"Titania");
//        long idRubrique = dba.insertRubruque(uneRubrique);
//        
//        Rubrique AffRubrique = dba.selectRubrique(idRubrique);
//        Log.i("Affiche Rubrique", AffRubrique.toString());
//        
//
//        Cursor cur = dba.ExecuteQuery("SELECT * FROM "+DBHelper.DATABASE_TABLE_MAGAZINES, null);
//        while(!cur.isAfterLast()){
//            Log.i("unMagazine", cur.getLong(0) + "-" + cur.getString(1) + "-" + cur.getLong(2) + "-" + cur.getInt(3));
//            
//            cur.moveToNext();
//        }
//        
//        
//        Cursor cur2 = dba.ExecuteQuery("SELECT * FROM "+ DBHelper.DATABASE_TABLE_THEMES, null);
//        while(!cur2.isAfterLast()){
//            Log.i("unTheme", cur2.getLong(0) + "-" + cur2.getString(1));
//            
//            cur2.moveToNext();
//        }
//
//        Cursor cur3 =dba.ExecuteQuery("SELECT * FROM " + DBHelper.DATABASE_TABLE_RUBRIQUES , null);
//          while(!cur3.isAfterLast()){
//            Log.i("uneRubrique", cur3.getLong(0) + "-" + cur3.getString(1));
//            
//            cur3.moveToNext();
//        }
        
        
//          Rubrique uneRubrique = new  Rubrique(2,"Trition");
//          long idRubrique = dba.insertRubruque(uneRubrique);
//        
//        Rubrique AffRubrique = dba.selectRubrique(idRubrique);
//        Log.i("Affiche Rubrique", AffRubrique.toString());
//        
        // Supprimer une rubrique
//        if(AffRubrique.getId())
//        {
//            long idRubrique = dba.supprimerRuprique(uneRubrique);
//        
//            Rubrique AffRubrique = dba.selectRubrique(idRubrique);
//            Log.i("Affiche Rubrique", AffRubrique.toString());
//        }
      
//      
//        Magazine unMagazine = dba.selectMagazine(1);
//        Log.i("magazine", unMagazine.toString());
//        ArrayList<Numero> lesnNumeros = dba.selectNumeroParIdMagazine(1);
//        for(Numero unNumero : lesnNumeros){
//            Log.i("numero", unNumero.toString());
//            ArrayList<Article> lesArticles = dba.selectArticleParIdNo(unNumero.getId());
//            for(Article unArticle : lesArticles){
//                Log.i("article", unArticle.toString());
//            }
//        }
        
        
        Intent intent = new Intent(this, MagazineActivity.class);
        this.startActivity(intent);
    }
}
