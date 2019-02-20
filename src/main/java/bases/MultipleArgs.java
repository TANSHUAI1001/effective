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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMaster() {
        return master;
    }

    public void setMaster(String master) {
        this.master = master;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "MultipleArgs{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", master='" + master + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
