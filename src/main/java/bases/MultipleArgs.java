package bases;

import java.util.Date;

/**
 * Created by shuai on 2017/3/6.
 */
public class MultipleArgs {
    private int id;
    private String name;
    private String master;
    private Date birthday;

    public MultipleArgs(int id, String name, String master, Date birthday) {
        this.id = id;
        this.name = name;
        this.master = master;
        this.birthday = birthday;
    }
}
