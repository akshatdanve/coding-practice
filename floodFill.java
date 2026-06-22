class Solution {
    public int[][] FloodFill(int[][] image, int sr, int sc, int color) {
        int originalColor = image[sr][sc];

        // If the original color is already the target color, no need to do anything
        if (originalColor == color) {
            return image;
        }

        dfs(image, sr, sc, originalColor, color);
        return image;
    }

    void dfs(int[][] image, int sr, int sc, int originalColor, int color) {
        int m = image.length;
        int n = image[0].length;

        // Boundary check
        if (sr < 0 || sc < 0 || sr >= m || sc >= n) {
            return;
        }

        // Stop if the current cell is not of the original color
        if (image[sr][sc] != originalColor) {
            return;
        }

        // Change the color
        image[sr][sc] = color;

        // Explore all 4 directions
        dfs(image, sr + 1, sc, originalColor, color);
        dfs(image, sr - 1, sc, originalColor, color);
        dfs(image, sr, sc + 1, originalColor, color);
        dfs(image, sr, sc - 1, originalColor, color);
    }
}
