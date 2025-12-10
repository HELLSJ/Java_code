public class Test {
    public static void main(String[] args) {
        char[] ch = new char[]{'a', 'b', 'c'};
        String s1 = new String(ch); // s1对象并不在常量池中
        //s1.intern();调用之后，会将s1对象的引用放入到常量池中
        String s2 = "abc"; // "abc" 在常量池中存在了，s2创建时直接用常量池中"abc"的引用
        System.out.println(s1 == s2);
    }
    public static void main1(String[] args) {
        String s1 = "hello";
        String s2 = "hello";
        String s3 = new String("hello");
        String s4 = new String("hello");
        System.out.println(s1 == s2); // true
        System.out.println(s1 == s3); // false
        System.out.println(s3 == s4); // false
    }
}
