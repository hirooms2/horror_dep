package com.horrornumber1.horrordepartment.Module;

import android.content.res.Resources;
import android.util.DisplayMetrics;

import com.horrornumber1.horrordepartment.DataModel.Youtube_Box;
import com.horrornumber1.horrordepartment.DataModel.Youtube_con;
import com.horrornumber1.horrordepartment.DataModel.Youtube_key;
import com.horrornumber1.horrordepartment.StaticData.DataHouse;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by KIMTAEHO on 2018-01-16.
 */

public class Youtube_Util {

    public Youtube_Util(){
    }
    public List<Youtube_con> searchTab1_All(int whichBtn){
        List<Youtube_con> list = new ArrayList<>();

        for(Youtube_con yc : DataHouse.youtube_box.getCon_box()) {
            if(yc.getWhichBtn()==whichBtn)
                list.add(yc);
        }
        return list;
    }

    public Youtube_con searchTab1(int whichBtn, int whichContent){

        for(Youtube_con yc : DataHouse.youtube_box.getCon_box()) {
            if(yc.getWhichBtn()==whichBtn && yc.getWhichContent()==whichContent)
                return yc;
        }
        return null;
    }

    public Youtube_key searchTab2(int whichBtn, int whichContent, int position){

        for(Youtube_key yk : DataHouse.youtube_box.getKey_box()) {
            if(yk.getWhichBtn()==whichBtn && yk.getWhichContent()==whichContent && yk.getPosition() == position)
                return yk;
        }
        return null;
    }

    public List<Youtube_key> searchTab2_All(int whichBtn, int whichContent){
        List<Youtube_key> list = new ArrayList<>();

        for(Youtube_key yk : DataHouse.youtube_box.getKey_box()) {
            if(yk.getWhichBtn()==whichBtn && yk.getWhichContent()==whichContent)
                list.add(yk);
        }
        return list;
    }

    public String whichImg(int whichBtn, int whichContent){
        float density = Resources.getSystem().getDisplayMetrics().density*160f;

        if(density== DisplayMetrics.DENSITY_XXHIGH)
            return searchTab1(whichBtn, whichContent).getImg2();
        else if (density==DisplayMetrics.DENSITY_XXXHIGH)
            return searchTab1(whichBtn, whichContent).getImg();

        return null;
    }

}