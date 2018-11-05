package q4statepattern;

public class DownState implements State {

	@Override
	public void doAction(Context context) {
		System.out.println("Down State");
		context.setState(this);
	}
	
	@Override
	public boolean isEquals(State state) {
		return state.getClass().getName().equals(this.getClass().getName());
	}

}
