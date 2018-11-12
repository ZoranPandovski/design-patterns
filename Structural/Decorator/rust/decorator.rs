use std::str::Lines;
pub struct TextReader {
    text: String
}

impl TextReader {
    fn read(&self) -> Lines {
        self.text.lines()
    }

    fn set_text(&mut self, text: &str) {
        self.text = text.to_string();
    }
}

enum Color {
    Red,
    Green,
    Blue
}

// Decorator for TextReader
pub struct Frame {
    tr: TextReader,
    border_width: u32,
    border_color: Color
}

impl Frame {
    fn read(&self) -> Lines {
        self.tr.read()
    }

    fn set_text(&mut self, text: &str) {
        self.tr.set_text(text);
    }

    fn set_border_width(&mut self, width: u32) {
        self.border_width = width;
    }

    fn set_border_color(&mut self, color: Color) {
        self.border_color = color;
    }
}

fn main() {
    let text = "This is\na sample text\nto test that this\nworks!";
    let kindle = Frame { tr: TextReader { text: String::new() }, border_width: 1, border_color: Color::Green };
    if let Some(value) = kindle.read().next() {
        assert_eq!(value, "This is");
    }
}
