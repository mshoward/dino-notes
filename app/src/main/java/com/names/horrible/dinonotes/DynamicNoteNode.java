package com.names.horrible.dinonotes;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.ArrayList;

/**
 * Created by mason on 10/24/17.
 */

public class DynamicNoteNode extends DynamicNoteItem {
    public ArrayList<Integer> ParentList;
    public ArrayList<Integer> ChildList;

    public DynamicNoteNode(@Nullable ArrayList<Integer> pParents, @Nullable ArrayList<Integer> pChildren, @NonNull DynamicNoteItem data){
        super(data.title, data.note, data.id);
        this.ParentList = pParents;
        this.ChildList = pChildren;
    }
    public DynamicNoteNode(){
        super();
        this.ParentList = new ArrayList<Integer>();
    }

    @org.jetbrains.annotations.Contract("null, _ -> false")
    private boolean arrayListContains(@Nullable ArrayList<Integer> pArrayList, Integer pId){
        if (pArrayList == null)
            return false;
        for(int i=0; i<pArrayList.size(); i++){
            if (pArrayList.get(i).equals(pId))
                return true;
        }
        return false;
    }

    public boolean hasParent(Integer pId){return arrayListContains(ParentList, pId);}
    public boolean hasParent(DynamicNoteNode pNode){return arrayListContains(ParentList, pNode.id);}


    public boolean hasChild(Integer pId){return arrayListContains(ChildList, pId);}
    public boolean hasChild(DynamicNoteNode pNode){return arrayListContains(ChildList, pNode.id);}

}
