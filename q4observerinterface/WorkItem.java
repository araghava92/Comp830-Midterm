package q4observerinterface;

public class WorkItem {
	
	private long itemId;
	private long workerId;
	private String message;
	
	public WorkItem(long itemId, long workerId, String message) {
		this.itemId = itemId;
		this.workerId = workerId;
		this.message = message;
	}
	
	public long getItemId() {
		return itemId;
	}
	
	public long getWorkerId() {
		return workerId;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setItemId(long itemId) {
		this.itemId = itemId;
	}

}
