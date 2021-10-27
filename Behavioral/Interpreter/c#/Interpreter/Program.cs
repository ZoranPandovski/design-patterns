using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Interpreter
{
    public interface IElement
    {
        int Value { get; }
    }

    public class Integer : IElement
    {
        public Integer(int value)
        {
            this.Value = value;
        }
        public int Value { get; }
    }

    public class BinaryOperation : IElement
    {
        public enum Type
        {
            Addition, Substraction
        }
        public Type MyType;
        public IElement Left, Right;
        public int Value
        {
            get
            {
                switch (MyType)
                {
                    case Type.Addition:
                        return Left.Value + Right.Value;
                    case Type.Substraction:
                        return Left.Value - Right.Value;
                    default:
                        throw new ArgumentOutOfRangeException();
                }
            }
        }
    }

    public enum Type
    {
        Integer, Plus, Minus, LeftParen, RightParen
    }

    public class Token
    {
        public Type MyType { get; set; }
        public string Text { get; set; }

        public Token(Type type, string text)
        {
            this.MyType = type;
            this.Text = text;
        }

        public override string ToString()
        {
            return $"`{Text}`";
        }
    }

    public class Program
    {
        static List<Token> Lex(string input)
        {
            var results = new List<Token>();
            for (int i = 0; i < input.Length; i++)
            {
                switch (input[i])
                {
                    case '+':
                        results.Add(new Token(Type.Plus, "+"));
                        break;
                    case '-':
                        results.Add(new Token(Type.Minus, "-"));
                        break;
                    case '(':
                        results.Add(new Token(Type.LeftParen, "("));
                        break;
                    case ')':
                        results.Add(new Token(Type.RightParen, ")"));
                        break;
                    default:
                        var sb = new StringBuilder(input[i].ToString());
                        for (int j = i + 1; j < input.Length; ++j)
                        {
                            if (char.IsDigit(input[j]))
                            {
                                sb.Append(input[j].ToString());
                                ++i;
                            }
                            else
                            {
                                results.Add(new Token(Type.Integer,sb.ToString()));
                                break;
                            }
                        }
                        break;
                }
            }
            return results;
        }

        static IElement Parse(IReadOnlyList<Token> tokens)
        {
            var result = new BinaryOperation();
            bool haveLHS = false;
            for (int i = 0; i < tokens.Count; i++)
            {
                var token = tokens[i];

                switch (token.MyType)
                {
                    case Type.Integer:
                        var integer = new Integer(int.Parse(token.Text));
                        if (!haveLHS)
                        {
                            result.Left = integer;
                            haveLHS = true;
                        }
                        else
                        {
                            result.Right = integer;
                        }
                        break;
                    case Type.Plus:
                        result.MyType = BinaryOperation.Type.Addition;
                        break;
                    case Type.Minus:
                        result.MyType = BinaryOperation.Type.Substraction;
                        break;
                    case Type.LeftParen:
                        int j = i;
                        for (;j < tokens.Count; ++j)
                            if (tokens[j].MyType == Type.RightParen)
                                break;
                        var subexpression = tokens.Skip(i + 1)
                            .Take(j - i - 1).ToList();
                        var element = Parse(subexpression);
                        if (!haveLHS)
                        {
                            result.Left = element;
                            haveLHS = true;
                        }
                        else
                        {
                            result.Right = element;
                        }
                        i = j;
                        break;
                    default:
                        throw new ArgumentOutOfRangeException();
                }
            }
            return result;
        }

        static void Main(string[] args)
        {
            string input = "(13+4)-(2+1)";
            var tokens = Lex(input);

            var parsed = Parse(tokens);
            Console.WriteLine(string.Join("\t", parsed.Value));

            Console.WriteLine(string.Join("\t", tokens));
        }
    }
}
 