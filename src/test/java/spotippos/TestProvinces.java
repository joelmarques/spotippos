package spotippos;

import java.util.Arrays;
import java.util.Collection;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.spotippos.province.Provinces;

public class TestProvinces {

	@Test
	public void testPropertyInGodeAndRuja() {
		
		Collection<String> provinces = new Provinces().provinces(420, 889);
		
		Assert.assertEquals(provinces, Arrays.asList("Gode", "Ruja"));
	}
	
	@Test
	public void testPropertyInRujaAndGroola() {
		
		Collection<String> provinces = new Provinces().provinces(730, 500);
		
		Assert.assertEquals(provinces, Arrays.asList("Ruja", "Groola"));
	}
	
	@Test
	public void testPropertyInGroola() {
		
		Collection<String> provinces = new Provinces().provinces(730, 499);
		
		Assert.assertEquals(provinces, Arrays.asList("Groola"));
	}
	
	@Test
	public void testPropertyInJaby() {
		
		Collection<String> provinces = new Provinces().provinces(1230, 850);
		
		Assert.assertEquals(provinces, Arrays.asList("Jaby"));
	}
}