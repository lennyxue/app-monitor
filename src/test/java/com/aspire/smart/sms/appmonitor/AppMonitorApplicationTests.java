package com.aspire.smart.sms.appmonitor;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppMonitorApplicationTests {

	@Autowired
	MonitorService monitorService;
	@Test
	public void contextLoads() {
//		System.setProperty("mail.recipient.address", "xuequnmou@163.com");
//		monitorService.heathCheck();

	}

}
