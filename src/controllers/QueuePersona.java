package Controllers;

import Models.*;

public class QueuePersona extends QueueG<Persona> {

    public Persona findByName(String nombre) {
        NodeGeneric<Persona> actual = this.primero; // requiere que primero sea protected
        while (actual != null) {
            if (actual.getValue().getNombre().equalsIgnoreCase(nombre)) {
                return actual.getValue();
            }
            actual = actual.getNext();
        }
        return null;
    }

    public Persona deleteByName(String nombre) {
        NodeGeneric<Persona> actual = this.primero;
        NodeGeneric<Persona> anterior = null;

        while (actual != null) {
            if (actual.getValue().getNombre().equalsIgnoreCase(nombre)) {
                Persona personaEliminada = actual.getValue();

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