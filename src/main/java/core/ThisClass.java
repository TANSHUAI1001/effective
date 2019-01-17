package core;

/**
 * 子父类this对象指向
 */
public class ThisClass {
    private int p = 0;
    public ThisClass getThis(){
        synchronized (this){
            return this;
        }
    }

    public void parentMethod(){
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "parent";
    }
}

class ThisSubClass extends ThisClass{
    private int c = 1;
    public ThisClass getThis(){
        synchronized (this){
            return this;
        }
    }

    public void compare(){
        Object object = getThis();
        System.out.println(this == object);
    }
    @Override
    public String toString() {
        return "child";
    }
    public static void main(String[] args) {
        ThisClass a = new ThisClass();
        ThisClass b = new ThisSubClass();
        ThisSubClass c = new ThisSubClass();

        Object a1 = a.getThis();
        Object b1 = b.getThis();
        Object c1 = c.getThis();
        System.out.println(a1); // parent
        System.out.println(b1); // child
        System.out.println(c1); // child

        a.parentMethod(); // parent
        b.parentMethod(); // child
        c.parentMethod(); // child

        c.compare();
    }
}