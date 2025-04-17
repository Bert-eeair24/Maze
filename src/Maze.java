import java.util.Random;
public class Maze {
    private final int rows;
    private final int cols;
    private final char[][] grid;
    private final Random random = new Random();
    public static final char WALL = '#';
    public static final char PATH = ' ';
    public static final char VISITED_PATH = '.';

    public Maze(int rows, int cols) {
        if (rows % 2 == 0) rows++;  // делаем нечетным
        if (cols % 2 == 0) cols++;
        this.rows = rows;
        this.cols = cols;
        this.grid = new char[rows][cols];
        initMaze();
    }

    private void initMaze() {
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                grid[i][j] = WALL;
    }

    }
