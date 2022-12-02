package a.b.svgflagsdrawable.example;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.HashMap;

import a.b.svgflagsdrawable.FlagView;

class ExampleFlafPitoryList extends ArrayAdapter {
  HashMap<Integer,FlagView> flmap = new HashMap<>();

    String[] all , values;
    public ExampleFlafPitoryList(Context context) {
        super(context, 0);
       all = FlagView.getAliases(context);
        values = FlagView.getValues(context);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = LayoutInflater.from(getContext()).inflate(R.layout.item_flag_pictory ,null);
        FlagView flv = v.findViewById(R.id.flag) ;
        TextView country = v.findViewById(R.id.country);
        country.setText(all[position]);
        FlagView posfl = flmap.get(position);
        if(posfl == null){
            flv.setLoadFlag(values[position]);
            flmap.put(position,flv);
        } else flv.setImageDrawable( posfl.getDrawable());

        return v;
    }

    @Override
    public int getCount() {
        return all.length;
    }
}
