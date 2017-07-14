package util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author Ruslan_Makhmudau
 */
public class Common {

    public static Date fixDate(String date) throws ParseException {
        Calendar current = Calendar.getInstance(Locale.getDefault());
        Calendar parsed = Calendar.getInstance(Locale.getDefault());

        parsed.setTime(new SimpleDateFormat("hh:mm").parse(date));
        parsed.set(current.get(Calendar.YEAR), current.get(Calendar.MONTH), current.get(Calendar.DATE));

        return parsed.getTime();
    }

    public static Date addDate(Date start, int field, int duration) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(start);
        cal.add(field, duration);
        return cal.getTime();
    }
}
