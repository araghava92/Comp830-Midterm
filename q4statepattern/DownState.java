package q4statepattern;

public class DownState implements State {

	@Override
	public boolean doAction(Context context, String in) {
		if (in.equals("a")) {
			context.setState(context.ready);
			return true;
		}

		return false;
	}
	
	@Override
	public String toString() {
		return "Down State";
	}

}
