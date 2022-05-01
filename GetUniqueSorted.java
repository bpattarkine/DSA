public class GetUniqueSorted {

  public static String getUniqueSorted(String input) {
 /*
 given: helloworld

returns: dehlorw

  */
    int[] frequency = new int[26];
    String ouput = "";
    for (char c : input.toCharArray()) {
      frequency[c - 'a']++;
    }

    for (int i = 0; i < 26; ++i) {
      if (frequency[i] > 0)
      {
        char c = (char) (i + 'a');
        ouput = ouput + c ;
      }

    }
 return  ouput;

  }

    public static void main(String[] args) {

    System.out.println(getUniqueSorted("helloworld"));
    }

}
