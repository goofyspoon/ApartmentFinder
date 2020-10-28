package com.example.ApartmentFinder.home;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ApartmentFinder.Details;
import com.example.ApartmentFinder.R;
import com.example.ApartmentFinder.app.Apartment;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private LayoutInflater inflater;
    private ArrayList<Apartment> apartmentArray;

    private String[] aTitles;
    private String[] aContent;
    Adapter(Context context, ArrayList<Apartment> apartmentArray){
        this.inflater = LayoutInflater.from(context);
        this.apartmentArray = apartmentArray;
    }

    Adapter (Context context, String[] titles, String[] contents) {
        this.inflater = LayoutInflater.from(context);
        this.aTitles = titles;
        this.aContent = contents;
    }
    Adapter(Context context) throws JSONException {
//        this.inflater = LayoutInflater.from(context);
//        this.aTitles = new String[1];
//        this.aContent = new String[1];
        this.inflater = LayoutInflater.from(context);
        this.apartmentArray = new ArrayList<Apartment>();
        JSONObject  myJson = new JSONObject();

        myJson.put("apartment_id", 0);
        myJson.put("address", "");
        myJson.put("apartment_name", "Loading...");
        myJson.put("location", "");
        myJson.put("num_rooms", 0);
        myJson.put("rating", 0);
        myJson.put("rent", 0);

        apartmentArray.add(new Apartment(myJson));
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.custom_view,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

//        String aptTitle = aTitles[i];
//        String aptContent = aContent[i];
        String aptName = apartmentArray.get(i).getApartment_name();
        String aptAddress = apartmentArray.get(i).getAddress();
        viewHolder.ApartmentName.setText(aptName);
        viewHolder.ApartmentAddress.setText(aptAddress);
    }

    @Override
    public int getItemCount() {
        return apartmentArray.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView ApartmentName,ApartmentAddress;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(v.getContext(), Details.class);
//                    i.putExtra("nameOfApartment", aTitles[getAdapterPosition()]);
//                    i.putExtra("contentOfApartment", aContent[getAdapterPosition()]);
                    i.putExtra("nameOfApartment", apartmentArray.get(getAdapterPosition()).getApartment_name());
                    i.putExtra("addressOfApartment", apartmentArray.get(getAdapterPosition()).getAddress());
                    v.getContext().startActivity(i);
                }
            });
            ApartmentName = itemView.findViewById(R.id.AptTitle);
            ApartmentAddress = itemView.findViewById(R.id.AptContent);
        }
    }

}
