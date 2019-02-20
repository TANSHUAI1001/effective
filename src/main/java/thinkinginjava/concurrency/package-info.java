/**
 * 第二十一章 并发
 *
 * 使用Executor
 * @see thinkinginjava.concurrency.CachedThreadPool
 *
 * 从任务中返回值
 *
 * 优先级
 * @see thinkinginjava.concurrency.SimplePriorities
 *
 * 原子性与易变性
 * @see thinkinginjava.concurrency.Atomicity
 *
 * 原子类
 * @see thinkinginjava.concurrency.AtomicIntegerTest
 *
 * 临界区
 * @see thinkinginjava.concurrency.CriticalSection
 * @see thinkinginjava.concurrency.ExplicitCriticalSection
 *
 * 线程本地存储
 * @see thinkinginjava.concurrency.ThreadLocalVariableHolder
 *
 * 终结任务
 * @see thinkinginjava.concurrency.OrnamentalGarden
 * 在阻塞时终结
 * @see thinkinginjava.concurrency.Interrupting
 * @see thinkinginjava.concurrency.NIOInterruption
 * 被互斥所阻塞 Thread.interrupt()可打断被互斥阻塞的调用
 * @see thinkinginjava.concurrency.Interrupting2
 * 检查中断 Thread.interrupted()
 * @see thinkinginjava.concurrency.InterruptingIdiom
 *
 * 线程之间的协作
 * 调用sleep(),yield()时，锁并没有被释放
 * wait(), notify(), notifyall()
 * 当notifyall()因某个特定锁而被调用时，只有等待这个锁的任务才会被唤醒
 * @see thinkinginjava.concurrency.WaxOMatic
 * @see thinkinginjava.concurrency.NotifyVsNotifyAll
 * @see thinkinginjava.concurrency.Restaurant
 *
 * await(), signal()，signalAll()
 * 显式的Lock和Condition对象，await()挂起，signal()或signalAll()唤醒
 * 更安全的方式
 * @see thinkinginjava.concurrency.another.WaxOMatic
 *
 * 阻塞队列BlockingQueue使得代码没有显式的同步
 * @see thinkinginjava.concurrency.ToastOMatic
 *
 * 任务间使用管道输入输出
 * @see thinkinginjava.concurrency.PipedIO
 *
 * 死锁
 * 经典哲学家就餐问题
 * @see thinkinginjava.concurrency.deadlock
 *
 * 新类库中的构件：
 * CountDownLatch
 * CyclicBarrier
 * DelayQueue
 * PriorityBlockingQueue
 * ScheduledExecutor
 * Semaphore
 * Exchanger
 * @see thinkinginjava.concurrency.component
 *
 * 免锁容器
 * 乐观加锁
 * ReadWriteLock
 * @see thinkinginjava.concurrency.optimization
 */
package thinkinginjava.concurrency;