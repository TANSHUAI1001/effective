/**
 * 职责链模式
 *一个纯的职责链模式要求一个具体处理者对象只能在两个行为中选择一个：
 * 要么承担全部责任，要么将责任推给下家，不允许出现某一个具体处理者对象在承担了一部分或全部责任后又将责任向下传递的情况。
 * 而且在纯的职责链模式中，要求一个请求必须被某一个处理者对象所接收，不能出现某个请求未被任何一个处理者对象处理的情况。
 * @see design.cor.HookDemo
 */
package design.cor;

abstract class Handler
{
    protected Handler successor;

    public void setSuccessor(Handler successor)
    {
        this.successor=successor;
    }

    public abstract void handleRequest(String request);
}

class ConcreteHandler extends Handler
{
    public void handleRequest(String request)
    {
        if(true) //请求request满足条件
        {
            //处理请求；
        }
        else
        {
            this.successor.handleRequest(request); //转发请求
        }
    }
}