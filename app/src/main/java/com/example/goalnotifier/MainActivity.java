package com.example.goalnotifier;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.akshay.library.CurveBottomBar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    FrameLayout main_fragment;
    int MAIN_FRAGMENT=R.id.main_fragment;
    FloatingActionButton btn_add;
    CurveBottomBar bottomItem;
    NavigationView sideNavbar;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle myDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment, new AddFragment()).commit();
            main_fragment = (FrameLayout) findViewById(R.id.main_fragment);
            btn_add = (FloatingActionButton) findViewById(R.id.bottom_add);
            bottomItem = (CurveBottomBar) findViewById(R.id.cbb);

            drawerLayout = (DrawerLayout) findViewById(R.id.drawableLayout);
            sideNavbar = (NavigationView) findViewById(R.id.side_navigation);
            myDrawable = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);
            drawerLayout.addDrawerListener(myDrawable);
            myDrawable.syncState();
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);


            btn_add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getSupportFragmentManager().beginTransaction().replace(MAIN_FRAGMENT, new AddFragment()).commit();
                }
            });

            bottomItem.setOnNavigationItemSelectedListener(itemSelection);
        }
    CurveBottomBar.OnNavigationItemSelectedListener itemSelection=new CurveBottomBar.OnNavigationItemSelectedListener(){
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment=null;
           switch (item.getItemId())
           {
               case R.id.bottom_home:
                   selectedFragment=new HomeFragment();
                   break;
               case R.id.bottom_add:
                   selectedFragment=new AddFragment();
                   break;
               case R.id.bottom_profile:
                   selectedFragment=new ProfileFragment();
                   break;
               case R.id.bottom_notification:
                   selectedFragment=new NotificationFragment();
                   break;
               case R.id.bottom_setting:
                   selectedFragment=new SettingFragment();
                   break;
               default:
                   selectedFragment=new HomeFragment();
                   break;
           }
           getSupportFragmentManager().beginTransaction().replace(MAIN_FRAGMENT,selectedFragment).commit();
           return true;
        }
    };
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(myDrawable.onOptionsItemSelected(item))
        {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
