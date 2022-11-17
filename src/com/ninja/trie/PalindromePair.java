package com.ninja.trie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class PalindromePair {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static ArrayList<String> takeInput() throws IOException {
		ArrayList<String> words = new ArrayList<>();

		int n = Integer.parseInt(br.readLine().trim());

		if (n == 0) {
			return words;
		}

		String[] listOfWords; 
		listOfWords = br.readLine().split("\\s");


		for (int i = 0; i < n; ++i) {
			words.add(listOfWords[i]);
		}

		return words;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		Trie root = new Trie();

		ArrayList<String> words = takeInput();
		System.out.println(PalindromePairSol.isPalindromePair(words));
	} 
}

class PalindromePairSol {

	private TrieNode root;
	public int count;

	public PalindromePairSol() {
		root = new TrieNode('\0');
	}

	private void add(TrieNode root, String word){
		if(word.length() == 0){
			root.isTerminating = true;
			return;
		}		

		int childIndex = word.charAt(0) - 'a';
		TrieNode child = root.children[childIndex];

		if(child == null) {
			child = new TrieNode(word.charAt(0));
			root.children[childIndex] = child;
			root.childCount++;
		}

		add(child, word.substring(1));
	}

	public void add(String word){
		add(root, word);
	}

	private boolean search(TrieNode root, String word) {
		if(word.length() == 0) {
			return root.isTerminating;
		}

		int childIndex=word.charAt(0) - 'a';
		TrieNode child=root.children[childIndex];

		if(child == null) {
			return false;
		}

		return search(child,word.substring(1));

	}

	public boolean search(String word) {
		return search(root,word);
	}

	private void print(TrieNode root, String word) {
		if (root == null) {
			return;
		}
		
		if (root.isTerminating) {
			System.out.println(word);
		}
		
		for (TrieNode child : root.children) {
			if (child == null) {
				continue;
			}
			String fwd = word + child.data;
			print(child, fwd);
		}
	}
	
	public void print() {
		print(this.root, "");
	}





	/*..................... Palindrome Pair................... */


	public static boolean isPalindromePair(ArrayList<String> vect) {
		for (int i = 0; i< vect.size(); i++)
        {
            if (isPalindrome(vect.get(i)))
                return true;
            for (int j = i+1; j< vect.size() ; j++)
            {
                if (isPalindrome(vect.get(j)))
                	return true;
                String check_str = "";
      
                // concatenate both strings
                check_str = check_str + vect.get(i) + vect.get(j);
      
                // check if the concatenated string is
                // palindrome
                if (isPalindrome(check_str))
                    return true;
 
                check_str = vect.get(j) + vect.get(i);
      
                // check if the concatenated string is
                // palindrome
                if (isPalindrome(check_str))
                    return true;
            }
        }
        return false;
	}

	static boolean isPalindrome(String str)
    {
        int len = str.length();
      
        // compare each character from starting
        // with its corresponding character from last
        for (int i = 0; i < len/2; i++ )
            if (str.charAt(i) != str.charAt(len-i-1))
                return false;
      
        return true;
    }
      
} 
