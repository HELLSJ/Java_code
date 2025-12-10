public class LogIn {
    private String userName = "admin";
    private String password = "123456";
    public static void loginInfo(String userName, String password) throws UserNameException, PasswordException{
        if (!userName.equals(userName)) {
            //用户名有问题
            throw new UserNameException("用户名有问题！");
        }
        if (!password.equals(password)) {
            //密码有问题
            throw new PasswordException("密码有问题！");
        }
        System.out.println("登陆成功");
    }
    public static void main(String[] args) {
        try{
            loginInfo("admin", "123456");
        }catch(UserNameException e){


        }catch(PasswordException e){

        } finally{

        }
    }
}

//如果要写一个自定义异常，一定要继承一个异常
//extends Exception
//
class UserNameException extends Exception {
    public UserNameException(String message) {
        super(message);
    }
}
class PasswordException extends Exception {
    public PasswordException(String message) {
        super(message);
    }
}