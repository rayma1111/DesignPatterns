package com.liebrother.designpatterns.srp;

/**
 * @author LieBrother
 * @date 2018/12/26
 */
public class SrpOfInterface {
}

/**
 * 错误的示范
 */
/**
 * 做家务
 */
interface Housework {
    //购物
    void shopping();
    //倒垃圾
    void pourGarbage();
}

class XiaoMing implements Housework {

    @Override
    public void shopping() {
        // 不购物
    }

    @Override
    public void pourGarbage() {
        System.out.println("pourGarbage ...");
    }
}

class XiaoHong implements Housework {

    @Override
    public void shopping() {
        System.out.println("shopping ...");
    }

    @Override
    public void pourGarbage() {
        // 从不倒垃圾
    }
}

// 现在小明只负责倒垃圾，小红只负责购物，很明显，假如要小红去洗碗，小明不用，在 Housework 中添加洗碗接口，这时小明和小红都需要实现洗碗这个方法，所以其实破坏了单一职责原则。
//也不符合开闭原则. 增加一种类型做饭, 要修改3个类.

/**
 * 正确的示范
 */

interface Shopping {
    void doShopping();
}

interface PourGarbage {
    void doPourGarbage();
}
//洗碗
interface WashingUp {
    void doWashingUp();
}

class XiaoMing2 implements PourGarbage {

    @Override
    public void doPourGarbage() {
        System.out.println("pourGarbage ...");
    }
}

class XiaoHong2 implements Shopping, WashingUp {

    @Override
    public void doShopping() {
        System.out.println("shopping ...");
    }

    @Override
    public void doWashingUp() {
        System.out.println("washing up ...");
    }
}

// 这样子，要让小红洗碗，只需要实现洗碗的接口，让小红实现洗碗的方法，就完成了，不会影响到小明，这样才算是一个比较好的接口
//符合单一职责原则. 一个类只做一件事. 并且他的修改不会带来其他的变化.