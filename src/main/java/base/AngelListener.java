package base;

import org.quartz.JobExecutionContext;
import org.quartz.Trigger;
import org.quartz.TriggerListener;

/**
 *
 * @author Wise
 */
public class AngelListener extends BaseEntity implements TriggerListener{

    @Override
    public String getName() {
        return "Name";
    }

    @Override
    public boolean vetoJobExecution(Trigger trgr, JobExecutionContext jec) {
        debug("vetoJobExecution");
        return false;
    }

    @Override
    public void triggerMisfired(Trigger trgr) {
        debug("triggerMisfired");
    }

    @Override
    public void triggerComplete(Trigger trgr, JobExecutionContext jec, Trigger.CompletedExecutionInstruction cei) {
        debug("triggerComplete");
    }

    @Override
    public void triggerFired(Trigger trgr, JobExecutionContext jec) {
        debug("triggerFired");
    }
}
