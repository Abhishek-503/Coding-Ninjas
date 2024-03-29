package com.ninja.trie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class AutoComplete {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


	public static void main(String[] args) throws IOException{
		Trie t = new Trie();
		int n = Integer.parseInt(br.readLine().trim());
		ArrayList<String> input = new ArrayList<String>();
		String[] words = br.readLine().split("\\s");
		for(int i = 0; i < n; i++) {

			input.add(words[i]);
		}
		String pattern = br.readLine();
		t.autoComplete(input, pattern);
	}
}


class Trie {
	private TrieNode root;
	public int count;
	public Trie() {
		root = new TrieNode('\0');
	}

	private void addHelper(TrieNode root, String word){
		if(word.length() == 0){
			root.isTerminating = true;
			return;
		}		
		int childIndex = word.charAt(0) - 'a';
		TrieNode child = root.children[childIndex];
		if(child == null){
			child = new TrieNode(word.charAt(0));
			root.children[childIndex] = child;
			root.childCount++;
		}
		addHelper(child, word.substring(1));
	}

	public void add(String word){
		addHelper(root, word);
	}


	public TrieNode findword(TrieNode root, String word) { 
		if(word.length() == 0){
			return root;
		}
		int childIndex = word.charAt(0) - 'a';
		TrieNode child = root.children[childIndex];
		if(child == null){
			return null; 
		}
		return findword(child, word.substring(1));
	} 

	public void allwords(TrieNode root,String word,String output){    
		if(root==null){
			return;
		}
		if(root.childCount == 0) { 
			if(output.length() > 0) {
				System.out.println(word + output); 
			}
			return; 
		}
		if(root.isTerminating == true) {
			System.out.println(word + output);
		}

		for(int i = 0; i < root.children.length; i++) {
			if(root.children[i] != null) {
				String ans = output + root.children[i].data; 
				allwords(root.children[i],word,ans);
			}
		}
	}

	public boolean searchhealper(TrieNode root,String word){
		if(word.length() == 0){
			return root.isTerminating;
		}	
		int childIndex = word.charAt(0) - 'a';
		TrieNode child = root.children[childIndex];
		if(child == null){
			return false;
		}
		return searchhealper(child,word.substring(1));
	}
	
	public boolean search(String word){
		return searchhealper(root,word);
	}

	public void autoComplete(ArrayList<String> input, String word){    

		int i=0; 
		while(i<input.size()){
			String a=input.get(i);
			addHelper(root,a); 
			i++;
		}  
		if(root == null || root.childCount == 0) { 
			return;
		}
		TrieNode a=findword(root,word);
		String output = ""; 
		allwords(a,word,output); 
	}
}