import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * Created by xiayuan on 2018/4/25.
 */
public class Solution {
    /**
     * 翻转字符串
     *
     * @param s
     * @return
     */
    public static String reverseString(String s) {
        String[] strs = s.split("");
        String[] strings = new String[strs.length];
        for (int i = 0; i < strs.length; i++) {
            strings[strs.length - i - 1] = strs[i];
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < strings.length; i++) {
            stringBuffer.append(strings[i]);
        }
        String result = stringBuffer.toString();
        return result;
    }

    /**
     * 颠倒整数
     *
     * @param x
     * @return
     */
    public static int reverse(int x) {

        if (x == Integer.MIN_VALUE) {
            return 0;
        }
        int xx = x;
        if (x < 0) {
            xx = -x;
        }
        String before = String.valueOf(xx);
        String after = reverseString(before);
        if (Long.parseLong(after) > Integer.MAX_VALUE) {
            return 0;
        }
        int xxx = Integer.parseInt(after);
        if (x < 0) {
            xxx = -xxx;
        }
        return xxx;
    }

    /**
     * 字符串中第一个唯一字符的位置
     *
     * @param s
     * @return
     */
    public static int firstUniqChar(String s) {
        char[] array = s.toCharArray();
        for (int i = 0; i < array.length; i++) {
            boolean flag = false;
            for (int j = 0; j < array.length; j++) {
                if (array[i] == array[j] && i != j) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 有效的字母异位词
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram(String s, String t) {
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        Arrays.sort(ss);
        Arrays.sort(tt);
        int length = ss.length > tt.length ? tt.length : ss.length;
        if (ss.length != tt.length) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            if (ss[i] != tt[i]) {
                return false;
            }
        }
        return true;
    }

    public static int maxNum(int[] arrs) {
        Arrays.sort(arrs);
        return arrs[arrs.length];
    }

    /**
     * 最长公共前缀
     *
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {
        /*char[][] chars = new char[strs.length][];
        for (int i = 0; i < strs.length; i++) {
            chars[i] = strs[i].toCharArray();
        }
        int[] arr = new int[chars.length];
        for(int i = 0;i< arr.length;i++){
            arr[i] = chars[i].length;
        }
        for (int i = 0; i < maxNum(arr); i++) {
            for (int j = 0; j < strs.length; j++) {
                if(chars[j][i] == chars[j+1][i]){

                }
            }
        }
        return "";*/
        StringBuilder sb = new StringBuilder();
        if (strs.length == 0) return sb.toString();

        for (int j = 0; j < strs[0].length(); j++) {
            char ch = strs[0].charAt(j);
            for (int i = 1; i < strs.length; i++) {
                if (j >= strs[i].length() || strs[i].charAt(j) != ch)
                    return sb.toString();
            }
            sb.append(ch);
        }
        return sb.toString();
    }

    /**
     * strStr
     *
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    /**
     * 数数并说
     *
     * @param n
     * @return
     */
    public static String countAndSay(int n) {
        StringBuilder input = new StringBuilder("1");
        StringBuilder output = new StringBuilder();
        for (int i = 1; i < n; i++) {
            char pch = input.charAt(0);
            int count = 1;
            for (int j = 1; j < input.length(); j++) {
                char ch = input.charAt(j);
                if (ch != pch) {
                    output.append(count).append(pch);
                    count = 1;
                } else {
                    count++;
                }
                pch = ch;
            }
            output.append(count).append(pch);
            input = output;
            output = new StringBuilder();
        }
        return input.toString();
    }

    /**
     * 无重复最长子串
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        // TODO: 2018/5/29 还不对
        char[] chs = s.toCharArray();
        int[] lengths = new int[chs.length];

        for (int i = 0; i < chs.length; i++) {
            int count = 1;
            for (int j = i + 1; j < chs.length; j++) {
                if (chs[i] != chs[j]) {
                    count++;
                } else {
                    break;
                }
            }
            lengths[i] = count;
        }
        int max = lengths[0];
        for (int i = 1; i < lengths.length; i++) {
            if (max < lengths[i]) {
                max = lengths[i];
            }
        }
        return max;
    }

    /**
     * 找不同
     *
     * @param s
     * @param t
     * @return
     */
    public static char findTheDifference(String s, String t) {
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        int count = 0;
        for (int i = 0; i < sc.length; i++) {
            count += (int) sc[i];
        }
        for (int j = 0; j < tc.length; j++) {
            count -= (int) tc[j];
        }
        return (char) (Math.abs(count));
    }

    /**
     * 第N个数字
     *
     * @param n
     * @return
     */
    public static int findNthDigit(int n) {
        /*String s = "";
        int[] lengths = new int[n];
        lengths[0] = 0;
        for(int i = 0,j = 1;i<lengths.length;i+=9,j++){
            lengths[j] = (i/9+1)*9;
        }
        //  (i/9+1)*9
        int num = 0;
        for(int i = 0;i<lengths.length;i++){
            if(n<lengths[i]){
                num = i-1;
                break;
            }
        }


        String[] strs = s.split("");
        return Integer.parseInt(strs[n-1]);*/
        int len = 1;
        long count = 9;
        int start = 1;

        while (n > len * count) {
            n -= len * count;
            len += 1;
            count *= 10;
            start *= 10;
        }

        start += (n - 1) / len;
        String s = Integer.toString(start);
        return Character.getNumericValue(s.charAt((n - 1) % len));
    }

    /**
     * 第三大的数
     *
     * @param nums
     * @return
     */
    public static int thirdMax(int[] nums) {
        Arrays.sort(nums);

        if (nums.length < 3) {
            return nums[nums.length - 1];
        }
        int count = 1;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] != nums[i - 1]) {
                count++;
            }
            if (count == 3) {
                return nums[i - 1];
            }

        }
        return nums[nums.length - 1];
    }

    class MyComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            //如果o1小于o2，我们就返回正值，如果o1大于o2我们就返回负值，
            //这样颠倒一下，就可以实现反向排序了
            if (o1 < o2) {
                return 1;
            } else if (o1 > o2) {
                return -1;
            } else {
                return 0;
            }
        }

    }

    /**
     * 猜数字大小
     *
     * @param n
     * @return
     */
    public static int guessNumber(int n) {

        return 0;
    }

    /**
     * 赎金信
     *
     * @param ransomNote
     * @param magazine
     * @return
     */
    public static boolean canConstruct(String ransomNote, String magazine) {
        /*List<Character> maga = new ArrayList<>();
        for (Character c : magazine.toCharArray()) maga.add(c);
        for (Character c : ransomNote.toCharArray()) {
            if (!maga.contains(c)) {
                return false;
            } else {
                maga.remove(maga.indexOf(c));
            }
        }
        return true;*/
        List<Character> mega = new ArrayList<>();
        for (Character c : magazine.toCharArray()) {
            mega.add(c);
        }
        for (Character c : ransomNote.toCharArray()) {
            if (!mega.contains(c)) {
                return false;
            } else {
                mega.remove(mega.indexOf(c));
            }
        }
        return true;
    }

    /**
     * FizzBuzz
     *
     * @param n
     * @return
     */
    public static List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 != 0) {
                result.add("Fizz");
            } else if (i % 3 != 0 && i % 5 == 0) {
                result.add("Buzz");
            } else if (i % 3 == 0 && i % 5 == 0) {
                result.add("FizzBuzz");
            } else {
                result.add("" + i);
            }
        }
        return result;
    }


    /**
     * 字符串中的单词数
     *
     * @param s
     * @return
     */
    public static int countSegments(String s) {

        return 0;
    }

    /**
     * 键盘行
     *
     * @param words
     * @return
     */
    public static String[] findWords(String[] words) {
        String[] result = new String[words.length];
        char[] row1 = {'q', 'Q', 'w', 'W', 'e', 'E', 'r', 'R', 't', 'T', 'y', 'Y', 'u', 'U', 'i', 'I', 'o', 'O', 'p', 'P'};
        char[] row2 = {'a', 'A', 's', 'S', 'd', 'D', 'f', 'F', 'g', 'G', 'h', 'H', 'j', 'J', 'k', 'K', 'l', 'L'};
        char[] row3 = {'z', 'Z', 'x', 'X', 'c', 'C', 'v', 'V', 'b', 'B', 'n', 'N', 'm', 'M'};
        int j = 0;
        for (int i = 0; i < words.length; i++) {
            if (function(row1, words[i]) || function(row2, words[i]) || function(row3, words[i])) {
                result[j] = words[i];
                j++;
            }
        }
        result = Arrays.copyOf(result, j);
        return result;
    }

    private static boolean function(String a1, String b1) {
        String a = "admin";
        String b = "pwd";
        boolean dl = true;
        if(a1.equals(a)&&b1.equals(b)){
            dl = true;
        }else{
            dl = false;
        }

        return dl;
    }

    public static String convertToBase7(int num) {

        /*
        if(num < 7 && num >=0){
            return num+"";
        }
        if(num <0){
            num = -num;
            String sb = "";
            int remain = num % 7;
            int result = num;
            while (result != 0) {
                sb = remain+sb;
                result = result / 7;
                remain = result % 7;
            }
            return "-"+sb;
        }
        String sb = "";
        int remain = num % 7;
        int result = num;
        while (result != 0) {
            sb = remain+sb;
            result = result / 7;
            remain = result % 7;
        }
        return sb;
         */
        return Integer.toString(num, 7);
    }

    /**
     * 相对名次
     *
     * @param nums
     * @return
     */
    public static String[] findRelativeRanks(int[] nums) {
        String gold = "Gold Medal";
        String silver = "Silver Medal";
        String bronze = "Bronze Medal";

        return null;
    }

    public static void main(String[] args) throws ParseException {
        /**
         *
         */
        System.out.println(convertToBase7(-9));
        /**
         * 键盘
         */
//        System.out.println(findWords(new String[]{"Hello", "Alaska", "Dad", "Peace"}));
        /**
         * FizzBuzz
         */
//        System.out.println(fizzBuzz(16));
        /*int[] nums = {3, 2, 2, 2};
        System.out.println(thirdMax(nums));*/
        /**
         * 第N个数字
         */
//        System.out.println(findNthDigit(13));
        /**
         * 无重复最长子串
         */
//        System.out.println(lengthOfLongestSubstring("abcdabcabcd"));
        /**
         * 测试日期转换
         */
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
//        String date = "2016";
//        sdf.parse(date);

        /**
         * 数数并说
         */
        /*int n = 5;
        System.out.println(countAndSay(n));*/
        /**
         * str
         *//*
        String haystack = "hello";
        String needle = "llq";
        System.out.println(strStr(haystack, needle));*/

        /**
         * 最长公共前缀
         */
        /**
         * 异位词
         *//*
        String s = "tea";
        String t = "eatt";
        System.out.println(isAnagram(s, t));*/
        /**
         * 字符串中第一个唯一字符的元素
         *//*
        String s = "lleetcode";
        int i = firstUniqChar(s);
        System.out.println(i);*/

        /**
         * 颠倒整数
         *//*
        int x = Integer.MIN_VALUE;
        System.out.println(reverse(x));*/
        /**
         * 翻转字符串
         *//*
        String s = "123456";
        String str = reverseString(s);
        System.out.println(str);*/
    }
}
