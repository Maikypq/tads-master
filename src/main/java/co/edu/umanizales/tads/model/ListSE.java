package co.edu.umanizales.tads.model;

import lombok.Data;

@Data
public class ListSE {
    private Node head;
    /*
    Algoritmo de adicionar al final
    Entrada
        un niño
    si hay datos
    si
        llamo a un ayudante y le digo que se posicione en la cabeza
        mientras en el brazo exista algo
            pasese al siguiente
        va estar ubicado en el ùltimo

        meto al niño en un costal (nuevo costal)
        y le digo al ultimo que tome el nuevo costal
    no
        metemos el niño en el costal y ese costal es la cabeza
     */
    public void add(Kid kid){
        if(head != null){
            Node temp = head;
            while(temp.getNext() !=null)
            {
                temp = temp.getNext();
            }
            /// Parado en el último
            Node newNode = new Node(kid);
            temp.setNext(newNode);
        }
        else {
            head = new Node(kid);
        }
    }

    /* Adicionar al inicio
    si hay datos
    si
        meto al niño en un costal (nuevocostal)
        le digo a nuevo costal que tome con su brazo a la cabeza
        cabeza es igual a nuevo costal
    no
        meto el niño en un costal y lo asigno a la cabez
     */
    public void addToStart(Kid kid){
        if(head !=null)
        {
            Node newNode = new Node(kid);
            newNode.setNext(head);
            head = newNode;
        }
        else {
            head = new Node(kid);
        }
    }
    public void deletebByidentification (String identification){
        Node currentNode = head;
        Node prevNode = null;

        while (currentNode != null && currentNode.getData().getIdentification() != identification){
            prevNode = currentNode;
            currentNode = currentNode.getNext();
        }
        if (currentNode != null){
            if (prevNode == null){
                head= currentNode.getNext();
            } else {
                prevNode.setNext(currentNode.getNext());
            }
        }
    }
    public void addByposition(Kid kid, int position){
        Node nuevoNodo = new Node(kid);
        if (position== 0){

            nuevoNodo.setNext(head);

            head = nuevoNodo;

        } else  {

            Node actual = head;

            for (int i= 0; i <position - 1; i++){

                actual = actual.getNext();
            }
            nuevoNodo.setNext(actual.getNext());

            actual.setNext(nuevoNodo);
        }

            }
    // Codigo parcial 1 (ELIMINAR A UN NIÑO POR UNA EDAD DADA)
    public void deleteByAge(int age) {
        Node current = head;
        Node prev = null;

        while (current != null) {
            if (current.getData().getAge() == age) {
                if (prev == null) {
                    // Si el niño a eliminar está al inicio de la lista
                    head = current.getNext();
                } else {
                    // Si el niño a eliminar está en otro lugar de la lista
                    prev.setNext(current.getNext());
                }
            } else {
                prev = current;
            }
            current = current.getNext();
        }
    }

    // Codigo parcial 1 (DEFINIRLE A UN NIÑO QUE ADELANTE UN NUMERO DE POSICIONES DADAS)

    public void moveKidToPosition(Kid kid, int newPosition) {
        if (head == null) {
            // la lista está vacía, no se puede mover ningún niño
            return;
        }

        Node currentNode = head;
        Node prevNode = null;
        int currentPosition = 0;

        // Busca el nodo que contiene al niño que se desea mover
        while (currentNode != null && !currentNode.getData().equals(kid)) {
            prevNode = currentNode;
            currentNode = currentNode.getNext();
            currentPosition++;
        }

        if (currentNode == null) {
            // el niño no se encuentra en la lista, no se puede mover
            return;
        }

        if (newPosition < 0 || newPosition >= currentPosition) {
            // la posición a la que se desea mover el niño no es válida
            return;
        }

        // elimina el nodo que contiene al niño de la lista
        if (prevNode == null) {
            // el nodo a eliminar es el primero de la lista
            head = currentNode.getNext();
        } else {
            prevNode.setNext(currentNode.getNext());
        }

        // inserta el nodo en la nueva posición
        Node newNode = new Node(kid);
        if (newPosition == 0) {
            // el nodo se inserta al principio de la lista
            newNode.setNext(head);
            head = newNode;
        } else {
            // busca el nodo que va justo antes de la nueva posición
            Node actual = head;
            for (int i = 0; i < newPosition - 1; i++) {
                actual = actual.getNext();
            }
            // inserta el nodo después de ese nodo
            newNode.setNext(actual.getNext());
            actual.setNext(newNode);
        }

    }
}
