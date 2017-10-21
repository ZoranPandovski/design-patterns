public class AccessLimitingTextFile implements TextFile {

    private static final String ADMIN_USER = "admin";

    private final TextFile textFile;
    private final String user;

    public AccessLimitingTextFile(TextFile textFile, String user) {
        this.textFile = textFile;
        this.user = user;
    }

    @Override
    public String getContent() {
        if (ADMIN_USER.equals(user)) {
            return textFile.getContent();
        }
        return "Must be " + ADMIN_USER + " to access the file";
    }
}