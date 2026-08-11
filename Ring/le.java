public class le<T{
    //Datentypen
    private T value;
    protected le<T> next;   //links
    protected le<T> prev;   //rechts
    
    //Konstruktor
    public le(T value){
        this.value = value;
    }
    
    //Methoden
    public T getValue(){
        return value;
    }
    
    public le<T> getNext(){
        return next;
    }
    
    public le<T> getPrev(){
        return prev;
    }
    
}