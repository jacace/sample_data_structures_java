package modeler_package;

import java.util.*;

public class Node {
    private String text;
    private String id;
    private List<Node> nodes;

    public Node() {
        id=java.util.UUID.randomUUID().toString();
        nodes=new ArrayList<Node>();
    }

    public void setText(String text)
    {
        this.text=text;
    }

    public String getText()
    {
        return this.text;
    }

    public String getId()
    {
        return id;
    }   

    public void addChild(Node tmpNode)
    {
        nodes.add(tmpNode);
    }

    public int childrenSize()
    {
        return nodes.size();
    }

    public Node searchById(String id)
    {
        if(nodes!=null)
        {
            for(int i=0;i<nodes.size();i++)
            {
                if(nodes.get(i).getId().equals(id))
                {
                    return nodes.get(i);
                }
                else
                {
                    //Id was not found, so we don depth first search
                    Node tmpNode=null;
                    for(int j=0;j<nodes.get(i).childrenSize();j++)
                    {
                        tmpNode=nodes.get(j).searchById(id);
                        if(tmpNode!=null)
                        {
                            return tmpNode;
                        }
                    }
                }                

            }          
        }        

        return null;
    }
}
