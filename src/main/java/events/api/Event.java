package events.api;

import java.util.Date;
import org.quartz.JobDetail;

/**
 *
 * @author Ruslan_Makhmudau
 */
public interface Event {

    public void finishEvent();

    public int getDuration();

    public String getSchedule();

    public Date getEndDate();

    public JobDetail getJob();
}
