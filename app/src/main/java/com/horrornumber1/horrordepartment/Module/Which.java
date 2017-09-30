package com.horrornumber1.horrordepartment.Module;

import com.horrornumber1.horrordepartment.DataModel.Model;
import com.horrornumber1.horrordepartment.StaticData.DataHouse;

import java.util.List;

/**
 * Created by KIMTAEHO on 2017-08-17.
 */

public class Which {

    public List<Model> whichContents(String name) {
        switch (name) {
            case "지역괴담":
                return DataHouse.region2;
            case "군대괴담":
                return DataHouse.millitary2;
            case "실제이야기":
                return DataHouse.real2;
            case "대학괴담":
                return DataHouse.college2;
            case "로어":
                return DataHouse.lore2;
            case "이해하면 무서운 이야기":
                return DataHouse.understand2;
            case "도시괴담":
                return DataHouse.city2;
            case "투고괴담":
                return DataHouse.togo2;
        }
        return null;
    }

    public String whichSub(String name) {
        switch (name) {
            case "지역괴담":
                return DataHouse.sub.get(0);
            case "군대괴담":
                return DataHouse.sub.get(1);
            case "실제이야기":
                return DataHouse.sub.get(2);
            case "대학괴담":
                return DataHouse.sub.get(3);
            case "로어":
                return DataHouse.sub.get(4);
            case "이해하면 무서운 이야기":
                return DataHouse.sub.get(5);
            case "도시괴담":
                return DataHouse.sub.get(6);
            case "투고괴담":
                return DataHouse.sub.get(7);
        }
        return null;
    }

    public String whichBoard(String name)
    {
        switch (name)
        {
            case "지역괴담":
                return "region";
            case "군대괴담":
                return "millitary";
            case "실제이야기":
                return "realstory";
            case "대학괴담":
                return "college";
            case "로어":
                return "lore";
            case "이해하면 무서운 이야기":
                return "understand";
            case "도시괴담":
                return "city";
            case "투고괴담":
                return "togo";
        }
        return null;
    }

    public String whichTable(String name)
    {
        switch (name)
        {
            case "지역괴담":
                return "REGION2";
            case "군대괴담":
                return "MILLITARY2";
            case "실제이야기":
                return "REAL2";
            case "대학괴담":
                return "COLLEGE2";
            case "로어":
                return "LORE2";
            case "이해하면 무서운 이야기":
                return "UNDERSTAND2";
            case "도시괴담":
                return "CITY2";
            case "투고괴담":
                return "TOGO2";
        }
        return null;
    }
}
