package events;

import events.api.Event;
import java.util.Date;
import org.quartz.DateBuilder;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobListener;

/**
 *
 * @author Ruslan_Makhmudau
 */
public class GuildBoss extends base.BaseEntity implements Event, Job, JobListener {

    public static String startButton = "images\\events\\guildBoss\\start.png";
    public static String quickCheckBox = "images\\events\\guildBoss\\quickCheck.png";
    public static String autoCheckBox = "images\\events\\guildBoss\\autoCheck.png";
    //in minutes
    public static final int DEFAULT_DURATION = 25;
    //in seconds
    private static final int DEFAULT_TIMEOUT = 15;
    public static Date startDate;
    public static Boolean triedBack;

    public GuildBoss(Date startDate) {
        triedBack = false;
    }

    @Override
    public void finishEvent() {
        click(backButton);
    }

    @Override
    public int getDuration() {
        return DEFAULT_DURATION;
    }

    @Override
    public Date getStartDate() {
        return startDate;
    }

    @Override
    public Date getEndDate() {
        return DateBuilder.futureDate(DEFAULT_DURATION, DateBuilder.IntervalUnit.MINUTE);
    }

    @Override
    public void execute(JobExecutionContext jec) {
        if (waitFor(startButton, DEFAULT_TIMEOUT)) {
            click(startButton);
            clickPrecision(quickCheckBox);
            clickPrecision(autoCheckBox);
        } else if (!triedBack) {
            click(backButton);
            triedBack = true;
            execute(null);
        }
    }

    @Override
    public JobDetail getJob() {
        return JobBuilder.newJob(GuildBoss.class).withIdentity("Guild Boss").build();
    }

    @Override
    public String getName() {
        return "";
    }

    @Override
    public void jobToBeExecuted(JobExecutionContext jec) {

    }

    @Override
    public void jobExecutionVetoed(JobExecutionContext jec) {

    }

    @Override
    public void jobWasExecuted(JobExecutionContext jec, JobExecutionException jee) {
        finishEvent();
    }
}
