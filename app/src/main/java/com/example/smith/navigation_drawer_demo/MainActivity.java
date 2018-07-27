package com.example.smith.navigation_drawer_demo;

import android.content.ClipData;
import android.drm.DrmStore;
import android.graphics.Rect;
import android.support.design.widget.NavigationView;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;


    private final String actionName[] = {
            "Home",
            "My Profile",
            "Events",
            "Favorites",
            "Inbox",
            "Contact Us",
            "Feed Back",
            "Settings",
            "My Schools",
            "Add a school",
            "How to use Application"


    };

    private final Integer iconRsId[] = {
            R.drawable.home,
            R.drawable.profile,
            R.drawable.event,
            R.drawable.favorites,
            R.drawable.inbox,
            R.drawable.contactus,
            R.drawable.feedback,
            R.drawable.settings,
            R.drawable.myschoools,
            R.drawable.addschool,
            R.drawable.howtouse


    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_drawer);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);


        ActionBarDrawerToggle toggle;
        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_drawer, R.string.close_drawer);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        initRycler();

    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);

        } else {
            super.onBackPressed();
        }
    }

    private void initRycler(){
        RecyclerView recyclerView = findViewById(R.id.drawer_itemset_1);
        ArrayList<ItemData> itemData = praperData(1);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(itemData,getApplicationContext(),1);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        RecyclerView recyclerView2 = findViewById(R.id.drawer_itemset_2);
        ArrayList<ItemData> itemData2 = praperData(2);
        RecyclerViewAdapter adapter2 = new RecyclerViewAdapter(itemData2,getApplicationContext(),1);
        recyclerView2.setAdapter(adapter2);
        recyclerView2.setLayoutManager(new LinearLayoutManager(this));


        RecyclerView recyclerView3 = findViewById(R.id.drawer_itemset_3);
        ArrayList<ItemData> itemData3 = praperData(3);
        RecyclerViewAdapter adapter3 = new RecyclerViewAdapter(itemData3,getApplicationContext(),2);
        recyclerView3.setAdapter(adapter3);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView3.setLayoutManager(linearLayoutManager);

    }

    private ArrayList<ItemData> praperData(int type) {


        ArrayList<ItemData> itemDataArrayList = new ArrayList<>();


        if(type == 1){

            for (int i = 0; i < 5; i++) {
                ItemData itemdata = new ItemData();
                itemdata.setActionName(actionName[i]);
                itemdata.setIconRsId(iconRsId[i]);
                itemDataArrayList.add(itemdata);
            }
        }else if(type == 2){

            for (int i = 5; i < 8; i++) {
                ItemData itemdata = new ItemData();
                itemdata.setActionName(actionName[i]);
                itemdata.setIconRsId(iconRsId[i]);
                itemDataArrayList.add(itemdata);
            }

        }else{


            for (int i = 8; i < actionName.length; i++) {
                ItemData itemdata = new ItemData();
                itemdata.setActionName(actionName[i]);
                itemdata.setIconRsId(iconRsId[i]);
                itemDataArrayList.add(itemdata);
            }


        }

        return itemDataArrayList;

    }

    public void imgbtnClicked(View view) {

        Toast.makeText(this, "Img Btn", Toast.LENGTH_SHORT).show();
    }

}
