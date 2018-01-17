package com.horrornumber1.horrordepartment.Module;

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
    public ArrayList<Youtube_con> searchTab1(int whichBtn){
        ArrayList<Youtube_con> list = new ArrayList<>();

        for(Youtube_con yc : DataHouse.youtube_box.getCon_box()) {
            if(yc.getWhichBtn()==whichBtn)
                list.add(yc);
        }
        return list;
    }

    ArrayList<Youtube_key> searchTab2(int whichBtn, int whichContent){
        ArrayList<Youtube_key> list = new ArrayList<>();

        for(Youtube_key yk : DataHouse.youtube_box.getKey_box()) {
            if(yk.getWhichBtn()==whichBtn && yk.getWhichContent()==whichContent)
                list.add(yk);
        }
        return list;
    }
}
