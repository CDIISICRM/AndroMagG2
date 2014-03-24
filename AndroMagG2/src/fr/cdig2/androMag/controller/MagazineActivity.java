package fr.cdig2.androMag.controller;

import java.util.ArrayList;

import dbAccess.DBAdapter;
import fr.cdig2.androMag.metier.Magazine;
import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.os.Build;
import android.widget.TextView;

public class MagazineActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_magazine);
/*
		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	*/	
		ListView laListView = (ListView)findViewById(R.id.listView1);
		
		DBAdapter dba = new DBAdapter(this);
		ArrayList<Magazine> lesMagazines = dba.slectTousLesMagazines();
<<<<<<< HEAD
<<<<<<< HEAD
		ArrayList<String> list = new ArrayList<String>();
		for(Magazine unMagazine : lesMagazines){
			list.add(unMagazine.getNom());
		}
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.item_list_view,R.id.titre_liste_magazine, list);
=======
=======
>>>>>>> da8b187d9e5e8d3cd969badd6e9e1880d260a1df
                
//		ArrayList<String> list = new ArrayList<String>();
                
//		for(Magazine unMagazine : lesMagazines){
//                    TextView magazineNom = (TextView) laListView.findViewById(R.id.magazineId);
//                    magazineNom.setText(unMagazine.getNom());
////			list.add(unMagazine.getNom());
//		}
                MagazineAdapter adapter = new MagazineAdapter(lesMagazines, this);
//		ArrayAdapter<Magazine> adapter = new ArrayAdapter<Magazine>(this, R.layout.item_list_view,R.id.magazineId, lesMagazines);
<<<<<<< HEAD
>>>>>>> da8b187d9e5e8d3cd969badd6e9e1880d260a1df
=======
>>>>>>> da8b187d9e5e8d3cd969badd6e9e1880d260a1df
		laListView.setAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.magazine, menu);
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

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_magazine,
					container, false);
			return rootView;
		}
	}

}
