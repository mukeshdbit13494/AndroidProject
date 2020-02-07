package com.example.goalnotifier;

import android.os.Bundle;
import android.view.Window;

import com.google.android.material.tabs.TabLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

public class UserDataActivity extends AppCompatActivity {
    //private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_data);


        //toolbar=(Toolbar)findViewById(R.id.tb_user_data);
        tabLayout=(TabLayout)findViewById(R.id.tl_user_data);
        viewPager=(ViewPager)findViewById(R.id.vp_user_data);

        //setSupportActionBar(toolbar);
        setViewPager(viewPager);

        tabLayout.setupWithViewPager(viewPager);
    }

    public void setViewPager(ViewPager viewPager){
       ViewPageAdapter viewPageAdapter=new ViewPageAdapter(getSupportFragmentManager());
       viewPageAdapter.addFragment(new PersonalFragment(),"Personal");
       viewPageAdapter.addFragment(new EducationFragment(),"Educational");
       viewPager.setAdapter(viewPageAdapter);
    }
}
