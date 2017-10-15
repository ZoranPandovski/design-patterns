public class PrintAreaVisitor implements ShapeVisitor {
    @Override
    public void visit(Rectangle rectangle) {
        double area = rectangle.getLength() * rectangle.getWidth();
        System.out.println("Rectangle area: " + area);
    }

    @Override
    public void visit(Circle circle) {
        double area = Math.PI * (circle.getRadius() * circle.getRadius());
        System.out.println("Circle area: " + area);
    }
}
