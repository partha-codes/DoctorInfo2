package com.abc.doctorinfo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class doctorAdapter extends RecyclerView.Adapter <doctorAdapter.doctorViewHolder>{


    //this context we will use to inflate the layout
    private Context mCtx;

    //we are storing all the products in a list
    private List<doctor> doctorList;


    //set the adapter here
    public doctorAdapter(Context mCtx, List<doctor> doctorList) {
        this.mCtx = mCtx;
        this.doctorList = doctorList;
    }

    @NonNull
    @Override
    public doctorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.layout_doctor,parent, false);
        return new doctorViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull doctorViewHolder holder, int position) {
        //getting the product of the specified position
        doctor dct = doctorList.get(position);

        //binding the data with the viewholder views
        holder.textViewName.setText(dct.getName());
        holder.textViewSpeciality.setText(dct.getSpeciality());
        holder.textViewRating.setText(String.valueOf(dct.getRating()));
        holder.textViewEmail.setText(String.valueOf(dct.getEmail()));
        holder.textViewLocation.setText(String.valueOf(dct.getLocation()));
        holder.imageView.setImageDrawable(mCtx.getResources().getDrawable(dct.getImage()));
    }

    @Override
    public int getItemCount() {
        return doctorList.size();
    }


    class doctorViewHolder extends RecyclerView.ViewHolder {

        TextView textViewName, textViewSpeciality, textViewRating, textViewEmail,textViewLocation;
        ImageView imageView;

        public doctorViewHolder(View itemView) {
            super(itemView);

            textViewName = itemView.findViewById(R.id.textViewTitle);
            textViewSpeciality = itemView.findViewById(R.id.textViewShortDesc);
            textViewRating = itemView.findViewById(R.id.textViewRating);
            textViewEmail = itemView.findViewById(R.id.textViewPrice);
            imageView = itemView.findViewById(R.id.imageView);
            textViewLocation=itemView.findViewById(R.id.textViewLocation);
        }
    }







}
