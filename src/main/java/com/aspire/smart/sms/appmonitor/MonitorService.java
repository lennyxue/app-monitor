package com.aspire.smart.sms.appmonitor;

import org.springframework.scheduling.annotation.Scheduled;

public interface MonitorService {
    void heathCheck();
}
