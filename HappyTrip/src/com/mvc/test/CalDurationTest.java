package com.mvc.test;
import static org.junit.Assert.*;
import org.junit.Test;
import com.mvc.service.CalDurationSchedule;

public class CalDurationTest {

	@Test
	public void test() {
		CalDurationSchedule cd=new CalDurationSchedule();
		
		
		long l=cd.dur("13:14","15:14");
		
		assertEquals("Calculate duration",120,l);
	}

}
