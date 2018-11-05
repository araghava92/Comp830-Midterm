package q2unittest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InventoryItemTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetters() {
		InventoryItem item = new InventoryItem("type", 20, "itemName", 6);
		assertNotNull(item);
		assertEquals("itemName", item.getName());
		assertEquals("type", item.getType());
		assertEquals(20, item.getWeight());
		assertEquals(6, item.getCount());
	}

	@Test
	void testToString() {
		InventoryItem item = new InventoryItem("type", 20, "itemName", 1);
		assertEquals("itemName type (type), wt: 20" , item.toString());
		item.count = 2;
		assertEquals("itemName type (type), wt: 20, there are 2 left" , item.toString());
	}
}
