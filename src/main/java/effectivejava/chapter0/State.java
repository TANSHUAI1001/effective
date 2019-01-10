package effectivejava.chapter0;

/**
 * Created by shuai on 2017/1/19.
 */
public enum State {
    SUCCESS(1,"成功"), FAILED(0,"失败"), REJECT(-1,"拒绝");
    private int state;
    private String stateInfo;
    private State(int state,String stateInfo){
        this.state = state;
        this.stateInfo = stateInfo;
    }
}
