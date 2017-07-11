
import events.api.Event;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

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
                .endAt(event.getEndDate())
                .build();
        try {
            scheduler.scheduleJob(event.getJob(), trigger);
        } catch (SchedulerException ex) {
            error(ex);
        }
    }
}
