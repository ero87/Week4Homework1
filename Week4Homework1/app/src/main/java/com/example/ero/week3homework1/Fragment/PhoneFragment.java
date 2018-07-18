package com.example.ero.week3homework1.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ero.week3homework1.Adapters.PhoneAdapter;
import com.example.ero.week3homework1.R;
import com.example.ero.week3homework1.UserDataProvider;

/**
 * A simple {@link Fragment} subclass.
 */
public class PhoneFragment extends Fragment {

    public PhoneFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_phone, container, false);
        final RecyclerView userList = view.findViewById(R.id.phone_list);
        userList.setHasFixedSize(true);
        userList.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        final PhoneAdapter adapter = new PhoneAdapter(getContext(), UserDataProvider.getUserList());
        userList.setAdapter(adapter);
        return view;
    }
}
