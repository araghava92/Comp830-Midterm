package q4statepattern;

public class ReadyState implements State {
	
	@Override
	public boolean doAction(Context context, String in) {
		if (in.equals("e")) {
			context.setState(context.disabled);
			return true;
		}
		else if (in.equals("c")) {
			context.setState(context.unknown);
			return true;
		}

		return false;
	}
	
	@Override
	public String toString() {
		return "Ready State";
	}

}
