package com.example.vsevolodvesnovsky.homework1_yalantis;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vsevolod vesnovsky on 20.03.2016.
 */
public class MyRecAdapter extends RecyclerView.Adapter {

    private List<Uri> mImageUri;
    private Context mContext;
    private static final int SIZE_HOR = 400, SIZE_VER = 400;

    public MyRecAdapter(ArrayList<Uri> imageUri, Context context) {
        mImageUri = imageUri;
        mContext = context;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_adapter, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder h, final int position) {

        final ViewHolder holder = (ViewHolder)h;
        
        Picasso.with(mContext).load(mImageUri.get(position))
                .resize(SIZE_HOR, SIZE_VER)
                .into(holder.mPhoto);
                
        holder.mPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, holder.getmPhoto().getClass().getSimpleName(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mImageUri.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView mPhoto;
        
        public ViewHolder(View itemView) {
            super(itemView);
            mPhoto = (ImageView) itemView.findViewById(R.id.ivPhoto);
        }

        public ImageView getmPhoto() {
            return mPhoto;
        }
    }
}
