import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;

class LFUCache {

/* This problem tests your understanding of system design and data structures.

The first challenge is to understand what stateful things you need to keep track of.
In this case we need:
    1. To store a key and it's value
    2. To store the frequency that the key shows up
    3. To store the order of key recency with respect to frequency

The next challenge is to decide on the proper data structures.
If you brushed up on DS, the O(1) restrictions give an intuitive hint that we'll be using maps.

Here's the easy part:
We'll use a plain map for mapping a key to a value.
We'll use another map for mapping a key to a frequency.
This satisfies adding entries in O(1) time.

Here's the hard part (This part of the problem tests your knowledge of map's underlying implementation):

How can we get the least frequent entries in O(1) instead of linearly searching?
By using a map DS that uses a natural ordering scheme for the order of it's keys!
In this case, a TreeMap does just that.
Logically, we can grab the first key and have guaranteed certainty that we're grabbing keys of the minimum frequency.

Now we need to pick a DS for storing entries in the frequency map above.
Referring back to the instructions, if we have a tie for least frequent element we default to LRU scheme to break the tie.
Now we need a map that preserves insertion order.
This time we will use a LinkedHashMap.
Logically, if I were to iterate over the keys of this map, they would appear in the order that I inserted them.

*/
int capacity;
int current = 0;
HashMap<Integer, Integer> valueMap = new HashMap<Integer, Integer>();
HashMap<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();
TreeMap<Integer, LinkedHashMap<Integer, Integer>> map = new TreeMap<Integer, LinkedHashMap<Integer, Integer>>();

public LFUCache(int capacity) {
    this.capacity = capacity;
    LinkedHashMap<Integer, Integer> zeroFrequency = new LinkedHashMap<Integer, Integer>();
    map.put(0, zeroFrequency);
}

/*
    1. We need to check if we're updating an existing entry or if this is a brand new key
    2. If we're at capacity and we're NOT updating an existing key:
        2a. Get the minimum frequency from the recency map
        2b. Grab it's least recent entry
        2c. Use that value to delete the key from all maps
    3. Conditionally update the capacity param if needed
    4. Set the K:V in the value Map
    5. Update the recency map
    6. Either update or initialize in the frequency map
*/
public void put(int k, int v) {
	if(this.capacity < 1){
        return;
    }

	int frequency = 0;
	boolean updateExisting = frequencyMap.containsKey(k);
	if(updateExisting) {
		frequency += frequencyMap.get(k);
	}

	if(this.current == this.capacity && !updateExisting) {
		HashMap<Integer, Integer> leastFrequent = map.get(map.firstKey());
		int leastRecentKey = leastFrequent.keySet().iterator().next();

		valueMap.remove(leastRecentKey);
		frequencyMap.remove(leastRecentKey);
		leastFrequent.remove(leastRecentKey);
	}

	if(this.current < this.capacity && !updateExisting) {
		this.current++;
	}

	valueMap.put(k, v);
	updateRecencyMap(k);
	frequencyMap.put(k, frequency+1);
}
/*
    1. If we're not storing this key return -1
    2. We need to update the recency map for this key entry to frequency + 1
    3. Update the frequency map + 1
    4. Return the value
*/
public int get(int k) {
	if(!valueMap.containsKey(k)) {
		return -1;
	}

	updateRecencyMap(k);

	int frequency = frequencyMap.get(k);
	frequencyMap.put(k, frequency + 1);

	return valueMap.get(k);
}

/*
    In this function we update the recency map:
    1. If the key already has a frequency entry we need to remove said entry
    2. If the frequency map of said entry is empty we need to remove it to preserve order
    3. If the recency map is dealing with a new frequency, we need to add a map entry
    4. Lastly add a recency entry for k in the new frequency
*/
public void updateRecencyMap(int k) {
	int frequency = frequencyMap.getOrDefault(k, 0);

	if(map.containsKey(frequency) && map.get(frequency).containsKey(k)) {
		map.get(frequency).remove(k);
	}

	if(map.containsKey(frequency) && map.get(frequency).isEmpty()) {
		map.remove(frequency);
	}

	if(!map.containsKey(frequency+1)) {
		LinkedHashMap<Integer, Integer> nextFrequency = new LinkedHashMap<Integer, Integer>();
		map.put(frequency+1, nextFrequency);
	}

	map.get(frequency+1).put(k, k);
}
}