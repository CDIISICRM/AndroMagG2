/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.cdig2.androMag.controller;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import dbAccess.DBAdapter;
import fr.cdig2.androMag.metier.Magazine;

/**
 *
 * @author crm
 */
public class NumerosActivity extends Activity {

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.numeros);
        
        TextView laTextView = (TextView) findViewById(R.id.detail_numero);
        DBAdapter dba = new DBAdapter(this);
        Magazine leMagazine = dba.selectMagazine(this.getIntent().getLongExtra("idMagazine", 0));
        laTextView.setText(leMagazine.toString());
    }
    
}
