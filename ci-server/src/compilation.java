import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;

public class compilation {

    public static File localtmpPath;

    final private static String compileCommand = " javac -cp lib/* src/*.java";
    final private static String application = "cmd.exe";

    public static void init() throws IOException {
        localtmpPath = helpFunc.create_temp_path();
        System.out.println(localtmpPath.getAbsolutePath());
        cloneGitRepo();
        compileGitRepo();
    }

    public static void cloneGitRepo() throws IOException {
        try {
            System.out.println("Downloading project ...... ");
            System.out.println("Src Address: " + ContinuousIntegrationServer.githubURL);
            System.out.println("Dst Address: " + localtmpPath);

            Git.cloneRepository().setURI(ContinuousIntegrationServer.githubURL).setDirectory(localtmpPath)
                    .setCloneAllBranches(true).call();

            System.out.println("Clone Done");
        } catch (GitAPIException e) {
            System.out.println("Clone Failed ");
            e.printStackTrace();
        }
    }

    // javac -cp lib/* src/*.java
    public static void compileGitRepo() throws IOException {
        String location = localtmpPath.getAbsolutePath() + "/ci-server";
        System.out.println("Current st: " + location);
        String cd = "cd ";
        String command = "/C " + cd + location + "&" + compileCommand;

        ProcessBuilder testPB = new ProcessBuilder(application, command);
        testPB.redirectErrorStream(true);
        Process p = testPB.start();
        BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line;
        while (true) {
            line = r.readLine();
            if (line == null) {
                break;
            }
            System.out.println(line);
        }
        System.out.println("Compiling project ...... ");
    }
}
