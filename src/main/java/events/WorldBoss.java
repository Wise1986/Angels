package events;

import base.BaseEntity;
import events.api.Event;
import java.text.ParseException;
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
public class WorldBoss extends BaseEntity implements Event, Job {

    public static String startButton = "images\\events\\worldBoss\\start.png";
    public static String quickCheckBox = "images\\events\\worldBoss\\quickCheck.png";
    public static String autoCheckBox = "images\\events\\worldBoss\\autoCheck.png";
    //in minutes
    public static final int DEFAULT_DURATION = 1;
    //in seconds
    private static final int DEFAULT_TIMEOUT = 15;
    public Date startDate;
    public static Boolean triedBack;
    private Calendar cal = Calendar.getInstance();

    public WorldBoss(String startDate) throws ParseException {
        triedBack = false;
        this.startDate = Common.fixDate(startDate);
    }

    public WorldBoss() {
    }

    @Override
    public void finishEvent() {
        debug("finish");
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
        return Common.addDate(startDate, Calendar.MINUTE, DEFAULT_DURATION);
    }

    @Override
    public void execute(JobExecutionContext jec) {
        debug("Starting Guild Boss ");
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
        return JobBuilder.newJob(WorldBoss.class).build();
    }

}
