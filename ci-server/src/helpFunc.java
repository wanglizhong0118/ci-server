import java.io.File;
import java.io.IOException;

public class helpFunc {

    public static File create_temp_path() throws IOException {
        File tempFilePath = File.createTempFile("TestCloneGitRepo", "");
        if (!tempFilePath.delete()) {
            throw new IOException("Could not delete temporary file " + tempFilePath);
        }
        return tempFilePath;
    }

}
