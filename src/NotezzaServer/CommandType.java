package NotezzaServer;

public enum CommandType {
    INITIALIZATION,
    LOGIN, // Check with the server if already registered
    REGISTER,
    CREATE_CLASS,
    VIEW_CLASS_INFORMATION,
    CREATE_PRESENTATION,
    VIEW_PRESENTATION;
}
