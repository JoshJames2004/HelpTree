/**
 * The Tree class creates the tree and handles adding nodes to the tree, printing the tree in pre order and running the help session
 * 
 * @author Joshua James
 * ID: 115113767
 * e-mail: joshua.james@stonybrook.edu
 */
import java.util.Scanner;

public class Tree {

    TreeNode root; //keeps track of the root node of the tree 
    /**
     * default constructor 
     */
    public Tree(){
        root = null;
    }
    /**
     * constructor for when root is already defined 
     * @param r
     */
    public Tree(TreeNode r){
        root = r;
    }
    /**
     * accessor for root node 
     * @return
     * TreeNode root 
     */
    public TreeNode getRoot(){
        return root;
    }
    /**
     * mutator for root node
     * @param n
     * node that root is set to
     */
    public void setRoot(TreeNode n){
        root = n;
    }
    /**
     * creates the root node of the tree 
     * @param label
     * label of the node 
     * @param prompt
     * prompt of the node 
     * @param message
     * message of the node 
     * @return
     * true because it added the node 
     */
    public boolean addNode(String label, String prompt, String message){
        TreeNode n = new TreeNode(label, message, prompt);
        setRoot(n);
        return true;

    }
    /**
     * adds a node to the tree that is not the root 
     * @param label
     * label of the node  
     * @param prompt
     * prompt of the node 
     * @param message
     * prompt of the node 
     * @param parentLabel
     * the label of the parent node 
     * @return
     * true or false depending on whether it was added or not
     */
    public boolean addNode(String label, String prompt, String message, String parentLabel){
        TreeNode a = new TreeNode(label, message, prompt);
        
        TreeNode p = getNodeReference(parentLabel); //gets the parent node

        if(p != null){ //decides which child spot to put the new node in
            if(p.getLeft() == null){
                p.setLeft(a);
                System.out.println(parentLabel);
                return true;
                        
            }
            
            if(p.getMid() == null){
                p.setMid(a);
                System.out.println(parentLabel);
                return true;
                        
            }
            
            if(p.getRight() == null){
                p.setRight(a);
                System.out.println(parentLabel); 
                return true;
                        
            }
            else{
                System.out.println(p.getLeft().getLabel());
                System.out.println(p.getMid().getLabel());
                System.out.println(p.getRight().getLabel());
                System.out.println("No more spots for children");
                return false;
            }         
        }
        else { //incase the parent node could not be found 
            System.out.println("Could not find parent node");
            return false;
        } 
    }

    /**
     * calls recursive getNode method to find the parent node 
     * @param label
     * parent label
     * @return
     * the node found or null if the parent node wasn't found 
     */
    public TreeNode getNodeReference(String label){
        TreeNode l = getNode(this.root, label);
        return l;
    }

    /**
     * locates the node 
     * @param n
     * Treenode that is checked if it is the correct node 
     * @param label
     * target label
     * @return
     * the treenode it found or null if it couldn't find it
     */
    public TreeNode getNode(TreeNode n, String label){
        if(n !=null){
            if(n.getLabel().equalsIgnoreCase(label)){
                return n;
            }
            else {
                TreeNode foundNode = getNode(n.getLeft(), label);
                if(foundNode == null){
                    foundNode = getNode(n.getMid(), label);
                }
                if(foundNode == null){
                    foundNode = getNode(n.getRight(), label);
                }
                return foundNode;
            }
        }
        else{
            return null;
        }
       
    }

    /**
     * prints the tree in preOrder
     * @param node
     * the root node of the tree
     */
    public void preOrder(TreeNode node){
        
        System.out.println("Label: " + node.getLabel());
        System.out.println("Prompt: " + node.getPrompt());
        System.out.println("Message: " + node.getMessage());
        System.out.println(""); 

        for(int i = 0; i < 3; i++){
            if(node.getChildren()[i] != null){
                preOrder(node.getChildren()[i]); 
            }
        }
    }

    /** 
     * handles the help session function of the program 
     */
    public void beginSession(){
        Scanner sc = new Scanner(System.in); 
         
        TreeNode cursor = root;
        boolean cont = true;
        if(cursor == null){
            System.out.println("Error: no tree setup");
        }
        else {
            while(cont == true){
                System.out.println("Message: " + cursor.getMessage());
                if(cursor.isLeaf()){ //incase of no children, ends the session
                    System.out.println("Thank you for using this automated help service"); 
                    
                    cont = false;
                    break;
                }
                for(int i = 0; i < 3; i++){ //prints the three options the children nodes give
                    if(cursor.getChildren()[i] != null){
                        System.out.println((i + 1) + ")" + cursor.getChildren()[i].getPrompt());
                    }
                }
                System.out.println("0 Exit Session");

                int choice = sc.nextInt(); 

                if(choice == 0){ //Quits the session
                    cont = false;
                    break;
                }
                else if (choice == 1){
                    if(cursor.getLeft() == null){ //checks whether that option exists 
                        System.out.println("Not an option");
                    }
                    else {
                        cursor = cursor.getLeft();
                    } 
                }
                else if (choice == 2){
                    if(cursor.getMid() == null){
                        System.out.println("Not an option");
                    }
                    else {
                        cursor = cursor.getMid();
                    } 
                }
                else if (choice == 3){
                    if(cursor.getRight() == null){
                        System.out.println("Not an option");
                    }
                    else {
                        cursor = cursor.getRight();
                    }
                }
                else {
                    System.out.println("Invalid Input"); //incase of invalid input 
                }
            }
            
        }
    }
    
}
