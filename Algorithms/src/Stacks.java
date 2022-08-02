
import java.util.EmptyStackException;

class Stack<T>{
    class Node<T>{
        private T data;
        private Node<T> next;

        public Node(T data){
            this.data = data;
        }
    }
    private Node<T> top; // 맨 위에 있는 요소의 주소

    public T pop(){ //데이터 삭제
        if(top == null){
            throw new EmptyStackException();
        }
        T item = top.data;
        top = top.next;
        return item;
    }
    public void push(T item){ // 데이터 추가
        Node<T> t = new Node<T>(item);
        t.next = top;
        top = t;
    }
    public T peek(){ // 요소를 삭제하지 않고 보기만 함
        if(top == null){
            throw new EmptyStackException();
        }
        return top.data;
    }
    public boolean isEmpty(){ // 스택이 공백인지 검사
        return top == null;
    }
}

public class Stacks {
    public static void main(String[] args){
        Stack<Integer> s = new Stack<Integer>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.peek());
        System.out.println(s.pop());
        System.out.println(s.isEmpty());
        System.out.println(s.pop());
        System.out.println(s.isEmpty());
    }
}
