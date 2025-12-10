package stack;

public interface IStack {
    void push(int x);

    int pop();

    int peek();

    int size();

    boolean empty();

    boolean full();
}
