
package MyQueue;

import MyLinkedList.*;

public class MyQueue<T> {
    MyLinkedList<T> linkedList = new MyLinkedList<>();
    
    public boolean isEmpty(){
        return linkedList.isEmpty();
    }
    public void enqueue(T item){
        linkedList.addToHead(item);
    }
    public T dequeue(){
        T data = linkedList.getTail();
        linkedList.removeTail();
        return data;
    }
    public T front(){
        return linkedList.getTail();
    }
    public void clean(){
        linkedList.clear();
    }
    public void visit(){
        for (int i = 0; i < linkedList.size(); i++) {
            System.out.println(linkedList.getIndex(i));
        }
    }
}
