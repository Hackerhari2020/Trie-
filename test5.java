class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isEndOfWord;

    TrieNode() {
        isEndOfWord = false;
        for (int i = 0; i < 26; i++) {
            children[i] = null;
        }
    }

}

class Trie {
    TrieNode root = new TrieNode();

    public void Insert(String key) {

        TrieNode current = root;

        for (int i = 0; i < key.length(); i++) {
            int index = key.charAt(i) - 'a';

            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            if (i == key.length() - 1) {
                current.isEndOfWord = true;
            }
            current = current.children[index];

        }

        current.isEndOfWord = true;
    }

    public boolean Search(String key) {

        TrieNode current = root;

        for (int i = 0; i < key.length(); i++) {
            int index = key.charAt(i) - 'a';

            if (current.children[index] == null) {
                return false;
            }
            if (i == key.length() - 1 && current.children[index].isEndOfWord == false) {
                return false;
            }

            current = current.children[index];

        }
        return true;
    }

}

public class test5 {

    public static void main(String[] args) {
        Trie t = new Trie();
        t.root = new TrieNode();
        t.Insert("bad");
        t.Insert("bat");
        t.Insert("geek");
        t.Insert("geeks");
        t.Insert("cat");

        System.out.print(t.Search("cats"));
    }

}
