package controllers;
import java.util.EmptyStackException;

import models.*;

public class Stack {
    private Node top;
    private int size;

    public Stack(){
        this.top=null;
        this.size=0;

    }

    public void push(int value){
        Node newNode=new Node(value);
        newNode.setNext(top);
        top =  newNode;
        size++;
     
    }

    public int pop(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        int value = top.getValue();
        top = top.getNext();
        size--;
        return value;
    }

    public int peek(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        int value = top.getValue();
        
        return value;

    }

    public void printStack(){
        Node aux = top;
        while (aux!=null) {
            System.out.print(aux.getValue()+"|");
            aux=aux.getNext();
            
        }
        System.out.println();
        
        

    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return top==null;
    }

    
}
