class Solution {
    public int[][] imageSmoother(int[][] img) {
        /*
        Y = p.X + r
        p = Y / X
        r = Y % X
        
        0 <= img[i][j] <= 255 -> so X = 256 
        as we want % to give no. till 255
        
        **/
        int m = img.length;
        int n = img[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int sum = 0;
                int count = 0;

                // Iterate over all plausible nine indices.
                for (int x = i - 1; x <= i + 1; x++) {
                    for (int y = j - 1; y <= j + 1; y++) {
                        // If the indices form valid neighbor
                        if (0 <= x && x < m && 0 <= y && y < n) {
                            //Extract the (original value = r) of (img[x][y] = Y).
                            sum += img[x][y] % 256;
                            count += 1;
                        }
                    }
                }
                
                // Encode the smoothed value in img[i][j].
                //Y = r + p.X
                img[i][j] = img[i][j] + ((sum / count) * 256);
            }
        }

        // Extract the smoothed value from encoded img[i][j].
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                img[i][j] /= 256;
            }
        }

        return img;
    }
}
