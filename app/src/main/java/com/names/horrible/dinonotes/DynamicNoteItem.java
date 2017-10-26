package com.names.horrible.dinonotes;

/**
 * Created by mason on 10/24/17.
 */

public class DynamicNoteItem {
    protected String title;
    protected String note;
    protected Integer id;

    public DynamicNoteItem(String pTitle, String pNote, Integer pId){
        this.note = pNote;
        this.title = pTitle;
        this.id = pId;
    }
    public DynamicNoteItem(){this("","", 0);}

    public void setTitle(String pTitle){this.title = pTitle;}
    public String getTitle(){return this.title;}

    public void setNote(String pNote){this.note = pNote;}
    public String getNote(){return this.note;}

    public void setId(Integer pId){this.id = pId;}
    public Integer getId(){return this.id;}

    @Override
    public String toString(){
        return title + "\n" + note;
    }
}
