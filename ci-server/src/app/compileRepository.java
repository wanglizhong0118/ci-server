package app;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class compileRepository {

    private static String CMD = "cmd.exe";
    private static String compileCommand = " javac -cp lib/* src/app/*.java";
    static boolean compileResult = false;

    public static boolean init(File localtmpPath, String logFilePath) throws IOException {

        String compileLocation = localtmpPath.getAbsolutePath() + "/ci-server";
        String command = "/C cd " + compileLocation + "&" + compileCommand;

        try (FileWriter fw = new FileWriter(logFilePath, true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter out = new PrintWriter(bw)) {

            out.println("===============================");
            out.println("Compilation Started ...... ");

            long startTime = System.currentTimeMillis();
            ProcessBuilder compilePB = new ProcessBuilder(CMD, command);
            compilePB.redirectErrorStream(true);
            Process compileProcess = compilePB.start();
            long endTime = System.currentTimeMillis();
            long timeToCompile = endTime - startTime;
            out.println("Complation Done in " + timeToCompile + " ms");

            BufferedReader resultBuffer = new BufferedReader(new InputStreamReader(compileProcess.getInputStream()));
            String line;
            String log = "";
            while (true) {
                line = resultBuffer.readLine();
                if (line == null) {
                    out.println("Compilation Finished Sucessfully");
                    notification.init("Compilation Finished Sucessfully");
                    compileResult = true;
                    break;
                }
                log = log + " \n " + line;
                out.println(line);
            }
            notification.init(log);
        }
        return compileResult;
    }
}
