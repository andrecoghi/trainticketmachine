package com.ticketmachine.helper;

import java.util.List;

import com.ticketmachine.domain.TrieNode;

public class TrieNodeHelper {

	static TrieNode root;

	public static TrieNode buildTrieNode(List<String> words) {
		root = new TrieNode();
		if (null != words && !words.isEmpty())
			for (String word : words)
				root.insert(word);
		return root;
	}

	public static TrieNode getTrieNode(List<String> words) {
		if (root == null) {
			root = buildTrieNode(words);
		}
		return root;
	}

}