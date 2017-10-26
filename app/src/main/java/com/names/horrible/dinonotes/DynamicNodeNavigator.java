package com.names.horrible.dinonotes;

import java.util.ArrayList;

/**
 * Created by mason on 10/24/17.
 */

public class DynamicNodeNavigator {
    private DynamicNoteRoot currentRoot;
    private DynamicNoteNode currentNode;
    private ArrayList<DynamicNoteNode> Nodes;

    public DynamicNodeNavigator(){
        currentNode = null;
        currentRoot = null;
        Nodes = null;
    }

    public void setRoot(DynamicNoteRoot pRoot){currentRoot = pRoot;}
    public DynamicNoteRoot getCurrentRoot(){return currentRoot;}

    public void setCurrentNode(DynamicNoteNode pNode){currentNode = pNode;}
    public DynamicNoteNode getCurrentNode(){return currentNode;}

    public void setNodes(ArrayList<DynamicNoteNode> pNodes){Nodes = pNodes;}
    public ArrayList<DynamicNoteNode> getNodes(){return Nodes;}

    public void changeRoots(DynamicNoteRoot pRoot){
        setRoot(pRoot);
        setCurrentNode(pRoot);
        setNodes(pRoot.NodesList);
    }

    public void moveCurrNodeUp(Integer pIndex){
        //// TODO: 10/24/17
    }
    public void moveCurrNodeDown(Integer pIndex){
        //// TODO: 10/24/17
    }

}
