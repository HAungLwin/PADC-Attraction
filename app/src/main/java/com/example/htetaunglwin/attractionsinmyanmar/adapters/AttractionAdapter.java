package com.example.htetaunglwin.attractionsinmyanmar.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.htetaunglwin.attractionsinmyanmar.AttractionsinMyanmar;
import com.example.htetaunglwin.attractionsinmyanmar.R;
import com.example.htetaunglwin.attractionsinmyanmar.data.vos.AttractionVO;
import com.example.htetaunglwin.attractionsinmyanmar.fragments.MainActivityFragment;
import com.example.htetaunglwin.attractionsinmyanmar.views.AttractionViewHolder;

import java.util.List;

/**
 * Created by Htet Aung Lwin on 09-Jul-16.
 */
public class AttractionAdapter extends RecyclerView.Adapter<AttractionViewHolder> {

    private LayoutInflater inflater;
    private List<AttractionVO> placeList;
    private MainActivityFragment.ControllerPlaceItem mControllerPlaceItem;

    public AttractionAdapter(List<AttractionVO> placeList, MainActivityFragment.ControllerPlaceItem controllerPlaceItem){
        inflater = LayoutInflater.from(AttractionsinMyanmar.getContext());
        this.placeList = placeList;
        this.mControllerPlaceItem = controllerPlaceItem;
    }

    @Override
    public AttractionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.view_item_place, parent, false);
        AttractionViewHolder attractionViewHolder = new AttractionViewHolder(itemView, mControllerPlaceItem);

        return attractionViewHolder;
    }

    @Override
    public void onBindViewHolder(AttractionViewHolder holder, int position) {
        holder.setData(placeList.get(position));
    }

    @Override
    public int getItemCount() {
        return placeList.size();
    }
}
