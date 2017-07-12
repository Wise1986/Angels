
import events.GuildBoss;
import events.WorldBoss;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import org.quartz.SchedulerException;

/**
 *
 * @author Ruslan_Makhmudau
 */
public class Main {
    
    

    public static void main(String[] args) throws SchedulerException, ParseException {
        WatchDog wd = new WatchDog();
        wd.selectBrowserPage();
        
        //GuildBoss gb = new GuildBoss(new Date());
        
        
        //gb.execute(null);
        AngelScheduler as = new AngelScheduler();
        as.addEvent(new WorldBoss("20:57"));
        as.start();
    }
}
