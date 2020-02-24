package org.geekbang.time.principle.ocp;

import java.util.List;

public class EmailMsgSender implements MsgSender {

    private List<String> emailAddress;

    public EmailMsgSender(List<String> emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public void send(String message) {

    }

}
