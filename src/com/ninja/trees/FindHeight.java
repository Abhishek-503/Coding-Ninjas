package com.ninja.trees;

import java.util.ArrayList;
import java.util.Collections;

public class FindHeight {

}
class FindHeightSol {

	/*	TreeNode structure 
	 * 
	 * class TreeNode<T> {
		T data;
		ArrayList<TreeNode<T>> children;

		TreeNode(T data){
			this.data = data;
			children = new ArrayList<TreeNode<T>>();
		}
	}*/

//	public static int getHeight(TreeNode<Integer> root){
//		
//        if(root==null){
//            return 0;
//        }
//        int height = 1;
//        ArrayList<Integer> list = new ArrayList<>();
//        list.add(height);
//        for(int i = 0;i<root.children.size();i++){
//        	int h = 1 + getHeight(root.children.get(i));
//            list.add(h);
//        }
//        return Collections.max(list);
//	}

	public static int getHeight(TreeNode<Integer> root){
		
        if(root==null){
            return 0;
        }
        int height = 0;
        for(int i = 0;i<root.children.size();i++){
        	int h = getHeight(root.children.get(i));
        	if(h>height) {
        		height = h;
        	}
        }
        return height+1;
	}
}