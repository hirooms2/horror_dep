package com.horrornumber1.horrormagazine.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.horrornumber1.horrormagazine.Activities.Content;
import com.horrornumber1.horrormagazine.Adapters.ExpandableAdapter;
import com.horrornumber1.horrormagazine.DataModel.Model;
import com.horrornumber1.horrormagazine.R;
import com.horrornumber1.horrormagazine.StaticData.DataHouse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by 김태호 on 2017-01-21.
 */

public class ExpandableFragment extends Fragment {
    ArrayList<String> parentList;
    TextView board_expandable_title, board_expandable_sub;
    HashMap<String, List<Model>> childList;
    String name, sub;
    List<Model> contents;

    List<Model> a = new ArrayList<>(); //수도권
    List<Model> b = new ArrayList<>();//충청
    List<Model> c= new ArrayList<>();; //강원
    List<Model> d= new ArrayList<>();; //경상
    List<Model> e= new ArrayList<>();; //전라
    List<Model> f= new ArrayList<>();; //제주

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.board_fragment_expandable, container, false);

        name = getArguments().getString("name");
        contents=whichContents(name);

        board_expandable_title = (TextView) rootView.findViewById(R.id.board_expandable_title);
        board_expandable_sub = (TextView) rootView.findViewById(R.id.board_expandable_sub);
        board_expandable_title.setText(name);
        board_expandable_sub.setText(sub);


        setLists();
        ExpandableListView expandableListView = (ExpandableListView) rootView.findViewById(R.id.expandablelist);
        ExpandableAdapter adapter = new ExpandableAdapter(getContext(), parentList, childList);
        expandableListView.setAdapter(adapter);
        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener(){
            @Override
            public void onGroupExpand(int i) {

            }
        });
        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener(){
            @Override
            public void onGroupCollapse(int i) {

            }
        });
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener()
        {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int groupposition, int childposition, long l) {
                int position=0;
                switch (groupposition) {
                    case 0:
                        position=childposition;
                        break;
                    case 1:
                        position=a.size() + childposition;
                        break;
                    case 2:
                        position=a.size()+b.size()+childposition;
                        break;
                    case 3:
                        position=a.size()+b.size()+c.size()+childposition;
                        break;
                    case 4:
                        position=a.size()+b.size()+c.size()+d.size()+childposition;
                        break;
                    case 5:
                        position=a.size()+b.size()+c.size()+d.size()+e.size()+childposition;
                        break;
                }
                Intent intent = new Intent(getContext(), Content.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                intent.putExtra(Content.PARAM_INPUT_NAME, name);
                intent.putExtra(Content.PARAM_INPUT_FROM, "B");
                intent.putExtra(Content.PARAM_INPUT_INDEX, position);
                startActivity(intent);
                return false;
            }
        });
        return rootView;
    }

    void setLists()
    {
        parentList = new ArrayList<String>();
        parentList.add("서울/경기");
        parentList.add("충청도");
        parentList.add("강원도");
        parentList.add("경상도");
        parentList.add("전라도");
        parentList.add("제주");




        childList = new HashMap<String, List<Model>>();

        for(int i=0; i< contents.size() ; i++) {
            String str = contents.get(i).getFile();
            String[] arr = str.split("/");
            switch (arr[arr.length-1].charAt(0)) {
                case 'a':
                    a.add(contents.get(i));
                    break;
                case 'b':
                    b.add(contents.get(i));
                    break;
                case 'c':
                    c.add(contents.get(i));
                    break;
                case 'd':
                    d.add(contents.get(i));
                    break;
                case 'e':
                    e.add(contents.get(i));
                    break;
                case 'f':
                    f.add(contents.get(i));
                    break;
            }
        }

        childList.put(parentList.get(0), a); //수도권
        childList.put(parentList.get(1), b); //충청
        childList.put(parentList.get(2), c); //강원
        childList.put(parentList.get(3), d); //경상
        childList.put(parentList.get(4), e); //전라
        childList.put(parentList.get(5), f); //제주

    }
    private List<Model> whichContents(String name)
    {
        switch (name)
        {
            case "지역괴담":
                contents = DataHouse.region2;
                sub=DataHouse.sub.get(0);
                return contents;
            case "군대괴담":
                contents = DataHouse.millitary2;
                sub=DataHouse.sub.get(1);
                return contents;
            case "실제이야기":
                contents = DataHouse.real2;
                sub=DataHouse.sub.get(2);
                return contents;
            case "대학괴담":
                contents = DataHouse.college2;
                sub=DataHouse.sub.get(3);
                return contents;
            //case "4컷 만화":
            //    contents = DataHouse.understand2;
            //    sub=DataHouse.sub.get(4);
            //    return contents;
            case "로어":
                contents = DataHouse.lore2;
                sub=DataHouse.sub.get(4);
                return contents;
            case "이해하면 무서운 이야기":
                contents = DataHouse.understand2;
                sub=DataHouse.sub.get(5);
                return contents;
            case "도시괴담":
                contents = DataHouse.city2;
                sub=DataHouse.sub.get(6);
                return contents;
        }
        return contents;
    }

}
