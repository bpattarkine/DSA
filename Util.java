import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class Util {

  private Util() {
  }

  public static int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {
      int complement = target - nums[i];
      if (map.containsKey(complement)) {
        return new int[]{i, map.get(complement)};
      }
      map.put(nums[i], i);
    }

    return new int[]{-1};
  }

  public static int numSubarrayBoundedMax(int[] A, int L, int R) {

    int result = 0, start = -1, end = -1;

    for (int i = 0; i < A.length; i++) {
      if (A[i] > R) {
        start = i;
      }
      if (A[i] >= L) {
        end = i;
      }
      result = result + end - start;
    }
    return result;
  }

  public static String intersection(final String string1, String string2) {
    HashSet<Character> hashset1 = new HashSet<Character>();
    HashSet<Character> output = new HashSet<Character>();
    for (char c : string1.toCharArray()) {
      hashset1.add(c);
    }
    for (char c : string2.toCharArray()) {
      if (hashset1.contains(c)) {
        output.add(c);
      }
    }
    return output.toString();
  }

  public static String union(final String string1, String string2) {
    HashSet<Character> hashset1 = new HashSet<Character>();
    HashSet<Character> output = new HashSet<Character>();
    for (char c : string1.toCharArray()) {
      hashset1.add(c);
    }
    for (char c : string2.toCharArray()) {
      output.add(c);
    }
    return output.toString();
  }

  public static List<Integer> findDuplicates(int[] nums) {
    List<Integer> output = new ArrayList();
    for (int i = 0; i < nums.length; ++i) {
      int index = nums[i] - 1;
      if (nums[index] < 0) {
        output.add(index + 1);
      }
    }

    return output;
  }

  public static tree invert(tree root) {

    if (root == null) {
      return null;
    }

    tree left = invert(root.left);
    tree right = invert(root.right);

    root.left = right;
    root.right = left;

    return root;


  }

  public static void transform(char[] input) {

    int space = 0;
    for (int i = 0; i < input.length; ++i) {
      if (input[i] == 'a') {
        for (int j = i; j < input.length - 1; ++j) {
          input[j] = input[j + 1];
        }
        input[input.length - 1] = '$';
        --i;
        ++space;
      }
    }
    System.out.println(input);
    System.out.println(space);

    for (int i = 0; i < input.length; ++i) {
      if (input[i] == 'b') {
        --space;
      }
    }
    if (space < 0) {
      System.out.println("NOT enough space");
      return;
    }

    for (int i = 0; i < input.length; ++i) {
      if (input[i] == 'b') {
        ++i;
        for (int j = input.length - 1; j >= i; j--) {
          //Shift element of array by one
          input[j] = input[j - 1];
        }

      }

    }
  }

  public static String compress(char[] chars) {
    // validation
    String output = chars[0] + "";
    int charCount = 1;
    for (int i = 1; i < chars.length; i++) {
      char cuurentChar = chars[i];
      char prevCharChar = chars[i - 1];
      if (cuurentChar == prevCharChar) {
        charCount++;
        if(charCount >= 9) {
          output +=   charCount;
          output += cuurentChar;
          charCount = 1;
          i++;

        }
      } else {
        if (charCount > 1) {
          output += charCount;
          charCount = 1;
        }
        output += cuurentChar;
      }
    }
    if (charCount > 1 ) {
      output += charCount;
    }

    return output;

}


  void printLeftview(boolean[] levels, tree root, int curr) {
    if (root == null) {
      return;
    }

    if (levels[curr] == false) {
      levels[curr] = true;
      //cout<<root->data<<" ";
      //print
    }
    printLeftview(levels, root.left, curr + 1);    //left child called
    printLeftview(levels, root.right, curr + 1);   //right child called
  }

  void leftView(tree root) {
    // Max height of tree assumed to be 100
    //Therefore for skew tree, max levels = 100
    boolean[] levels = new boolean[200];
    printLeftview(levels, root, 0);
  }

class tree {

  tree left, right;
  int val;

  tree(int val) {
    left = null;
    right = null;
    this.val = val;
  }
}


}
