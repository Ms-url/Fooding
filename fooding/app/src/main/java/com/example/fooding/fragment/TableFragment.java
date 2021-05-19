package com.example.fooding.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fooding.R;
import com.example.fooding.fragment.eatingsecond.LocationFragment;
import com.example.fooding.fragment.eatingsecond.RestaurantFragment;
import com.example.fooding.fragment.tablesecond.EatPlanFragment;
import com.example.fooding.fragment.tablesecond.FoodMenuFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class TableFragment extends Fragment {
    View view;
    private ViewPager table_view_pager;
    private TabLayout tabLayout;
    List<Fragment> fragmentList = new ArrayList<>();
    List<String> fragmentTitle = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view =inflater.inflate(R.layout.fragment_table, container, false);
        table_view_pager = view.findViewById(R.id.my_table_view_pager);
        tabLayout = view.findViewById(R.id.tab_table);

        fragmentList.clear();
        fragmentTitle.clear();
        fragmentTitle.add("食堂菜单");
        fragmentTitle.add("选择方案");
        fragmentList.add(new FoodMenuFragment());
        fragmentList.add(new EatPlanFragment());
        table_view_pager.setAdapter(new ViewPagerAdapter(getChildFragmentManager(),
               ViewPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT));
        tabLayout.setupWithViewPager(table_view_pager);
        table_view_pager.setOffscreenPageLimit(2);

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

        return view;
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