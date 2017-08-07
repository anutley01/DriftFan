package com.example.aids.a09application;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    ActionBarDrawerToggle actionBarDrawerToggle;
    FragmentTransaction fragmentTransaction;
    NavigationView navigationView;
    Intent intent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close);

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.main_container, new HomeFragment());
        fragmentTransaction.commit();
        getSupportActionBar().setTitle("Drift Fan");
        navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.Home:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.main_container, new HomeFragment());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("Home Fragment");
                        item.setCheckable(true);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.my_account:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.main_container, new myAccountFragment());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("My Account");
                        item.setCheckable(true);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.nav_about:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.main_container, new AboutDriftingFragment());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("About Drifting");
                        item.setCheckable(true);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.nav_shop:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.main_container, new ShopFragment());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("Shop");
                        item.setCheckable(true);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.nav_news:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.main_container, new NewsFragment());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("News");
                        item.setCheckable(true);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.nav_media:
                        intent = new Intent(MainActivity.this, media_main.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        MainActivity.this.startActivity(intent);
                        break;
                }


                return false;
            }

        });

    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.drawer_menu, menu);
        return true;



    }
}





