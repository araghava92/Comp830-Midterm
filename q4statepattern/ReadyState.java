package q4statepattern;

public class ReadyState implements State {
	
	@Override
	public void doAction(Context context) {
		System.out.println("Ready State");
		context.setState(this);
	}
	
	@Override
	public boolean isEquals(State state) {
		return state.getClass().getName().equals(this.getClass().getName());
	}

}
