package com.example.user.instagram;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by User on 3/13/2016.
 */
public class InstegramPhotosAdapter extends ArrayAdapter<InstegramPhoto> {
    public InstegramPhotosAdapter(Context context,List<InstegramPhoto> objects) {
        super(context,android.R.layout.simple_list_item_1, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        InstegramPhoto photo = getItem(position);
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_photo,parent,false);

        }
        TextView tvCaption = (TextView)convertView.findViewById(R.id.tvCaption);
        ImageView ivPhoto = (ImageView)convertView.findViewById(R.id.ivPhotos);
        TextView tvuser = (TextView)convertView.findViewById(R.id.tvuser);
        TextView tvlike = (TextView)convertView.findViewById(R.id.tvlike);
        ImageView imgAvt = (ImageView)convertView.findViewById(R.id.imgAvt);

        tvlike.setText(String.valueOf(photo.likesCount));

        tvuser.setText(photo.username);
        tvCaption.setText(photo.caption);
//        ivPhoto.setImageResource(0);
        ivPhoto.setBackgroundResource(0);
        Picasso.with(getContext()).load(photo.imageUrl).into(ivPhoto);

        imgAvt.setBackgroundResource(0);
        Picasso.with(getContext()).load(photo.profile).into(imgAvt);
        return convertView;
    }
}

