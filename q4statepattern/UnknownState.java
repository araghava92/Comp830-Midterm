package q4statepattern;

public class UnknownState implements State {

	@Override
	public boolean doAction(Context context, String in) {
		if (in.equals("b") || in.equals("c")) {
			context.setState(context.down);
			return true;
		}
		else if (in.equals("a")) {
			context.setState(context.ready);
			return true;
		}

		return false;
	}
	
	@Override
	public String toString() {
		return "Unknown State";
	}

}
