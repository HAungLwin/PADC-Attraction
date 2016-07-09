package com.example.htetaunglwin.attractionsinmyanmar.data.models;

import com.example.htetaunglwin.attractionsinmyanmar.data.vos.AttractionVO;
import com.example.htetaunglwin.attractionsinmyanmar.utils.CommonInstances;
import com.example.htetaunglwin.attractionsinmyanmar.utils.JsonUtils;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Htet Aung Lwin on 08-Jul-16.
 */
public class AttractionModel {
    public static final String DUMMY_ATTRACTION_LIST = "myanmar_attractions.json";
    private static AttractionModel objInstance;
    private List<AttractionVO> placeList;

    public AttractionModel(){
        placeList = initializePlaceList();
    }

    public static AttractionModel getObjInstance(){
        if(objInstance == null){
            objInstance = new AttractionModel();
        }
        return objInstance;
    }
    private List<AttractionVO> initializePlaceList() {
        List<AttractionVO> eventList = new ArrayList<>();

        try {
            String dummyPlaceList = JsonUtils.getInstance().loadDummyData(DUMMY_ATTRACTION_LIST);
            Type listType = new TypeToken<List<AttractionVO>>() {
            }.getType();
            eventList = CommonInstances.getGsonInstance().fromJson(dummyPlaceList, listType);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return eventList;
    }

    public List<AttractionVO> getPlaceList() {
        return placeList;
    }

    public AttractionVO getPlaceByTitle(String title){
        for(AttractionVO place: placeList){
            if(place.getTitle().compareTo(title) == 0){
                return place;
            }
        }
        return null;
    }

}
