
import events.api.Event;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobListener;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Wise
 */
public class AngelListener implements JobListener {

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
        Event event = (Event) jec.getJobDetail().getJobClass().cast(Event.class);
        event.finishEvent();
    }

}
