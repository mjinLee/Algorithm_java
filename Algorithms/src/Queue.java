import java.util.NoSuchElementException;

class Queue_<T>{
    class Node<T>{
        private T data;
        private Node<T> next;
        public Node(T data){
            this.data = data;
        }
    }
    private Node<T> first;
    private Node<T> last;

    public void add(T item){
        Node<T> t = new Node<T>(item);
        if(last != null){ // 마지막 node가 있으면
            last.next = t; // 뒤에 새로 생성한 node붙이고
        }
        last = t; // t가 마지막 node
        if(first == null){ // data가 없으면
            first = last; // 같은 값 할당
        }
    }
    public T remove(){
        if(first == null){
            throw new NoSuchElementException();
        }
        T data = first.data; // backup
        first = first.next; // 다음 요소를 first로

        if(first == null){
            last = null;
        }
        return data;
    }
    public T peek(){
        if(first == null){
            throw new NoSuchElementException();
        }
        return first.data;
    }
    public boolean isEmpty(){
        return first == null;
    }
}
public class Queue {
    public static void main(String[] args){
        Queue_<Integer> q = new Queue_<Integer>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q.peek());
        System.out.println(q.remove());
        System.out.println(q.isEmpty());
        System.out.println(q.remove());
        System.out.println(q.isEmpty());
    }
}
