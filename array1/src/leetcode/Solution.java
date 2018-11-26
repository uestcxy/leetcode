package leetcode;

/**
 * Created by xiayuan on 2018/4/21.
 */

import java.math.BigInteger;
import java.util.*;

import static java.lang.Math.round;

public class Solution {
    /**
     * 两数之和
     */
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }

    /**
     * 有效的数独
     *
     * @param board
     */
    public static boolean isValidSudoku(char[][] board) {
        //横行和竖行遍历
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != '.') {
                    //TODO 查重
                }
            }
        }
        return false;
    }

    /**
     * 买股票的最佳时机
     *
     * @param nums
     * @return
     */
    public static int maxProfit3(int[] nums) {
        if (nums.length <= 1) return 0;

        int cost = nums[0], profit = 0, total = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] < nums[i]) cost = nums[i + 1];
            total += (nums[i + 1] - cost);
            cost = nums[i + 1];
        }
        return total;
    }

    /**
     * 两个数组的交集
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersect(int[] nums1, int[] nums2) {
        /*if (nums1.length == 0 || nums2.length == 0) return new int[0];
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> intersection = new ArrayList<>();
        int index = 0;
        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] == nums2[index]) {
                intersection.add(nums1[i]);
                if (++index == nums2.length) break;
            } else if (nums1[i] > nums2[index]) {
                i--;
                if (++index == nums2.length) break;
            }
        }
        int[] result = new int[intersection.size()];
        for (int i = 0; i < intersection.size(); i++) {
            result[i] = intersection.get(i);
        }
        return result;*/
        int p1 = 0;
        int p2 = 0;
        int length1 = nums1.length;
        int length2 = nums2.length;
        int[] result = new int[Math.min(length1, length2)];
        int counter = 0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        while (p1 < length1 && p2 < length2) {
            if (nums1[p1] == nums2[p2]) {
                result[counter] = nums1[p1];
                p1++;
                p2++;
                counter++;
            } else if (nums1[p1] > nums2[p2]) {
                p2++;
            } else {
                p1++;
            }
        }
        return Arrays.copyOfRange(result, 0, counter);
    }

    /**
     * 回文数
     *
     * @param x
     * @return
     */
    public static boolean isPalindrome(int x) {
        String str = Integer.toString(x);
        String[] strs = str.split("");
        String[] strings = new String[strs.length];
        for (int i = 0; i < strs.length; i++) {
            strings[strs.length - i - 1] = strs[i];
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < strings.length; i++) {
            stringBuffer.append(strings[i]);
        }
        String result = stringBuffer.toString();

        if (result.equals(str)) {
            return true;
        }

        return false;
    }

    /**
     * 回文数
     *
     * @param x
     * @return
     */
    public static boolean isPalindrome2(int x) {
        // TODO: 2018/5/15 不用字符串，用取余和取商来做

        return false;
    }

    /**
     * 有效括号
     *
     * @param s
     * @return
     */
    public boolean isValid(String s) {

        /*char[] chars = s.toCharArray();
        for(int i = 0;i<chars.length;i++){
            if(chars[i] == '('||chars[i] == '['||chars[i] == '{'){
                if(){

                }
            }
        }
        return false;*/
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char character = s.charAt(i);
            if (stack.size() == 0) {
                stack.push(character);
            } else {
                char topChar = stack.peek();
                if (topChar == '(' && character == ')' ||
                        topChar == '{' && character == '}' ||
                        topChar == '[' && character == ']') {
                    stack.pop();
                } else {
                    stack.push(character);
                }
            }
        }

        return stack.empty();
    }

    /**
     * 移除元素
     *
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement(int[] nums, int val) {
        Arrays.sort(nums);
        int[] arr = new int[nums.length];
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                arr[count] = nums[i];
                count++;
            }
        }
        System.arraycopy(arr, 0, nums, 0, arr.length);
        Arrays.copyOf(nums, count);
        return count;
    }

    /**
     * 搜索位置
     *
     * @param nums
     * @param target
     * @return
     */
    public static int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if (target > nums[i]) {
                return i + 1;
            }

        }
        return 0;
    }

    /**
     * 最大和的子数组
     *
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        Arrays.sort(nums);
        int[] sums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
// TODO: 2018/5/18 不会
            }

        }
        int max = sums[0];
        for (int i = 1; i < sums.length; i++) {
            if (max < sums[i]) {
                max = sums[i];
            }
        }
        return max;
    }

    private static int sumArray(int... nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
        }
        return sum;
    }

    /**
     * 最后一个单词的长度
     *
     * @param s
     * @return
     */
    public static int lengthOfLastWord(String s) {
        String[] strs = s.split(" ");
        if (strs.length >= 1) {
            return strs[strs.length - 1].length();
        }
        return 0;
    }

    /**
     * 二进制求和
     *
     * @param a
     * @param b
     * @return
     */
    public static String addBinary(String a, String b) {
        return (new BigInteger(a, 2).add(new BigInteger(b, 2))).toString(2);
    }

    /**
     * 爬楼梯
     *
     * @param n
     * @return
     */
    public static int climbStairs(int n) {
        if (n <= 2) return n;
        int[] mem = new int[n];
        mem[0] = 1;
        mem[1] = 2;
        for (int i = 2; i < n; i++) mem[i] = mem[i - 1] + mem[i - 2];
        return mem[n - 1];
    }

    /**
     * 平方根
     *
     * @param x
     * @return
     */
    public static int mySqrt(int x) {

        for (long i = 0; i <= x; i++) {
            if (x >= i * i && x < (i + 1) * (i + 1)) {
                return (int) i;
            }
        }
        return 0;
    }

    /**
     * 有效的完全平方数
     *
     * @param num
     * @return
     */
    public static boolean isPerfectSquare(int num) {
        for (long i = 0; i <= num; i++) {
            if (num == i * i) {
                return true;
            }
        }
        return false;
    }

    /**
     * 平方数之和
     *
     * @param c
     * @return
     */
    public static boolean judgeSquareSum(int c) {
        int n1 = 0, n2 = (int) Math.sqrt(c);
        while (n1 <= n2) {
            int cur = n1 * n1 + n2 * n2;
            if (cur == c) return true;
            if (cur < c) n1++;
            else n2--;
        }
        return false;
    }

    /**
     * 合并两个有序数组
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        /*if (nums1[m - 1] < nums2[0]) {
            System.arraycopy(nums2, 0, nums1, m, n);
            return;
        }
        if (nums1[0] > nums2[n - 1]) {
            System.arraycopy(nums1, nums1.length - m, nums1, 0, m);
            System.arraycopy(nums2, 0, nums1, 0, n);
            return;
        }
        for (int i = m - 2; i > 0; i--) {
            for (int j = 1; j < n - 2; j++) {
                // TODO: 2018/5/22
            }
        }*/
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }

    /**
     * 两数之和 II
     *
     * @param numbers
     * @param target
     * @return
     */
    public static int[] twoSum2(int[] numbers, int target) {
        int[] result = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }

    /**
     * Excel表列名
     *
     * @param n
     * @return
     */
    public static String convertToTitle(int n) {
        return n == 0 ? "" : convertToTitle(--n / 26) + (char) ('A' + (n % 26));
    }

    /**
     * Excel表列序号
     *
     * @param s
     * @return
     */
    public static int titleToNumber(String s) {
        char[] chs = s.toCharArray();
        int result = 0;
        for (int i = 0; i < chs.length; i++) {
            result = result + (chs[chs.length - i - 1] - ('A' - 1)) * (int) (Math.pow(26, i));
        }
        return result;
    }

    /**
     * 缺失的数字
     *
     * @param nums
     * @return
     */
    public static int missingNumber(int[] nums) {
        Arrays.sort(nums);
        if (nums[0] != 0) {
            return 0;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] - nums[i] != 1) {
                return nums[i] + 1;
            }
        }

        return nums[nums.length - 1] + 1;
    }

    /**
     * 求众数
     *
     * @param nums
     * @return
     */
    public static int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int num = nums[0];
        int[] counts = new int[nums.length];
        int i = 0;
        for (int j = 0; i < nums.length; i++) {
            if (nums[i] == num) {
                counts[j]++;
                if (counts[j] > nums.length / 2) {
                    return nums[i];
                }
            } else {
                num = nums[i];
                j++;
                counts[j]++;
            }
        }
        return 0;
    }

    /**
     * 求众数2
     *
     * @param nums
     * @return
     */
    public static List<Integer> majorityElement2(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        int num = nums[0];
        int[] counts = new int[nums.length];
        int i = 0;
        boolean flag = true;
        for (int j = 0; i < nums.length; i++) {
            if (nums[i] == num) {
                counts[j]++;
                if (counts[j] > nums.length / 3 && flag) {
                    list.add(nums[i]);
                    flag = false;
                }
            } else {
                num = nums[i];
                j++;
                counts[j]++;
                if (counts[j] > nums.length / 3) {
                    list.add(nums[i]);
                    flag = false;
                } else {
                    flag = true;
                }
            }
        }
        return list;
    }

    /**
     * 存在重复元素2
     *
     * @param nums
     * @param k
     * @return
     */
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] == nums[j] && j - i == k) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 2的幂
     *
     * @param n
     * @return
     */
    public static boolean isPowerOfTwo(int n) {
        while (n / 2 != 0 && n % 2 != 1) {
            n = n / 2;
        }
        if (n == 1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 位1的个数
     *
     * @param n
     * @return
     */
    // you need to treat n as an unsigned value
    public static int hammingWeight(int n) {
        // TODO: 2018/5/24 如何转换二进制
        return 0;
    }

    /**
     * 各位相加
     *
     * @param num
     * @return
     */
    public static int addDigits(int num) {
        /*
        用字符串的方法
         */
        /*String numStr = String.valueOf(num);
        char[] nums = numStr.toCharArray();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i]-48;
        }
        if(sum>9){
            sum = addDigits(sum);
        }
        return sum;*/
        /*
        用每位相加
         */
        int result = num;
        int remain = 0;
        int sum = 0;
        while (result != 0) {
            remain = result % 10;
            result = result / 10;
            sum += remain;
        }
        if (sum > 9) {
            sum = addDigits(sum);
        }
        return sum;
    }

    /**
     * 快乐数
     *
     * @param n
     * @return
     */
    public static boolean isHappy(int n) {
        // TODO: 2018/5/24 想法不对
        return false;
    }

    /**
     * 3的幂
     *
     * @param n
     * @return
     */
    public static boolean isPowerOfThree(int n) {
        while (n / 3 != 0 && n % 3 != 1 && n % 3 != 2) {
            n = n / 3;
        }
        if (n == 1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 4的幂
     *
     * @param n
     * @return
     */
    public static boolean isPowerOfFour(int n) {
        while (n / 4 != 0 && n % 4 != 1 && n % 4 != 2 && n % 4 != 3) {
            n = n / 4;
        }
        if (n == 1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 反转元音字母
     *
     * @param s
     * @return
     */
    public static String reverseVowels(String s) {
        String result = "";
        char[] vowels = {'a', 'e', 'i', 'o', 'u'};
        char[] strs = s.toCharArray();
        for (int i = 0; i < vowels.length; i++) {
            for (int j = 0; j < strs.length; j++) {
                if (strs[j] == vowels[i]) {
                    // TODO: 2018/5/24
                }
            }
        }
        return result;
    }

    /**
     * 螺旋矩阵
     *
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                list.add(matrix[i][j]);
                // TODO: 2018/5/25 还没做完 
            }
        }
        return list;
    }

    /**
     * 阶乘后的零
     *
     * @param n
     * @return
     */
    public static int trailingZeroes(int n) {
        BigInteger result = new BigInteger("1");
        for (int i = 1; i <= n; i++) {
            String val = String.valueOf(i);
            result = result.multiply(new BigInteger(val));
        }
//        System.out.println(result);
        String res = String.valueOf(result);
        String[] strs = res.split("");
        int count = 0;
        for (int i = strs.length - 1; i > 0; i--) {
            if (!("0".equals(strs[i]))) {
                return count;
            } else {
                count++;
            }
        }
        return count;
    }

    /**
     * 计数质数
     *
     * @param n
     * @return
     */
    public static int countPrimes(int n) {
        // TODO: 2018/5/28 质数还不对
        /*
        int count = 0;
        boolean flag = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (j % i == 0 && i != 1 && j != i) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                
            }
        }
        return count;*/
        /**
         *
         */
        boolean[] notPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (notPrime[i] == false) {
                count++;
                for (int j = 2; i * j < n; j++) {
                    notPrime[i * j] = true;
                }
            }
        }

        return count;
    }


    /**
     * @param num
     * @return
     */
    public static boolean isUgly(int num) {
        if (num == 0) return false;
        while (num % 2 == 0) num = num / 2;
        while (num % 3 == 0) num = num / 3;
        while (num % 5 == 0) num = num / 5;
        return num == 1;
    }

    /**
     * 分发饼干
     *
     * @param g
     * @param s
     * @return
     */
    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0, j = 0;
        while (i < g.length && j < s.length) {
            if (g[i] > s[j]) {
                j++;
            } else {
                i++;
                j++;
            }
        }
        return i;

    }

    public static boolean repeatedSubstringPattern(String s) {
        StringBuilder str = new StringBuilder(s + s); //concatenate the given string with itself
        str.deleteCharAt(0); //remove first char
        str.deleteCharAt(str.length() - 1); //remove last char

        return str.indexOf(s) != -1; //check if the given string is substring of the new string
    }

    /**
     * 构造矩形
     *
     * @param area
     * @return
     */
    public static int[] constructRectangle(int area) {
        int[] result = new int[2];
        if (area == 0) {
            return result;
        }
        int a = (int) Math.sqrt(area);
        while (area % a != 0) {
            a--;
        }
        int b = area / a;
        result[0] = b;
        result[1] = a;
        return result;
    }

    /**
     * 排列硬币
     *
     * @param n
     * @return
     */
    public static int arrangeCoins(int n) {

        return 1;
    }

    /**
     * 最大连续1的个数
     *
     * @param nums
     * @return
     */
    public static int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1)
                max = Math.max(++j, max);
            else
                j = 0;
        };
        return max;
    }

    /**
     * 下一个更大元素
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // TODO: 2018/6/4 还不对
       /* int[] result = new int[nums1.length];
//        Arrays.sort(nums1);
//        Arrays.sort(nums2);
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    if (i == nums1.length - 1) {
                        if (nums1[i] < nums2[j + 1]) {
                            result[i] = nums2[j + 1];
                        } else {
                            result[i] = -1;
                        }
                    } else {
                        result[i] = -1;
                    }

                }
            }
        }
        return result;*/
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums2.length; ++i) {
            for (int j = i + 1; j < nums2.length; ++j) {
                if (nums2[j] > nums2[i]) {
                    map.put(nums2[i], nums2[j]);
                    break;
                }
            }
            map.put(nums2[i], map.containsKey(nums2[i]) ? map.get(nums2[i]) : -1);
        }
        for (int i = 0; i < nums1.length; ++i) {
            nums1[i] = map.get(nums1[i]);
        }
        return nums1;
    }


    /**
     * 完美数
     * @param num
     * @return
     */
    public static boolean checkPerfectNumber(int num) {
        for(int i = 1;i<num;i++){

        }
        return false;
    }

    public static boolean checkRecord(String s) {
        char[] chs = s.toCharArray();
        int countA = 0;
        int countL = 0;
        for(int i = 0;i<chs.length;i++){
            if(chs[i] == 'A'){
                countA++;
            }
            if(chs[i] == 'L'){
                countL++;
            }else {
                countL=0;
            }
            if(countA>1 && countL==3){
                return false;
            }
        }
        return true;
    }

    public static boolean detectCapitalUse(String word) {
        String reg1 = "[A-Z]+";
        String reg2 = "[A-Z]?[a-z]";
        if(word.matches(reg1)||word.matches(reg2)){
            return true;
        }
        return false;
    }


    /*public static int findLUSlength(String a, String b) {

        return 0;
    }*/

    public static void main(String[] args) {



        /**
         *
         */
        System.out.println(findMaxConsecutiveOnes(new int[]{1, 0}));
        /**
         * 构造矩形
         */
//        System.out.println(constructRectangle(8)[0] + "," + constructRectangle(8)[1]);
        /**
         *
         */
//        System.out.println(repeatedSubstringPattern("abcabc"));
        /**
         * 计数质数
         */
//        System.out.println(countPrimes(10));
        /**
         * 阶乘后的零
         */
//        System.out.println(trailingZeroes(30));
        /**
         * 4的幂
         */
//        System.out.println(isPowerOfFour(8));
        /**
         * 3的幂
         */
//        System.out.println(isPowerOfThree(9));
        /**
         * 各位相加
         */
//        System.out.println(addDigits(38));

        /**
         * 2的幂
         */
//        System.out.println(isPowerOfTwo(1));

        /**
         * 存在重复元素2
         */
       /* int[] nums = {1, 2, 3, 1};
        int k = 3;
        System.out.println(containsNearbyDuplicate(nums, k));*/

        /**
         * 找众数
         */
        /*int[] nums = {2,2,3,3,3};
        System.out.println(majorityElement2(nums));*/
        /**
         * 缺失的数字
         */
        /*int[] nums = {1};
        System.out.println(missingNumber(nums));*/

        /**
         * Excel表列序号
         */
        /*String s = "ZY";
        System.out.println(titleToNumber(s));*/

        /**
         * Excel表列名
         */
//        int n = 1;
//        int m = 26;
//        int k = 28;
//        int l = 701;
//        System.out.println(convertToTitle(l));
        /**
         * 合并两个有序数组
         */

        /*int[] nums1 = {1, 2, 3, 4, 0, 0, 0,};
        int[] nums2 = {2, 3, 5};
        int m = 4;
        int n = 3;
        merge(nums1, m, nums2, n);
        for (int i = 0; i < nums1.length; i++) {
            System.out.println(nums1[i]);
        }*/
        /**
         * 有效的完全平方数
         */
//        System.out.println(isPerfectSquare(10));
        /**
         * 平方根
         */
//        System.out.println(mySqrt(2147395600));
        /**
         * 爬楼梯
         */
        /*int n = 4;
        System.out.println(climbStairs(n));*/
        /**
         *
         */
        /*String s = " ";
        System.out.println("最后一个单词的长度" + lengthOfLastWord(s));*/
        /**
         * 最大和的子数组
         */
        /*int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("最大和的子数组的最大和是：" + maxSubArray(nums));*/
        /**
         *
         */
        /*int[] nums = {1, 2, 3, 4};
        int target = 3;
        System.out.println(searchInsert(nums, target));*/
        /**
         *
         */
        /*int[] nums = {1, 1, 2, 3, 4, 2, 0};
        int val = 2;
        int length = removeElement(nums, val);
        for (int i = 0; i < length; i++) {
            System.out.println(nums[i]);
        }*/
        /**
         * 两数之和
         *//*
        int[] nums = {3, 2, 4};
        int target = 6;
        int[] result = twoSum(nums, target);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }*/
        /**
         * 移零
         *//*
//        int[] nums = { 1, 0, 3, 0, 6,0};
        int[] nums = {0, 1, 0, 1,0,1};
//        int[] nums = { 0,0,1, 1, 3, 0, 6};
//        int[] nums = { 0,0,1, 1, 3, 0, 6,0};
        moveZeroes(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }*/

        /**
         * 加一
         */

        /**
         * 只出现一次的数字
         *//*
        int[] nums = {1,2,1,2,5};
        int num = singleNumber(nums);
        System.out.println(num);*/

        /**
         * 判断重复
         *//*
//        int[] nums = {1,2,1,3,4,1,2,33,1,5,6};
        int[] nums = {1, 1};
//        boolean flag = containsDuplicate(nums);
        boolean flag2 = containsDuplicate2(nums, 2);
        System.out.println(flag2);*/
        /*
         * 调用rotate方法
         *//*
        int[] nums = {1,2,3,4,5,6,7};
        rotate2(nums, 4);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }*/
        /**
         * 调用maxProfit方法
         */
//        int[] nums = {7, 1, 5, 3, 4, 6};
//        int[] nums = {1,2,3,4,5};
//        int[] nums = {7, 1, 2, 3, 4, 6};
//        int[] nums = {7,6,4,3,1};
        /*int[] nums = {6, 7, 1, 2, 3, 4, 6};
        int profit = maxProfit(nums);
        int profit2 = maxProfit3(nums);
//        System.out.println("能获取的最大利润为：" + profit);
        System.out.println("能获取的最大利润3为：" + profit2);*/
        /*// nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
        int[] nums = {1, 2, 4, 4, 5, 6, 0, 1, 5, 6};
        int len = removeDuplicates(nums);

        // 在函数里修改输入数组对于调用者是可见的。
        // 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
        for (int i = 0; i < len; i++) {
            System.out.println(nums[i]);
        }*/

    }

    /**
     * 移零
     */
    public static void moveZeroes(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[k++] = nums[i];
            }
        }
        for (int j = k; j < nums.length; j++) {
            nums[j] = 0;
        }
    }

    public static void moveZero(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                j++;

            }

        }
        while (j < nums.length) {

            nums[j] = 0;
            j++;
        }

    }

    /**
     * 加一
     */
    public static int[] plusOne3(int[] digtis) {
        int n = digtis.length;
        for (int i = n - 1; i >= 0; i--) {
            if (digtis[i] < 9) {
                digtis[i]++;
                return digtis;
            }
            digtis[i] = 0;
        }
        int[] nums = new int[n + 1];
        nums[0] = 1;
        return nums;
    }

    public static int[] plusOne2(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] nums = new int[n + 1];
        nums[0] = 1;

        return nums;
    }

    public static int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        int[] newNumber = new int[n + 1];
        newNumber[0] = 1;

        return newNumber;

    }


    /**
     * 只出现一次的数字
     */
    public static int singleNumber(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            boolean flag = true;
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] == nums[j] && i != j) {
                    flag = false;
                }
            }
            if (flag) {
                return nums[i];
            }
        }
        return -1;
    }


    /**
     * 存在重复
     * 给定一个整数数组，判断是否存在重复元素
     * 如果任何值在数组中出现至少两次，函数应该返回 true。如果每个元素都不相同，则返回 false。
     */
    public static boolean containsDuplicate2(int[] nums, int k) {
        boolean flag = false;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j] && j - i == k) {
                    return true;
                }
            }
        }
        return flag;
    }

    public static boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }

    /**
     * 翻转数组
     *
     * @param nums
     * @param k
     */
    public static void rotate1(int[] nums, int k) {
        if (k > nums.length) {
            k = k % nums.length;
            if (nums.length == 1) {
                return;
            }
        }
        int[] arr = new int[k];
        int[] arr2 = new int[nums.length - k];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = nums[i];
        }
        for (int i = 0; i < arr.length; i++, k--) {
            arr[i] = nums[nums.length - k];
        }
        System.arraycopy(arr, 0, nums, 0, arr.length);
        System.arraycopy(arr2, 0, nums, arr.length, arr2.length);
