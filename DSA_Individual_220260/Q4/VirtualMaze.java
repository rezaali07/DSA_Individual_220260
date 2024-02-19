
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class VirtualMaze {

    // public int minMovesToCollectKeys(char[][] grid) {
    // int m = grid.length;
    // int n = grid[0].length;

    // Set<Character> collectedKeys = new HashSet<>();
    // int[] start = null;
    // int[] end = null;
    // int keysCount = 0;

    // for (int i = 0; i < m; i++) {
    // for (int j = 0; j < n; j++) {
    // if (grid[i][j] == 'S') {
    // start = new int[] { i, j, 0 }; // x, y, moves
    // } else if ('a' <= grid[i][j] && grid[i][j] <= 'f') {
    // keysCount++;
    // } else if (grid[i][j] == 'E') {
    // end = new int[] { i, j, 0 };
    // }
    // }
    // }

    // Queue<int[]> queue = new ArrayDeque<>();
    // Set<String> visited = new HashSet<>();

    // queue.offer(start);
    // visited.add(start[0] + "," + start[1]);
    // if (end == null) {
    // System.out.println("End does not exist");
    // return -1;
    // }

    // while (!queue.isEmpty()) {
    // int[] current = queue.poll();
    // int x = current[0], y = current[1], moves = current[2];

    // if (collectedKeys.size() == keysCount && grid[x][y] == 'E') {
    // return moves;
    // }

    // /*
    // *
    // * 0 1
    // * 0 -1
    // * 1 0
    // * -1 0
    // *
    // */

    // int[][] directions = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
    // for (int[] dir : directions) {
    // int nx = x + dir[0];
    // int ny = y + dir[1];

    // if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] != 'W') {
    // char cell = grid[nx][ny];

    // if ('a' <= cell && cell <= 'f') {
    // collectedKeys.add(cell);
    // } else if ('A' <= cell && cell <= 'F' &&
    // collectedKeys.contains(Character.toLowerCase(cell))) {
    // // Check if the corresponding key is collected
    // queue.offer(new int[] { nx, ny, moves + 1 });
    // visited.add(nx + "," + ny);
    // } else if (cell == 'P' || cell == 'E') {
    // queue.offer(new int[] { nx, ny, moves + 1 });
    // visited.add(nx + "," + ny);
    // }
    // }
    // }
    // }

    // return -1;
    // }

    // public static void main(String[] args) {
    // char[][] grid = { { 'S', 'P', 'P', 'P' }, { 'W', 'P', 'P', 'E' }, { 'P', 'b',
    // 'W', 'P' },
    // { 'P', 'P', 'P', 'P' } };

    // // for (int i = 0; i < grid.length; i++) {
    // // for (int j = 0; j < grid[0].length; j++) {
    // // System.out.print("i"+i+",j"+j + "\t");
    // // }
    // // System.out.println();
    // // }

    // VirtualMaze vm = new VirtualMaze();
    // System.out.println(vm.minMovesToCollectKeys(grid));
    // }

    // 2d matrix representinfg a maze then
    // an array to check if i have the key or not
    // use that keyarray to check if i can get the next key
    int[][] directions = {
            { 0, 1 }, // Right
            { 0, -1 }, // Left
            { 1, 0 }, // Up
            { -1, 0 } // Down
    };

    // void move based on key locations

    // determine if navigable by getting any key then check if key is accesible

    public int minMovesToCollectKeys(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Set<Character> collectedKeys = new HashSet<>();
        int[] start = null;
        int[] end = null;
        int keysCount = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'S') {
                    start = new int[] { i, j, 0 }; // x, y, moves
                } else if ('a' <= grid[i][j] && grid[i][j] <= 'f') {
                    keysCount++;
                } else if (grid[i][j] == 'E') {
                    end = new int[] { i, j, 0 };
                }
            }
        }

        Queue<int[]> queue = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();

        queue.offer(start);
        visited.add(start[0] + "," + start[1]);
        if (end == null) {
            System.out.println("End does not exist");
            return -1;
        }

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0], y = current[1], moves = current[2];

            if (collectedKeys.size() == keysCount && grid[x][y] == 'E') {
                return moves;
            }

            for (int[] dir : directions) {
                int nx = x + dir[0];
                int ny = y + dir[1];

                if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] != 'W') {
                    char cell = grid[nx][ny];

                    if ('a' <= cell && cell <= 'f') {
                        collectedKeys.add(cell);
                    } else if ('A' <= cell && cell <= 'F' &&
                            collectedKeys.contains(Character.toLowerCase(cell))) {
                        // Check if the corresponding key is collected
                        queue.offer(new int[] { nx, ny, moves + 1 });
                        visited.add(nx + "," + ny);
                    } else if (cell == 'P' || cell == 'E') {
                        queue.offer(new int[] { nx, ny, moves + 1 });
                        visited.add(nx + "," + ny);
                    }
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        char[][] grid = { { 'S', 'P', 'P', 'P' }, { 'W', 'P', 'P', 'E' }, { 'P', 'b',
                'W', 'P' },
                { 'P', 'P', 'P', 'P' } };

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j] + "\t");
            }
            System.out.println();
        }

        VirtualMaze vm = new VirtualMaze();
        System.out.println(vm.minMovesToCollectKeys(grid));
    }

}
