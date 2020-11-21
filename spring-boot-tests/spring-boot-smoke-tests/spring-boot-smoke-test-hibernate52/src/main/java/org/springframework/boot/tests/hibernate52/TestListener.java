package org.springframework.boot.tests.hibernate52;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.math.BigDecimal;
import java.math.BigInteger;

public class TestListener implements SpringApplicationRunListener {
	public TestListener() {
	}
	public TestListener(SpringApplication application, String[] args) {
		System.out.println("init...");
	}

	@Override
	public void starting() {
		System.out.println("starting...");
	}

	@Override
	public void environmentPrepared(ConfigurableEnvironment environment) {
		System.out.println("environmentPrepared...");
	}

	@Override
	public void contextPrepared(ConfigurableApplicationContext context) {
		System.out.println("contextPrepared...");
	}

	@Override
	public void contextLoaded(ConfigurableApplicationContext context) {
		System.out.println("contextLoaded...");
	}

	@Override
	public void started(ConfigurableApplicationContext context) {
		System.out.println("started...");
	}

	@Override
	public void running(ConfigurableApplicationContext context) {
		System.out.println("running...");
	}

	@Override
	public void failed(ConfigurableApplicationContext context, Throwable exception) {
		System.out.println("failed...");
	}


	public static void main(String[] args) {
		TestListener t = new TestListener();
		int temp = 1;
		int cnt = 0;
		while(temp != 0) {
			temp = temp << 1;
			cnt++;
		}
		System.out.println(0x80000000);
		System.out.println(0x80000001);
		int cntNumberOf1 = t.CountNumberOf1(0x80000001);
		System.out.println(cntNumberOf1);
	}
	public int CountNumberOf1(int n) {
		int value = 1;
		int res = 0;
		while(value != 0) {
			if((value & n) != 0) {
				res ++;
			}
			value = value << 1;
		}
		return res;
	}
}
