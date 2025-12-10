
class Message<T> {
    private T message ;
    public T getMessage() {
        return message;
    }
    public void setMessage(T message) {
        this.message = message;
    }
}
public class Test {
    public static void main(String[] args) {
        Message<String> message = new Message<>() ;
        message.setMessage("比特就业课欢迎您");
        fun(message);

        Message<Integer> message2 = new Message<>() ;
        message2.setMessage(10);
        fun(message2);
    }
    public static void fun(Message<?> temp){
        System.out.println(temp.getMessage());
//        temp.setMessage();
    }
}