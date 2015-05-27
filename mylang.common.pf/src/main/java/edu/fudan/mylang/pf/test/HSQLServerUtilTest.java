package edu.fudan.mylang.pf.test;

import org.junit.Test;


public class HSQLServerUtilTest {
	@Test
	public void dummy(){
		HSQLServerUtil.getInstance().start("testdb");
		HSQLServerUtil.getInstance().stop();
	}
}
