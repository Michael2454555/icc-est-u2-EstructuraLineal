package controllers;

import java.util.EmptyStackException;

import models.NodeGeneric;

public class QueueG <T>{
    private NodeGeneric <T> primero; 
    private NodeGeneric <T> ultimo; 
    private int size;

    public QueueG(){
        this.primero=null;
        this.ultimo=null;
        this.size=0;  
    }
    public void add(T value ){
        NodeGeneric<T> newNode=new NodeGeneric<T>(value);
        if(isEmpty()){
            primero = newNode;
            ultimo = newNode;
        }else{
            ultimo.setNext(newNode);
            ultimo=newNode;
        }

        size++;

        
    }

    public T remove(){
        if (isEmpty()) {
            throw new EmptyStackException();
            
        }
        T aux = primero.getValue();
        primero = primero.getNext();
        size--;
        return aux;
    }
    public int size(){
        return size;
    }
    public T peek(){
        if(isEmpty()) throw new EmptyStackException();return primero.getValue();
    }

    public boolean isEmpty(){
        return primero==null;
    }
    public void printCola(){
        NodeGeneric<T> aux = primero;
        while (aux!=null) {
            System.out.print(aux.getValue()+"|");
            aux=aux.getNext();
            
        }
        System.out.println();
    }
    public T findByName(String clave){
        NodeGeneric<T> aux = primero;
        while (aux!=null) {
            if(aux.getNext().toString().equalsIgnoreCase(clave)){
                return aux.getValue();

            }
            aux=aux.getNext();
            
        }
        return null;

    }

    public T deleteByName(String nombre) {
        NodeGeneric<T> actual = this.primero;
        NodeGeneric<T> anterior = null;

        while (actual != null) {
            if (actual.getValue().getNombre().equalsIgnoreCase(nombre)) {
                T personaEliminada = actual.getValue();

                if (anterior == null) { // es el primero
                    this.primero = actual.getNext();
                    if (this.primero == null) this.ultimo = null; // la cola quedó vacía
                } else {
                    anterior.setNext(actual.getNext());
                    if (actual == this.ultimo) {
                        this.ultimo = anterior;
                    }
                }

                this.size--;
                return personaEliminada;
            }

            anterior = actual;
            actual = actual.getNext();
        }

        return null;
    }

}
