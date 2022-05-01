class CountPalendromicSubstrings {
    public int countSubstrings(String s) {
        int len = s.length();
         boolean[][] subString = new boolean[len][len];
         int result = 0;
        for (int g = 0; g < len; ++ g) {
            for(int i = 0, j = g; j < len; i++, j++) {
                // 1 length chars
                if(g == 0) {
                    subString[i][j] = true;
                }
                else if(g == 1){
                    if(s.charAt(i) == s.charAt(j)){
                         subString[i][j] = true;
                    }else {
                         subString[i][j] = false;
                    }
                }else {
                    if(s.charAt(i) == s.charAt(j) && subString[i+1][j-1]) {
                        subString[i][j] = true;
                    }else{
                        subString[i][j] = false;
                    }
                }
                if(subString[i][j]) {
                    result++;
                }
            }
        }
        return result;
    }
}