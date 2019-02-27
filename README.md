# CleanMVPDemo
A demo of Clean Architecture combine with MVP for Android Application development
## 概念
* 什么是Clean架构
  网上已经有很多文章已经很好的很准确的回答了这个问题。在这里也不再多做赘述。而Clean Architecture的特性有如下几点：
  * 易于测试
  * 易于维护
  * 高内聚
  * 低耦合
## Clean架构层级
Clean Architecture中系统最少要分为但不局限于四层：
* 1.实体层(Entities) -- EnterPrice Business Rules
实体层是用来规定和封装业务规则的，即是公司的业务对象(可以简单理解为后台接口数据)。具体表现形式可以是方法，业务数据结构，或者类。
* 2.用例(User Case) -- Application Business Rules
用例则是用来协调和控制流入实体的数据流(Entity)和流出实体(App Model)的数据流的实现，即将后台接口数据转换为App展示所需的数据。又可以称作为交互器。
* 3.接口适配层(Interface Adapters)
该层就是进行数据的转换，将便于用例和实体层操作的数据结构变化成为最便于外部结构操作的数据结构。Presenter或者Controller则属于这一层。
* 4.框架和驱动层(Frameworks and Drivers)
这层表达的是所有的数据应该具体最终到达的地方。比如用于UI展示，比如数据库存储。我们把这些东西放在最外层，它们几乎对个系统的架构造不成什么影响。

![Clean.jpg](https://upload-images.jianshu.io/upload_images/2757743-0baf1fba84746fad.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

由图可以看出，Clean的依赖规则只能由外向内进行单向依赖。外层的类，方法等不需要被内层知晓。
Clean架构中，最重要的一层是用户实例层(应用业务逻辑层)，这一层中我们决定了软件有什么功能, 最终目标是什么, 以及解决了什么现实问题。

## Clean+MVP
引用Clean到MVP以后，总共可以分为三个层次：
展示层
领域层
数据层
![MVP+Clean.jpg](https://upload-images.jianshu.io/upload_images/2757743-758ba82d7cf97f4c.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

* Domain Layer 
在Android app中，最重要的是领域层，在这一层我们会实现app业务逻辑。这一层不应该依赖任何安卓的FrameWork，它是一个纯粹的Java层。其中Use Case(Interactor)定义了每个具体业务的具体操作，细化了业务粒度。它将Presentation和Data分隔开，负责所有的业务逻辑交互，释放原本Presentation中Presenter中要做的大量逻辑处理，避免了Presenter代码臃肿。
* Data Layer
Data层则用来存放具体的业务数据类型，网络(本地)数据获取，以及将业务数据转换为App展示所需的数据模型，或者App需要的数据模型，例如Parcelable。
* Presentation Layer
MVP则表现在展示层，P层通过获取到Data层的用例数据流出，从而改变UI。

## 实现MVP+Clean
实现一个天气展示的Demo App。
创建Android项目。创建两个lib:data和domain。domain建议创建为java library，保证其不会受到污染。
app目录下使用MVP模式进行开发。
![Demo.jpg](https://upload-images.jianshu.io/upload_images/2757743-c35f4e227e3b6493.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
## 依赖注入(Dependency Injection)
引入Clean以后，对象的引用和传递将会变得十分繁复，当业务拓展到一定程度，到处的传参将会使代码的层次结构深层化以及降低代码可读性，为了研究一个功能的实现，有时候会需要从上层一直追溯参数到底层，同时又会加剧耦合关系，违背我们的初衷，这是一件很苦恼的事情。
这时候DI则解决了我们的问题，推荐使用Google的Dagger2，Dagger2的原理和使用方式在这里不做赘述。有需要可以看本人的前几篇博客或者自行查阅。
## RxJava
推荐使用RxJava(2)做数据流转换以及异步处理。
## 测试
我们花了这么大代价，搞了个Clean进来，明明很简单的功能，我们却需要大量的类和代码完成，这么做的好处有啥呢(敲代码都敲的手酸没点好处能行？)。
高内聚，低耦合，易维护都是很容易理解的。那么易测试呢？因为各个模块相互独立，耦合性低，特别是对于domain层的纯java业务，剔除了安卓FW的侵入，细分了业务粒度以后，每个业务都可以在单测进行数据mock来测试。

## 总结
值得注意的是Clean架构能在一定程度上缓解代码耦合的问题，并规定好各个分层领域的职责，但是它并不是银弹，它并不能完全解决开发中App由于业务功能复杂化带来的不可避免的耦合，同时也会在App起初阶段引入Clean会提高代码复杂性和带来多余的累赘类。针对前者我们可以尝试引入更多的例如组件化，模块化等思想来解决，而针对后者，考虑短期性的快速开发，仅仅引入MVP就可以，考虑后期业务的复杂，提前引入也OK，仁者见仁，智者见智。

水平有限，如有问题，欢迎随时指正。

## 参考
 **[Android-CleanArchitecture](https://github.com/android10/Android-CleanArchitecture)**
