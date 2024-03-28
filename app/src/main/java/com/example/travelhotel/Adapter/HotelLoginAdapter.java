package com.example.travelhotel.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.travelhotel.Hotel.HotelLoginFragment;
import com.example.travelhotel.Hotel.HotelSignupFragment;

public class HotelLoginAdapter extends FragmentStatePagerAdapter {
    public HotelLoginAdapter(FragmentManager fm, int behavior){
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int positon){
        switch (positon){
            case 0:
                return new HotelLoginFragment();
            case 1:
                return new HotelSignupFragment();
            default:
                return new HotelLoginFragment();
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
                title = "Login";
                break;
            case 1:
                title = "Signup";
                break;
        }
        return title;
    }
}
