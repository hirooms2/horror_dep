package com.horrornumber1.horrormagazine.CounsilClass;

/**
 * Created by 이승헌 on 2017-02-23.
 */
public class ListItem {
    int image;
    String imagetitle;

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
