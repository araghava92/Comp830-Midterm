package q4observerinterface;

public class Worker {
	
	private long workerId;

	public Worker(long workerId) {
		this.workerId = workerId;
	}

	public WorkItem notify(WorkItem wi) {
		if (workerId != wi.getItemId())
			return null;
		System.out.println(
			String.format("Worker %d processed WorkItem %d message %s", 
				workerId, wi.getItemId(), wi.getMessage()));
		wi.setItemId(wi.getItemId() + 1);
		return wi;
	}
	
	public long getWorkerId() {
		return workerId;
	}
	
}
