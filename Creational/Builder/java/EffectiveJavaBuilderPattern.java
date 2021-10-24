import java.time.LocalDate;

class EffectiveJavaBuilderPattern {

    public static class Book {
        private final String isbn;
        private final String title;
        private final String genre;
        private final String author;
        private final LocalDate published;
        private final String description;
        private Book(Builder builder) {
            this.isbn = builder.isbn;
            this.title = builder.title;
            this.genre = builder.genre;
            this.author = builder.author;
            this.published = builder.published;
            this.description = builder.description;
        }

        public String getIsbn() {
            return isbn;
        }

        public String getTitle() {
            return title;
        }

        public String getGenre() {
            return genre;
        }

        public String getAuthor() {
            return author;
        }

        public LocalDate getPublished() {
            return published;
        }

        public String getDescription() {
            return description;
        }

        public static class Builder {
            private final String isbn;
            private final String title;
            private String genre;
            private String author;
            private LocalDate published;
            private String description;

            public Builder(String isbn, String title) {
                this.isbn = isbn;
                this.title = title;
            }

            public Builder genre(String genre) {
                this.genre = genre;
                return this;
            }

            public Builder author(String author) {
                this.author = author;
                return this;
            }

            public Builder published(LocalDate published) {
                this.published = published;
                return this;
            }

            public Builder description(String description) {
                this.description = description;
                return this;
            }

            public Book build() {
                return new Book(this);
            }

        }
    }

    public static void main(String[] args) {
        var book = new Book.Builder("isbn", "Effective Java")
                .author("Joshua Bloch")
                .published(LocalDate.of(2021, 01, 01))
                .build();

        System.out.println(String.format("%s is written by %s and originally published on %s", book.getTitle(), book.getAuthor(), book.getPublished()));
    }
}
