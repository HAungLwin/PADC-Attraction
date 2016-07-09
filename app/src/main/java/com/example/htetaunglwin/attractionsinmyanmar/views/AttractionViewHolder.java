package com.example.htetaunglwin.attractionsinmyanmar.views;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.htetaunglwin.attractionsinmyanmar.R;
import com.example.htetaunglwin.attractionsinmyanmar.data.vos.AttractionVO;
import com.example.htetaunglwin.attractionsinmyanmar.fragments.MainActivityFragment;


/**
 * Created by Htet Aung Lwin on 09-Jul-16.
 */
public class AttractionViewHolder extends RecyclerView.ViewHolder {

    private TextView tvTitle, tvDesc;
    private ImageView ivPhoto;
    private MainActivityFragment.ControllerPlaceItem mControllerPlaceItem;
    private AttractionVO mPlace;

    public AttractionViewHolder(View itemView, MainActivityFragment.ControllerPlaceItem controllerPlaceItem) {
        super(itemView);
        this.mControllerPlaceItem = controllerPlaceItem;
        tvTitle = (TextView) itemView.findViewById(R.id.tv_place_title);
        tvDesc = (TextView) itemView.findViewById(R.id.tv_place_desc);
        ivPhoto = (ImageView) itemView.findViewById(R.id.iv_place_photo);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mControllerPlaceItem.onTapPlace(mPlace, ivPhoto);
            }
        });
    }

    public void setData(AttractionVO attractionVO){
        this.mPlace = attractionVO;
        tvTitle.setText(attractionVO.getTitle());
        tvDesc.setText(attractionVO.getDesc());

    }
}
