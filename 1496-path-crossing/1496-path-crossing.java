class Solution {
    public boolean isPathCrossing(String path) {
        Set<String> set = new HashSet<>();
        //NSEW
        int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int x = 0;
        int y = 0;
        set.add((x+"-"+y));
        for(char c : path.toCharArray()) {
            switch(c) {
                case 'N':
                    x += dir[0][0];
                    y += dir[0][1];
                    break;
                case 'S':
                    x += dir[1][0];
                    y += dir[1][1];
                    break;
                case 'E':
                    x += dir[2][0];
                    y += dir[2][1];
                    break;
                case 'W':
                    x += dir[3][0];
                    y += dir[3][1];
                    break;
                default:
                    break;
            }
            String st = x+"-"+y;
            if(set.contains(st)) return true;
            set.add(st);
        }
        return false;
    }
}