/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.cdig2.androMag.controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import fr.cdig2.androMag.metier.Magazine;
import java.util.List;

/**
 *
 * @author crm
 */
public class MagazineAdapter extends BaseAdapter{

    private List<Magazine> listeMag;
    private Context contexte;
    private LayoutInflater inflater;

    public MagazineAdapter(List<Magazine> listeMag, Context contexte) {
        this.listeMag = listeMag;
        this.contexte = contexte;
        this.inflater = LayoutInflater.from(this.contexte);
    }
   

    public int getCount() {
        return listeMag.size();
    }

    public Object getItem(int position) {
        return listeMag.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LinearLayout layoutItem;
        if(convertView == null){
            layoutItem = (LinearLayout) inflater.inflate(R.layout.item_list_view, parent, false);
        } else {
            layoutItem = (LinearLayout) convertView;
        }
        
        TextView magazineNom = (TextView) layoutItem.findViewById(R.id.magazine_nom);
        TextView magazineNote = (TextView) layoutItem.findViewById(R.id.note_liste_magazine);

        magazineNote.setText( String.valueOf(listeMag.get(position).getId()));
        magazineNom.setText(listeMag.get(position).getNom());
        
        return layoutItem;
    }
    
}
