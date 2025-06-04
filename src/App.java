import controllers.*;
import models.*;

public class App {
    public static void main(String[] args) throws Exception {
        Stack stack=new Stack();
        stack.push(10);
        stack.push(-1);
        stack.push(5);
        stack.push(8);
        System.out.println("Tam"+stack.size());
        stack.printStack();
        stack.pop();
        System.out.println("Tam"+stack.size());
        stack.printStack();


        StackG<Integer> stackG = new StackG<Integer>();
        stackG.push(10);
        stackG.push(8);
        stackG.push(-1);
        stackG.push(5);
        System.out.println("Tam"+stackG.size());
        stackG.printStack();
        stackG.pop();
        System.out.println("Tam"+stackG.size());
        stackG.printStack();

        Persona p1 = new Persona ("juan");
        Persona p2 = new Persona ("Maria");
        Persona p3 = new Persona ("Pedro");
        Persona p4 = new Persona ("David");

        QueueG<Persona> colaPersonas = new QueueG<Persona>();
        colaPersonas.add(p1);
        colaPersonas.add(p2);
        colaPersonas.add(p3);
        colaPersonas.add(p4);
        colaPersonas.printCola();
        System.out.println("Personas atendida -> "+ colaPersonas.remove());
        colaPersonas.printCola();
        Persona pB = colaPersonas.findByName("Juan");
        System.out.println("Personas encontrada -> "+ pB !=null? pB : "ninguna");
        Persona pE = colaPersonas.deleteByName("Pedro");
        System.out.println("Personas eliminada -> "+ pE !=null? pE : "ninguna");
        colaPersonas.printCola();
        



        
    }
}
