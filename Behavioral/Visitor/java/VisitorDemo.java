public class VisitorDemo {
    public static void main(String[] args) {
        ShapeVisitor visitor = new PrintAreaVisitor();

        Rectangle rectangle = new Rectangle(2, 3);
        rectangle.accept(visitor);

        Circle circle = new Circle(1);
        circle.accept(visitor);
    }
}
