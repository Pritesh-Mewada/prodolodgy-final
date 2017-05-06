package com.prodology.hackathon.prodology;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * Created by pritesh on 12/3/17.
 */

public class FragmentTwo extends Fragment {
    Boolean a = false;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        String[] demo = {"Cersei Lannister", "Daenerys Targaryen", "Sansa Stark", "Margaery Tyrell", "Melisandre"};

        View view = inflater.inflate(R.layout.fragmenttwo, container, false);
        Spinner spinner = (Spinner) view.findViewById(R.id.spinThis);
        ArrayAdapter arrayAdapter = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1, demo);
        spinner.setAdapter(arrayAdapter);
        Button btn = (Button) view.findViewById(R.id.vote);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (a == false) {
                    CustomToast.show(getContext(),"Your vote has been noted");
                    //Toast.makeText(getContext(), "Your vote has been noted", Toast.LENGTH_SHORT).show();
                    a = true;
                } else {
                    CustomToast.show(getContext(),"Your had already voted");

                    //Toast.makeText(getContext(), "", Toast.LENGTH_SHORT).show();

                }
            }
        });


        return view;
    }
}
