package edu.fudan.mylang.pf.test;

import org.junit.runner.notification.RunNotifier;
import org.junit.runners.model.InitializationError;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

public class HSQLDBRunner extends SpringJUnit4ClassRunner {

	public HSQLDBRunner(Class<?> clazz) throws InitializationError {
		super(clazz);
	}

	@Override
	public void run(RunNotifier notifier) {
		HSQLServerUtil.getInstance().start("testdb");
		try {
			super.run(notifier);
		} finally {
			HSQLServerUtil.getInstance().stop();
		}
	}
}
