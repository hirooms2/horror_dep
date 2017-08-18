package com.horrornumber1.horrordepartment.DataModel;


public class Model {
    int no;
    String title;
    String file;
    String file2;
    int like;
    String date;
    String writer;
    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }
    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getFile2() { return file2; }

    public void setFile2(String file2) {
        this.file2 = file2;
    }

    public String getWriter() { return writer; }

    public void setWriter(String writer) { this.writer = writer; }
}
