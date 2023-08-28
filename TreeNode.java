/**
 * The TreeNodes are the nodes on the tree the program uses for its automated help system
 * 
 * @author Joshua James
 * ID: 115113767
 * e-mail: joshua.james@stonybrook.edu
 */
public class TreeNode {
    
    TreeNode[] children = new TreeNode[3]; //max of three child nodes 

    private String label; //denotes location of node
    private String message; //denotes the message displayed by the node
    private String prompt; //denotes what the user inputs to select the node if it is an option

    /**
     * constructor 
     * @param l
     * label
     * @param m
     * message
     * @param p
     * prompt 
     */
    public TreeNode(String l, String m, String p){
        label = l;
        message = m;
        prompt = p; 
    }
    /**
     * accessor for children array
     * @return
     * children array 
     */
    public TreeNode[] getChildren(){
        return children;
    }
    /**
     * sets all the children of a node 
     * @param l
     * first child 
     * @param m
     * second child 
     * @param r
     * third child 
     */
    public void setChildren(TreeNode l, TreeNode m, TreeNode r){
        children[1] = l;
        children[2] = m;
        children[3] = r;
    }
    /**
     * accessor for leftmost child 
     * @return
     * TreeNode that is the left child
     */
    public TreeNode getLeft(){
        return children[0];
    }
    /**
     * accessor for middleChild
     * @return
     * TreeNode that is the middle child 
     */
    public TreeNode getMid(){
        return children[1];
    }
    /**
     * accessor for the right child
     * @return
     * Treenode that is the right child 
     */
    public TreeNode getRight(){
        return children[2];
    }
    /**
     * mutator for left child 
     * @param l
     * TreeNode that the left child is set to
     */
    public void setLeft(TreeNode l){
        children[0] = l;
    }
    /**
     * mutator for middle child 
     * @param l
     * TreeNode that the middle child is set to
     */
    public void setMid(TreeNode m){
        children[1] = m;
    }
    /**
     * mutator for right child 
     * @param l
     * TreeNode that the right child is set to
     */
    public void setRight(TreeNode r){
        children[2] = r;
    }
    /**
     * accessor for label
     * @return
     * label string 
     */
    public String getLabel(){
        return label;
    }
    /**
     * accessor for message
     * @return
     * String message
     */
    public String getMessage(){
        return message;
    }
    /**
     * accessor for prompt
     * @return
     * prompt string 
     */
    public String getPrompt(){
        return prompt;
    }
    /**
     * mutator for label
     * @param l
     * String that label is set to
     */
    public void setLabel(String l){
        label = l;
    }
    /**
     * mutator for Message
     * @param m
     * String that Message is set to
     */
    public void setMess(String m){
        message = m;
    }
    /**
     * mutator for prompt
     * @param p
     * String that prompt is set to
     */
    public void setPrompt(String p){
        prompt = p;
    }
    /**
     * checks whether the node is a leaf(has no children)
     * @return
     * boolean true or false depending on whether is a leaf or not 
     */
    public boolean isLeaf(){
        for(int i = 0; i < 3; i++){
            if(children[i] != null){
                return false;
            }
        }
        return true;
    }
}
