package com.example.travelhotel.Customer;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.travelhotel.Adapter.ItemsAdapter;
import com.example.travelhotel.Domain.ItemsDomain;
import com.example.travelhotel.R;

import java.util.ArrayList;

public class HomeTabFragment extends Fragment {
    private RecyclerView.Adapter adapterPopular, adapterNew;
    private RecyclerView recyclerViewPopular, recyclerViewNew;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home_customer, container, false);

        // Khởi tạo RecyclerView và Adapter
        recyclerViewPopular = view.findViewById(R.id.viewPopular);
        recyclerViewNew = view.findViewById(R.id.viewNew);

        recyclerViewPopular.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        recyclerViewNew.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));

        adapterNew = new ItemsAdapter(getItemsList());
        adapterPopular = new ItemsAdapter(getItemsList());

        recyclerViewNew.setAdapter(adapterNew);
        recyclerViewPopular.setAdapter(adapterPopular);

        return view;
    }

    private ArrayList<ItemsDomain> getItemsList() {
        ArrayList<ItemsDomain> itemsArrayList = new ArrayList<>();

        itemsArrayList.add(new ItemsDomain("Hotel with a great view", "Đà Lạt", "Description", 2, 1, 2500000, "pic1", true));
        itemsArrayList.add(new ItemsDomain("Hotel with a great view", "Vũng Tàu", "Description", 3, 1, 1500000, "pic2", false));
        itemsArrayList.add(new ItemsDomain("Hotel with a great view", "Bình Thuận", "Description", 3, 1, 1500000, "pic_new_1", false));

        return itemsArrayList;
    }
}
