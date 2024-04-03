package com.example.travelhotel.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.travelhotel.Hotel.HotelBookings;
import com.example.travelhotel.Hotel.HotelManagerment;

public class HotelManagermentAdapter extends FragmentPagerAdapter {

    public HotelManagermentAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new HotelBookings();
            case 1:
                return new HotelManagerment();
            default:
                return new HotelBookings();
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @NonNull
    @Override
    public CharSequence getPageTitle(int position) {
        String title = "";
        switch (position){
            case 0:
                title = "Booking";
                break;
            case 1:
                title = "Managerment";
                break;
        }
        return title;
    }

}
