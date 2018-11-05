package q4statepattern;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RunStateMachine {

	public static void main(String[] args) {
		
		Map<String, String> transitions = new HashMap<>();
		transitions.put("a", "Health check is good");
		transitions.put("b", "Health check is bad");
		transitions.put("c", "Service health check times out");
		transitions.put("d", "Service enabled");
		transitions.put("e", "Service disabled by user");
		transitions.put("f", "Quit");
		
		Context context = new Context();
		State ready = new ReadyState();
		State unknown = new UnknownState();
		State disabled = new DisabledState();
		State down = new DownState();

		unknown.doAction(context);
		
		Scanner scanner = new Scanner(System.in);
		boolean keepRunning = true;
		String input;
		boolean stateChanged = false;
		
		while(keepRunning) {
			stateChanged = false;
			printTransitions(transitions);

			System.out.print("\nPlease enter the choice: ");
			input = scanner.nextLine();
			
			switch (input) {
				case "a":
					if (context.getState().equals(down) || context.getState().equals(unknown)) {
						context.setState(ready);
						stateChanged = true;
					}
					break;
				case "b":
					if (context.getState().equals(ready) || context.getState().equals(unknown)) {
						context.setState(down);
						stateChanged = true;
					}
					break;
				case "c":
					if (context.getState().equals(ready)) {
						context.setState(unknown);
						stateChanged = true;
					} else if (context.getState().isEquals(unknown)) {
						context.setState(down);
						stateChanged = true;
					}
					break;
				case "d":
					if (context.getState().equals(disabled)) {
						context.setState(unknown);
						stateChanged = true;
					}
					break;
				case "e":
					if (context.getState().isEquals(ready)) {
						context.setState(disabled);
						stateChanged = true;
					}
					break;
				case "f":
					keepRunning = false;
					System.out.println("Quitting");
					continue;
				default:
					System.out.println("Invalid option\n");
					continue;
			}
			System.out.println(String.format("\nChosen >%s<", transitions.get(input)));
			if (stateChanged) {
				System.out.print("New State is ");
				context.doAction();
				System.out.println("");
			} else {
				System.out.println("No state change\n");
			}
		}
		scanner.close();
	}
	
	private static void printTransitions(Map<String, String> transitions) {
		for (String key : transitions.keySet()) {
			System.out.println(key + ") " + transitions.get(key));
		}
	}
		
}
