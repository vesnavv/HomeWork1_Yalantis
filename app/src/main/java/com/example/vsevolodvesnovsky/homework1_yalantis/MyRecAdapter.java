package com.example.vsevolodvesnovsky.homework1_yalantis;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;

/**
 * Created by vsevolod vesnovsky on 20.03.2016.
 */
public class MyRecAdapter extends RecyclerView.Adapter {

    private ArrayList<Uri> mImageUri;
    private Context mContext;
    private RecyclerViewOnClickListener mListener;

    public MyRecAdapter(ArrayList<Uri> mImageUri, Context mContext, RecyclerViewOnClickListener mListener) {
        this.mImageUri = mImageUri;
        this.mContext = mContext;
        this.mListener = mListener;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_adapter, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder h, final int position) {
        ViewHolder holder = (ViewHolder)h;

        Picasso.with(mContext).load(mImageUri.get(position))
                .placeholder(R.drawable.ic_photo_black_48dp)
                .error(R.drawable.ic_error_black_48dp)
                .into(holder.mPhoto);

        holder.mPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    mListener.onImageViewClick("ImageView " + position);
                }
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


    }
}
