package q4statepattern;

public class DisabledState implements State {

	@Override
	public boolean doAction(Context context, String in) {
		if (in.equals("d")) {
			context.setState(context.unknown);
			return true;
		}

		return false;
	}
	
	@Override
	public String toString() {
		return "Disabled State";
	}

}
