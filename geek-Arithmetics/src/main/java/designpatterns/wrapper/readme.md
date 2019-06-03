抽象构件类（Component）：给出一个抽象的接口，用以规范准备接收附加责任的对象
具体构件类（ConcreteComponent）：定义一个具体的准备接受附加责任的类，其必须实现Component接口。
装饰者类（Decorator）：持有一个构件（Conponent）对象的实例，并定义一个和抽象构件一致的接口。
具体装饰者类（Concrete Decoratator）：定义给构件对象“贴上”附加责任。


下面用一个实例来讲解一下装饰者模式《head first 设计模式》中的例子：
比如在星巴兹咖啡馆，人们需要根据自己的爱好来订购咖啡，而具体的coffee种类假设一共用两类：
HouseBlend（混合咖啡）
和darkRoast（深焙咖啡）。而另外客人也可根据的口味来添加一些其他的东西，
例如：摩卡（mocha）、Milk（牛奶）。

从实例中可以分析出：抽象构件类对应的就是coffee饮品（下面的beverage类），
具体构件类对应的就是HouseBlend和darkRoast；具体装饰者类对应mocha和milk口味；
至于装饰者类这里没有对应，主要用于具体装饰者类的继承。下面看具体d