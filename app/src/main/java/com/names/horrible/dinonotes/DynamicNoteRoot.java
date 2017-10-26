package com.names.horrible.dinonotes;

import java.util.ArrayList;

/**
 * Created by mason on 10/24/17.
 */

public class DynamicNoteRoot extends DynamicNoteNode {
    public ArrayList<DynamicNoteNode> NodesList;

    public DynamicNoteRoot(){
        super();
        NodesList = new ArrayList<>();
    }

    public boolean addNode(DynamicNoteNode pNode){
        if (pNode == null)
            return true;
        else{
            for (int i = 0; i < NodesList.size(); i++){
                if (NodesList.get(i).id.equals(pNode.id))
                    return true;
            }
            NodesList.add(pNode);
            return false;
        }
    }
}
