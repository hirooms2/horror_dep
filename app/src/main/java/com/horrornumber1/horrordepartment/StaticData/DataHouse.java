package com.horrornumber1.horrordepartment.StaticData;

import android.media.MediaPlayer;

import com.horrornumber1.horrordepartment.Module.DBManager;
import com.horrornumber1.horrordepartment.DataModel.Box;
import com.horrornumber1.horrordepartment.DataModel.Model;
import com.horrornumber1.horrordepartment.DataModel.MyData;
import com.horrornumber1.horrordepartment.R;

import java.util.ArrayList;
import java.util.List;

public class DataHouse {

    public static String uid;
    //*************************************ServerData**********************************************
    public static Box box = new Box();
    public static DBManager dbManager;
    //**************************************Background Music****************************************
    public static boolean musicCheck = true;
    public static MediaPlayer mp;

    //*********************************** Name  ***********************************************
    public static final List<String> title = new ArrayList<String>()
    {
        {
            add("지역괴담");
            add("군대괴담");
            add("실제이야기");
            add("대학괴담");
            //add("4컷 만화");
            add("로어");
            add("이해하면 무서운 이야기");
            add("도시괴담");
        }
    };
    //*********************************** sub  ***********************************************
    public static List<String> sub = new ArrayList<String>()
    {
        {
            add("우리 동네 무서운 이야기");
            add("잊을 수 없는 공포");
            add("실제로 있었던 무서운 이야기");
            add("20대의 아찔한 기억");
            //add("4컷의 공포 만화");
            add("출처를 알 수 없는 비밀");
            add("이해하면 무서운 이야기");
            add("현대의 민담");
            add("독자 제보 바탕의 이야기");
        }
    };

    //************************************Drawer Navigation1****************************************

    //************************************Drawer Navigation2****************************************
    public static List<MyData> drawerData2 = new ArrayList<MyData>()
    {
        {
            add(new MyData("면담하기",R.drawable.consult_icon));
            add(new MyData("건의/제보", R.drawable.mail_icon));
            add(new MyData("보관함", R.drawable.favorite2));
        }
    };

    //*******************************************지역***********************************************

    public static ArrayList<Model> region2 = new ArrayList<Model>();
    public static ArrayList<MyData> region = new ArrayList<MyData>() {
        {


        }
    };

    //*******************************************군대***********************************************

    public static ArrayList<Model> millitary2 = new ArrayList<Model>();
    public static ArrayList<MyData> millitary = new ArrayList<MyData>() {
        {

        }
    };

    //*******************************************실화***********************************************
    public static ArrayList<MyData> real = new ArrayList<MyData>(){
        {


        }
    };
    public static ArrayList<Model> real2 = new ArrayList<>();

    //*******************************************대학***********************************************

    public static ArrayList<MyData> college = new ArrayList<MyData>(){
        {


        }
    };
    public static ArrayList<Model> college2 = new ArrayList<Model>();


    //*******************************************Roar***********************************************
    public static List<MyData> lore = new ArrayList<MyData>()
    {
        {

        }
    };

    public static ArrayList<Model> lore2 = new ArrayList<Model>();


    //******************************************이무이*********************************************
    public static List<MyData> understand = new ArrayList<MyData>()
    {
        {
        }
    };

    public static List<String> understandAnswer = new ArrayList<String>()
    {
        {
        }
    }; //답변 리스트
    public static ArrayList<Model> understand2 = new ArrayList<Model>();


    //*******************************************도시괴담*******************************************
    public static ArrayList<MyData> city = new ArrayList<MyData>()
    {
        {

        }
    };
    public static ArrayList<Model> city2 = new ArrayList<Model>();

    //*******************************************만화*******************************************

    public static ArrayList<Model> cartoon2 = new ArrayList<>();

    public static ArrayList<Model> togo2 = new ArrayList<Model>();
}
