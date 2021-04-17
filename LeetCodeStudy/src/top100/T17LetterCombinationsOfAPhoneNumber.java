package top100;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 电话号码的字母组合
public class T17LetterCombinationsOfAPhoneNumber {

    public static List<String> letterCombinations(String digits) {
        // 存放结果集
        List<String> res = new ArrayList<>();
        if (digits.length() == 0) return res;
        // 存放数字对应的字母
        HashMap<Character,String> phoneMap = new HashMap<>();
        phoneMap.put('2',"abc");
        phoneMap.put('3',"def");
        phoneMap.put('4',"ghi");
        phoneMap.put('5',"jkl");
        phoneMap.put('6',"mno");
        phoneMap.put('7',"pqrs");
        phoneMap.put('8',"tuv");
        phoneMap.put('9',"wxyz");
        backTracking(res,phoneMap,digits,0,new StringBuffer());
        return res;
    }

    public static void backTracking(List<String> res, Map<Character,String> phoneMap,
                             String digits,int index,StringBuffer subset) {
        // 如果子集长度=字符串长度，加入结果集
        if (index == digits.length()) {
            res.add(subset.toString());
        } else {
            // 取传的号码
            char digit = digits.charAt(index);
            // 取号码对应的字符串
            String letters = phoneMap.get(digit);
            // 对应字符串的长度
            int lettersCount = letters.length();
            // 遍历这个字符串
            for (int i=0;i<lettersCount;i++) {
                // 往子集中append第一个字符
                subset.append(letters.charAt(i));
                // backTracking找下一个号码的字符串
                backTracking(res,phoneMap,digits,index+1,subset);
                // 回退到上一个号码(当每次跳出递归的时候，都会执行这行语句)
                // 索引默认从0开始，所以删index
                subset.deleteCharAt(index);
            }
        }
    }

    public static void main(String[] args) {
        String digits = "23";
        List<String> list = letterCombinations(digits);
        list.forEach(System.out::println);
    }
}
