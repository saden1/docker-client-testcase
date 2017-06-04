package test;

import com.spotify.docker.client.AnsiProgressHandler;
import com.spotify.docker.client.DefaultDockerClient;
import org.junit.Test;

public class DockerClientTest {

    @Test
    public void givenPostgresImageCallToPullShouldPullImage() throws Exception {
        System.out.println("Creating client from env");

        DefaultDockerClient client = DefaultDockerClient.fromEnv()
                .build();

        System.out.println("Pulling postgres image");
        AnsiProgressHandler progressHandler = new AnsiProgressHandler();

        client.pull("postgres", progressHandler);

        System.out.println("Image pulled");
    }
}
