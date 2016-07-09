package com.example.htetaunglwin.attractionsinmyanmar.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.htetaunglwin.attractionsinmyanmar.R;
import com.example.htetaunglwin.attractionsinmyanmar.adapters.AttractionAdapter;
import com.example.htetaunglwin.attractionsinmyanmar.data.models.AttractionModel;
import com.example.htetaunglwin.attractionsinmyanmar.data.vos.AttractionVO;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private AttractionAdapter mAttractionAdapter;
    private ControllerPlaceItem mPlaceItemController;

    public MainActivityFragment() {
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mPlaceItemController = (ControllerPlaceItem) context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAttractionAdapter = new AttractionAdapter(AttractionModel.getObjInstance().getPlaceList(), mPlaceItemController);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        RecyclerView rvPlace = (RecyclerView) view.findViewById(R.id.rv_attractions);
        rvPlace.setAdapter(mAttractionAdapter);
        rvPlace.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        return view;
    }

    public interface ControllerPlaceItem{
        void onTapPlace(AttractionVO place, ImageView ivPlacePhoto);
    }
}
