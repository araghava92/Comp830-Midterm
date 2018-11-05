package q4statepattern;

public class Context {
	State currentState;
	
	public Context() {
	}

	public State getState() {
		return currentState;
	}
	
	public void setState(State state) {
		this.currentState = state;
	}
	
	public void doAction() {
		this.currentState.doAction(this);
	}
}
