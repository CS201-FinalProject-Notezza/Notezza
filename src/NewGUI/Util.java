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
        sb.append("<body wrap=\"hard\">");
        sb.append("<font style=\"padding:0; margin:2px\" face=\"Century Gothic\" size=\"4\"><b>");
        if(title.length() > 35) {
        		title = title.substring(0,31);
        		title += "...";
        }
        sb.append(title);
        sb.append("</b></fonts><br />");
        sb.append("<font style=\"padding:0; margin:2px\" face=\"Century Gothic\" size=\"3\">");
        sb.append(getCalendarDateTime(date));
        sb.append("</font><br />");
        sb.append("<font wrap=\"hard\" style=\"padding:0; margin:2px\" face=\"Century Gothic\" size=\"3\">");
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
