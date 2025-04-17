public class MazeSolver {
    private final Maze maze;
    private final char[][] grid;
    private final int rows;
    private final int cols;
    public MazeSolver(Maze maze) {
        this.maze = maze;
        this.grid = maze.getGrid();
        this.rows = grid.length;
        this.cols = grid[0].length;
    }
    public boolean solve() {
        return dfs(1, 1);
    }
    private boolean dfs(int x, int y) {
        if (!isInBounds(x, y) || grid[x][y] != Maze.PATH) {
            return false;
        }
        if (x == rows - 2 && y == cols - 2) {
            grid[x][y] = Maze.VISITED_PATH;
            return true;
        }
        grid[x][y] = Maze.VISITED_PATH;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int i = 0; i < 4; i++) {
            if (dfs(x + dx[i], y + dy[i])) {
                return true;
            }
        }
        grid[x][y] = Maze.PATH;
        return false;
    }
    private boolean isInBounds(int x, int y) {
        return x >= 0 && y >= 0 && x < rows && y < cols;
    }
}
