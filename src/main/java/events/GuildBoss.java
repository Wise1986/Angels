package events;

import events.api.Event;
import java.util.Calendar;
import java.util.Date;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import util.Common;

/**
 *
 * @author Ruslan_Makhmudau
 */
public class GuildBoss extends base.BaseEntity implements Event, Job {

    public static String startButton = "images\\events\\guildBoss\\start.png";
    public static String quickCheckBox = "images\\events\\guildBoss\\quickCheck.png";
    public static String autoCheckBox = "images\\events\\guildBoss\\autoCheck.png";
    //in minutes
    public static final int DEFAULT_DURATION = 25;
    //in seconds
    private static final int DEFAULT_TIMEOUT = 15;
    public static Boolean triedBack;
    public String schedule = "0 0 20 1/2 * ? *";

    public GuildBoss() {
        triedBack = false;
    }

    @Override
    public Date getEndDate() {
        return Common.addDate(Calendar.getInstance().getTime(), Calendar.MINUTE, DEFAULT_DURATION);
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
        return JobBuilder.newJob(GuildBoss.class).build();
    }

    @Override
    public String getSchedule() {
        return schedule;
    }

    @Override
    public JobDetail getTearDown() {
        return JobBuilder.newJob(TearDown.class).build();
    }

    public class TearDown implements Job {

        @Override
        public void execute(JobExecutionContext jec) throws JobExecutionException {
            debug("finish");
            click(backButton);
        }

    }
}
