package com.example.travelhotel.Customer;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
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
 * Use the {@link SignupFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SignupFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private EditText edtusernamesignup_customer, edtpasswordsignup_customer, edtconfirmsignup_customer;
    private Button btnsignup_customer;
    public SignupFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SignupFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SignupFragment newInstance(String param1, String param2) {
        SignupFragment fragment = new SignupFragment();
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
        View view = inflater.inflate(R.layout.fragment_signup_customer, container, false);

        // anh xa
        edtusernamesignup_customer = view.findViewById(R.id.edtUsernameSignup_customer);
        edtpasswordsignup_customer = view.findViewById(R.id.edtPasswordSignup_customer);
        edtconfirmsignup_customer = view.findViewById(R.id.edtConfirmSignup_customer);
        btnsignup_customer = view.findViewById(R.id.btnSignup_customer);

        btnsignup_customer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = edtusernamesignup_customer.getText().toString();
                String pass = edtpasswordsignup_customer.getText().toString();
                String confirm = edtconfirmsignup_customer.getText().toString();

                if (TextUtils.isEmpty(user) || TextUtils.isEmpty(pass) || TextUtils.isEmpty(confirm)) {
                    Toast.makeText(getActivity(), "Please fill in all fields", Toast.LENGTH_SHORT).show();
                } else if (!pass.equals(confirm)) {
                    Toast.makeText(getActivity(), "Passwords do not match", Toast.LENGTH_SHORT).show();
                } else {
                    DBHelper dbHelper = new DBHelper(getActivity());
                    if (dbHelper.checkInserCustomer(user, pass)){
                        Intent intent = new Intent(getActivity(), CustomerLogin.class);
                        startActivity(intent);
                    }else {
                        Toast.makeText(getActivity(), "Fail", Toast.LENGTH_SHORT).show();
                    }

                }

            }
        });
        return  view;
    }


}