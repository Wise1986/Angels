package events.api;

import java.util.Date;
import org.quartz.JobDetail;

/**
 *
 * @author Ruslan_Makhmudau
 */
public interface Event {

    public void startEvent();

    public void finishEvent();

    public int getDuration();

    public Date getStartDate();

    public Date getEndDate();

    public JobDetail getJob();
}
