package com.example.travelhotel.Customer;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.travelhotel.Adapter.LoginAdapter;
import com.example.travelhotel.R;
import com.google.android.material.tabs.TabLayout;

public class CustomerLogin extends AppCompatActivity {

    private TabLayout tablayout;
    private ViewPager viewpager;

    EditText txtusernamelogin_customer, usernamepassword_customer;
    Button btnlogin_customer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_login);

        // anh xa



        // set layout login signup
        tablayout = findViewById(R.id.tabLayout);
        viewpager = findViewById(R.id.viewPager);

        LoginAdapter loginadapter = new LoginAdapter(getSupportFragmentManager(),
                FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewpager.setAdapter(loginadapter);

        tablayout.setupWithViewPager(viewpager);



    }
}