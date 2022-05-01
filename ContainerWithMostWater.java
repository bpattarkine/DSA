class ConatinerWithMostWater {
    public int maxArea(int[] height) {
        int leftIndex = 0;
        int rightIndex = height.length - 1;
        int maxVolume = 0;
        while(leftIndex < rightIndex) {
            int leftheight = height[leftIndex];
            int rightHeight = height[rightIndex];
            int minHeight = Math.min(leftheight, rightHeight);
            int distance = rightIndex - leftIndex;
            int volume = minHeight * distance;
            maxVolume = Math.max(maxVolume, volume);
            if(leftheight < rightHeight ) {
                leftIndex++;
            }else {
                rightIndex--;
            }

        }

        return maxVolume;
    }
}