package com.aspire.smart.sms.appmonitor;

public class MailConfig {
    private String smtpHost;
    private String senderAddress;
    private String senderAccount;
    private String senderPassword;
    private String recipientAddress;

    public void setSmtpHost(String smtpHost) {
        this.smtpHost = smtpHost;
    }

    public void setSenderAddress(String senderAddress) {
        this.senderAddress = senderAddress;
    }

    public void setSenderAccount(String senderAccount) {
        this.senderAccount = senderAccount;
    }

    public void setSenderPassword(String senderPassword) {
        this.senderPassword = senderPassword;
    }

    public String getSmtpHost() {
        return smtpHost;
    }

    public String getSenderAddress() {
        return senderAddress;
    }

    public String getSenderAccount() {
        return senderAccount;
    }

    public String getSenderPassword() {
        return senderPassword;
    }

    public String getRecipientAddress() {
        return recipientAddress;
    }

    public void setRecipientAddress(String recipientAddress) {
        this.recipientAddress = recipientAddress;
    }
}
