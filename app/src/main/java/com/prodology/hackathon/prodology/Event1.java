package com.prodology.hackathon.prodology;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gadhvi on 25-02-2017.
 */

public class Event1 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event1);
        //ActionBar actionBar = getSupportActionBar();
        //actionBar.setHomeButtonEnabled(true);
        //actionBar.setDisplayHomeAsUpEnabled(true);
        //setTitle("Event-1");
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Operating-System");

        getSupportActionBar().setDisplayShowTitleEnabled(true);
        toolbar.setTitleTextColor(Color.parseColor("#ffffff"));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        ListView lvItems = (ListView) findViewById(R.id.l1);
        ExpandableAdapter adapter = getAdapter();

        lvItems.setAdapter(adapter);
        lvItems.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ExpandableAdapter adapter = (ExpandableAdapter) parent.getAdapter();
                view.setBackgroundColor(Color.parseColor("#ffffff"));
                Item item = (Item) adapter.getItem(position);
                if (item != null) {
                    item.isExpanded = !item.isExpanded;
                }

                adapter.notifyDataSetChanged();
            }
        });
    }

    private ExpandableAdapter getAdapter() {

        List<Item> items = new ArrayList<>();

        for (int i = 0; i < 4; i++) {


            if (i == 0) {
                Item item = new Item();
                item.title="Android";
                item.description = "\n" +
                        "Android powers hundreds of millions of mobile devices in more than 190 countries around the world\n"+
                        "Android gives you a world-class platform for creating apps and games for Android users everywhere, as well as an open marketplace for distributing to them instantly\n"+
                        "Building on the contributions of the open-source Linux community and more than 300 hardware, software, and carrier partners, Android has rapidly become the fastest-growing mobile OS";

                item.isExpanded = false;
                items.add(item);
            }
            if (i ==1 ) {
                Item item = new Item();
                item.title="IOS";
                item.description = "Apple iOS is based on the Mac OS X operating system for desktop and laptop computers\n"+
                    "The iOS developer kit provides tools that allow for iOS app development\n"+
                    "Designed for use with Apple's multitouch devices, the mobile OS supports input through direct manipulation\n"+
                    "The system responds to various user gestures, such as pinching, tapping and swiping";
                item.isExpanded = false;
                items.add(item);
            }

            if (i ==2 ) {
                Item item = new Item();
                item.title="Windows";
                item.description = "Windows is Microsoft’s flagship operating system, the de facto standard for home and business computers.\nThe GUI-based OS was introduced in1985 and has been released in many versions\n"+
                                    "Microsoft became famous with the release of MS DOS, a text-based command line-driven operating system";
                item.isExpanded = false;
                items.add(item);
            }

        }


        return new ExpandableAdapter(this, items);


    }


    public boolean onOptionsItemSelected(MenuItem item)
    {
        finish();
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);

    }

}