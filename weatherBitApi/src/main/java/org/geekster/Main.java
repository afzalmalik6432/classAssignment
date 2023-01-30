package org.geekster;

import org.apache.http.client.utils.URIBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {
    public static void main(String[] args) {
        try {
            callWeatherApi();
        } catch (URISyntaxException | IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void callWeatherApi() throws URISyntaxException, IOException, InterruptedException {
        URIBuilder uribuilder = new URIBuilder("https://api.weatherbit.io/v2.0/current");
        uribuilder.setParameter("city","delhi");
        uribuilder.setParameter("key", "10ad3439e43c48bf924e43739f83cc4e");
        String url = uribuilder.build().toString();
        HttpRequest request = HttpRequest.newBuilder().GET().uri(URI.create(url)).build();
        HttpClient client = HttpClient.newBuilder().build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }
}