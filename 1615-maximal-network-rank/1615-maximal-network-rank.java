class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        int result = 0;
        int[] degrees = new int[n];
        for(int[] road : roads) {
            ++degrees[road[0]];
            ++degrees[road[1]];
        }
        //first & second most value of Degree of nodes
        int first = 0;
        int second = 0;
        //first & second will only hold diff values
        for(int degree : degrees) {
            if (degree > first) {
                second = first;
                first = degree;
            } else if (degree == first) {
                continue;
            } else if (degree > second) {
                second = degree;
            }
        }
        
        //count no.of nodes having same first & second values of Degree
        int firstCount = 0;
        int secondCount = 0;
        for(int degree : degrees) {
            if (degree == first) {
                ++firstCount;
            } else if (degree == second) {
                ++secondCount;
            }
        }
        //if one node is having first value degree 
        if (firstCount == 1) {
            //count roads which is having same first & second value degree nodes
            //for removing the common edge from network
            int count = 0;
            for(int[] road : roads) {
                if (degrees[road[0]] == first && degrees[road[1]] == second) {
                    ++count;
                } else if (degrees[road[1]] == first && degrees[road[0]] == second) {
                    ++count;
                }
            }
            //secondCount == count -> 
            //all second value degree nodes all connected with first degree nodes
            //There is no 2 nodes are not connected and have first & second degress
            return first + second - (secondCount == count ? 1 : 0);
        } else {//more than 2 first degree nodes
            int count = 0;
            for(int[] road : roads) {
                if (degrees[road[0]] == first && degrees[road[1]] == first) {
                    ++count;
                }
            }
            //firstCount * (firstCount - 1) / 2 > count -> 
            //all first degree nodes not connected with each other
            return first + first - (firstCount * (firstCount - 1) / 2 > count ? 0 : 1);
        }
    }
}