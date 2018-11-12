pub struct Lexer {
    tokens: Vec<String>
}

impl Lexer {
    fn tokenize(&mut self, text: &str);
    fn tokens(&self) -> &[String];
}
pub struct Parser {
    nodes: Vec<String>
}

impl Parser {
    fn parse(&mut self, tokens: &[String]);
    fn ast(&self) -> &[String];
}

pub struct Generator {
    machine_code: Vec<String>
}

impl Generator {
    fn generate(&mut self, ast: String);
    fn assembly(&self) -> &[String];
}

// The Facade for the underlying systems: Lexer, Parser and Code Generator
pub struct Compiler {
    flex: Lexer,
    yacc: Parser,
    llvm: Generator,
}

impl Compiler {
    fn new() -> Compiler;
    fn compile(&mut self, code: String) -> &[String] {
        flex.tokenize(code);
        yacc.parse(flex.tokens());
        llvm.generate(yacc.ast());
        llvm.assembly()
    }
}

fn main() {
    let gcc = Compiler::new();
    println!("Compiled code: {}", gcc.compile("Some code"));
}
