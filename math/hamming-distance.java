//https://leetcode.com/problems/hamming-distance
//Success 
//Runtime: 0 ms, faster than 100.00% of Java online submissions for Hamming Distance.
//Memory Usage: 36.4 MB, less than 5.09% of Java online submissions for Hamming Distance.

class Solution {
    static int N = 32;
    public int hammingDistance(int x, int y) {
      int[] b1 = new int[N];
      int[] b2 = new int[N];
      
      b1 = convertIntToBinary(x, b1);
      b2 = convertIntToBinary(y, b2);
      
      int count = 0;
      for(int i = 0; i < N; i++) {
        if(b1[i] != b2[i])
          count++;
      }
      return count;
    }
  
    public int[] convertIntToBinary(int b, int[] e) {
      int i = 0;
      while(b != 0) {
        e[i] = b%2;
        b = b/2;
        i++;
      }
      return e;
    }
  
    public int[] convertIntToBinaryRecursive(int b, int i, int[] e) {
      e[i] = b%2;
      if (b/2 == 0) {
        return e;
      }
      return convertIntToBinaryRecursive(b/2, i + 1, e);
    } 
}


