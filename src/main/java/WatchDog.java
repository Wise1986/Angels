
import org.sikuli.script.App;

/**
 *
 * @author Ruslan_Makhmudau
 */
public class WatchDog extends base.BaseEntity {

    private static String browserName = "Chrome";
    private static String openURL = "https://rbkgames.com/games/liga-angelov-2/play/";
    private static String browserPage = "images\\browser\\browserGameTab.png";
    private double defaultTimeout = 3;

    public Boolean isDead() {
        //check all messages
        //check time
        return false;
    }

    public void selectBrowserPage() {
        App.focus(browserName);
        waitFor(browserPage, defaultTimeout);
        click(browserPage);
    }

    public void reloadPage() {
        
    }

    public void login() {

    }

    public void selectServer(String serverName) {

    }
}
