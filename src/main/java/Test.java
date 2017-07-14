
import base.BaseEntity;
import java.util.Date;
import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobListener;

/**
 *
 * @author Ruslan_Makhmudau
 */
public class Test extends BaseEntity implements Job, events.api.Event{

    public Test(String bla){
        
    }
    
    public Test(){
        
    }
    @Override
    public void execute(JobExecutionContext jec) {
        System.out.println("Hello");
    }

    @Override
    public void finishEvent() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getDuration() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Date getStartDate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Date getEndDate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public JobDetail getJob() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
