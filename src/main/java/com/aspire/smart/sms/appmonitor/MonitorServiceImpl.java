package com.aspire.smart.sms.appmonitor;

import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@EnableScheduling
@Service
@EnableAutoConfiguration
public class MonitorServiceImpl implements MonitorService {
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    MailSender mailSender;

    @Override
    @Scheduled(cron = "0 55 23 * * *")
    public void heathCheck() {
        try {
            String[] urls = System.getenv().getOrDefault("heathCheck", "http://10.12.8.174:9123/heathCheck,http://10.1.5.251:9123/heathCheck").split(",");
            StringBuilder sb = new StringBuilder();
            StringBuilder exceptionSb = new StringBuilder();
            for (String url : urls) {
                JSONObject json = null;
                try {
                    json = restTemplate.getForEntity(url, JSONObject.class).getBody();
                } catch (RestClientException e) {
                    e.printStackTrace();
                    exceptionSb.append("****************************************\n\r").append(url).append("    -    Can't Access\n\r");
                    exceptionSb.append("Reason: ").append(e.getMessage()).append("\n").append("****************************************\n\r");
                    continue;
                }
                String data = json.getAsString("data");
                sb.append("****************************************\n\r").append(url).append("    -    PASSED\n\r").append(data).append("\n").append("****************************************\n\r");
            }
            String status = exceptionSb.length() == 0 ? "PASSED" : "FAILED";
            if (exceptionSb.length() == 0){
                status = "通过";
            } else if (sb.length() == 0) {
                status = "失败";
            } else {
                status = "不健康";
            }
            sb.append("This report is scheduled at every 23:00 morning, monitoring UV services. \n");

            mailSender.sendAMail(exceptionSb.toString()+ sb.toString(), "UV Heath Check Report - " + status);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
