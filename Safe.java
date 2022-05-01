
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Safe {

    public static void main(String[] args) {

        Map<Integer, List<Integer>> adjs = new HashMap<>();

        adjs.put(2, List.of(7,9));
        adjs.put(7, List.of(2,6));
        adjs.put(6, List.of(7));
        adjs.put(9, List.of(2,4));
        adjs.put(4, List.of(9,3));
        adjs.put(3, List.of(4,8));
        adjs.put(8, List.of(4));

        System.out.println("----");
        System.out.println(findCombos(2, 1, 4, adjs));
        System.out.println("----");
        Map<String, Integer> cache = new HashMap<>();
        System.out.println(findCombosMemoized(2, 1, 4, adjs,cache ));
        System.out.println("----");
        List<Integer> value = new ArrayList<>();
        value.add(2);
       findComboValues(2, value, 4, adjs);
    }


    static int findCombos(int current, int distance, int targetLength, Map<Integer, List<Integer>> adjs ){
        if (distance == targetLength){
            return 1;
        }

        List<Integer> children = adjs.get(current);
        int count = 0;

        for(Integer child : children){
            count+= findCombos(child, distance+1, targetLength, adjs);
        }
       return count;
    }

    static int findCombosMemoized(int current, int distance, int targetLength, Map<Integer, List<Integer>> adjs , Map<String, Integer> cache ){

        String key = current+"_"+ distance;
        if (cache.containsKey(key)){
            return cache.get(key);
        }
        if (distance == targetLength){
            return 1;
        }

        List<Integer> children = adjs.get(current);
        int count = 0;

        for(Integer child : children){
            count+= findCombosMemoized(child, distance+1, targetLength, adjs, cache);
        }
        cache.put(key, count);
        return count;
    }

    static void findComboValues(int current, List<Integer> value, int targetLength, Map<Integer, List<Integer>> adjs ){
        if (value.size() == targetLength){
            System.out.println(value);
            return;
        }

        List<Integer> children = adjs.get(current);

        for(Integer child : children){
            value.add(child);
            findComboValues(child, value , targetLength, adjs);
            value.remove(value.size()-1);
        }
    }
}