public class LinkedList<T> implements List<T>{

    node head;
    int size;

    LinkedList(){
        this.head=null;
        this.size=0;
    }

    public class node<T>{
        T data;
        node next;
        node(T data, node next){
            this.data=data;
            this.next=next;
        }
        public node next(){
            return next;
        }
        void setNext(node item){
            next = item;
        }
        public T getData(){
            return data;
        }
    }
    public void add(T item){
        if (head == null){
            head = new node(item, null);
        }
        else{
            node previous = head;
            while(previous.next != null){
                previous = previous.next;
            }
            node current = new node(item, null);
            previous.next = current;
        }
        size++;
    }
    public void add(int pos, T item){
        if (pos>size || pos<0){
            throw new IndexOutOfBoundsException();
        }
        if (pos == 0){
            node current = new node(item, null);
            current.setNext(head);
            head = current;
        }
        else{
            node current = new node(item,null);
            node previous = head;
            for (int i = 0; i<pos-1;i++){
                previous = previous.next;
            }
            current.setNext(previous.next);
            previous.setNext(current);
        }
        size++;
    }
    public T remove(int pos){
        if (pos>size-1 || pos<0){
            throw new IndexOutOfBoundsException();
        }
        if (pos==0){
            node temp = head;
            head = head.next;
            size--;
            return (T)temp.getData();
        }
        else{
            node previous = head;
            node temp = previous;
            for (int i = 0; i<pos-1;i++){
                temp = previous.next;
                previous = temp;
            }
            size--;
            return (T)temp.next.getData();
        }
    }
    public T get(int pos){
        node temp = null;
        if (pos==0){
            temp = head;
        }
        else{
            node previous = head;
            for (int i = 0; i<pos;i++){
                temp = previous;
                previous.next = temp.next;
            }
        }
        return (T)temp.getData();
    }
    public int size(){
        return size;
    }

}
