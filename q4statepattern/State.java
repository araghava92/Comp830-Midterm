package q4statepattern;

public interface State {
	void doAction(Context context);
	boolean isEquals(State state);
}
