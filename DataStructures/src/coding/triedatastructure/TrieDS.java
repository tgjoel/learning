package coding.triedatastructure;

import java.util.HashMap;
import java.util.Map;

public class TrieDS {
    public static void main(String[] args) {

    }
}

class TrieNode {
    Map<Character, TrieNode> children;
    boolean endOfWord;

    public TrieNode() {
        this.children = new HashMap<>();
        this.endOfWord = false;
    }
}

class Trie {
    TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            TrieNode node = current.children.get(c);
            if (node == null) { // if its not there then we are inserting the char and creating the node
                node = new TrieNode();
                current.children.put(c, node);
            }
            current = node;
        }
        /* Also can use computeIfAbsent
        for (char c : word.toCharArray()) {
            current = current.children.computeIfAbsent(c, v -> new TrieNode());
        } */
        current.endOfWord = true; // since the last node will be the end of string.
    }

    public boolean search(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            TrieNode node = current.children.get(c);
            if (node == null) {
                return false;  // if char is not present in the map returning false
            }
            current = node;
        }
        return current.endOfWord;
        // checked till the last of the string and if the last node has end of word true then the word is present
    }

    public void delete(String word) {
        delete(root, word, 0);
    }

    private boolean delete(TrieNode current, String word, int index) {

        //if the index is equal to the size of the word then, needs to check if that's the end of word.
        if (index == word.length()) {
            if (!current.endOfWord) {
                //if its not the end of the word return false.
                return false;
            }
            // if its the end of the word making it as false to represent its being deleted.
            current.endOfWord = false;
            //return true if we can delete this node completely if there is no children.
            return current.children.isEmpty();
        }
        //in other cases getting the node
        char ch = word.charAt(index);
        TrieNode node = current.children.get(ch);
        // if the node is null then the word is not present in the trie
        if (node == null) {
            return false;
        }
        //calling recursively the same whether to delete the node or not
        boolean shouldDeleteNode = delete(node, word, index + 1);
        if (shouldDeleteNode) { // if its true removing the node from the map
            current.children.remove(ch);
            //we can remove the current node as well if there is no children present after removing one of the node.
            return current.children.isEmpty();
        }
        return false;
    }

    public void insertRecursive(String word) {
        insertRecursive(root, word, 0);
    }

    private void insertRecursive(TrieNode current, String word, int index) {
        if (index == word.length()) {
            //if end of word is reached then mark endOfWord as true on current node
            current.endOfWord = true;
            return;
        }
        char ch = word.charAt(index);
        TrieNode node = current.children.get(ch);

        //if node does not exists in map then create one and put it into map
        if (node == null) {
            node = new TrieNode();
            current.children.put(ch, node);
        }
        insertRecursive(node, word, index + 1);
    }

    public boolean searchRecursive(String word) {
        return searchRecursive(root, word, 0);
    }

    private boolean searchRecursive(TrieNode current, String word, int index) {
        if (index == word.length()) {
            //return true of current's endOfWord is true else return false.
            return current.endOfWord;
        }
        char ch = word.charAt(index);
        TrieNode node = current.children.get(ch);
        //if node does not exist for given char then return false
        if (node == null) {
            return false;
        }
        return searchRecursive(node, word, index + 1);
    }
}
