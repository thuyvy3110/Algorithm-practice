//https://leetcode.com/problems/longest-word-in-dictionary


//Test case [1]
//Input : ["a","banana","app","appl","ap","apply","apple"]
//Output : "banana"
//Expected : "apple"

//Test case [2]
//Input : ["m","mo","moc","moch","mocha","l","la","lat","latt","latte","c","ca","cat"]
//Output : "cat"
//Expected : "latte"


class Solution {
    private static int R = 256; // radix
    private Node root;
    
    public static class Node
    {
        private Node[] next = new Node[R];
        private boolean isEnd;
    }
    
    public String longestWord(String[] words) {
        for (String word : words) {
            insert(word);
        }
    
        String temp = "";
        for (String word : words) {
            int count = search(root, word, 0, 0);
            if (count == word.length()) {
                if (temp.length() < word.length()) {
                    temp = word;
                } else if (temp.length() == word.length()) {
                    temp = (temp.compareTo(word) > 0) ? word : temp;
                }
            }
        }
        return temp;
    }
    
    public int search(Node node, String word, int index, int count) {
        if (node == null) {
            return count;
        }
        if(node.isEnd) {
            count++;
        }
        if (index == word.length()) {
            return count;
        }
        char c = word.charAt(index);
        return search(node.next[c], word, index+1, count);
    }
    
    public void insert(String word)
    {
        root = insert(root, word, 0);
    }
    
    public Node insert(Node node, String word, int index)
    {
        if (node == null) {
            node = new Node();
        }
        if (index == word.length()) {
            node.isEnd = true;
            return node;
        }
        char c = word.charAt(index);
        node.next[c] = insert(node.next[c], word, index+1);
        return node;
    }
}
