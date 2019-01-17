package bases;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by shuai on 2017/3/6.
 */
public class UseLog {
    private final static Logger logger = LoggerFactory.getLogger(UseLog.class);

    public static void main(String[] args) {
        logger.info("info");
        logger.debug("debugging...{}:{}",15,45);
        Calendar calendar = Calendar.getInstance();
        calendar.set(2017,Calendar.MARCH,6,0,0,0);
        MultipleArgs ma = new MultipleArgs(1,"001","000",calendar.getTime());
        logger.debug("{}",ma.toString());
    }
}
