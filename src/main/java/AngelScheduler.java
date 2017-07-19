
import base.AngelListener;
import events.api.Event;
import java.util.Date;
import static org.quartz.CronScheduleBuilder.cronSchedule;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import static org.quartz.TriggerBuilder.newTrigger;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.matchers.EverythingMatcher;

/**
 *
 * @author Ruslan_Makhmudau
 */
public class AngelScheduler extends base.BaseEntity {

    private final Scheduler scheduler;

    public AngelScheduler() throws SchedulerException {
        this.scheduler = StdSchedulerFactory.getDefaultScheduler();
    }

    public void addEvent(Event event) {
        Trigger trigger = newTrigger()
                .withSchedule(cronSchedule(event.getSchedule()))
                .build();
        Trigger endTrigger = newTrigger()
                .startAt(event.getEndDate())
                .build();
        try {
            scheduler.scheduleJob(event.getJob(), trigger);
            scheduler.scheduleJob(event.getTearDown(), endTrigger);
        } catch (SchedulerException ex) {
            error(ex);
        }

    }

    public void start() throws SchedulerException, InterruptedException {
        AngelListener al = new AngelListener();
        scheduler.getListenerManager().addTriggerListener(al, EverythingMatcher.allTriggers());

        scheduler.start();
        Thread.sleep(2000);
        scheduler.shutdown();
    }
}
