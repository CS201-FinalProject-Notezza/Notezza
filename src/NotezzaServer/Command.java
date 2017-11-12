package NotezzaServer;

import java.io.Serializable;

public class Command implements Serializable {
    public static final long serialVersionUID = 1;

    private CommandType type;
    private String message;
    private int number;
    private boolean decision;

    public Command(CommandType type, String message, int number, boolean decision) {
        this.type = type;
        this.message = message;
        this.number = number;
        this.decision = decision;
    }

    public CommandType getType() { return type; }

    public void setType(CommandType type) { this.type = type; }

    public String getMessage() { return message; }

    public void setMessage(String message) { this.message = message; }

    public int getNumber() { return number;}

    public void setNumber(int number) { this.number = number; }

    public boolean isDecision() { return decision; }

    public void setDecision(boolean decision) { this.decision = decision; }
}
