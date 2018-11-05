package q2unittest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;


class InventoryTest {
	
	@Test
	void testInventory() {
		Inventory i = new Inventory();
		assertNotNull(i);
	}

	@Test
	void testAddItemToInventory() {
		Inventory i = new Inventory();
		InventoryItem item = mock(InventoryItem.class);
		
		when(item.getWeight()).thenReturn(20);
		assertTrue(i.addItemToInventory(item));
		
		when(item.getWeight()).thenReturn(251);
		assertFalse(i.addItemToInventory(item));
	}

	@Test
	void testDropInventoryItem() {
		Inventory i = new Inventory();
		InventoryItem item = new InventoryItem("Item", 20, "", 1);
		i.addItemToInventory(item);
		
		assertTrue(i.dropInventoryItem(item));
		
		assertFalse(i.dropInventoryItem(item));
	}

	@Test
	void testGetWeight() {
		Inventory i = new Inventory();
		InventoryItem item1 = new InventoryItem("Item", 20, "", 1);
		InventoryItem item2 = new InventoryItem("Item", 270, "", 4);

		InventoryItem item1Spy = spy(item1);
		InventoryItem item2Spy = spy(item2);
		
		i.addItemToInventory(item1Spy);
		i.addItemToInventory(item2Spy);

		verify(item1Spy, times(2)).getWeight();
		verify(item2Spy, times(1)).getWeight();
		assertEquals(20, i.getWeight());	
	}

	@Test
	void testGetCount() {
		Inventory i = new Inventory();
		InventoryItem item1 = new InventoryItem("Item", 20, "", 1);
		InventoryItem item2 = new InventoryItem("Item", 20, "", 4);
		i.addItemToInventory(item1);
		i.addItemToInventory(item2);
		assertEquals(2, i.getCount());	
	}
	
	@Test
	void testToString() {
		Inventory i = new Inventory();
		assertEquals("Your inventory has:\n", i.toString());
		InventoryItem item1 = new InventoryItem("type", 20, "itemName", 1);
		i.addItemToInventory(item1);
		assertEquals("Your inventory has:\nitemName type (type), wt: 20" , i.toString());
	}

}
