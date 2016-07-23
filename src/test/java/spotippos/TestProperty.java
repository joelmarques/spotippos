package spotippos;

import java.math.BigDecimal;

import org.testng.annotations.Test;

import com.spotippos.property.Property;
import com.spotippos.property.PropertyValidator;

public class TestProperty {
	
	@Test
	public void testValidBeds() {
		
		Property property = new Property();
		property.setBeds(3);
		
		PropertyValidator validator = new PropertyValidator(property);
		
		org.testng.Assert.assertTrue(validator.validBeds());
	}
	
	@Test
	public void testInvalidBeds() {
		
		Property property = new Property();
		property.setBeds(7);
		
		PropertyValidator validator = new PropertyValidator(property);
		
		org.testng.Assert.assertFalse(validator.validBeds());
	}
	
	@Test
	public void testValidBaths() {
		
		Property property = new Property();
		property.setBaths(2);
		
		PropertyValidator validator = new PropertyValidator(property);
		
		org.testng.Assert.assertTrue(validator.validBaths());
	}
	
	@Test
	public void testInvalidBaths() {
		
		Property property = new Property();
		property.setBaths(5);
	
		PropertyValidator validator = new PropertyValidator(property);
		
		org.testng.Assert.assertFalse(validator.validBaths());
	}
	
	@Test
	public void testValidSquareMeters() {
		
		Property property = new Property();
		property.setSquareMeters(new BigDecimal(110));
		
		PropertyValidator validator = new PropertyValidator(property);
		
		org.testng.Assert.assertTrue(validator.validSquareMeters());
		
	}
	
	@Test
	public void testInvalidSquareMeters() {
		
		Property property = new Property();
		property.setSquareMeters(new BigDecimal(250));
		
		PropertyValidator validator = new PropertyValidator(property);
		
		org.testng.Assert.assertFalse(validator.validSquareMeters());
		
	}
	
	@Test
	public void testValidCoordinates() {
		
		Property property = new Property();
		property.setX(222);
		property.setY(444);
		
		PropertyValidator validator = new PropertyValidator(property);
		
		org.testng.Assert.assertTrue(validator.validCoordinates());
	}
	
	@Test
	public void testInvalidCoordinates() {
		
		Property property = new Property();
		property.setX(1401);
		property.setY(1000);
		
		PropertyValidator validator = new PropertyValidator(property);
		
		org.testng.Assert.assertFalse(validator.validCoordinates());
	}
	
	@Test
	public void testValidRequiredFields() {
		
		Property property = new Property();
		property.setX(222);
		property.setY(444);
		property.setTitle("Imóvel código 1, com 5 quartos e 4 banheiros");
		property.setPrice(new BigDecimal(1250000));
		property.setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
		property.setBeds(5);
		property.setBaths(4);
		property.setSquareMeters(new BigDecimal(210));
		
		PropertyValidator validator = new PropertyValidator(property);
		
		org.testng.Assert.assertTrue(validator.validRequiredFields());
	}
	
	@Test
	public void testInvalidRequiredFields() {
		
		Property property = new Property();
		property.setX(222);
		property.setY(444);
		property.setTitle("  ");
		property.setPrice(new BigDecimal(1250000));
		property.setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
		property.setBeds(5);
		property.setBaths(4);
		property.setSquareMeters(new BigDecimal(210));
		
		PropertyValidator validator = new PropertyValidator(property);
		
		org.testng.Assert.assertFalse(validator.validRequiredFields());
	}
}