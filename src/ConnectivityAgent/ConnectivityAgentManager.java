package ConnectivityAgent;

public class ConnectivityAgentManager {
    private ConnectivityAgent connectivityAgent;

    public ConnectivityAgentManager(ConnectivityAgent connectivityAgent){
        this.connectivityAgent = connectivityAgent;
    }

    public String launchTest(Server server) {
        boolean serverValidationResult = connectivityAgent.verify(server);
        String result;
        if (serverValidationResult) {
            result = server.getDestinationIp() + " --> UP";
        } else {

            result = server.getDestinationIp() + " --> DOWN";
        }
        return result;
    }
}
