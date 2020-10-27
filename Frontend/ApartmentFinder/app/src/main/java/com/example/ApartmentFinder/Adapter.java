package com.example.ApartmentFinder;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private LayoutInflater inflater;
    private String[] aTitles;
    private String[] aContent;
    Adapter (Context context, String[] titles, String[] contents) {
        this.inflater = LayoutInflater.from(context);
        this.aTitles = titles;
        this.aContent = contents;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.custom_view,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        String aptTitle = aTitles[i];
        String aptContent = aContent[i];
        viewHolder.ApartmentTitle.setText(aptTitle);
        viewHolder.ApartmentContent.setText(aptContent);
    }

    @Override
    public int getItemCount() {
        return aTitles.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView ApartmentTitle,ApartmentContent;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(v.getContext(), Details.class);
                    i.putExtra("nameOfApartment", aTitles[getAdapterPosition()]);
                    i.putExtra("contentOfApartment", aContent[getAdapterPosition()]);
                    v.getContext().startActivity(i);
                }
            });
            ApartmentTitle = itemView.findViewById(R.id.AptTitle);
            ApartmentContent = itemView.findViewById(R.id.AptContent);
        }
    }

}
