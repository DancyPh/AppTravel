package com.example.travelhotel.Hotel;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.travelhotel.Adapter.HotelManagermentAdapter;
import com.example.travelhotel.R;
import com.google.android.material.tabs.TabLayout;

public class HotelHome extends AppCompatActivity {

    TabLayout tablayout_hotel_home;
    ViewPager viewpager_hotel_home;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_home);

        tablayout_hotel_home = findViewById(R.id.tabLayout_hotel_home);
        viewpager_hotel_home = findViewById(R.id.viewPager_hotel_home);

        HotelManagermentAdapter hotelManagermentAdapter = new HotelManagermentAdapter(getSupportFragmentManager(),
                FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);

        viewpager_hotel_home.setAdapter(hotelManagermentAdapter);
        tablayout_hotel_home.setupWithViewPager(viewpager_hotel_home);
    }
}