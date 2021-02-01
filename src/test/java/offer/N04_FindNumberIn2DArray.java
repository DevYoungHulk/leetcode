package offer;

import org.junit.Assert;
import org.junit.Test;

public class N04_FindNumberIn2DArray {
    @Test
    public void test() {
        int[][] matrix = {
                new int[]{1, 4, 7, 11, 15},
                new int[]{2, 5, 8, 12, 19},
                new int[]{3, 6, 9, 16, 22},
                new int[]{10, 13, 14, 17, 24},
                new int[]{18, 21, 23, 26, 30}};

        Assert.assertFalse(findNumberIn2DArray(matrix, 27));
        Assert.assertTrue(findNumberIn2DArray(matrix, 2));
        Assert.assertTrue(findNumberIn2DArray(matrix, 11));
        Assert.assertTrue(findNumberIn2DArray(matrix, 30));
        Assert.assertFalse(findNumberIn2DArray(matrix, 31));
        Assert.assertFalse(findNumberIn2DArray(matrix, 25));
    }

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (null == matrix)
            return false;
        if (matrix.length == 0)
            return false;
        if (matrix.length == 1 && matrix[0].length == 0)
            return false;
        int x = matrix[0].length - 1, y = 0;
        while (y < matrix.length && x >= 0) {
            if (matrix[y][x] == target) {
                return true;
            } else if (matrix[y][x] > target) {
                x--;
            } else {
                y++;
            }
        }
        return false;
    }
}
