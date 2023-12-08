import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Task12 {
//    int n;
//    int[][] field;
//    int stepNum = 0;
//
//    public Task12(int n) {
//        this.n = n;
//        this.field = new int[n][n];
//    }
//
//
//
//    public boolean isValid(int row, int col) {//ячейка пустая и находится внутри поля
//        if (row < 0 || col < 0 || row >= n || col >= n || field[row][col] != 0) {
//            return false;
//        }
//        return true;
//    }
//
//    public boolean move(int row, int col, int count) {
//        stepNum++;
//
//        if (!isValid(row, col)) {
//            return false;
//        }
//
//        if (count == (n * n)){ // Счетчик достиг конца поля
//            return true;
//        }
//
//        field[row][col] = count; // заполняем ячейку значением счетчика
//
//        if (field[row][col] == 0) {
//            return false;
//        }
//
//        if (field[row][col] != 0) {//проверка возможности/невозможности каждого возможного хода
//            for (int i = 0; i < 8; i++) {
//                // массив вариантов ходов "конем" по координатам
//                int[] X = { 2, 1, -1, -2, -2, -1, 1, 2 };
//                int[] Y = { 1, 2, 2, 1, -1, -2, -2, -1 };
//
//                // позиция после хода
//                int x = row + X[i];
//                int y = col + Y[i];
//
//                if (move(x, y, count++)) {
//                    return true;
//                }
//            }
//        }
//        field[row][col] = 0;
//        return false;
//    }
//
//    public long getSteps(){//Кол-во сделанных ходов
//        return stepNum;
//    }
//
//    public void printField(){
//        for (int i = 0; i < field.length; i++) {
//            for (int j = 0; j < field[i].length; j++) {
//                System.out.print(field[i][j] + " ");
//            }
//            System.out.println();
//        }
//    }

    private int base = 12;
    private int[][] moves = {{1,-2},{2,-1},{2,1},{1,2},{-1,2},
            {-2,1},{-2,-1},{-1,-2}};
    private int[][] grid;
    private int total;

    public Task12() {

    }

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public int[][] getMoves() {
        return moves;
    }

    public void setMoves(int[][] moves) {
        this.moves = moves;
    }

    public int[][] getGrid() {
        return grid;
    }

    public void setGrid(int[][] grid) {
        this.grid = grid;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    private boolean solve(int r, int c, int count) {
        if (count > total)
            return true;

        List<int[]> nbrs = neighbors(r, c);

        if (nbrs.isEmpty() && count != total)
            return false;

        Collections.sort(nbrs, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[2] - b[2];
            }
        });

        for (int[] nb : nbrs) {
            r = nb[0];
            c = nb[1];
            grid[r][c] = count;
            if (!orphanDetected(count, r, c) && solve(r, c, count + 1))
                return true;
            grid[r][c] = 0;
        }

        return false;
    }

    private List<int[]> neighbors(int r, int c) {
        List<int[]> nbrs = new ArrayList<>();

        for (int[] m : moves) {
            int x = m[0];
            int y = m[1];
            if (grid[r + y][c + x] == 0) {
                int num = countNeighbors(r + y, c + x);
                nbrs.add(new int[]{r + y, c + x, num});
            }
        }
        return nbrs;
    }

    private int countNeighbors(int r, int c) {
        int num = 0;
        for (int[] m : moves)
            if (grid[r + m[1]][c + m[0]] == 0)
                num++;
        return num;
    }

    private boolean orphanDetected(int cnt, int r, int c) {
        if (cnt < total - 1) {
            List<int[]> nbrs = neighbors(r, c);
            for (int[] nb : nbrs)
                if (countNeighbors(nb[0], nb[1]) == 0)
                    return true;
        }
        return false;
    }

    private void printResult() {
        for (int[] row : grid) {
            for (int i : row) {
                if (i == -1) continue;
                System.out.printf("%2d ", i);
            }
            System.out.println();
        }
    }
}
