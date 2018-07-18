package com.example.ero.week3homework1.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.ero.week3homework1.Adapters.MessengeAdapter;
import com.example.ero.week3homework1.Users.ChatActivity;
import com.example.ero.week3homework1.Modeles.MessengeModel;
import com.example.ero.week3homework1.Modeles.UserModel;
import com.example.ero.week3homework1.R;
import com.example.ero.week3homework1.UserDataProvider;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ChatFragment extends Fragment {

    public ChatFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chat, container, false);
        if (getArguments() != null) {
            final int userPosition = getArguments().getInt(ChatActivity.MESSENGER);
            final UserModel user = UserDataProvider.getUserListPosition(userPosition);
            TextView userName = view.findViewById(R.id.chat_user_name);
            userName.setText(user.getNameSurname());
            CircleImageView userImage = view.findViewById(R.id.chat_image);
            Picasso.get().load(user.getImage()).into(userImage);
            initializeMessagesList(view, user);
        }

        return view;
    }

    private void initializeMessagesList(View view, UserModel user) {

        final RecyclerView messengeList = view.findViewById(R.id.chat_list);
        messengeList.setHasFixedSize(true);

        final LinearLayoutManager meneger = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        messengeList.setLayoutManager(meneger);
        final List<MessengeModel> messengs = user.getMessege();
        final MessengeAdapter adapter = new MessengeAdapter(getContext(), messengs, user.getImage());
        messengeList.setAdapter(adapter);

        final EditText editText = view.findViewById(R.id.editText);
        final ImageButton send = view.findViewById(R.id.send);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                messengs.add(new MessengeModel(editText.getText().toString(), true));
                messengs.add(new MessengeModel("Barevv", false));
                editText.setText("");
                adapter.notifyDataSetChanged();
                messengeList.scrollToPosition(messengs.size() - 1);
            }
        });
    }
}
