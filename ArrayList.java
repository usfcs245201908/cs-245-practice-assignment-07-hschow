public class ArrayList<T> implements  List<T>{

    int size;
    T[] a;

    ArrayList(){
        size = 0;
        a = (T[]) new Object[10];
    }

    public void add(T item){
        if (size==a.length){
            growArray();
        }
        a[size++] = item;
    }
    public void add(int pos, T item){
        //throw exception if i is not in index range
        if (pos>size || pos<0){
            throw new IndexOutOfBoundsException();
        }
        if (size==a.length){
            growArray();
        }
        for (int i = size; i>pos;i--){
            a[i]=a[i-1];
        }
        a[pos]=item;
        size++;
    }
    public T remove(int pos){
        if (pos<0 || pos>=size){
            new IndexOutOfBoundsException();
        }
        T temp = a[pos];
        for (int i = pos;i<size-1;i++){
            a[i]=a[i+1];
        }
        size--;
        return temp;
    }
    public T get(int pos){
        if (pos<0 || pos>=size){
            new IndexOutOfBoundsException();
        }
        return a[pos];
    }
    public int size(){
        return size;
    }
    void growArray(){
        T[] temp = a;
        a = (T[]) new Object[temp.length*2];
        for (int i = 0; i<temp.length;i++){
            a[i]=temp[i];
        }
    }

}
