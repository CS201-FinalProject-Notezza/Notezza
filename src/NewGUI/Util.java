package NewGUI;

import objects.Note;

public class Util {
    public static String getHTMLforNote(Note note) {
        StringBuilder sb = new StringBuilder();
        sb.append("<html>");
        sb.append("<body wrap =\"hard\">");
        sb.append("<h1>");
        sb.append(note.getTitle());
        sb.append("</h1>");
        sb.append(note.getTextContent());
        sb.append("</body></html>");
        return sb.toString();
    }
}
