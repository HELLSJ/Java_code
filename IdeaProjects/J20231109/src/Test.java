import java.util.Arrays;

public class Test {
    public static boolean isNumOrCharacter(char ch){
        if(ch >= '0' && ch <= '9' || ch >= 'a' && ch <= 'z'){
            return true;
        }
        return false;
    }
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        //定义i和j下标
        int i = 0;
        int j = s.length()-1;
        while(i < j){
            //i要一直走到一个合法的字符那里，而且为了防止i越界得多加一个i<j的前提
            while(i < j && !isNumOrCharacter(s.charAt(i))){
                i++;
            }
            //j要一直走到一个合法的字符那里，而且为了防止j越界得多加一个i<j的前提
            while(i < j && !isNumOrCharacter(s.charAt(j))){
                j--;
            }
            //对应下标字符一样，i++，j--
            if(s.charAt(i) == s.charAt(j)){
                i++;
                j--;
            }else{
                //对应下标不一样
                return false;
            }
        }
        return true;
    }
    public int firstUniqChar(String s) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            count[ch-'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(count[ch-'a'] == 1){
                return i;
            }
        }
        return -1;
    }
    public static void main26(String[] args) {
        long start = System.currentTimeMillis();
        String s = "";
        for(int i = 0; i < 10000; ++i){
            s += i;
        }
        long end = System.currentTimeMillis();
        System.out.println("String: "+(end - start));

        start = System.currentTimeMillis();
        StringBuffer sbf = new StringBuffer("");
        for(int i = 0; i < 10000; ++i){
            sbf.append(i);
        }
        end = System.currentTimeMillis();
        System.out.println("StringBuffer: "+(end - start));

        start = System.currentTimeMillis();
        StringBuilder sbd = new StringBuilder();
        for(int i = 0; i < 10000; ++i){
            sbd.append(i);
        }
        end = System.currentTimeMillis();
        System.out.println("StringBuilder: "+(end - start));
    }
    public static void main24(String[] args) {
        String str = "hello";
        StringBuilder stringBuilder = new StringBuilder();//底层构建了一个新对象stringBuilder
        stringBuilder.append(str);
        stringBuilder.append("abc");
        str = stringBuilder.toString();
        System.out.println(str);
    }
    public static void main23(String[] args) {
        String str = "hello";
//        System.out.println(str);//hello
        str = str + "abc";
        System.out.println(str);//helloabc
    }
//    String str = new String("good");
//    char[ ] ch = { 'a' , 'b' , 'c' };
//    public static void main22(String args[]){
//        Test ex = new Test();
//        ex.change(ex.str,ex.ch);
//        System.out.print(ex.str + " and ");
//        System.out.print(ex.ch);
//    }
    public void change(String str,char ch[ ]){
        str = "test ok";
        ch[0] = 'g';
    }
    public static void main16(String[] args) {
        String str = "     fasfsgfdajhsd   ahgsdjhsa   ";
        System.out.println(str);
        System.out.println(str.trim());
    }
    public static void main15(String[] args) {
        String str = "ababc";
//        String ret = str.substring(0,3);//截取字符串范围[0,3)
//        System.out.println(ret);
        String ret1 = str.substring(2);
        System.out.println(ret1);
    }
    public static void main14(String[] args) {
        String str = "name=zhangsan&age=18" ;
//        String[] ret = str.split("=|&");
//        for (int i = 0; i < ret.length; i++) {
//            System.out.println(ret[i]);
//        }
        String[] ret = str.split("&");
        for (int i = 0; i < ret.length; i++) {
            System.out.println(ret[i]);
            String x = ret[i];
            //在第一次分割的基础上按照"="进行第二次分割
            String[] ret2 = x.split("=");
            for (int j = 0; j < ret2.length; j++) {
                System.out.println(ret2[j]);
            }
        }
    }
    public static void main13(String[] args) {
        String str = "192.168.1.1";
        String[] ret = str.split("\\.");
        for (int i = 0; i < ret.length; i++) {
            System.out.println(ret[i]);
        }
    }
    public static void main12(String[] args) {
        String str = "ababcabcabcde";
        String ret = str.replace("ab","99");
        System.out.println(ret);
        ret = str.replaceFirst("ab","8888");
        System.out.println(ret);
    }
    public static void main11(String[] args) {
        String s = String.format("%d-%d-%d",2023,11,9);
        System.out.println(s);
    }
    public static void main10(String[] args) {
        String s1 = "hello";
        char[] array = s1.toCharArray();
        System.out.println(Arrays.toString(array));
    }
    public static void main9(String[] args) {
        String s1 = "hello";
        //转变为大写不是在原来的基础上转变
        //转变成大写后是一个新的对象
        String ret = s1.toUpperCase();
        System.out.println(ret);
    }
    public static void main8(String[] args) {
        int data = Integer.parseInt("19.8");
        System.out.println(data);
//        String s = String.valueOf(19.9);
//        System.out.println(s);
//
    }
    public static void main7(String[] args) {
        String s1 = "ababcabcd";

        int index = s1.indexOf("abc");
        System.out.println(index);
        //char ch = s1.charAt(12);
//        System.out.println(ch);
    }
    public static void main6(String[] args) {
        String s1 = new String("abc");
        String s2 = new String("ABC");

        System.out.println(s1.compareToIgnoreCase(s2));
        //System.out.println(s1 == s2);
        //System.out.println(s1.equals(s2));
    }
    public static void main3(String[] args) {
//        String s1 = new String("hello");
//        String s2 = new String("world");
//        String s3 = s1;
//
//        System.out.println(s1.length());
//        System.out.println(s2.length());
//        System.out.println(s3.length());

        String str4 = "";
//        System.out.println(str4.length());
        System.out.println(str4.isEmpty());
        String str5 = null;
        //System.out.println(str5.length());
        System.out.println(str5.isEmpty());
    }
    public static void main1(String[] args) {
        //"hello" 是字符串常量，没有\0标记结尾
        String str = "hello";
        System.out.println(str);//hello

        String str2 = new String();
        System.out.println(str2);//没有输出

        String str3 = new String("pppp");
        System.out.println(str3);//pppp

        char[] array = {'a','b','c'};
        String str4 = new String(array);
        System.out.println(str4);//abc

        char[] array1 = {'a','b','c'};
        String str5 = new String(array1,1,2);
        System.out.println(str5);//bc
    }
}