//        System.arraycopy(arr2, k, arr, k, arr2.length);
//        for(int i = 0; i< nums.length;i++){
//            System.out.println(nums[i]);
//        }

    }

    public static void rotate2(int[] nums, int k) {
        //将数组转换成list，再转换成数组
        if (k > nums.length) {
            k = k % nums.length;
            if (nums.length == 1) {
                return;
            }
        }
//        List<Integer> arrList = Arrays.asList();
        List<Integer> arrList = new ArrayList<>(nums.length);
        int m = nums.length - k;
        //先全部赋值
        for (int i = 0; i < nums.length; i++) {
            arrList.add(nums[i]);
        }
        //然后调整顺序
        int k1 = 0;
        for (int i = 0; i < nums.length && k1 < k; i++, k++) {
            if (i < m) {
                arrList.set(k, nums[i]);
            } else {
                arrList.set(k1, nums[i]);
                k1++;
            }

        }
//        nums = (int[])arrList.toArray();
        for (int i = 0; i < arrList.size(); i++) {
            nums[i] = arrList.get(i);
        }
    }

    public static int removeDuplicates(int[] nums) {
        Arrays.sort(nums);
        // 创建一个新的数组，与输入数组长度相同
        int[] arr = new int[nums.length];
        int j = 0;
        for (int i = 0; i < nums.length + 1 && j < arr.length; i++) {
            if (i == nums.length - 1) {
                arr[j] = nums[i];
                j++;
                break;
            }
            if (nums[i] == nums[i + 1]) {
                continue;
            }
            arr[j] = nums[i];
            j++;

        }
        System.arraycopy(arr, 0, nums, 0, arr.length);
        nums = Arrays.copyOf(nums, j);
        return nums.length;
    }

    public static int maxProfit(int[] prices) {
        /*//找出所有价格的最大值和最小值
        int buy = 0;
        int sell = 0;
        int profit = 0;
        int[] profits = new int[prices.length];
        //找出所有的升序序列
        //计算所有尾-头的和，即为利润
        int j = 0;
        for(int i = 0;i<prices.length;i++){
            boolean flag = true;
            for( j = i+1;j<prices.length;j++){
                if(prices[i] < prices[j]){
                    if(prices[j-1] < prices[j] && flag ){
                        // TODO: 2018/4/21 不知如何处理重复的部分
                        buy = prices[i];
                        sell = prices[j];
                    }else{
                        flag = false;
                    }
                }else{
                    break;
                }
            }
            if(buy == prices[i]){
                profits[i] = sell - buy;

            }


        }
        //对每个升序利润求和
        for(int i = 0; i<profits.length;i++){
            profit = profit+profits[i];
        }
        return profit;*/
        int profit = 0;
        int[] profits = new int[prices.length];
        //找出所有的升序序列，放入二维数组
        int[][] arr = new int[prices.length][prices.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = -1;
            }
        }
        int count = 0;
        for (int j = 0, i = count; j < arr.length && i < prices.length - 1; j++) {
            for (i = count; i < prices.length - 1; i++) {
                if (prices[i] < prices[i + 1]) {
                    arr[j][i] = prices[i];
                    arr[j][i + 1] = prices[i + 1];
                    count++;
                } else {
//                    arr[j][i] = prices[i];
                    count++;
                    break;
                }
            }

            //单独判断profit数组中最后一个元素
//            if( i == prices.length - 1 && prices[prices.length - 1] > prices[prices.length - 2]){
//                arr[j][i] = prices[prices.length - 1];
//            }
            //对每一个升序数组求尾-头
//            profits[j] = arr[j][i] - arr[j][i - j];
            for (int k = 0; k < arr[j].length; k++) {
                if (arr[j][k] != -1) {
                    // TODO: 2018/4/23 还没实现尾-头
                }
            }
        }
        //对profits数组求和
        for (int i = 0; i < profits.length; i++) {
            profit = profit + profits[i];
        }
        return profit;
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<char[], List<String>> ans = new HashMap<>();
        for (String item : strs) {
            char[] s = item.toCharArray();
            Arrays.sort(s);
            if (ans.containsKey(s)) {
                ans.get(s).add(item);
            } else {
                ans.put(s, new ArrayList<>(Arrays.asList(item)));
            }
        }
        return new ArrayList<>(ans.values());
    }

    public static int maxProfit2(int[] prices) {
        int profit = 0;
        int[] profits = new int[prices.length];
        //找出所有的升序序列，放入二维数组
        int[][] arr = new int[prices.length][prices.length];

        int count = 0;
        int min = 0;
        int flag = 0;
        for (int j = 0, i = count; j < arr.length && i < prices.length - 1; j++) {
            for (flag = 0, i = count; i < prices.length - 1; i++) {
                if (prices[i] < prices[i + 1]) {
                    flag++;
                    arr[j][i] = prices[i];
                    arr[j][i + 1] = prices[i + 1];
                    count++;
                    if (flag == 1) {
                        min = i;
                    }
                } else {
                    count++;
                    break;
                }
            }
            profits[j] = arr[j][i] - arr[j][min];
        }
        //对profits数组求和
        for (int i = 0; i < profits.length; i++) {
            profit = profit + profits[i];
        }
        return profit;
    }


}

