
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
    
    

    public static void main(String[] args) throws SchedulerException, ParseException, InterruptedException {
        System.setProperty("user.timezone", "GMT+3");
        //WatchDog wd = new WatchDog();
        //wd.selectBrowserPage();
        
        //GuildBoss gb = new GuildBoss(new Date());
        
        
        //gb.execute(null);
        
        
        AngelScheduler as = new AngelScheduler();
        as.addEvent(new WorldBoss("18:30"));
        as.start();
        
        /*
        Scheduler sch = StdSchedulerFactory.getDefaultScheduler();
        
        JobDetail jd = JobBuilder.newJob(Test.class)
                .build();
        
        Trigger tr = TriggerBuilder.newTrigger()
                .startAt(Common.addDate(Calendar.getInstance().getTime(), Calendar.SECOND, 1))
                .build();
        
        sch.scheduleJob(jd, tr);
        sch.start();
*/
    }
    
}
