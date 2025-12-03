package ConnectivityAgent;

import org.junit.jupiter.api.Assertions;

import org.junit.Test;

public class PingAgentTest {

    @Test
    public void testSuccessPingAgent(){
        String testingIp = "8.8.8.8";
        String expectedOutput = testingIp + " --> UP";
        Server server = new Server();
        server.setDestinationIp(testingIp);
        PingAgent pingAgent = new PingAgent();
        ConnectivityAgentManager connectivityAgentManager = new ConnectivityAgentManager(pingAgent);
        Assertions.assertEquals(expectedOutput, connectivityAgentManager.launchTest(server));
    }

    @Test
    public void testFailPingAgent(){
        String testingIp = "192.0.0.4";
        String expectedOutput = testingIp + " --> DOWN";
        Server server = new Server();
        server.setDestinationIp(testingIp);
        PingAgent pingAgent = new PingAgent();
        ConnectivityAgentManager connectivityAgentManager = new ConnectivityAgentManager(pingAgent);
        Assertions.assertEquals(expectedOutput, connectivityAgentManager.launchTest(server));
    }
}
