package com.example.tnvprojectandroid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class UtentiAdapter extends ArrayAdapter<Utente> {
    public UtentiAdapter(Context context, int textViewResourceId,
                         List<Utente> objects) {
        super(context, textViewResourceId, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.activity_gestione_singolo_elemento, null);
        TextView titolo = (TextView)convertView.findViewById(R.id.title);
        TextView descrizione = (TextView)convertView.findViewById(R.id.description);
        Utente c = getItem(position);
        titolo.setText(c.getUsername());
        descrizione.setText("Admin: "+c.getAdmin().toString());
        return convertView;
    }

}

