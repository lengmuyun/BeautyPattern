package org.geekbang.time.principle.lsp;

import org.apache.http.client.HttpClient;

public class SecurityTransporter extends Transporter {

    private String appId;
    private String appToken;

    public SecurityTransporter(HttpClient httpClient, String appId, String appToken) {
        super(httpClient);
        this.appId = appId;
        this.appToken = appToken;
    }

    @Override
    public Response sendRequest(Request request) {
        if (isBlank(appId) && isBlank(appToken)) {
            // 抛出异常，不符合里氏替换原则
            throw new NoAuthorizationRuntimeException("....");
        }
        request.addPayload("app-id", appId);
        request.addPayload("app-token", appToken);
        return super.sendRequest(request);
    }

    private boolean isNotBlank(String string) {
        return !isBlank(string);
    }

    private boolean isBlank(String string) {
        return (string == null || string.length() == 0);
    }

}
