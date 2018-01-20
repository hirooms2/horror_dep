package com.horrornumber1.horrordepartment.CounsilClass;

public class ListItem {
    public String image;
    public String imagetitle;

    public String getImage(){
        return image;
    }
    public String getImagetitle(){
        return imagetitle;
    }
    public ListItem(String image, String imagetitle){
        this.image = image;
        this.imagetitle = imagetitle;
    }
}
