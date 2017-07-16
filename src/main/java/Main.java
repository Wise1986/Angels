
import events.WorldBoss;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import util.Common;

/**
 *
 * @author Ruslan_Makhmudau
 */
public class Main {
    
    

    public static void main(String[] args) throws SchedulerException, InterruptedException  {
        System.setProperty("user.timezone", "GMT+3");
        //WatchDog wd = new WatchDog();
        //wd.selectBrowserPage();
        
        AngelScheduler as = new AngelScheduler();
        as.addEvent(new WorldBoss());
        as.start();
        
    }
    
}
