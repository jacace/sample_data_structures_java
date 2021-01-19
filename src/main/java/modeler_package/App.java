package modeler_package;

import java.util.Scanner;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
 
        System.out.println("Add your root text!");

        Scanner sc = new Scanner(System.in); 
        String rootText = sc.nextLine();

        Node root=new Node();
        root.setText(rootText);

        char c='n';
        while(c=='n')
        {
            System.out.println("Add your child text!"); 
            Scanner childScanner = new Scanner(System.in); 
            String tmpText=childScanner.nextLine();

            Node tmpNode=new Node();
            tmpNode.setText(tmpText);
            root.addChild(tmpNode);
            System.out.println("Id:"+tmpNode.getId());
            
            System.out.println("Exit? y/n");
            c = childScanner.next().charAt(0);  
        }

        String searchId;
        c='n';
        while(c=='n')
        {
            System.out.println("Enter ID to search!");   
            searchId=sc.nextLine();
            Node foundNode=root.searchById(searchId);

            if(foundNode!=null)
            {
                System.out.println("Node found: " + foundNode.getText()); 
            }
            System.out.println("Exit? y/n");
            c = sc.next().charAt(0);  
        }

        System.out.println("Thanks for using this CLI!");

    }
}
