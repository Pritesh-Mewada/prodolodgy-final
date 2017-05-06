package com.prodology.hackathon.prodology;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;


/**
 * Created by pritesh on 12/3/17.
 */

public class FragmentOne extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        String[] demo = {"Ned Stark", "Jon Snow", "Tyrion Lanister ", "Littlefinger", "Robert Baratheon", "Theon Greyjoy"};
        View view = inflater.inflate(R.layout.fragmentone, container, false);
        ListView li = (ListView) view.findViewById(R.id.list);
        ArrayAdapter arrayAdapter = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1, demo);
        li.setAdapter(arrayAdapter);
        Button bt = (Button) view.findViewById(R.id.service);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getContext(), "Service will be available Soon", Toast.LENGTH_SHORT).show();
                CustomToast.show(getContext(),"Service will be available Soon");
            }
        });


        return view;


    }
}
