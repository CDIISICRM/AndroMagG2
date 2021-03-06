/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.cdig2.androMag.controller;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.os.Build;
import dbAccess.DBAdapter;
import fr.cdig2.androMag.metier.Magazine;
/**
 *
 * @author crm
 */
public class SupprimerMagazine extends Activity {

    Intent intentionPrecedente;
	int idMagazineSupprimer;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_supprimer_magazine);

		intentionPrecedente = this.getIntent();
		//idMagazineSupprimer = intentionPrecedente.getIntExtra("idMagazine", 0);
		TextView titreMagazine = (TextView)findViewById(R.id.supr_titre_magazine);
		titreMagazine.setText("Magazine");
		
//		if (savedInstanceState == null) {
//			getFragmentManager().beginTransaction()
//					.add(R.id.container, new PlaceholderFragment()).commit();
//		};
                DBAdapter dba = new DBAdapter(this);
                long[] lesIds = intentionPrecedente.getLongArrayExtra("idsMagazines");
                for(int i = lesIds.length -1; i >= 0; i--){
                    if(lesIds[1] != 0){
                        Magazine unMagazine = dba.selectMagazine(lesIds[i]);
                        dba.supprimerMagazine(unMagazine);
                    }
                    
                }
                
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.supprimer_magazine, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item); 
	}

//	/**
//	 * A placeholder fragment containing a simple view.
//	 */
//	public static class PlaceholderFragment extends Fragment {
//
//		public PlaceholderFragment() {
//		}
//
//		@Override
//		public View onCreateView(LayoutInflater inflater, ViewGroup container,
//				Bundle savedInstanceState) {
//			View rootView = inflater.inflate(
//					R.layout.activity_supprimer_magazine, container, false);
//			return rootView;
//		}
//	}

}

