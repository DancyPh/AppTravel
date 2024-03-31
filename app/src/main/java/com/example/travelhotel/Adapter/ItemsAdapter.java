package com.example.travelhotel.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

//import com.example.travelhotel.DetailActivity;
import com.example.travelhotel.Domain.ItemsDomain;
import com.example.travelhotel.R;
import com.bumptech.glide.Glide;


import java.text.DecimalFormat;
import java.util.ArrayList;

public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ViewHolder> {

    ArrayList<ItemsDomain> items;
    DecimalFormat formatter;
    Context context;

    public ItemsAdapter(ArrayList<ItemsDomain> items){
        this.items = items;
        formatter = new DecimalFormat("###,###,###,###.##");
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_viewholder,parent,false);
        context = parent.getContext();
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.titleTxt.setText(items.get(position).getTitle());
        holder.addressTxt.setText(items.get(position).getAddress());
        holder.priceTxt.setText("$" + formatter.format(items.get(position).getPrice()));

        int drawableResouceId = holder.itemView.getResources().getIdentifier(items.get(position).getPic(), "drawable",holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext())
                .load(drawableResouceId)
                .into(holder.pic);

        holder.itemView.setOnClickListener(v ->  {
            //Intent intent = new Intent(context, DetailActivity.class);
            //intent.putExtra("object",items.get(position));
            //context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView titleTxt,addressTxt,priceTxt;
        ImageView pic;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTxt = itemView.findViewById(R.id.titletxt);
            addressTxt = itemView.findViewById(R.id.addresstxt);
            priceTxt = itemView.findViewById(R.id.pricetxt);
            pic = itemView.findViewById(R.id.pic);
        }
    }
}