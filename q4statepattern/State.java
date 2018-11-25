package q4statepattern;

public interface State {
	boolean doAction(Context context, String in);
	String toString();
}
