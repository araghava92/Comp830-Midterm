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
		context.setState(context.unknown);
		boolean stateChanged = true;
		
		Scanner scanner = new Scanner(System.in);
		boolean keepRunning = true;
		String input;
		
		while(keepRunning) {
			if (stateChanged) {
				System.out.print(String.format("Current State is %s\n", context.currentState.toString()));
			} else {
				System.out.println("No state change\n");
			}
			
			stateChanged = false;
			printTransitions(transitions);

			System.out.print("\nPlease enter the choice: ");
			input = scanner.nextLine();
			
			switch (input) {
				case "a": case "b": case "c": 
				case "d": case "e":
					stateChanged = context.doAction(input);
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
		}
		scanner.close();
	}
	
	private static void printTransitions(Map<String, String> transitions) {
		for (String key : transitions.keySet()) {
			System.out.println(key + ") " + transitions.get(key));
		}
	}
		
}
