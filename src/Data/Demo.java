package Data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * Created by rabota on 19.07.15.
 */
public class Demo {
    public static void main(String[] args) throws ParseException {
        Date current = new Date();
        Calendar c = new GregorianCalendar();

        c.set(1974, Calendar.JULY, 14);
        System.out.println(c.get(Calendar.DATE));

        SimpleDateFormat df = new SimpleDateFormat("d MMM yy", Locale.ENGLISH);

        System.out.println(df.format(current));
        Date my = df.parse("07 SEP 1977");
        System.out.println(df.format(my));

    }
}
