package com.prodology.hackathon.prodology;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by pritesh on 15/3/17.
 */

public class CustomToast   {

    public static void show(Context context,String text){

        Toast toast = Toast.makeText(context,text,Toast.LENGTH_LONG);
        View view = LayoutInflater.from(context).inflate(R.layout.toastview,null);

        TextView textView = (TextView) view.findViewById(R.id.message);

        textView.setText(text);

        toast.setView(view);

        toast.show();

    }


}
