import java.lang.Math;
public class Snail {

    /**
     *
     * TODO 5
     *
     * Input: an n x n 2d array.
     * Output: a 1d array of length n^2 that contains the order of elements visited in a snail traversal of the 2d array.
     *
     * Example:
     *
     * Input:
     *
     * {
     *     {1,2,3},
     *     {4,5,6},
     *     {7,8,9}
     * }
     *
     * Output:
     *
     * {1,2,3,6,9,8,7,4,5}
     *
     * @param array2d
     * @return a 1d array containing the order of elements visited in a snail traversal of the 2d array.
     *         returns an empty array if array2d is not square.
     */
    public static int[] flattenSnail(int[][] array2d) {
        if (!isPerfectSquare(array2d)){
            int[] asdf = new int[0];
            return asdf;
        }

        int[] result = new int [array2d.length * array2d.length];
        int y = 0;
        int x = 0;
        int index = 0;
        int direction = 0; // 0 left, 1 down, 2 right, 3, up
        int horizontalBoundLeft = -1;
        int horizontalBoundRight = array2d.length;
        int verticalBoundUp = 0;
        int verticalBoundDown = array2d.length;

        while (index < result.length){
            result[index] = array2d[y][x];
            if (direction == 0 && x == horizontalBoundRight - 1) {
                direction++;
                horizontalBoundRight--;
            }
            else if (direction == 1 && y == verticalBoundDown - 1) {
                direction++;
                verticalBoundDown--;
            }
            else if (direction == 2 && x == horizontalBoundLeft + 1){
                direction++;
                horizontalBoundLeft++;
            }
            else if (direction == 3 && y == verticalBoundUp + 1) {
                direction = 0;
                verticalBoundUp++;
            }
            switch (direction){
                case 0:
                    x ++;
                    break;
                case 1:
                    y++;
                    break;
                case 2:
                    x--;
                    break;
                case 3:
                    y--;
                    break;
                default:
                    break;
            }
            index++;
        }

        return result;
    }

    /**
     *
     * TODO 6
     *
     * Input: a 1d array of length n, where n is a perfect square.
     * Output: a 2d array of width == height == sqrt(n) that represents a snail.
     *
     * Example:
     *
     * Input:
     *
     * {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25};
     *
     * Output:
     *
     * {
     *     {1,2,3,4,5},
     *     {16,17,18,19,6},
     *     {15,24,25,20,7},
     *     {14,23,22,21,8},
     *     {13,12,11,10,9},
     * }
     *
     *
     * @param array1d
     * @return a 2d array of width == height == sqrt(n), where n is the length of the inputted array, that represents a snail.
     *         returns an empty 2d array if the length of array1d is not a perfect square.
     */
    public static int[][] makeSnail(int[] result) {
        if (!isPerfectSquare(result)){
            int[][] asdf = new int[0][0];
            return asdf;
        }

        int[][] array2d = new int[(int) Math.sqrt(result.length)][(int) Math.sqrt(result.length)];
        int y = 0;
        int x = 0;
        int index = 0;
        int direction = 0; // 0 left, 1 down, 2 right, 3, up
        int horizontalBoundLeft = -1;
        int horizontalBoundRight = array2d.length;
        int verticalBoundUp = 0;
        int verticalBoundDown = array2d.length;

        while (index < result.length){
            array2d[y][x] = result[index];
            if (direction == 0 && x == horizontalBoundRight - 1) {
                direction++;
                horizontalBoundRight--;
            }
            else if (direction == 1 && y == verticalBoundDown - 1) {
                direction++;
                verticalBoundDown--;
            }
            else if (direction == 2 && x == horizontalBoundLeft + 1) {
                direction++;
                horizontalBoundLeft++;
            }
            else if (direction == 3 && y == verticalBoundUp + 1) {
                direction = 0;
                verticalBoundUp++;
            }

            switch (direction){
                case 0:
                    x ++;
                    break;
                case 1:
                    y++;
                    break;
                case 2:
                    x--;
                    break;
                case 3:
                    y--;
                    break;
                default:
                    break;
            }
            index++;
        }

        return array2d;
    }

    /**
     *
     * TODO 1
     *
     * Private helper method that prints the contents of a 1d array.
     * Used mainly for debugging purposes.
     *
     * @param array1d
     */
    private static void print1dArray(int[] array1d) {
        for (int i : array1d)
            System.out.println(i);
    }

    /**
     *
     * TODO 2
     *
     * Private helper method that prints the contents of a 2d array.
     * Used mainly for debugging purposes.
     *
     * @param array2d
     */
    private static void print2dArray(int[][] array2d) {
        for (int[] row : array2d){
            print1dArray(row);
        }
    }

    /**
     *
     * TODO 3
     *
     * Private helper method that checks to see if a 1d array is of a length that is a perfect square.
     *
     * @param array1d
     * @return
     */
    private static boolean isPerfectSquare(int[] array1d) {
        if (array1d == null) return false;
        if (Math.sqrt(array1d.length) % 1 == 0)
            return true;
        return false;
    }


    /**
     *
     * TODO 4
     *
     * Private helper method that checks to see if a 2d array is a square.
     *
     * @param array2d
     * @return
     */
    private static boolean isPerfectSquare(int[][] array2d) {
        if (array2d == null) return false;
        int height = array2d.length;
        for (int[] row : array2d)
            if (row.length != height)
                return false;
        return true;
    }


}
