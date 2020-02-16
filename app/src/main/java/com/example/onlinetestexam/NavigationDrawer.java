package com.example.onlinetestexam;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class NavigationDrawer extends AppCompatActivity {

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;
    Toolbar toolbar;
    ActionBar actionBar;
    NavigationView navigationView;
    FirebaseAuth mAuth;



    DatabaseReference reference;
    List<DataModel> dataModels;
    RecycleViewAdapter adapter;
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer);

        navigationView=findViewById(R.id.NavigationDrawerId);
        mAuth=FirebaseAuth.getInstance();

        //Toolbar setup
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        actionBar=getSupportActionBar();
        actionBar.setTitle("Departments");
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);
        drawerLayout=findViewById(R.id.naviDrawerId);
        toggle=new ActionBarDrawerToggle(this,drawerLayout,R.string.nav_open,R.string.nav_close);
        toggle.syncState();




        reference= FirebaseDatabase.getInstance().getReference("DATA");
        dataModels = new ArrayList<>();


        recyclerView=findViewById(R.id.RecycleViewId);
        adapter = new RecycleViewAdapter(this, dataModels);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);



        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {


                switch (menuItem.getItemId())
                {
                    case R.id.navi_Gallary:
                        Intent intent = new Intent();
                        intent.setType("image/*");
                        intent.setAction(Intent.ACTION_GET_CONTENT);
                        startActivityForResult(Intent.createChooser(intent, "Select Picture"),0);
                        drawerLayout.closeDrawers();
                        return  true;
                    case R.id.navi_signout:
                        FirebaseAuth.getInstance().signOut();
                        finish();
                        Intent signout=new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(signout);


                }





                return false;



            }
        });



        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                try {
                    for (DataSnapshot ds : dataSnapshot.getChildren()) {
                        DataModel model = ds.getValue(DataModel.class);
                        dataModels.add(model);
                        adapter.notifyDataSetChanged();
                    }
                }

                catch (Exception e){
                    Toast.makeText(NavigationDrawer.this, "Could not parse the data properly", Toast.LENGTH_LONG).show();


                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });




    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;

        }

        return super.onOptionsItemSelected(item);
    }


}
