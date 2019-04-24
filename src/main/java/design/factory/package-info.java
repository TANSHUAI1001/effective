/**
 *  使用xml读取参数的可以参考
 *  @see design.builder._XMLUtil
 * 设计模式之工厂模式：
 * 简单工厂 simple
 * Factory（工厂角色）  Product（抽象产品角色）  ConcreteProduct（具体产品角色）
 *
 * 工厂方法 method
 * Product（抽象产品） ConcreteProduct（具体产品） Factory（抽象工厂） ConcreteFactory（具体工厂）
 * 抽象工厂可以是接口，也可以是抽象类或者具体类
 *
 * 由于工厂方法模式中的每个工厂只生产一类产品，可能会导致系统中存在大量的工厂类，势必会增加系统的开销。
 * 此时，我们可以考虑将一些相关的产品组成一个“产品族”，由同一个工厂来统一生产，这就是抽象工厂模式的基本思想。
 * 抽象工厂 abstracts
 * Factory ConcreteFactory1 ConcreteFactory2
 * ProductA ConcreteProductA1 ConcreteProductA2
 * ProductB ConcreteProductB1 ConcreteProductB2
 *
 * Factory1生产1级的产品ProductA1, ProductB1
 * Factory2生产2级的产品ProductA2, ProductB2
 *
 * 抽象工厂为横向纵向设计两部分，一向符合开闭原则，另一向不符合
 *
 */
package design.factory;