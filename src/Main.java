import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(" введите количество строк (нечетное, >= 5): ");
        int rows = scanner.nextInt();
        System.out.print(" введите количество столбцов (нечетное, >= 5): ");
        int cols = scanner.nextInt();
        Maze maze = new Maze(rows, cols);
        maze.generateMaze();
        System.out.println("сгенерированный лабиринт:");
        maze.printMaze();
        MazeSolver solver = new MazeSolver(maze);
        if (solver.solve()) {
            System.out.println("путь найден:");
            maze.printMaze();
        } else {
            System.out.println("путь не найден.");
        }
        scanner.close();
    }
}
