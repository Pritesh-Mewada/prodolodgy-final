package com.prodology.hackathon.prodology;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by pritesh on 21/2/17.
 */

public class RecylerViewAdapter extends RecyclerView.Adapter<RecylerViewAdapter.ViewHolder> {
    int []mainImageId={R.drawable.image,R.drawable.image1,R.drawable.image,R.drawable.image1,R.drawable.image,R.drawable.image1,R.drawable.image,R.drawable.image1};
    String [] tileString={"Computers","Information Tech.","Electronics","Mechanical","Production","Civil","Textile"};
    String [] iconString={"C","I","E","M","P","C","T"};
    String [] color={"#663399","#808080","#4169E1","#C0C0C0","#663399","#708090","#808080"};
    @Override
    public RecylerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview, parent, false);
        ViewHolder vh = new ViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(RecylerViewAdapter.ViewHolder holder, int position) {
        //bind elements
        holder.tileTitle.setText(tileString[position]);
        holder.tiletext.setText(iconString[position]);
        holder.drawable.setColor(Color.parseColor(color[position]));
        holder.mainImage.setImageResource(mainImageId[position]);


    }

    @Override
    public int getItemCount() {
        return 7;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tileTitle;
        TextView tiletext;
        ImageView mainImage;
        GradientDrawable drawable;
        public ViewHolder(View itemView) {
            super(itemView);
            //give elements of cardview
            tiletext = (TextView) itemView.findViewById(R.id.icon_letter);
            drawable = (GradientDrawable)tiletext.getBackground();
            mainImage = (ImageView) itemView.findViewById(R.id.mainImage);
            tileTitle = (TextView) itemView.findViewById(R.id.tileTitle);
        }
    }


}