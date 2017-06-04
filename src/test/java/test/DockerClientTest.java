package test;

import org.junit.Test;
import org.testifyproject.spotify.docker.client.AnsiProgressHandler;
import org.testifyproject.spotify.docker.client.DefaultDockerClient;

public class DockerClientTest {

    @Test
    public void givenPostgresImageCallToPullShouldPullImage() throws Exception {
        System.out.println("Creating client from env");

        DefaultDockerClient client = DefaultDockerClient.fromEnv()
                .connectTimeoutMillis(10000)
                .connectionPoolSize(16)
                .build();

        System.out.println("Pulling postgres image");
        AnsiProgressHandler progressHandler = new AnsiProgressHandler();

        client.pull("postgres:9.4", progressHandler);

        System.out.println("Image pulled");
    }
}
