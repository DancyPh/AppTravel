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
import com.example.travelhotel.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HotelSignupFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HotelSignupFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private EditText edtusernamesignup_hotel, edtpasswordsignup_hotel, edtconfirmsignup_hotel;
    private Button btnsignup_hotel;
    private View view;

    public HotelSignupFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HotelSignupFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HotelSignupFragment newInstance(String param1, String param2) {
        HotelSignupFragment fragment = new HotelSignupFragment();
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
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_hotel_signup, container, false);

        edtusernamesignup_hotel = view.findViewById(R.id.edtUsernameSignup_hotel);
        edtpasswordsignup_hotel = view.findViewById(R.id.edtPasswordSignup_hotel);
        edtconfirmsignup_hotel = view.findViewById(R.id.edtConfirmSignup_hotel);
        btnsignup_hotel = view.findViewById(R.id.btnSignup_hotel);

        btnsignup_hotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = edtusernamesignup_hotel.getText().toString();
                String pass = edtpasswordsignup_hotel.getText().toString();
                String confirm = edtconfirmsignup_hotel.getText().toString();

                if (user.isEmpty() || pass.isEmpty() || confirm.isEmpty()){
                    Toast.makeText(getActivity(), "Not null", Toast.LENGTH_SHORT).show();
                } else if (!user.equals(confirm)) {
                    Toast.makeText(getActivity(), "Password and Confirm password not equals", Toast.LENGTH_SHORT).show();
                } else {
                    DBHelper dbHelper = new DBHelper(getActivity());
                    if (dbHelper.checkInserHotel(user, pass)){
                        Intent intent = new Intent(getActivity(), HotelLogin.class);
                        startActivity(intent);
                    }else {
                        Toast.makeText(getActivity(), "Fail", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


        return view;
    }
}