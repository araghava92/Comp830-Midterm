package q4observerinterface;

import java.util.ArrayList;
import java.util.List;

public class WorkManager implements PublisherInterface {
	
	private List<Worker> workers;
	private WorkItem workItem;
	
	public WorkManager() {
		workers = new ArrayList<>();
	}
	
	@Override
	public void registerObserver(Worker w) {
		workers.add(w);

	}

	@Override
	public void removeObserver(Worker w) {
		workers.remove(w);
	}

	@Override
	public void notifyObservers() {
		WorkItem _wi = workItem;
		for (Worker w : workers) {
			if (_wi.getItemId() > 4)
				break;
			_wi = w.notify(workItem);
			if (_wi != null) {
				System.out.println(
					String.format("%d: Completed work on WorkItem<%d>", 
						w.getWorkerId(), _wi.getItemId() - 1));
			}
		}
	}
	
	public void setWorkItem(WorkItem workItem) {
		this.workItem = workItem;
	}
}
