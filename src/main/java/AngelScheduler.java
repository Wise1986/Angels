
import base.AngelListener;
import events.WorldBoss;
import events.api.Event;
import java.util.Date;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobListener;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.matchers.EverythingMatcher;
import org.quartz.listeners.JobChainingJobListener;
import org.quartz.listeners.JobListenerSupport;

/**
 *
 * @author Ruslan_Makhmudau
 */
public class AngelScheduler extends base.BaseEntity{

    private static Date startTime;
    private static Date worldBoss1;
    private static Date worldBoss2;
    private static Date guildBoss;
    private static Date resourceWar;
    private static Date safeBonus1;
    private static Date safeBonus2;
    private static Date crossWars;
    private static Date crusade;
    private static Date conquest;
    private static Date specialAction1;
    private static Date specialAction2;
    private static Date specialAction3;
    private final Scheduler scheduler;

    public AngelScheduler() throws SchedulerException {
        this.scheduler = StdSchedulerFactory.getDefaultScheduler();
    }

    public void addEvent(Event event) {
        Trigger trigger = TriggerBuilder.newTrigger()
                .startAt(event.getStartDate())
                .build();
        try {
            scheduler.scheduleJob(event.getJob(), trigger);
        } catch (SchedulerException ex) {
            error(ex);
        }

    }
    
    public void start() throws SchedulerException, InterruptedException{
        AngelListener al = new AngelListener();
        scheduler.getListenerManager().addTriggerListener(al, EverythingMatcher.allTriggers());
        
        scheduler.start();
        Thread.sleep(2000);
        scheduler.shutdown();
    }
}
