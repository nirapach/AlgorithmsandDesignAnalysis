import java.util.Scanner;
import java.util.*;

/**
 * Created by Niranjan on 10/2/2015.
 */

class Node{
    public Object key;
    public Node left_node;
    public Node right_node;

    public Node(Object key, Node left_node, Node right_node) {
        this.key = key;
        this.left_node = left_node;
        this.right_node = right_node;
    }

    public Node(Object key) {
        this(key,null,null);
    }
}

class BinaryTree{

    public Node root;

    List<Integer> sorted_array = new ArrayList<Integer>();

    //recursice call
    public void insert(Integer element){
        root=inserted(root, element);
    }
    private Node inserted(Node node,Integer element){

        if (node == null) {
                node = new Node(element);
                return node;
        }

        else {
            if (element <= (Integer) node.key)
            {
                node.left_node=inserted(node.left_node, element);

            } else if (element > (Integer) node.key) {
                node.right_node=inserted(node.right_node, element);

            }
        }
        return node;
    }

    public boolean search(Node node,int element) {

        boolean check=false;
        if (node == null ) {
            check=false;
        } else {
            if (((Integer) node.key).intValue() == element) {
                check=true;

            } else {
                if (element < ((Integer) node.key).intValue()) {
                    return search(node.left_node, element);
                } else {
                    if (element > ((Integer) node.key).intValue()) {
                        return search(node.right_node, element);
                    }
                }
            }
        }
        return check;
    }

    public int count(Node node)
    {
        if( node == null)
            return(0);
        else
        if( node.left_node == null && node.right_node == null)
            return(1);
        else
            return(1 + count(node.left_node) + count(node.right_node));
    }

    public List<Integer> Inorder(Node node){

            if(node!= null) {

                Inorder(node.left_node);
                sorted_array.add(((Integer) node.key).intValue());
                    //System.out.println(((Integer) node.key).intValue());
                Inorder(node.right_node);

            }

        return sorted_array;
    }

}

public class BSTSort {


    public static void main(String args[]){

        //header
        System.out.println("Program for BST Insertion and Sorting ");
        System.out.println("-----------------------------------------------------");

        //Initialize the scanner class to get the input
        Scanner in = new Scanner(System.in);

        //get the input for the size of the sequence
        System.out.println("Please Enter the Size of the Sequence (i.e.,) the number of individual" +
                " numbers that are present in the sequence..");
        int size = in.nextInt();

        //initialize the array with the size of the sequence
        int sequence[] = new int[size];

        //storing the input into the array
        for (int i=0;i<=size-1;i++){
            System.out.println("Enter the number that needs to be added to the sequence...");
            sequence[i]=in.nextInt();
        }

        BinaryTree bst=new BinaryTree();

        //storing the input into the BST
        for (int i=0;i<=size-1;i++){
          bst.insert(new Integer(sequence[i]));

        }

        System.out.println("Numder of nodes in BST:" + bst.count(bst.root));

        //get the input for search
        System.out.println("Please Enter the number to be searched");
        int number = in.nextInt();

        boolean found=bst.search(bst.root,number);
        if(found){
            System.out.println("Number Found");
        }else{
            System.out.println("Number not Found");
        }

            System.out.println("Elements after doing Binary Search Tree Inorder Sort and storing in the list");
    List<Integer> sorted_array = new ArrayList<Integer>();

    sorted_array=bst.Inorder(bst.root);
    System.out.println();

    for (int i =0; i < sorted_array.size(); i++) {
        System.out.println(sorted_array.get(i));
    }

}


}
