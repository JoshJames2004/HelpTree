/**
 * The TreeDriver class contains the menu the user interacts with and drives the program 
 * 
 * @author Joshua James
 * ID: 115113767
 * e-mail: joshua.james@stonybrook.edu
 */
import java.io.File;
import java.util.Scanner;
public class TreeDriver {

    /**
     * The main method contains the menu and gets user input for each function of the program 
     */
    public static void main(String[] args) throws Exception {
        
        boolean cont = true;
        Tree tree = new Tree();
        String input;
        Scanner s = new Scanner(System.in); 

        while(cont){
                //main menu
                System.out.println(""); 
                System.out.println("L - Load a tree");
                System.out.println("H - Begin a help session");
                System.out.println("T - Traverse the tree in preorder");
                System.out.println("Q - Quit");
                System.out.println("Choice: "); 
                input = s.nextLine(); 
                
                System.out.println("");
                //gets input for all the nodes in the tree from the file 
                //user enters the filename 
                //Precondition: The file is in the correct format 
                if(input.equalsIgnoreCase("L")){
                    tree = new Tree();
                    System.out.println("Enter the name of the file");
                    input = s.nextLine();
                    File start = new File(System.getProperty("user.dir"));

                    String l;
                    String p;
                    String m;
                    String pl = "";

                    File text = new File(start, input + ".txt"); 
                    Scanner sc = new Scanner(text); 
                    int num = 0;

                    l = sc.nextLine();
                    p = sc.nextLine();
                    m = sc.nextLine();

                    tree.addNode(l,p,m); // adds the root which is always first in the file 
                    
                    while(sc.hasNextLine()){

                        String ln = sc.nextLine();

                        for(int j = 0; j < ln.length(); j++){
                            pl = ln.split(" ")[0];
                            if(ln.charAt(j) == ' '){ //checks the line for the number of children it has
                                num = Character.getNumericValue(ln.charAt(j+1));
                                break;
                            }
                        }
                        
                        while(num > 0){ //creates children nodes 
                            l = sc.nextLine();
                            p = sc.nextLine();
                            m = sc.nextLine();
                            System.out.println(pl);
                            tree.addNode(l, p, m, pl);
                            num--; 
                        } 
                    }     
                }
                else if(input.equalsIgnoreCase("H")){ //begins the help session 
                    tree.beginSession();
                }
                else if (input.equalsIgnoreCase("T")){ //prints the entire tree in preorder 
                    tree.preOrder(tree.getRoot());
                }
                else if(input.equalsIgnoreCase("Q")){ //quits the program 
                    cont = false;
                }
                else { //incase the user enters something that does not match an option
                    System.out.println("Invalid Input, Please retry"); 
                }
        }   
    }
}
