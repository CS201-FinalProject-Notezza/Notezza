package NotezzaServer;

import java.io.Serializable;

public class Command implements Serializable {
    public static final long serialVersionUID = 1;

    private CommandType type;
    private Object obj;
    
    public Command(CommandType type, Object obj) {
        this.type = type;
        this.obj = obj;
    }
    
    public CommandType getType() { return type; }

    public void setType(CommandType type) { this.type = type; }

    public Object getObject() { return obj; }

    public void setObject(Object obj) { this.obj = obj; }

}
