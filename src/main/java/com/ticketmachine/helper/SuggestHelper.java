package com.ticketmachine.helper;

import java.util.ArrayList;
import java.util.List;

import com.ticketmachine.domain.TrieNode;

public class SuggestHelper {
	
	public static List<String> suggest(String searchTerm, TrieNode root) {
		List<String> list = new ArrayList<>();
		TrieNode lastNode = root;
		StringBuffer curr = new StringBuffer();
		for (char c : searchTerm.toCharArray()) {
			lastNode = lastNode.getNode().get(c);
			if (lastNode == null)
				return list;
			curr.append(c);
		}
		find(lastNode, list, curr);
		return list;
	}

	public static void find(TrieNode root, List<String> list, StringBuffer curr) {
		if (root.isTerm()) {
			list.add(curr.toString());
		}

		if (root.getNode() == null || root.getNode().isEmpty())
			return;

		for (TrieNode child : root.getNode().values()) {
			find(child, list, curr.append(child.getCharacter()));
			curr.setLength(curr.length() - 1);
		}
	}

}
