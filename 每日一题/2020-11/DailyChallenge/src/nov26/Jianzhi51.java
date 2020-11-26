package nov26;

import java.util.*;

/**
 * @Author: iqqcode
 * @Date: 2020-11-26 15:40
 * @Description:数组中的逆序对
 * @Link: https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof/
 */
public class Jianzhi51 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        //暴力法
        //System.out.println(solutionI(nums, n));
        //归并思想
        System.out.println(solutionII(nums, n));
    }

    public static int solutionI(int[] nums, int n) {
        int num = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] > nums[j]) num++;
            }
        }
        return num;
    }

    /**
     * 利用数组的部分有序性
     * 时间复杂度: O(nlogn)--如何推导的
     * 空间复杂度: O(n)
     *
     * @param nums
     * @param n
     * @return
     */
    public static int solutionII(int[] nums, int n) {
        if (nums.length < 2 || nums == null) return 0;
        int[] temp = new int[nums.length];
        return mergeNums(nums, 0, nums.length - 1, temp);
    }

    /**
     * nums[low...high] 计算逆序对个数并且排序
     *
     * @param nums
     * @param low
     * @param high
     * @return
     */
    public static int mergeNums(int[] nums, int low, int high, int[] temp) {
        if (low >= high) return 0;
        int pivot = (low + high) >>> 1;
        int leftPairs = mergeNums(nums, low, pivot, temp);
        int rightPairs = mergeNums(nums, pivot + 1, high, temp);
        // 优化， 如果当左右子组归会整体数组时已经有序，则直接返回
        if (nums[pivot] < nums[pivot + 1]) {
            return leftPairs + rightPairs;
        }
        int crossPairs = merge(nums, low, pivot, high, temp);
        return leftPairs + rightPairs + crossPairs;
    }

    /**
     * nums[left...pivot] 有序, nums[pivot + 1, high] 有序
     *
     * @param nums
     * @param low
     * @param pivot
     * @param high
     * @param temp
     * @return
     */
    private static int merge(int[] nums, int low, int pivot, int high, int[] temp) {
        int p1 = low, p2 = pivot + 1;
        int index = low;
        //计数器变量，记录右侧每次归并回去的逆序对个数
        int count = 0;
        while (p1 <= pivot && p2 <= high) {
            count += nums[p1] <= nums[p2] ? 0 : pivot - p1 + 1;
            temp[index++] = nums[p1] <= nums[p2] ? nums[p1++] : nums[p2++];
        }
        while (p1 <= pivot) temp[index++] = nums[p1++];
        while (p2 <= high) temp[index++] = nums[p2++];
        for (int i = low; i <= high; i++) {
            nums[i] = temp[i];
        }
        return count;
    }
}