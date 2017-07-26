package com.mvc.test;
import static org.junit.Assert.*;
import org.junit.Test;
import com.mvc.service.*;

public class CalCostTest {

	@Test
	public void test() {
		CalCost cc=new CalCost();
		
		int x=cc.costcal(10000);
		assertEquals("The cost must be distance*5/distance*7",50000,x);
	}

}
