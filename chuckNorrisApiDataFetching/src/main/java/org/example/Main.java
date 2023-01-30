package org.example;

import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {
    public static void main(String[] args) {
        try {
            callChuckNorrisApi();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static void callChuckNorrisApi() throws IOException, InterruptedException {
        String url = "https://api.chucknorris.io/jokes/random";
        HttpRequest request = HttpRequest.newBuilder().GET().uri(URI.create(url)).build();
        HttpClient client = HttpClient.newBuilder().build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String body = response.body();
        System.out.println(body);
        System.out.println();
        JSONObject  jsonObject=new JSONObject(body);
        System.out.println("Created At :"+jsonObject.getString("created_at"));
        System.out.println("Icon_url:  :"+jsonObject.getString("icon_url"));
        System.out.println("Id         :"+jsonObject.getString("id"));
        System.out.println("Updated At :"+jsonObject.getString("updated_at"));
        System.out.println("Url        :"+jsonObject.getString("url"));
        System.out.println("Value      :"+jsonObject.getString("value"));
    }
}