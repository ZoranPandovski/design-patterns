package java;
public class Books {

    private int isbn;
    private String bookName;

    public Books() {
    }

    public Books(int isbn, String bookName) {
        this.isbn = isbn;
        this.bookName = bookName;
    }

    public int getIsBn()
    {
        return this.isbn;
    }
    
    public void setIsBn(int isbn)
    {
        this.isbn = isbin;
    }
    
    public String getBookName()
    {
        return this.bookName;
    }
    
    public void setIsBn(String bookName)
    {
        this.bookName = bookName;
    }
    
    public String toString()
    {
        return this.isbn+" "+this.bookName;
    }
}

