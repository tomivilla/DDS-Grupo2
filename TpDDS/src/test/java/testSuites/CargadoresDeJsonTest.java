package testSuites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import testCases.CargadorDeDispositivosTest;
import testCases.CargadorDeUsuariosTest;

@RunWith(Suite.class)
@SuiteClasses({
	CargadorDeDispositivosTest.class,
	CargadorDeUsuariosTest.class
	})
public class CargadoresDeJsonTest {

}
