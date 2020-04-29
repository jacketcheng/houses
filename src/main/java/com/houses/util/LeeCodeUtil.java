package com.houses.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class LeeCodeUtil {

    public static void main(String[] args) {
        System.out.println(addBinary("10101","1101"));
    }

    /**
     * 判断符号的有效性
     * @param s
     * @return
     */
    public boolean isValid(String s){
        if (null == s || "".equals(s)){
            return false;
        }
        if (s.length()%2 != 0){
            return false;
        }else {
            Map<Character,Character> map = new HashMap<>();
            map.put(')','(');
            map.put('}','{');
            map.put(']','[');
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (map.containsKey(c)){
                    char out = stack.isEmpty() ? '<' : stack.pop();
                    if (out != map.get(c)){
                        return false;
                    }
                }else{
                    stack.push(c);
                }
            }
            return stack.isEmpty();
        }
    }

    /**
     * 移除数组中等于val的元素并返回最终数组的长度
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val){
        if (nums == null){
            return 0;
        }
        int length = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val){
                nums[length] = nums[i];
                length++;
            }
        }
        return length;
    }

    /**
     * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。前五项如下：
     * 1.     1
     * 2.     11
     * 3.     21
     * 4.     1211
     * 5.     111221
     *
     * 1 被读作  "one 1"  ("一个一") , 即 11。
     * 11 被读作 "two 1s" ("两个一"）, 即 21。
     * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211
     *给定一个正整数 n（1 ≤ n ≤ 30），输出外观数列的第 n 项
     * @param n
     * @return
     */
    public static String countAndSay(int n){
        if (n == 1){
            return "1";
        }else if (n == 2){
            return "11";
        }
        String value = "11";
        for (int i = 2; i < n; i++) {
            String result = "";
            int length = 1;
            char element;
            for (int j = 0; j < value.length()-1; j++) {
                element = value.charAt(j);
                if (element == value.charAt(j+1)){
                    length++;
                }else{
                    result =  result.concat(String.valueOf(length)).concat(String.valueOf(element));
                    length = 1;
                }
                if (j ==  value.length()-2){
                    result =  result.concat(String.valueOf(length)).concat(String.valueOf(value.charAt(j+1)));
                }
            }
            value = result;
        }
        return value;
    }

    /**
     * 集合最大子序列的和
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums){
        if (nums == null || nums.length == 0){
            return 0;
        }
        int current = nums[0];
        int sum = nums[0];
        if (nums.length == 1){
            return sum;
        }
        for (int i = 1; i < nums.length; i++) {//{-2,1,-3,4,-1,2,1,-5,4}
            current = Math.max(nums[i],current+nums[i]);
            sum = Math.max(sum,current);
        }
        return sum;
    }

    /**
     * 最后一个非空字符的长度
     * @param s  "add  aaaaa to vvvvvv"
     * @return
     */
    public static int lengthOfLastWord(String s){
        if (s == null || s.length() == 0){
            return 0;
        }
        int end = s.length()-1;
        while (s.charAt(end) == ' '){
            end--;
            if (end < 0){
                return 0;
            }
        }
        int start = end;
        while (start >=0 && s.charAt(start) != ' '){
            start--;
        }
        return end -start;
    }

    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0){
            return digits;
        }
        int length = digits.length;
        if (digits[length-1] != 9){
            digits[length-1] = digits[length-1] +1;
        }else{
            for (int i = length-1; i >= 0 ; i--) {
                if (digits[i] == 9){
                    digits[i] = 0;
                    if (i == 0){
                        int[] target = new int[length+1];
                        target[0] = 1;
                        return target;
                    }
                }else{
                    digits[i] = digits[i]+1;
                    break;
                }
            }
        }
        return digits;
    }

    /**
     * 给两个二进制字符串，返回它们的和（用二进制表示）。
     * @param a
     * @param b
     * @return
     */
    public static String addBinary(String a, String b) {
        int length = Math.max(a.length(),b.length());
        StringBuilder stringBuilder = new StringBuilder();
        int add = 0;
        for (int i = 1; i <= length; i++) {
            int aNum = a.length()-i >=0 ? Integer.parseInt(String.valueOf(a.charAt(a.length()-i))) : 0;
            int bNum = b.length()-i >=0 ? Integer.parseInt(String.valueOf(b.charAt(b.length()-i))) : 0;
            if (aNum + bNum + add > 1){
                stringBuilder.append((aNum + bNum + add)%2);
                if (length == i){
                    stringBuilder.append("1");
                }
                add = 1;
            }else{
                stringBuilder.append(aNum + bNum + add);
                add = 0;
            }
        }
        return stringBuilder.reverse().toString();
    }

}
