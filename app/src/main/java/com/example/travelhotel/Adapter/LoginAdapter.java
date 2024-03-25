package com.example.travelhotel.Adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.travelhotel.LoginFragment;
import com.example.travelhotel.SignupFragment;

public class LoginAdapter extends FragmentStatePagerAdapter {

    public LoginAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new LoginFragment();
            case 1:
                return new SignupFragment();
            default:
                return new LoginFragment();
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
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
