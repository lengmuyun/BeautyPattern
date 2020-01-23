package org.geekbang.time.principle.lsp;

import org.apache.http.client.HttpClient;

public class Transporter {

    private HttpClient httpClient;

    public Transporter(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public Response sendRequest(Request request) {
        // ...use httpClient to send request
        return new Response();
    }

}
