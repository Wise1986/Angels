package events.api;

import java.util.Date;
import org.quartz.JobDetail;

/**
 *
 * @author Ruslan_Makhmudau
 */
public interface Event {

    public String getSchedule();

    public JobDetail getTearDown();

    public JobDetail getJob();
    
    public Date getEndDate();
}
