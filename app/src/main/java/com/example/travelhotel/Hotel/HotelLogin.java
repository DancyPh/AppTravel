package com.example.travelhotel.Hotel;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.travelhotel.Adapter.HotelLoginAdapter;
import com.example.travelhotel.R;
import com.google.android.material.tabs.TabLayout;

public class HotelLogin extends AppCompatActivity {

    private TabLayout tablelayout_hotel;
    private ViewPager viewpager_hotel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_login);

        // set tablelayout and viewpager
        tablelayout_hotel = findViewById(R.id.tabLayout_hotel);
        viewpager_hotel = findViewById(R.id.viewPager_hotel);

        HotelLoginAdapter hotelLoginAdapter = new HotelLoginAdapter(getSupportFragmentManager(),
                FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);

        viewpager_hotel.setAdapter(hotelLoginAdapter);
        tablelayout_hotel.setupWithViewPager(viewpager_hotel);
    }
}