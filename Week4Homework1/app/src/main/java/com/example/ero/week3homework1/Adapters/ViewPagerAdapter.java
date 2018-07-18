package com.example.ero.week3homework1.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ero.week3homework1.Modeles.Girl;
import com.example.ero.week3homework1.R;
import com.example.ero.week3homework1.Users.Users;

import java.util.List;

public class ViewPagerAdapter extends PagerAdapter {

    private Context context;
    private List<Girl> girls;
    private Button button;

    public ViewPagerAdapter(Context context, List<Girl> girls) {
        this.context = context;
        this.girls = girls;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View view = inflater.inflate(R.layout.girl_item, container, false);
        final TextView girlName = view.findViewById(R.id.girl_name);
        final ImageView girlImage = view.findViewById(R.id.girl_image);
        button = view.findViewById(R.id.button1);
        final Girl girl = girls.get(position);
        girlImage.setImageResource(girl.getImageId());
        girlName.setText(girl.getName());
        container.addView(view);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Users.class);
                context.startActivity(intent);
            }
        });
        return view;
    }


    @Override
    public int getCount() {
        return girls.size();
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }
}
