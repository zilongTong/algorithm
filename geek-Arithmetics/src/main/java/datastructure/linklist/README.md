

class Node<E> {
 
    E item;
    Node<E> next;
    
    //构造函数
    Node(E element) {
       this.item = element;
       this.next = null;
   }
}