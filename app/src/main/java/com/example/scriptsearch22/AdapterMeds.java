package com.example.scriptsearch22;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Collections;
import java.util.List;

public class AdapterMeds extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private LayoutInflater inflater;
    List<MedData> data= Collections.emptyList();
    MedData current;

    // create constructor to initialize context and data sent from MainActivity
    public AdapterMeds(Context context, List<MedData> data){
        this.context=context;
        inflater= LayoutInflater.from(context);
        this.data=data;
    }

    // Inflate the layout when ViewHolder created
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.container_meds, parent,false);
        MyHolder holder=new MyHolder(view);
        return holder;
    }

    // Bind data
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        // Get current position of item in RecyclerView to bind data and assign values from list
        final MyHolder myHolder= (MyHolder) holder;
        MedData current=data.get(position);
        myHolder.textPharmacyName.setText(current.pharmacy);
        myHolder.textMedName.setText("Medicine: " + current.medName);
        myHolder.textMg.setText("MG: " + current.mG);
        myHolder.textPackSize.setText("Tablet Amount " + current.packSize);
        myHolder.amountStock.setText(" "+current.stockAmount);
        myHolder.latitude.setText(" "+current.lat);
        myHolder.longitude.setText( " "+current.lon);




        myHolder.textPackSize.setTextColor(ContextCompat.getColor(context, R.color.colorAccent));





        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                //Intent intent = new Intent(v.getContext(), MapsActivity.class);

                //intent.putExtra("cords", myHolder.latitude.getText());
                //intent.putExtra("cords2", myHolder.longitude.getText());




                //context.startActivity(intent);



            }
        });





    }

    // return total item from List
    @Override
    public int getItemCount() {
        return data.size();
    }


    class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView textPharmacyName;
        TextView textMedName;
        TextView textMg;
        TextView textPackSize;
        TextView amountStock;
        TextView latitude;
        TextView longitude;

        // create constructor to get widget reference
        public MyHolder(View itemView) {
            super(itemView);
            textPharmacyName = (TextView) itemView.findViewById(R.id.textPharmName);
            textMedName = (TextView) itemView.findViewById(R.id.textMedName);
            textMg = (TextView) itemView.findViewById(R.id.textMG);
            textPackSize = (TextView) itemView.findViewById(R.id.textPack);
            amountStock = (TextView)itemView.findViewById(R.id.textStock);
            latitude = (TextView)itemView.findViewById(R.id.textLat);
            longitude = (TextView)itemView.findViewById(R.id.textLong);
            itemView.setOnClickListener(this);
        }

        // Click event for all items
        @Override
        public void onClick(View v) {

            Toast.makeText(context, "You clicked an item", Toast.LENGTH_SHORT).show();



        }

    }



}


