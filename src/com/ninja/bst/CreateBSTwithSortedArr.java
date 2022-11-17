/*Construct BST
Send Feedback
Given a sorted integer array A of size n, which contains all unique elements. You need to construct a balanced BST from this input array. Return the root of constructed BST.
Note: If array size is even, take first mid as root.
Input format:
The first line of input contains an integer, which denotes the value of n. The following line contains n space separated integers, that denote the values of array.
Output Format:
The first and only line of output contains values of BST nodes, printed in pre order traversal.
Constraints:
Time Limit: 1 second
Sample Input 1:
7
1 2 3 4 5 6 7
Sample Output 1:
4 2 1 3 6 5 7 */
package com.ninja.bst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CreateBSTwithSortedArr {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	private static void preOrder(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return;
		}
		System.out.print(root.data + " ");
		preOrder(root.left);
		preOrder(root.right);
	}

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int len = Integer.parseInt(st.nextToken());
		int arr[] = new int[len];
		if(len>0)
		{
			st = new StringTokenizer(br.readLine());
		}
		for(int i=0;i<len;i++)
		{
		    arr[i]=Integer.parseInt(st.nextToken());
		}
		BinaryTreeNode<Integer> ans = CreateBSTwithSortedArrSol.SortedArrayToBST(arr, len);
		preOrder(ans);
	}
}
class CreateBSTwithSortedArrSol {
	public static BinaryTreeNode<Integer> SortedArrayToBST(int[] arr, int n){
		return helper(arr, 0,n-1);
	}
	
	private static BinaryTreeNode<Integer> helper(int[] arr, int start, int end){
        if(start>end){
            return null;
        }
        int index = (start+end)/2;
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(arr[index]);
        root.left = helper(arr, start, index-1);
        root.right = helper(arr, index+1, end);
        return root;
    }
}