package examples;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ex1 {
    public static void runCommand(String command){
        try {
            String[] tokens = command.split(" ");
            ProcessBuilder pb = new ProcessBuilder(tokens);
            pb.redirectErrorStream(true);
            Process process = pb.start();
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream())
            );
            String line;
            System.out.println("Executing Command: " + command);
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            int exitCode = process.waitFor();
            System.out.println("Process Exit Code:" + exitCode);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        runCommand("java -version");
        runCommand("ping -c 3 8.8.8.8");
    }
}
