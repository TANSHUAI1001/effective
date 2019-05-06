package design.facade;

public class Facade {
    private SubSystemA systemA;
    private SubSystemB systemB;
    private SubSystemC systemC;

    public void method(){
        systemA = new SubSystemA();
        systemB = new SubSystemB();
        systemC = new SubSystemC();
        systemA.method();
        systemB.method();
        systemC.method();
    }

}
