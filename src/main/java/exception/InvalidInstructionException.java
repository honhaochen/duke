package exception;

/**
 * Specify validity of instructions given to Duke.
 */
public class InvalidInstructionException extends DukeException {

    public InvalidInstructionException() {
        super("OOPS!!! I'm sorry, but I don't know what that means :-(");
    }

}