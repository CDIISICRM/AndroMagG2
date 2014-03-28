package fr.cdig2.androMag.controller;

import java.util.ArrayList;

import dbAccess.DBAdapter;
import fr.cdig2.androMag.metier.Magazine;
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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.os.Build;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MagazineActivity extends Activity implements MagazineAdapter.MagazineAdapterListener, View.OnClickListener{
    ArrayList<Long> lesIdMagazines;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_magazine);
		
		Button boutonAjouter = (Button)findViewById(R.id.bouton_ajouter_magazine);
		boutonAjouter.setOnClickListener(this);
		
		Button boutonSupprimer = (Button)findViewById(R.id.bouton_supprimer_magazine);
		boutonSupprimer.setOnClickListener(this);
		
		
/*
		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	*/	
		ListView laListView = (ListView)findViewById(R.id.listView1);
//                int taille = laListView.getCount();
		lesIdMagazines= new ArrayList<Long>();
                
		DBAdapter dba = new DBAdapter(this);
		ArrayList<Magazine> lesMagazines = dba.selectTousLesMagazines();

                
//		ArrayList<String> list = new ArrayList<String>();
                
//		for(Magazine unMagazine : lesMagazines){
//                    TextView magazineNom = (TextView) laListView.findViewById(R.id.magazineId);
//                    magazineNom.setText(unMagazine.getNom());
////			list.add(unMagazine.getNom());
//		}
                MagazineAdapter adapter = new MagazineAdapter(lesMagazines, this);
//		ArrayAdapter<Magazine> adapter = new ArrayAdapter<Magazine>(this, R.layout.item_list_view,R.id.magazineId, lesMagazines);

                adapter.addListener(this);
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

    public void onClickNom(Magazine item, int position) {
        
        Log.i("magazine", item.toString());
        Intent uneIntent = new Intent(this, NumerosActivity.class).putExtra("idMagazine", item.getId());
        this.startActivity(uneIntent);
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
	
        public void myHandler(View v){
            CheckBox cb = (CheckBox) v;
            Magazine leMagazine = (Magazine) cb.getTag();
            long id = leMagazine.getId();
//            int position = Integer.parseInt(cb.getTag(2).toString());
            if(cb.isChecked()){
                lesIdMagazines.add(id);
            }else{
                lesIdMagazines.remove(id);
            }
        }
	@Override
	public void onClick(View v) 
		{
		System.out.println("Un click 2!");
        switch (v.getId())
        	{
	        case R.id.bouton_ajouter_magazine:
	            System.out.println("Ajouter magazine !");
	            break;
			case R.id.bouton_supprimer_magazine:
				Intent monIntention = new Intent(this, SupprimerMagazine.class);
//                                ArrayList<CheckBox> lesCheckBoxs = new ArrayList<CheckBox>();
//                                ListView laListView = (ListView) findViewById(R.id.listView1);
//                                for(int i = laListView.getCount() - 1; i>=0; i--){
//                                    LinearLayout l  = (LinearLayout) laListView.getChildAt(i);
//                                    CheckBox uneCheckBox = (CheckBox) l.getChildAt(3);
//                                    lesCheckBoxs.add(uneCheckBox);
//                                }
//				
//                                for(int i = lesCheckBoxs.size() - 1; i >= 0; i--){
//                                    CheckBox uneBox = (CheckBox) lesCheckBoxs.get(i);
//                                    lesIdMagazines[i] =  Long.getLong(uneBox.getTag().toString());
//                                }
                                long[] idTab = new long[lesIdMagazines.size()];
                                
                                for(int i = lesIdMagazines.size() - 1; i>=0; i--){
                                    idTab[i] = lesIdMagazines.get(i);
                                }
                                monIntention.putExtra("idsMagazines", idTab);
				startActivityForResult(monIntention, 12);
				break;
	          }
		}
        @Override
        public void onResume(){
            onCreate(Bundle.EMPTY);
        }
}
