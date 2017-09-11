package com.example.aids.a09application;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aids on 09/09/2017.
 */

public class StandingsAdapter extends ArrayAdapter {
    List list = new ArrayList();
    public StandingsAdapter(@NonNull Context context, @LayoutRes int resource) {
        super( context, resource );
    }

    public void add(Standings object) {
        super.add( object );
        list.add( object );
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        return list.get( position );
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row;
        row = convertView;
        StandingsHolder standingsHolder;
        if(row ==null){
            LayoutInflater layoutInflater= (LayoutInflater) this.getContext().getSystemService( Context.LAYOUT_INFLATER_SERVICE );
            row = layoutInflater.inflate(R.layout.row_layout, parent, false);
            standingsHolder = new StandingsHolder();
            standingsHolder.tx_id = (TextView) row.findViewById( R.id.sec_1 );
            standingsHolder.txt_id = (TextView) row.findViewById( R.id.sec_2 );
            standingsHolder.tx_fn = (TextView) row.findViewById( R.id.sec_3 );
            standingsHolder.tx_ln = (TextView) row.findViewById( R.id.sec_4 );
            standingsHolder.tx_pos = (TextView) row.findViewById( R.id.sec_5 );
            standingsHolder.tx_po = (TextView) row.findViewById( R.id.sec_6 );
            row.setTag( standingsHolder );
        }
        else
        {
            standingsHolder = (StandingsHolder) row.getTag();
        }
        Standings standings = (Standings)this.getItem( position );
        standingsHolder.tx_id.setText(String.valueOf( standings.getDriver_id()));
        standingsHolder.txt_id.setText(String.valueOf( standings.getTeam_id()));
        standingsHolder.tx_fn.setText( standings.getFirstName() );
        standingsHolder.tx_ln.setText( standings.getLastName() );
        standingsHolder.tx_pos.setText(String.valueOf( standings.getPosition()));
        standingsHolder.tx_po.setText(String.valueOf( standings.getPoints()));


        return row;
    }

    static class StandingsHolder {
        TextView tx_id, txt_id, tx_fn, tx_ln, tx_pos, tx_po;
    }
}
