package concurrent;

/**
 * 注意，迭代器的快速失败行为不能得到保证，一般来说，存在非同步的并发修改时，不可能作出任何坚决的保证。
 * 迭代器的快速失败行为应该仅用于检测程序错误。
 *
 * fail-fast产生的原因就在于程序在对 collection 进行迭代时，某个线程对该 collection 在结构上对其做了修改，
 * 这时迭代器就会抛出 ConcurrentModificationException 异常信息，从而产生 fail-fast。
 *
 * 两种解决方案：
 * 方案一：在遍历过程中所有涉及到改变modCount值得地方全部加上synchronized或者直接使用Collections工具类的同步方法synchronized`Collection`
 * 方案二：使用java.util.concurrent包下的容器类
 */
public class FailFast {
    // TODO
}
