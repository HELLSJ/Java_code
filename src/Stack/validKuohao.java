package Stack;
//https://leetcode.cn/problems/valid-parentheses/
import java.util.Stack;

public class validKuohao {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        //1. ±éÀú×Ö·û´®
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            //2. ÅÐ¶ÏÊÇ²»ÊÇ×óÀ¨ºÅ
            if(ch=='{' || ch=='[' || ch=='('){
                stack.push(ch);
            }else{
                //3.Óöµ½ÓÒÀ¨ºÅ
                if(stack.empty()){
                    return false;
                }
                char ch2 = stack.peek();
                if((ch2 == '{' && ch =='}' ) || (ch2=='[' && ch ==']') || (ch2=='(' && ch == ')')){
                    //µ¯³öÆ¥ÅäµÄ×óÀ¨ºÅ
                    stack.pop();
                }else{
                    return false;
                }
            }
        }
        if(!stack.empty()){
            return false;
        }
        return true;
    }
}
