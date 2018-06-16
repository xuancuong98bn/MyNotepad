/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyStack;

import MyLinkedList.*;

/**
 *
 * @author MTC
 * @param <T>
 */
public class MyStack<T>{
    MyLinkedList<T> linkedList = new MyLinkedList<>();

    public MyStack() {
    }
    
    public void push(T item){
        linkedList.addToTail(item);
    }
    public T pop(){
        T data = linkedList.getTail();
        linkedList.removeTail();
        return data;
    }
    public T top(){
        return linkedList.getTail();
    }
    public void print(){
        for (int i = 0; i < linkedList.size(); i++) {
            System.out.println(linkedList.getIndex(i));
        }
    }
    public void clear(){
        linkedList.clear();
    }
    public boolean isEmpty(){
        return linkedList.isEmpty();
    }
    
    public static void main(String[] args) {
        MyStack test = new MyStack();
         System.out.println(test.isEmpty());
        test.push("hello");
        test.push("hellow");
        System.out.println(test.isEmpty());
        System.out.println(test.pop().toString());
        System.out.println(test.top().toString());
        System.out.println(test.top().toString());
        System.out.println(test.pop().toString());
        System.out.println(test.isEmpty());
        
    }
}
