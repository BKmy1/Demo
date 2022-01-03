package com.example.demo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.demo.top.Top1Fragment;
import com.example.demo.top.Top2Fragment;
import com.example.demo.top.Top3Fragment;
import com.example.demo.top.Top4Fragment;
import com.example.demo.top.Top5Fragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;


public class viewPageFragment extends Fragment {
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private List<String> titles;
    private List<Fragment> fragments;
    public static viewPageFragment  newInstance() {
        return new viewPageFragment ();
    }
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // TODO: Use the ViewModel

        View view=inflater.inflate(R.layout.fragment_view_page, container, false);
        tabLayout = (TabLayout) view.findViewById(R.id.tabs2);
        viewPager = (ViewPager) view.findViewById(R.id.viewpage);
        //Fragment
        fragments = new ArrayList<>();
        Top1Fragment top1Fragment = new Top1Fragment();
        fragments.add(top1Fragment);
        Top2Fragment top2Fragment=new  Top2Fragment ();
        fragments.add(top2Fragment);
        Top3Fragment top3Fragment=new  Top3Fragment();
        fragments.add(top3Fragment);
        Top4Fragment top4Fragment=new  Top4Fragment();
        fragments.add(top4Fragment);
        Top5Fragment top5Fragment=new Top5Fragment();
        fragments.add(top5Fragment);
        //Titles
        titles = new ArrayList<>();
        titles.add("推荐");
        titles.add("电脑");
        titles.add("食物");
        titles.add("水果");
        titles.add("手机");
        //
        FragmentViewPagerAdapter adapter = new FragmentViewPagerAdapter(getChildFragmentManager(), fragments, titles);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        return  view;
    }

    public static class FragmentViewPagerAdapter extends FragmentPagerAdapter
    {

        private List<Fragment> fragments;
        private List<String> titles;

        public FragmentViewPagerAdapter(FragmentManager manager, List<Fragment> fragments, List<String> titles) {
            super(manager);
            this.fragments = fragments;
            this.titles = titles;
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles.get(position);
        }
    }

}


