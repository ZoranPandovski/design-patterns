using System.Text;

namespace DesignPatters
{
    using DictType = Dictionary<Type, Action<Expression, StringBuilder>>;

    public abstract class Expression
    {

    }

    public class DoubleExpression : Expression
    {
        public double Value { get; set; }  

        public DoubleExpression(double value)
        {
            this.Value = value;
        }
    }

    public class AdditionExpression : Expression
    {
        public Expression Left;
        public Expression Right;

        public  AdditionExpression(Expression left, Expression right)
        {
            Left = left ?? throw new ArgumentNullException(paramName: nameof(left));
            Right = right ?? throw new ArgumentNullException(paramName: nameof(right));
        }
    }

    public static class ExpressionPrinter
    {
        private static DictType actions = new DictType
        {
            [typeof(AdditionExpression)] = (e, sb) =>
            {
                var ae = (AdditionExpression)e;
                sb.Append("(");
                Print(ae.Left, sb);
                sb.Append("+");
                Print(ae.Right, sb);
                sb.Append(')');
            },
            [typeof(DoubleExpression)] = (e, sb) =>
            {
                var de = (DoubleExpression)e;
                sb.Append(de.Value);
            }
        };
        public static void Print(Expression e, StringBuilder sb)
        {
            actions[e.GetType()](e, sb);
        }
    }

    public class Demo
    {
        public static void Main()
        {
            var e = new AdditionExpression(new DoubleExpression(2), new AdditionExpression(new DoubleExpression(2),new DoubleExpression(2)));
            var sb = new StringBuilder();
            ExpressionPrinter.Print(e, sb);
            Console.WriteLine(sb.ToString());

        }
    }
}