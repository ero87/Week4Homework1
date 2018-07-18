package com.example.ero.week3homework1.Adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.ero.week3homework1.Users.ChatActivity;
import com.example.ero.week3homework1.Modeles.UserModel;
import com.example.ero.week3homework1.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class PhoneAdapter extends RecyclerView.Adapter<PhoneAdapter.PhoneViewHolder> {

    private Context context;
    private List<UserModel> userList;
    public static final String KEY1 = "key1";
    public static final String CHECK = "check";

    public PhoneAdapter(Context context, List<UserModel> userList) {
        this.context = context;
        this.userList = userList;
    }

    @Override
    public PhoneViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View view = inflater.inflate(R.layout.phone_item, parent, false);
        return new PhoneViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PhoneViewHolder holder, final int position) {
        final UserModel user = userList.get(position);
        holder.userPhone.setText(user.getNameSurname());
        Picasso.get().load(user.getImage()).into(holder.userImage);
        holder.call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + user.getPhone()));
                context.startActivity(intent);
            }
        });

        holder.userImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ChatActivity.class);
                intent.putExtra(KEY1, position);
                intent.putExtra(CHECK, "phone");
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class PhoneViewHolder extends RecyclerView.ViewHolder {
        private final TextView userPhone;
        private final CircleImageView userImage;
        private final ImageButton call;

        public PhoneViewHolder(View itemView) {
            super(itemView);
            userPhone = itemView.findViewById(R.id.phone_user_name);
            userImage = itemView.findViewById(R.id.image_user_phoe);
            call = itemView.findViewById(R.id.call_id);

        }
    }
}
