package com.example.ero.week3homework1.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ero.week3homework1.Users.ChatActivity;
import com.example.ero.week3homework1.Modeles.UserModel;
import com.example.ero.week3homework1.R;
import com.example.ero.week3homework1.UserDataProvider;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * A simple {@link Fragment} subclass.
 */
public class InfoUserFragment extends Fragment {

    public InfoUserFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_info_user, container, false);
        if (getArguments() != null) {
            final int userPosition = getArguments().getInt(ChatActivity.INFO);
            final UserModel user = UserDataProvider.getUserListPosition(userPosition);
            final CircleImageView infoImage = view.findViewById(R.id.info_image);
            final TextView infoName = view.findViewById(R.id.info_name);
            final TextView infoAge = view.findViewById(R.id.info_age);

            infoName.setText(user.getNameSurname());
            infoAge.setText(user.getAge());
            Picasso.get().load(user.getImage()).into(infoImage);
        }
        return view;
    }
}
