package com.example.ero.week3homework1.Users;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.ero.week3homework1.Adapters.PhoneAdapter;
import com.example.ero.week3homework1.Adapters.UserAdapter;
import com.example.ero.week3homework1.Fragment.ChatFragment;
import com.example.ero.week3homework1.Fragment.InfoUserFragment;
import com.example.ero.week3homework1.R;

public class ChatActivity extends AppCompatActivity {

    public static final String INFO = "info";
    public static final String MESSENGER = "messenger";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        if(getIntent().getExtras().get(PhoneAdapter.CHECK).equals("phone")){
            final int position = getIntent().getIntExtra(PhoneAdapter.KEY1, 0);
            InfoUserFragment infoFragment = new InfoUserFragment();
            Bundle bundle = new Bundle();
            bundle.putInt(INFO, position);
            infoFragment.setArguments(bundle);
            getSupportFragmentManager().beginTransaction().replace(R.id.chat_conteiner, infoFragment).commit();

        }else if (getIntent().getExtras().get(UserAdapter.CHECK).equals("user")) {

            final int position = getIntent().getIntExtra(UserAdapter.KEY, 0);
            ChatFragment chatFragment = new ChatFragment();
            Bundle bundle = new Bundle();
            bundle.putInt(MESSENGER, position);
            chatFragment.setArguments(bundle);
            getSupportFragmentManager().beginTransaction().replace(R.id.chat_conteiner, chatFragment).commit();
        }
    }
}
