package base;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.EnhancedPatternLayout;
import org.apache.log4j.Level;
import org.sikuli.basics.Settings;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Match;
import org.sikuli.script.Screen;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Ruslan_Makhmudau
 */
public abstract class BaseEntity {

    //protected static Screen screen = new Screen();
    protected static final Screen screen = new Screen(1);
    private static final EnhancedPatternLayout LOG_PATTERN = new EnhancedPatternLayout("%d{yyyy-MM-dd HH:mm:ss,SSS}{GMT+3} [%t][%-5p]: %m%n");
    private static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger("log4j.logger.org.quartz");
    protected static final String backButton = "images\\backBtn.png";

    public BaseEntity() {
        logger.removeAllAppenders();
        ConsoleAppender ca = new ConsoleAppender(LOG_PATTERN);
        ca.setThreshold(Level.DEBUG);
        ca.activateOptions();
        logger.addAppender(ca);
    }

    protected void info(Object msg) {
        logger.info(msg);
    }

    protected void debug(Object msg) {
        logger.debug(msg);
    }
    
    protected void error(Object msg){
        logger.error(msg);
    }

    protected Boolean waitFor(String path, double time) {
        try {
            screen.wait(path, time);
            return true;
        } catch (FindFailed ex) {
            logger.error(ex);
            return false;
        }
    }

    protected void click() {
        try {
            screen.click();
        } catch (Exception ex) {
            logger.error(ex);
        }
    }

    protected void click(String path) {
        try {
            screen.click(path);
        } catch (FindFailed ex) {
            logger.error(ex);
        }
    }

    protected void clickPrecision(String path) {
        info(Settings.MinSimilarity);
        double accuracy = Settings.MinSimilarity;
        Settings.MinSimilarity = 0.96;
        click(path);
        Settings.MinSimilarity = accuracy;
    }

    protected Boolean isVisible(String path) {
        Match m = screen.exists(path);
        return m.isValid();
    }

    protected void click(String path, int modifiers) {
        try {
            screen.click(path, modifiers);
        } catch (FindFailed ex) {
            logger.error(ex);
        }

    }

}
