package q4observerinterface;

public interface PublisherInterface {

	void registerObserver(Worker w);
	void removeObserver(Worker w);
	void notifyObservers();
	
}
