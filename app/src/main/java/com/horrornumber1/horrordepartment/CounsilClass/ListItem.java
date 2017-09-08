package com.horrornumber1.horrordepartment.CounsilClass;

public class ListItem {
    public int image;
    public String imagetitle;

    public int getImage(){
        return image;
    }
    public String getImagetitle(){
        return imagetitle;
    }
    public ListItem(int image, String imagetitle){
        this.image = image;
        this.imagetitle = imagetitle;
    }
}
