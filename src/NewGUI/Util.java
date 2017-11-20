package NewGUI;

import objects.Comment;
import objects.Note;

import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

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
        sb.append("<div style='text-align: left; background-color: #f0f8ff; height: 15px; padding: 2px'>");
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

    public static String getHTMLforComments(Note note) {
        StringBuilder sb = new StringBuilder();
        Vector<Comment> comments = note.getComments();

        sb.append("<html>").append("<body style='padding:5px' wrap=\"hard\">");
        //sb.append("<ul style=\"list-style-type:none margin:10px\">");
        for (Comment comment : comments) {
            sb.append("<div style=\"font-family:Lucida Grande; background-color:#f0f8ff; margin:5px; padding:10px\">");
            String userName = comment.getUser().getUsername();
            String commentContent = comment.getContent();
            String date = getCalendarDateTime(comment.getDateCreated());
            sb.append("<font size=\"4\">");
            sb.append("<b>").append(userName).append("</b>  ").append(date).append("<br />");
            sb.append(commentContent);
            sb.append("</font>");
            sb.append("</div>");
        }
//        sb.append("</ul>");
        sb.append("</body></html>");
        return sb.toString();
    }

    public static String getCalendarDateTime(Date date) {
        Format formatter = new SimpleDateFormat("MM/dd/yy HH:mm");
        return formatter.format(date);
    }
}
