package org.springframework.boot.tests.hibernate52;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

public class TestListener implements SpringApplicationRunListener {
	public TestListener(SpringApplication application, String[] args) {
		System.out.println("hello world Init");
	}

	@Override
	public void starting() {
	}

	@Override
	public void environmentPrepared(ConfigurableEnvironment environment) {
		System.out.println("hello world starting");
	}

	@Override
	public void contextPrepared(ConfigurableApplicationContext context) {
		System.out.println("hello world starting");
	}

	@Override
	public void contextLoaded(ConfigurableApplicationContext context) {
		System.out.println("hello world starting");
	}

	@Override
	public void started(ConfigurableApplicationContext context) {
		System.out.println("hello world starting");
	}

	@Override
	public void running(ConfigurableApplicationContext context) {
		System.out.println("hello world starting");
	}

	@Override
	public void failed(ConfigurableApplicationContext context, Throwable exception) {
		System.out.println("hello world starting");
	}
}
