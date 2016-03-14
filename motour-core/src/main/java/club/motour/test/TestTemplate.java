package club.motour.test;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/conf/motour-spring.xml" })
public class TestTemplate {

	public TestTemplate() {
		BasicConfigurator.configure();
		LogManager.getRootLogger().setLevel(Level.INFO);
	}
}
