package q4statepattern;

public class DisabledState implements State {

	@Override
	public void doAction(Context context) {
		System.out.println("Disabled State");
	}
	
	@Override
	public boolean isEquals(State state) {
		return state.getClass().getName().equals(this.getClass().getName());
	}

}
