package NewGUI;

import objects.Note;

import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {
    public static String getHTMLforNoteOverview(Note note) {
        StringBuilder sb = new StringBuilder();
        String title = note.getTitle();
        String content = note.getTextContent();
        Date date = note.getDateCreated();
        sb.append("<html>");
        sb.append("<body style='width: 220px; margin-left: 5px; margin-right:5px;  margin-top: 2px; margin-bottom: 2px;'>");
        sb.append("<font style=\"padding:0; margin:2px\" face=\"Lucida Grande\" size=\"4\"><b>");
        if(title.length() > 35) {
        		title = title.substring(0,31);
        		title += "...";
        }
        sb.append(title);
        sb.append("</b></fonts><br />");
        sb.append("<font style=\"padding:0; margin:2px\" face=\"Lucida Grande\" size=\"3\">");
        sb.append(getCalendarDateTime(date));
        sb.append("</font><br />");
        sb.append("<font wrap=\"hard\" style=\"padding:0; margin:2px\" face=\"Lucida Grande\" size=\"3\">");
        if(content.length() > 80) {
        		content = content.substring(0,77);
        		content += "...";
        }
        sb.append(content);
        sb.append("</font></body></html>");
        return sb.toString();
    }
    
    public static String getHTMLforNoteDetail(Note note) {
        StringBuilder sb = new StringBuilder();
        String title = note.getTitle();
        String content = note.getTextContent();
        Date date = note.getDateCreated();
        String author = note.getUser().getUsername();
        sb.append("<html>");
        sb.append("<body style='margin: 10px; padding:5px' wrap=\"hard\">");
        // Title
        sb.append("<font style=\"padding:5px; margin:5px\" face=\"Lucida Grande\" size=\"5\"><b>");
        sb.append(title);
        sb.append("</b><br /><br />");
        
        // Content
        sb.append("<font face=\"Lucida Grande\" size=\"4\">");
        sb.append(content);
        sb.append("</fonts><br /> <br />");
        
        // Author
        sb.append("<div style='text-align: left; background-color: #f0f8ff; position: absolute; bottom: 0px; height: 15px; padding: 2px'>");
        sb.append("<font face=\"Lucida Grande\" size=\"3\">");
        sb.append("Update at ");
        sb.append(getCalendarDateTime(date));
        sb.append(" by ");
        sb.append(author);
        sb.append("</font></div>");
        
        sb.append("</font></body></html>");
        return sb.toString();
    }
    
    public static Date getCurrentDate() {
        DateFormat df = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM);
        Date d = new Date();
        df.format(d);
        return d;
    }
    
    public static String getCalendarDateTime(Date date) {
    		Format formatter = new SimpleDateFormat("MM/dd/yy HH:mm");
        String calendarDateTime = formatter.format(date);
        return calendarDateTime;
    }
}
