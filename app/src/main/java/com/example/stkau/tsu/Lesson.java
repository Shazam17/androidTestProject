package com.example.stkau.tsu;

public class Lesson {
    private String name;
    private String type;
    private String auditory;
    private String teacher;

    public Lesson(String name , String type , String aud , String teach){
        this.name = name;
        this.type = type;
        this.auditory = aud;
        this.teacher = teach;
    }

    public String getName(){
        return this.name;
    }



}
