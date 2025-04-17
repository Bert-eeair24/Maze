
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
}