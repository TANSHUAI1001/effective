package bases;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * Created by shuai on 2017/3/6.
 */
public class UseLog {
    final static Logger logger = LoggerFactory.getLogger(UseLog.class);

    public static void main(String[] args) {
        logger.info("info");
        logger.debug("debuging...{}:{}",15,45);
        MultipleArgs ma = new MultipleArgs(1,"001","000",new Date(2017-3-6));
        logger.debug("%id %name %master %birthday",ma);
    }
}
