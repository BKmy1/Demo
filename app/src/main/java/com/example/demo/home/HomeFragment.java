package com.example.demo.home;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.demo.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeFragment extends Fragment {
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);
        BottomNavigationView bnv =view.findViewById(R.id.nav_bottom);
//        bnv.setElevation(0f);     设置底部导航图不遮挡内容
        bnv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                NavController navController = Navigation.findNavController(getActivity(),R.id.nav_host_fragment2);
                if (id == R.id.test1){
                    navController.navigate(R.id.navigation_viewpager);
                }
                if(id == R.id.test2){
                    navController.navigate(R.id.navigation_living);
                }
                if(id == R.id.test3){
                    navController.navigate(R.id.navigation_classify);
                }
                if(id == R.id.test4){
                    navController.navigate(R.id.navigation_comment);
                }
                if(id == R.id.test5){
                    navController.navigate(R.id.navigation_person);
                }
                return true;
            }
        });
        return view;
    }
}