public class Atoi {


  public static void main(String[] args) {

    System.out.println(myAtoi("-91283472332"));
  }

  public static int myAtoi(String s) {

    int sign = 1;

    int answer = 0;
    for (int i = 0; i < s.length(); ++i) {

      if (s.charAt(i) == ' ') {
        continue;
      }
      if (s.charAt(i) == '-') {
        sign = -1;
        continue;
      }

      if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
        answer = (answer * 10) + s.charAt(i) - '0';

        if (answer * sign >= Integer.MAX_VALUE) {
          return Integer.MAX_VALUE;
        }
        System.out.println("answer * sign " + answer * sign);
        if (answer * sign <= Integer.MIN_VALUE) {

          System.out.println("min");
          return Integer.MIN_VALUE;
        }

        continue;
      }
      break;
    }
    System.out.println("end");
    return answer * sign;
  }

}
