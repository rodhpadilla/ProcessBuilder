package ConnectivityAgent;

import java.io.IOException;

public class PingAgent implements ConnectivityAgent {

    @Override public boolean verify(Server server) {

        try {
            String[] command = {"ping", "-c", "2", server.getDestinationIp()};
            ProcessBuilder pb = new ProcessBuilder(command);
            Process process = pb.start();
            int exitCode = process.waitFor();
            return exitCode == 0;
        } catch (IOException | InterruptedException e) {
            return false;
        }
    }
}
