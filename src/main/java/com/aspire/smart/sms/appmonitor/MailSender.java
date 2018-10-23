package com.aspire.smart.sms.appmonitor;

public interface MailSender {
    void sendAMail(String content, String subject) throws Exception;
}
