package com.example.fooding;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.fooding.fragment.BabyFragment;
import com.example.fooding.fragment.EatingFragment;
import com.example.fooding.fragment.TableFragment;
import com.google.android.material.tabs.TabLayout;

import org.litepal.LitePal;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager main_content;
    TabLayout tabLayout;

    List<Fragment> fragmentList = new ArrayList<>();
    List<String> fragmentTitle = new ArrayList<>();
    EatingFragment eatingFragment=new EatingFragment();
    TableFragment tableFragment =new TableFragment();
    BabyFragment babyFragment = new BabyFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar!=null){
            actionBar.hide();
        }

        main_content = findViewById(R.id.main_content);
        tabLayout = findViewById(R.id.bottom_tabs_1);

        fragmentList.clear();
        fragmentTitle.clear();
        fragmentTitle.add("食堂");
        //fragmentTitle.add("餐桌");
        fragmentTitle.add("发现");
        fragmentList.add(eatingFragment);
       // fragmentList.add(tableFragment);
        fragmentList.add(babyFragment);

        main_content.setAdapter(new ViewPagerAdapter(getSupportFragmentManager(),
                ViewPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT));
        tabLayout.setupWithViewPager(main_content);
      //  main_content.setOffscreenPageLimit(3);
      //main_content.setCurrentItem(1);//设置初始位置

        TabLayout.Tab tab_restaurant = tabLayout.getTabAt(0);
        TabLayout.Tab tab_find = tabLayout.getTabAt(1);
      //  TabLayout.Tab tab_self = tabLayout.getTabAt(2);
        tab_restaurant.setIcon(getResources().getDrawable(R.drawable.table));
        tab_find.setIcon(getResources().getDrawable(R.drawable.find));
      //  tab_self.setIcon(getResources().getDrawable(R.drawable.ic_baseline_face_24));


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });

    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        public ViewPagerAdapter(FragmentManager fm, int behavior) {
            super(fm, behavior);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return fragmentTitle.get(position);
        }
    }


}