public class CircleData
{
    private double radius;
    private Color color;
    private Point origin;
    public CircleData(double radius, Color color, Point origin)
    {
        this.radius = radius;
        this.color = color;
        this.origin = origin;
    }
    public double Radius
    {
        get { return this.radius; }
    }
    public Color Color
    {
        get { return this.color; }
    }
    public Point Origin
    {
        get { return this.origin; }
    }
}
public class Circle
{
    private CircleData circleData;
    public Circle(double radius, Color color, Point origin)
    {
        this.circleData = new CircleData(radius, color, origin);
    }
    public double Circumference
    {
        get { return this.circleData.Radius * Math.PI; }
    }
    public double Diameter
    {
        get { return this.circleData.Radius * 2; }
    }
    public void Draw(Graphics graphics)
    {
        //...
    }
}