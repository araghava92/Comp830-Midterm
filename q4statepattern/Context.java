package q4statepattern;

public class Context {
	State currentState;
	public final State ready;
	public final State unknown;
	public final State disabled;
	public final State down;
	
	public Context() {
		ready = new ReadyState();
		unknown = new UnknownState();
		disabled = new DisabledState();
		down = new DownState();
	}

	public State getState() {
		return currentState;
	}
	
	public void setState(State state) {
		this.currentState = state;
	}
	
	public boolean doAction(String in) {
		return this.currentState.doAction(this, in);
	}
}
