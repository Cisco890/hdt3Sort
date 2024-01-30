/** Anthony Lou Shwank 23410/Juan Francisco Martínez 23617
  * Icalculadora
 
  * @param   no_hay
  * @throws Stacks Clase que crea la estructura y metodos que usan los stacks con datos genericos
  */
  public class CustomStack<T> {
    public Node<T> lastNode;
    public Node<T> firstNode;

    public void push(T value) {                     //Inicia metodo push
        if (lastNode == null) {                     //Indicamos instrucciones para cuando se esta empezando una lista
            lastNode = new Node<T>(value);
            firstNode = lastNode;
        } else {                                    //Si ya hay valores, metemos el nuevo valor indicado y lo convertimos al nuevo dato "current"
            Node<T> current = new Node<T>(value);
            current.setNext(firstNode);
            firstNode = current;
        }
    }

    public boolean isEmpty() {                      //Indica metodo isEmpty
        return firstNode == null;                   //Nos devuelve el dato para revisar que la lista esta vacia
    }
    
    public T pop() {                                //Indica metodo pop
        if (firstNode != null) {                    //Revisa primero que si hayan datos dentro del stack
            T value = firstNode.getValue();         //Devuelve el dato dentro del stack, mientras que simultaneamente el stack es disasociado de la cadena de la pila
            firstNode = firstNode.getNext();
            return value;
        }
        return null;
    }
}

