/*
Given a binary tree, and your task is to return its bottom view. The bottom view of a binary tree is the set of nodes visible when the tree is viewed from the bottom.

Note: If there are multiple bottom-most nodes for a horizontal distance from the root, then the latter one in the level order traversal is considered.
GeekForFeek Link :- https://www.geeksforgeeks.org/problems/bottom-view-of-binary-tree/1

Time Complexity :- O(n)
Space Complexity :- O(n)
*/


package Hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class BottomViewBT {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int val) {
            data = val;
            left = right = null;

        }
    }

    static class Info{
        Node node;
        int hd;
        
        public Info(Node node , int hd){
            this.node = node;
            this.hd = hd;
        }
    }

    public static  ArrayList<Integer> bottomView(Node root) {
        // code here
        HashMap<Integer,Node> map = new HashMap<>();
        Queue<Info> q = new LinkedList<>();
        ArrayList<Integer> arr = new ArrayList<>();
        
        int min = 0 , max = 0;
        
        q.add(new Info(root , 0));
        q.add(null);
        
        while(!q.isEmpty()){
            Info currNode = q.remove();
            if(currNode == null){
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                }
            }else{
                    map.put(currNode.hd , currNode.node);
                    
                    if(currNode.node.left != null){
                        q.add(new Info(currNode.node.left , currNode.hd - 1));
                        min = Math.min(min , currNode.hd - 1);
                    }
                    
                    if(currNode.node.right != null){
                        q.add(new Info(currNode.node.right , currNode.hd + 1));
                        max = Math.max(max , currNode.hd + 1);
                    }
               }
            }
        
        for(int i=min ; i<=max ; i++){
            arr.add(map.get(i).data);
        }
        
        return arr;
    }

    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(8);
        root.left.left = new Node(5);
        root.left.right = new Node(3);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);
        root.right = new Node(22);
        root.right.right = new Node(25);

        System.out.println(bottomView(root));
    }
}
