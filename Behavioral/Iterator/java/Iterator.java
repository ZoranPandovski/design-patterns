interface Collection {
    
        public void add(double x);
        public int size();
        public Iterator createIterator();
    }
    
    interface Iterator {
    
        public void first();
        public void next();
        public boolean isDone();
        public double currentElement();
    }
    
    class List implements Collection{
    
        private double [] elements;
        private int free; // Marks the first empty slot in the array
    
        public List(int size){
            //Creates the iterable list.
            elements = new double[size];
            free = 0;
        }
    
        public void add(double x){
    
            elements[free] = x;
            free++;
        }
    
        public int size(){
    
            return free;
        }
        
        public double getElement(int index){
    
            return elements[index];
        }
    
        public Iterator createIterator(){
    
            return new ListIterator(this);
            //return new ReverseIterator4(this);
        }
    }
    
    class ListIterator implements Iterator {
    
        private List lista;
        private int index;
    
        public ListIterator(List lista){
    
            this.lista = lista;
        }
    
        public void first(){
    
            index = 0;
        }
    
        public void next(){
    
            index++;
        }
    
        public boolean isDone(){
            //returns true if the index is the last element.
            return index == lista.size();
        }
    
        public double currentElement(){
            
            return lista.getElement(index);
        }
    }
    
    class ReverseIterator implements Iterator{
    
        private List list;
        private int index;
    
        public ReverseIterator(List list){
    
            this.list = list;
        }
    
        public void first(){
    
            index = list.size() - 1;
        }
    
        public void next(){
    
            index--;
        }
    
        public boolean isDone(){
    
            return index < 0;
        }
    
        public double currentElement(){
    
            return list.getElement(index);
        }
    }
    
    public class Iterator {
    
        public static void printList(Collection colecao){
    
            System.out.print("Elements: ");
    
            Iterator it = colecao.createIterator();
            
            for(it.first(); !it.isDone(); it.next()){
                 
                System.out.print(it.currentElement() + " ");
            }
    
            System.out.println();
        }
    
        public static void main(String [] args){
    
            double [] values = { 1.0, 5.5, 3.2, 2.3, 9.8 };	
            
            Collection colecao = new List(10);
    
            for(double d : values) colecao.add(d);
    
            printList(colecao);
        }
    }
    
    