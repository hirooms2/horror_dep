package com.horrornumber1.horrordepartment.Module;

import com.horrornumber1.horrordepartment.DataModel.Model;

import java.util.Comparator;

/**
 * Created by KIMTAEHO on 2017-08-17.
 */

public class Comp implements Comparator<Model> {
    @Override
    public int compare(Model o1, Model o2) {
        int a = Integer.parseInt(o1.getDate());
        int b = Integer.parseInt(o2.getDate());
        if(a < b)
            return 1;
        else if (a==b)
            return 0;
        else
            return -1;    }
}
