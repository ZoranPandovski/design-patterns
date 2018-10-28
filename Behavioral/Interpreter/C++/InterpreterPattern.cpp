#include <iostream>
#include <string>
#include <map>
#include <list>

namespace interpreter_design_patterns
{

typedef std::string String;
struct Expression;
typedef std::map<String,Expression*> Map;
typedef std::list<Expression*> Stack;

struct Expression {
    virtual int interpret(Map variables) = 0;
	virtual ~Expression() {}
};
 
class Number : public Expression {
private:
	int number;
public: 
	Number(int number)       { this->number = number; }
	int interpret(Map variables)  { return number; }
};
 
class Plus : public Expression {
    Expression* leftOperand;
    Expression* rightOperand;
public: 

    Plus(Expression* left, Expression* right) { 
        leftOperand = left; 
        rightOperand = right;
    }
    ~Plus(){ 
	delete leftOperand;
	delete rightOperand;
    }
 
    int interpret(Map variables)  { 
        return leftOperand->interpret(variables) + rightOperand->interpret(variables);
    }
};
 
class Minus : public Expression {
    Expression* leftOperand;
    Expression* rightOperand;
public: 
    Minus(Expression* left, Expression* right) { 
        leftOperand = left; 
        rightOperand = right;
    }
    ~Minus(){ 
	delete leftOperand;
	delete rightOperand;
    }
 
    int interpret(Map variables)  { 
        return leftOperand->interpret(variables) - rightOperand->interpret(variables);
    }
};
 
class Variable : public Expression {
    String name;
public: 
	Variable(String name)       { this->name = name; }
    int interpret(Map variables)  { 
        if(variables.end() == variables.find(name)) return 0;
        return variables[name]->interpret(variables); 
    }
};

//	While the interpreter pattern does not address parsing, a parser is provided for completeness.
 
class Evaluator : public Expression {
    Expression* syntaxTree;
 
public:
	Evaluator(String expression){
        Stack expressionStack;

	size_t last = 0;
	for (size_t next = 0; String::npos != last; last = (String::npos == next) ? next : (1+next)) {
	    next = expression.find(' ', last);
	    String token( expression.substr(last, (String::npos == next) ? (expression.length()-last) : (next-last)));

            if  (token == "+") {
		Expression* right = expressionStack.back(); expressionStack.pop_back();
                Expression* left = expressionStack.back(); expressionStack.pop_back();
                Expression* subExpression = new Plus(right, left);
                expressionStack.push_back( subExpression );
            }
            else if (token == "-") {
                // it's necessary remove first the right operand from the stack
                Expression* right = expressionStack.back(); expressionStack.pop_back();
                // ..and after the left one
                Expression* left = expressionStack.back(); expressionStack.pop_back();
                Expression* subExpression = new Minus(left, right);
                expressionStack.push_back( subExpression );
            }
            else                        
                expressionStack.push_back( new Variable(token) );
        }

        syntaxTree = expressionStack.back(); expressionStack.pop_back();
    }

     ~Evaluator() {
	delete syntaxTree;
     }
 
    int interpret(Map context) {
        return syntaxTree->interpret(context);
    }
};

}

void main()
{
	using namespace interpreter_design_patterns;

	Evaluator sentence("w x z - +");

	static
	const int sequences[][3] = {
		{5, 10, 42}, {1, 3, 2}, {7, 9, -5},
	};
	for (size_t i = 0; sizeof(sequences)/sizeof(sequences[0]) > i; ++i) {
		Map variables;
		variables["w"] = new Number(sequences[i][0]);
		variables["x"] = new Number(sequences[i][1]);
		variables["z"] = new Number(sequences[i][2]);
		int result = sentence.interpret(variables);
		for (Map::iterator it = variables.begin(); variables.end() != it; ++it) delete it->second;
    
		std::cout<<"Interpreter result: "<<result<<std::endl;
	}
}
