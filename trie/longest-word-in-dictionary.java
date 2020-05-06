//https://leetcode.com/problems/longest-word-in-dictionary

//Wrong Answer
//Input : ["a","banana","app","appl","ap","apply","apple"]
//Output : "banana"
//Expected : "apple"
// todo: Find the smallest lexicographical order.

class Solution {
    
    private static int R = 256; // radix
    private Node root;
    
    private static class Node
    {
        private Object val;
        private Node[] next = new Node[R];
    }
    
    public String longestWord(String[] words) {
        int maxLength = 0;
        int length;
        
        Map<Integer, String> mapWords = new HashMap<Integer, String> ();  

        for (String word : words) {
            put(word);
            String a = "";
            length = search(root, word, 0, 0);
            a = word.substring(0, length);
            mapWords.put(length, a);
        }
        
        int maxValueInMap=(Collections.max(mapWords.keySet()));

        return mapWords.get(maxValueInMap);
    }
    
    private int search(Node x, String word, int d, int length) {
        if (x == null) 
            return length;
        length = d;
        if (d == word.length()) 
            return length;
        char c = word.charAt(d);
        
        return search(x.next[c], word, d+1, length);
    }
    
    public void put(String key)
    {  
        root = put(root, key, 0);  
    }
    
    private Node put(Node x, String key, int d)
    {
        if (x == null) 
            x = new Node();
        if (d == key.length()) { 
            return x; 
        }
        char c = key.charAt(d); 
        x.next[c] = put(x.next[c], key, d+1);
        return x;
    }
}
