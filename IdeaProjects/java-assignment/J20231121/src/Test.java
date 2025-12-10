import java.util.Scanner;

class LoginException extends Exception {
    public LoginException(String message) {
        super(message);
    }
}

public class Test{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入用户名：");
        String username = scanner.nextLine();

        System.out.println("请输入密码：");
        String password = scanner.nextLine();

        try {
            login(username, password);
            System.out.println("登录成功！");
        } catch (LoginException e) {
            System.out.println("登录失败：" + e.getMessage());
        }
    }


    public static void login(String username, String password) throws LoginException {
        // 假设正确的用户名和密码分别为 "admin" 和 "password"
        if (!username.equals("admin") || !password.equals("password")) {
            throw new LoginException("用户名或密码错误");
        }
    }
}