package com.horrornumber1.horrordepartment.DataModel;




public class MyData {
    String title;
    int icon;
    int file;
    boolean selected = true;

    public MyData() {}

    //기존의 것과 호환성을 위해
    public MyData(String title, int icon)
    {
        this.title = title;
        this.icon = icon;
    }

    //로어 아이템의 경우 icon값에 0을 준다
    public MyData(String title, int icon, int file)
    {
        this.title = title;
        this.icon = icon;
        this.file = file;
    }

    public String getTitle() { return title; }
    public int getIcon() { return icon; }
    public int getFile() { return file; }

}
