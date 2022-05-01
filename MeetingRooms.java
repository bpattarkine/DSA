import java.util.Arrays;
import java.util.TreeMap;

class MeetingRooms {
    public static int minMeetingRooms(int[][] intervals) {

        int len = intervals.length;
        int[] startTime = new int[len];
        int[] endTime = new int[len];
        int index = 0;
        for(int[] interval: intervals){
            startTime[index] = interval[0];
            endTime[index++] = interval[1];
        }
        Arrays.sort(startTime);
        Arrays.sort(endTime);
        int i = 0, j = 0;
        int activate = 0, max = 0;
        while(i < len && j < len){
            if(startTime[i] < endTime[j]){
                activate++;
                i++;
            }else{
                activate--;
                j++;
            }
            max = Math.max(max, activate);
        }
        return max;
    }

    public static  int minMeetingRoomsTreeMap(int[][] intervals) {
        TreeMap<Integer, Integer> tmap = new TreeMap<>();
        int ans = 0, cnt = 0;
        for (int[] interval : intervals) {
            int start = interval[0], end = interval[1];
            tmap.put(start, tmap.getOrDefault(start, 0) + 1);
            tmap.put(end, tmap.getOrDefault(end, 0) - 1);
        }

        System.out.println("map = " + tmap);

        for (int k : tmap.keySet()) {
        System.out.println( " get value " + tmap.get(k) + " k= " +k) ;
            cnt += tmap.get(k);
             System.out.println( " count " + cnt);
            ans = Math.max(ans, cnt);
            System.out.println( " ans " + ans);
        }
        return ans;
    }
    public static void main(String[] args) {

    int [][] sample = new int[][] {{0, 30},{5, 10}, {15, 20}};

    System.out.println(minMeetingRoomsTreeMap(sample));
    System.out.println(minMeetingRooms(sample));

    }


}