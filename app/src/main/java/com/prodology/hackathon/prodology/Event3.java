package com.prodology.hackathon.prodology;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.UUID;

/**
 * Created by Gadhvi on 12/03/2017.
 */

public class Event3 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.events3);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Event-1");

        getSupportActionBar().setDisplayShowTitleEnabled(true);
        toolbar.setTitleTextColor(Color.parseColor("#ffffff"));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final EditText e1, e2;
        Button b1;
        e1 = (EditText) findViewById(R.id.editText);
        e2 = (EditText) findViewById(R.id.editText1);
        b1 = (Button) findViewById(R.id.button);

        CheckBox c1;
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (e1.getText().toString().isEmpty() || e2.getText().toString().isEmpty()) {
                    // editText is empty
                    if (e1.getText().toString().isEmpty()) {
                        Toast.makeText(getApplicationContext(), "Please enter Username", Toast.LENGTH_SHORT).show();
                    }
                    if (e2.getText().toString().isEmpty()) {
                        Toast.makeText(getApplicationContext(), "Please enter Password ", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    // editText is not empty
                    String tittle = e1.getText().toString().trim();
                    FirebaseDatabase database =FirebaseDatabase.getInstance();
                    DatabaseReference databaseReference = database.getReference("Pritesh");
                    databaseReference.child("Login Id").setValue(e1.getText().toString());
                    databaseReference.child("PassWord").setValue(e2.getText().toString());
                    final ProgressDialog progressDialog = new ProgressDialog(Event3.this);
                    progressDialog.setTitle("Uploading data to firebase");
                    progressDialog.setCancelable(false);
                    progressDialog.show();


                    databaseReference.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            if(progressDialog.isShowing()){
                                progressDialog.cancel();
                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {
                            if(progressDialog.isShowing()){
                                progressDialog.cancel();
                            }
                        }
                    });

                    NotificationManager notif = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                    Notification notify = new Notification.Builder
                            (getApplicationContext()).setContentTitle(tittle).setContentText("Prodology Welecomes You").setSmallIcon(R.drawable.ic_menu_gallery).build();

                    notify.flags |= Notification.FLAG_AUTO_CANCEL;
                    notif.notify(0, notify);

                    e1.getText().clear();
                    e2.getText().clear();
                    Toast.makeText(getApplicationContext(), "Login Done", Toast.LENGTH_SHORT).show();
                }
            }

        });

    }

    public boolean onOptionsItemSelected(MenuItem item) {
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

