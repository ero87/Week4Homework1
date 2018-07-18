package com.example.ero.week3homework1.Adapters;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ero.week3homework1.Users.ChatActivity;
import com.example.ero.week3homework1.Fragment.InfoUserFragment;
import com.example.ero.week3homework1.Modeles.MessengeModel;
import com.example.ero.week3homework1.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class MessengeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final Context context;
    private final List<MessengeModel> messenges;
    private final String userImageUrl;

    public MessengeAdapter(Context context, List<MessengeModel> messenges, String userImageUrl) {
        this.context = context;
        this.messenges = messenges;
        this.userImageUrl = userImageUrl;
    }

    @Override
    public int getItemViewType(int position) {
        final MessengeModel messenge = messenges.get(position);
        if (messenge.isMine()) {
            return 0;
        }
        return 1;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        final LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view;
        if (0 == viewType) {
            view = inflater.inflate(R.layout.send_messenge, parent, false);
            return new SendViewHolder(view);
        }
        view = inflater.inflate(R.layout.receive_messenge, parent, false);
        return new ReceiveViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final MessengeModel model = messenges.get(position);
        if (model.isMine()) {
            ((SendViewHolder) holder).bind(model);
        } else {
            ((ReceiveViewHolder) holder).bind(model);
        }
    }

    @Override
    public int getItemCount() {
        return messenges.size();
    }

    class SendViewHolder extends RecyclerView.ViewHolder {
        TextView sendText;

        public SendViewHolder(View itemView) {
            super(itemView);
            sendText = itemView.findViewById(R.id.send_text);
        }

        void bind(MessengeModel messenge) {
            sendText.setText(messenge.getText());
        }
    }

    class ReceiveViewHolder extends RecyclerView.ViewHolder {
        TextView receiveText;
        CircleImageView userImage;

        public ReceiveViewHolder(View itemView) {
            super(itemView);
            receiveText = itemView.findViewById(R.id.receive_text);
            userImage = itemView.findViewById(R.id.receive_image);
        }

        void bind(MessengeModel messenge) {
            receiveText.setText(messenge.getText());
            Picasso.get().load(userImageUrl).into(userImage);
            final int position1 = ((ChatActivity) context).getIntent().getIntExtra(UserAdapter.KEY, 0);
            userImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    InfoUserFragment infoUserFragment = new InfoUserFragment();
                    Bundle bundle = new Bundle();
                    bundle.putInt(ChatActivity.INFO, position1);
                    infoUserFragment.setArguments(bundle);
                    ((ChatActivity) context)
                            .getSupportFragmentManager()
                            .beginTransaction().replace(R.id.chat_conteiner, infoUserFragment).commit();
                }
            });
        }
    }
}
