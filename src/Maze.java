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
    public void generateMaze() {
        dfsGenerate(1, 1);
        grid[1][1] = PATH; // старт
        grid[rows - 2][cols - 2] = PATH;
    }
    private void dfsGenerate(int x, int y) {
        grid[x][y] = PATH;
        int[] dx = {0, 0, -2, 2};
        int[] dy = {-2, 2, 0, 0};
        int[] order = {0, 1, 2, 3};
        for (int i = 0; i < order.length; i++) {
            int j = random.nextInt(order.length);
            int temp = order[i];
            order[i] = order[j];
            order[j] = temp;
        }
        for (int i : order) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (isInBounds(nx, ny) && grid[nx][ny] == WALL) {
                grid[x + dx[i] / 2][y + dy[i] / 2] = PATH;
                dfsGenerate(nx, ny);
            }
        }
    }
    private boolean isInBounds(int x, int y) {
        return x > 0 && y > 0 && x < rows - 1 && y < cols - 1;
    }


    public void printMaze() {
            for (char[] row : grid) {
                for (char c : row) {
                    System.out.print(c);
                }
                System.out.println();
            }
        }

    }

