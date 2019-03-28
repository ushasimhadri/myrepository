import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

class CalculatorTest {
	

	@Test
	void testAdd() {
		Arithmetic obj=new Arithmetic();
		assertEquals(10.0,obj.Add(5.0, 5.0));
		
	}

	@Test
	void testMul() {
		Arithmetic obj=new Arithmetic();
		assertEquals(25.0,obj.Mul(5.0, 5.0));
		
	}

	@Test
	void testDiv() {
		Arithmetic obj=new Arithmetic();
		assertEquals(1.0,obj.Div(5.0, 5.0));
		
	}

}
