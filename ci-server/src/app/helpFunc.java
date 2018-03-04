package app;

import java.io.File;
import java.io.IOException;

public class helpFunc {

    public static File create_temp_path() throws IOException {
        String tempDir = "C://Users/allwi/Documents/GitHub/ci-serve-temp";
        File tempFile = new File(tempDir);
        File tempFilePath = File.createTempFile("TestCloneGitRepo", "", tempFile);
        if (!tempFilePath.delete()) {
            throw new IOException("Could not delete temporary file " + tempFilePath);
        }
        return tempFilePath;
    }

}
