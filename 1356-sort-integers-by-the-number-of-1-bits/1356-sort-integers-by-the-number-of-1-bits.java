class Solution {
    public int[] sortByBits(int[] arr) {
        Integer[] nums = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(nums, new BitCompareComparator());
        return Arrays.stream(nums).mapToInt(Integer::intValue).toArray();
    }
}

class BitCompareComparator implements Comparator<Integer> {
    private int findWeight(int num) {
        int weight = 0;
        //7 = 0111
        //6 = 0110
        //0111 & 0110 = 0110
        while (num > 0) {
            weight++;
            num &= (num - 1);//remove right most bit from num
        }
        
        return weight;
    }
    
    @Override
    public int compare(Integer a, Integer b) {
        int bitsInA = findWeight(a);
        int bitsInB = findWeight(b);
        if (bitsInA == bitsInB) {
            return a - b;
        }
        
        return bitsInA - bitsInB;
    }
}