package engage.pages;

import org.testng.annotations.Test;

public class HomePageTest extends TestBase {



	@Test
	public void testH1Existing() throws Exception {
		driver.get(baseUrl);
	}


}
