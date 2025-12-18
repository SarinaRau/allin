package business;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class VhsTest {
	
	Volkshochschulkurs kurs;

	@BeforeEach
	void setUp() throws Exception {
		kurs=new Volkshochschulkurs("Politik",14,"Mittwoch",16.00f,new String[] {"keine"});
	}

	@AfterEach
	void tearDown() throws Exception {
		kurs=null;
	}

	@Test
	void test() {
		assertTrue(kurs.getKursbeitrag()==14,()->"muss 14 sein");
		Throwable exc=assertThrows(IllegalArgumentException.class,()->{
			kurs=new Volkshochschulkurs(null,14,"Mittwoch",16.00f,new String[] {"keine"});
		});
		
	}

}


