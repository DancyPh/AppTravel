package com.example.travelhotel.Hotel;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.travelhotel.DB.DBHelper;
import com.example.travelhotel.DB.Hotels;
import com.example.travelhotel.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HotelLoginFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HotelLoginFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private EditText edtusernamelogin_hotel, edtpasswordlogin_hotel;
    private Button btnlogin_hotel;

    public ArrayList<Hotels> hotelInforList;
    public HotelLoginFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HotelLoginFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HotelLoginFragment newInstance(String param1, String param2) {
        HotelLoginFragment fragment = new HotelLoginFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_hotel_login, container, false);

        hotelInforList = new ArrayList<>();

        edtusernamelogin_hotel = view.findViewById(R.id.edtUsernameLogin_hotel);
        edtpasswordlogin_hotel = view.findViewById(R.id.edtPasswordLogin_hotel);
        btnlogin_hotel = view.findViewById(R.id.btnLogin_hotel);

        btnlogin_hotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = edtusernamelogin_hotel.getText().toString();
                String pass = edtpasswordlogin_hotel.getText().toString();

                DBHelper dbHelper = new DBHelper(getActivity());
                if (user.isEmpty() || pass.isEmpty()){
                    Toast.makeText(getActivity(), "not null", Toast.LENGTH_SHORT).show();
                } else if (dbHelper.checkLoginHotel(user,pass)){
                    Hotels hotel = dbHelper.getHotelById(user, pass);
                    if (hotel != null) hotelInforList.add(hotel); // kiểm tra có thông tin khách sạn hay không

                    // chuyển hướng sang
                    Intent intent = new Intent(getActivity(), HotelHome.class);
                    intent.putExtra("hotelInfor", hotel); // lưu thông tin của khachs sạn
                    startActivity(intent);
                }
            }
        });

        return view;
    }
}