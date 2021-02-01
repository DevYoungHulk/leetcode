package offer;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class N03_ShuZuZhongZhongFuDeShuZiLcof {
    @Test
    public void test() {
        int repeatNumber = findRepeatNumber(new int[]{2, 3, 1, 0, 2, 5, 3});
        System.out.println(repeatNumber);
        Assert.assertTrue(repeatNumber == 2 || repeatNumber == 3);
        int repeatNumber2 = findRepeatNumber2(new int[]{2, 3, 1, 0, 2, 5, 3});
        System.out.println(repeatNumber2);
        Assert.assertTrue(repeatNumber2 == 2 || repeatNumber2 == 3);
    }

    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) {
                return nums[i];
            }
        }
        return -1;
    }

    public int findRepeatNumber2(int[] nums) {
        int tmp;
        for (int i = 0; i < nums.length; i++) {
          while (nums[i]!=i){
              tmp  = nums[i];
              if(nums[i] ==nums[tmp]){
                  return tmp;
              }
              nums[i] = nums[tmp];
              nums[tmp] = tmp;
          }
        }
        return -1;
    }
}
