package testSuites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import testCases.ControlarDispositivoTest;

@RunWith(Suite.class)
@SuiteClasses({ 
	CargadoresDeJsonTest.class,
	ControlarDispositivoTest.class
	})
public class AllTests {

}
