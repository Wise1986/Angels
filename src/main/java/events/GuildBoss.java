package events;

import java.util.Date;
import org.quartz.DateBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;

/**
 *
 * @author Ruslan_Makhmudau
 */
public class GuildBoss extends base.BaseEntity implements events.api.Event, org.quartz.Job {

    public static String startButton = "images\\events\\guildBoss\\start.png";
    public static String quickCheckBox = "images\\events\\guildBoss\\quickCheck.png";
    public static String autoCheckBox = "images\\events\\guildBoss\\autoCheck.png";
    //in minutes
    public static int duration = 30;
    public static Date startDate;
    public static Boolean triedBack;

    public GuildBoss(Date startDate) {
        triedBack = false;
    }

    @Override
    public void startEvent() {
        if (waitFor(startButton, 5)) {
            click(startButton);
            clickPrecision(quickCheckBox);
            clickPrecision(autoCheckBox);
        } else if (!triedBack) {
            click(backButton);
            triedBack = true;
            startEvent();
        }
    }

    @Override
    public void finishEvent() {
        click(backButton);
    }

    @Override
    public int getDuration() {
        return duration;
    }

    @Override
    public Date getStartDate() {
        return startDate;
    }

    @Override
    public Date getEndDate() {
        return DateBuilder.futureDate(duration, DateBuilder.IntervalUnit.MINUTE);
    }

    @Override
    public void execute(JobExecutionContext jec) {
        startEvent();
        try {
            Thread.sleep(duration);
        } catch (InterruptedException ex) {
        }
        finishEvent();
    }

    @Override
    public JobDetail getJob() {
        return JobBuilder.newJob(GuildBoss.class).withIdentity("Guild Boss").build();
    }
}
