/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyLinkedList;

/**
 *
 * @author MTC
 * @param <T>
 */
public class MyLinkedList<T> {
    MyNode<T> head;
    MyNode<T> tail;
    
    public MyLinkedList() {
        head = new MyNode<>();
        tail = new MyNode<>();
    }
    public boolean isEmpty(){
        if (head == null) return true;
        return head.getData() == null;
    }
    public  void clear(){
        head = tail = null;
    }
    public void addToTail(T data){
        MyNode<T> n = new MyNode<>();
        n.setData(data);
        if (isEmpty()){
            head = tail = n;
        } else {
            tail.setNext(n);
            tail=n;
        }
    }
    public void addToHead(T data){
        MyNode<T> n = new MyNode<>();
        
        n.setData(data);
        if (isEmpty()) {
            head = tail = n;
        } else {
            n.setNext(head);
            head=n;
        }
    }
    public void addToIndex(T data, int index){
        MyNode<T> n = new MyNode<>();
        MyNode<T> temp = new MyNode<>();
        n.setData(data);   
        
        if (isEmpty()){
            head = tail = n;
        } else {
            int i=0;
            temp.setNext(head);
            while(temp.hasNext()){
                if (i<index){
                    temp = temp.getNext();
                    i++;
                } else break;
            }
            if(i == index){
                n.setNext(temp.getNext());
                temp.setNext(n);
            } else throw new IndexOutOfBoundsException();
        }
    }
 
    public void removeTail(){
        if (isEmpty()){
            return;
        } else if (size()==1){
            head = tail = null;
        } else {
            MyNode<T> n = head;
            for (int i = 0; i < size()-2; i++) {
                n=n.getNext();
            }
            n.setNext(null);
            tail = n;
            
            
        }
    }
    public void removeHead(){
        if (isEmpty()){
            return;
        } else if (size()==1){
            head = tail = null;
        } else {
            MyNode<T> n = head;
            n=n.getNext();
            head=n;
        }
    }
    public void removeIndex(int index){
        MyNode<T> n = new MyNode<>();
        MyNode<T> temp = new MyNode<>();

        
        if (isEmpty()){
            head = tail = n;
        } else if (size()==1){
            head = tail = null;
        } else {
            int i=0;
            temp.setNext(head);
            while(temp.hasNext()){
                if (i<index){
                    temp = temp.getNext();
                    i++;
                } else break;
            }
            if(i == index){
                temp.setNext(temp.getNext().getNext());
            } else throw new IndexOutOfBoundsException();
        }
    }
    public T getHead(){
        if (head == null) return null;
        return head.getData();
    }
    public T getTail(){
        if (head == null) return null;
        return tail.getData();
    }
    public T getIndex(int index){
        if (head == null) return null;
        MyNode<T> temp = head;
        if (index < size()){
            for (int i = 0; i < index; i++) {
                temp = temp.getNext();
            }
        }
        return temp.getData();
    }
    public void traverse(){
        MyNode<T> temp = head;
        while(temp!=null){
            System.out.println(temp.getData());
            temp = temp.getNext();
        }
    }
    public int size(){
        int c =0;
        if (isEmpty()) return c;
        MyNode<T> temp = head;
        while (temp!=null){
            temp = temp.getNext();
            c++;
        }
        return c;
    }
    
    public static void main(String[] args) {
        MyLinkedList test = new MyLinkedList();
        System.out.println(test.isEmpty());
        test.addToTail("hello");
        System.out.println(test.isEmpty());
        test.addToTail("/??");
        test.addToTail("tail");
        System.out.println(test.getTail());
        test.clear();
        System.out.println(test.getHead());
//        System.out.println(test.size());
//        test.removeTail();
//        System.out.println(test.getTail());
        System.out.println(test.size());
    }
}
