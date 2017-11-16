package NotezzaServer;

public enum CommandType {
    INITIALIZATION_STUDENT,
    INITIALIZATION_INSTRUCTOR,
    LOGIN, // Check with the server if already registered
    LOGIN_FAIL,
    REGISTER,
    CREATE_CLASS,
    VIEW_CLASS_INFORMATION,
    CREATE_PRESENTATION,
    VIEW_PRESENTATION;
}
