package net.sgoliver.android.gridview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class TableAdapter extends BaseAdapter {
    private Context context;
    TableAdapter adapter = this;
  //  private final String[] mobileValues;
  ArrayList<String> mobileValues = new ArrayList<String>();
    public TableAdapter(Context context, ArrayList<String> list) {
        this.context = context;
        this.mobileValues = list;
    }

    public View getView(final int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View gridView;

        if (convertView == null) {

            gridView = new View(context);

            // get layout from mobile.xml
         //   gridView = inflater.inflate(R.layout.filaproductos, null);
            convertView = LayoutInflater.from(context).inflate(R.layout.filaproductos, parent, false);
            // set value into textview
            TextView idpro = (TextView) convertView.findViewById(R.id.grid_item_idpro);
            idpro.setText(mobileValues.get(position)); //[position]);

            TextView nombrepro = (TextView) convertView
                    .findViewById(R.id.grid_item_pro);
        //    nombrepro.setText(mobileValues[position]);
            nombrepro.setText(mobileValues.get(position));

            TextView cantidad = (TextView) convertView
                    .findViewById(R.id.grid_item_notas);
          //  cantidad.setText(mobileValues[position]);
            cantidad.setText(mobileValues.get(position));

/*
            Button btnQuitar = (Button) gridView.findViewById(R.id.btnQuitarProd);

            btnQuitar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(
                            context, mobileValues[position]
                            , Toast.LENGTH_SHORT).show();


                }
            });*/

            convertView.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                   // Toast.makeText(context, Integer.toString(position) , Toast.LENGTH_SHORT).show();
                   mobileValues.remove(position);
                    adapter.notifyDataSetChanged();
                }
            });

            //String mobile = mobileValues[position];
            mobileValues.get(position);


        } else {
            convertView = (View) convertView;
        }

        return convertView;
    }

    @Override
    public int getCount() {
        return mobileValues.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

}