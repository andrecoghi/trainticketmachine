package com.ticketmachine.domain;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
	Map<Character, TrieNode> node;
	char character;
	boolean isTerm;

	public TrieNode(char character) {
		this.character = character;
		node = new HashMap<>();
	}

	public TrieNode() {
		node = new HashMap<>();
	}

	/**
	 * Insert a word into the trie
	 * @param word
	 */
	public void insert(String word) {
		if (word == null || word.isEmpty())
			return;
		char firstChar = word.charAt(0);
		final TrieNode current = node.computeIfAbsent(firstChar, c -> new TrieNode(firstChar));
		node.put(firstChar, current);
		//recursive call insert method to create a node to each character to the rest of the word
		if (word.length() > 1)
			current.insert(word.substring(1));
		else
			current.isTerm = true;
	}

	public Map<Character, TrieNode> getNode() {
		return node;
	}

	public void setNode(Map<Character, TrieNode> node) {
		this.node = node;
	}

	public char getCharacter() {
		return character;
	}

	public void setCharacter(char character) {
		this.character = character;
	}

	public boolean isTerm() {
		return isTerm;
	}

	public void setTerm(boolean isTerm) {
		this.isTerm = isTerm;
	}

}