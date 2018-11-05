package q4observerinterface;

public class RunObserverPattern {

	public static void main(String[] args) {
		WorkManager wm = new WorkManager();
		
		for (int i = 1; i < 5; i++)
			wm.registerObserver(new Worker(i));
		
		wm.setWorkItem(new WorkItem(1, 0, "Message1"));
		wm.notifyObservers();
		
		wm.setWorkItem(new WorkItem(3, 0, "Message3"));
		wm.notifyObservers();
		
		wm.setWorkItem(new WorkItem(5, 0, "Message5"));
		wm.notifyObservers();
	}
	
}
