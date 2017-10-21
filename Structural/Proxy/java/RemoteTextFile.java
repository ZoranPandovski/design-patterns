public class RemoteTextFile implements TextFile {

    private final String content;

    public RemoteTextFile(String content) {
        this.content = content;
    }

    @Override
    public String getContent() {

        // Simulating a remotely hosted file.
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ignored) {
        }
        return content;
    }
}
