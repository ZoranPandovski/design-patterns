public abstract class Shape {
    //Composition - implementor
    Color color;

    //constructor with implementor as input argument
    Shape(Color c) {
        this.color = c;
    }

    abstract public void applyColor();
}
