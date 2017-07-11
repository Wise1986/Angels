
import events.GuildBoss;
import java.util.Date;

/**
 *
 * @author Ruslan_Makhmudau
 */
public class Main {
    
    

    public static void main(String[] args) {
        WatchDog wd = new WatchDog();
        wd.selectBrowserPage();
        
        GuildBoss gb = new GuildBoss(new Date());
        
        gb.startEvent();
    }
}
