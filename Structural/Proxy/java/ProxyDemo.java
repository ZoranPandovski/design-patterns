public class ProxyDemo {

    public static void main(String[] args) {
        TextFile file = new CachedTextFile(new RemoteTextFile("Sample content"));

        // First file fetch will be slow, as a remote file has to be accessed.
        printContent(file);

        // After fetching the file once, the second attempt will be quick, as file contents will be cached inside the
        // proxy.
        printContent(file);

        // File can be further wrapped in other proxies, to add additional checks.
        printContent(new AccessLimitingTextFile(file, "admin"));
        printContent(new AccessLimitingTextFile(file, "user"));
    }

    private static void printContent(TextFile file) {
        System.out.println("Getting file content...");

        long start = System.currentTimeMillis();
        String content = file.getContent();
        long duration = (System.currentTimeMillis() - start);

        System.out.println("Got file content in " + duration + "ms, content: \"" + content + "\"");
    }
}