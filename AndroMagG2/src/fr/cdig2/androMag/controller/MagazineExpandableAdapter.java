package fr.cdig2.androMag.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import fr.cdig2.androMag.controller.MagazineAdapter.MagazineAdapterListener;
import fr.cdig2.androMag.metier.Magazine;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MagazineExpandableAdapter extends BaseExpandableListAdapter {
	private Map<String, List<Magazine>> titreGroupe = new HashMap<String, List<Magazine>>();
    private ArrayList<Magazine> listeMag;
    private Context contexte;
    private LayoutInflater inflater;
    
    private ArrayList<MagazineAdapterListener> magListener = new ArrayList<MagazineAdapterListener>();

    public MagazineExpandableAdapter(ArrayList<Magazine> listeMag, Context contexte) {
        this.listeMag = listeMag;
        this.contexte = contexte;
        this.inflater = LayoutInflater.from(this.contexte);
        this.titreGroupe.put("Tous les magazines", listeMag);
    }
   


	@Override
	public int getGroupCount() {
		return titreGroupe.size();
	}

	@Override
	public int getChildrenCount(int groupPosition) {
		return titreGroupe.get(listeMag.get(groupPosition)).size();
	}

	@Override
	public Object getGroup(int groupPosition) {
		Set leSet = titreGroupe.keySet();
		return leSet.toArray()[0];
	}

	@Override
	public Object getChild(int groupPosition, int childPosition) {
		return titreGroupe.get(listeMag.get(groupPosition)).get(childPosition);
	}

	@Override
	public long getGroupId(int groupPosition) {
		return groupPosition;
	}

	@Override
	public long getChildId(int groupPosition, int childPosition) {
		return childPosition;
	}

	@Override
	public boolean hasStableIds() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public View getGroupView(int groupPosition, boolean isExpanded,
			View convertView, ViewGroup parent) {
		String titreCombo = (String) getGroup(groupPosition);
		if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) contexte
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.group_item,
                    null);
        }
		TextView item = (TextView) convertView.findViewById(R.id.liste_mag); 
		item.setTypeface(null, Typeface.BOLD);
        item.setText(titreCombo);
		return convertView;
	}

	@Override
	public View getChildView(int groupPosition, int childPosition,
			boolean isLastChild, View convertView, ViewGroup parent) {
		final Magazine magazine = (Magazine) getChild(groupPosition, childPosition);
		inflater = LayoutInflater.from(this.contexte);
 
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.child_item, null);
        }
 
        TextView item = (TextView) convertView.findViewById(R.id.child_item);
        item.setText(magazine.getNom());
		return null;
	}

	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return true;
	}

}
