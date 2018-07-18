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

import com.example.ero.week3homework1.Modeles.UserModel;
import com.example.ero.week3homework1.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class MailAdapter extends RecyclerView.Adapter<MailAdapter.MailViewHolder> {

    private Context context;
    private List<UserModel> userList;

    public MailAdapter(Context context, List<UserModel> userList) {
        this.context = context;
        this.userList = userList;
    }

    @Override
    public MailAdapter.MailViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View view = inflater.inflate(R.layout.mail_item, parent, false);
        return new MailViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MailAdapter.MailViewHolder holder, int position) {
        final UserModel user = userList.get(position);
        holder.userMail.setText(user.getNameSurname());
        Picasso.get().load(user.getImage()).into(holder.image);
        holder.mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:" + user.getEmail()));
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class MailViewHolder extends RecyclerView.ViewHolder {
        private final TextView userMail;
        private final CircleImageView image;
        private final ImageButton mail;

        public MailViewHolder(View itemView) {
            super(itemView);
            userMail = itemView.findViewById(R.id.mail_user_name);
            image = itemView.findViewById(R.id.mail_user_image);
            mail = itemView.findViewById(R.id.mail_id);
        }
    }
}
