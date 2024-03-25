package com.example.travelhotel;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.travelhotel.Customer.CustomerLogin;
import com.example.travelhotel.Hotel.HotelLogin;

public class MainActivity extends AppCompatActivity {

    Button btnlogincustomer, btnloginhotel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnlogincustomer = findViewById(R.id.btnLoginCustomer_Main);
        btnloginhotel = findViewById(R.id.btnLoginHotel_Main);

        btnlogincustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentCustomer = new Intent(MainActivity.this, CustomerLogin.class);
                startActivity(intentCustomer);
            }
        });

        btnloginhotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentHotel = new Intent(MainActivity.this, HotelLogin.class);
                startActivity(intentHotel);
            }
        });
    }
}