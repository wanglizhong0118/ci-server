package app;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;

public class cloneRepository {

    public static void init(String githubURL, File localtmpPath, String logFilePath) {

        try (FileWriter fw = new FileWriter(logFilePath, true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter out = new PrintWriter(bw)) {
            try {
                out.println(LocalDateTime.now());
                out.println("Downloading project ...... ");
                out.println("Source Address: " + githubURL);
                out.println("Local Destination: " + localtmpPath);
                long startTime = System.currentTimeMillis();
                Git.cloneRepository().setURI(githubURL).setDirectory(localtmpPath).setBranch("refs/heads/master")
                        .call();
                long endTime = System.currentTimeMillis();
                long timeToClone = endTime - startTime;
                out.println("Clone Done in " + timeToClone + " ms");
            } catch (GitAPIException e) {
                System.out.println("Clone Failed ");
                e.printStackTrace();
            }
        } catch (IOException e) {
        }
    }

}
