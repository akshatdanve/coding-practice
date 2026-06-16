class numberOfIslands {

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] vis = new boolean[m][n];
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                // Found an unvisited piece of land
                if (grid[i][j] == '1' && !vis[i][j]) {
                    dfs(grid, vis, i, j);
                    count++;
                }
            }
        }

        return count;
    }

    private void dfs(char[][] grid, boolean[][] vis, int row, int col) {
        int m = grid.length;
        int n = grid[0].length;

        // Out of bounds
        if (row < 0 || row >= m || col < 0 || col >= n) {
            return;
        }

        // Water or already visited
        if (grid[row][col] == '0' || vis[row][col]) {
            return;
        }

        // Mark current cell as visited
        vis[row][col] = true;

        // Explore all 4 directions
        dfs(grid, vis, row - 1, col); // Up
        dfs(grid, vis, row + 1, col); // Down
        dfs(grid, vis, row, col - 1); // Left
        dfs(grid, vis, row, col + 1); // Right
    }
}
