public class CachedTextFile implements TextFile {

    private final TextFile textFile;
    private String content;

    public CachedTextFile(TextFile textFile) {
        this.textFile = textFile;
    }

    @Override
    public String getContent() {
        if (content == null) {
            content = textFile.getContent();
        }
        return content;
    }
}