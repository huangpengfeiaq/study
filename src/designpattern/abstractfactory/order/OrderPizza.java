package designpattern.abstractfactory.order;

import designpattern.abstractfactory.pizza.BasePizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author huangpengfei
 * @version 1.0
 * @date 2019/8/3 15:31
 */
public class OrderPizza {
    AbstractFactory factory;

    /**
     * 构造器
     */
    public OrderPizza(AbstractFactory factory) {
        setFactory(factory);
    }

    private void setFactory(AbstractFactory factory) {
        BasePizza pizza;
        // 用户输入
        String orderType;
        this.factory = factory;
        do {
            orderType = getType();
            // factory 可能是北京的工厂子类，也可能时伦敦的工厂子类
            pizza = factory.createPizza(orderType);
            // 输出pizza 制作过程
            if (pizza != null) {
                pizza.prepare();
                pizza.bake();
                pizza.cut();
                pizza.box();
            } else {
                System.out.println(" 订购披萨失败 ");
                break;
            }
        } while (true);
    }

    /**
     * 写一个方法，可以获取客户端希望订购的披萨种类
     */
    private String getType() {
        try {
            BufferedReader string = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("input pizza type:");
            return string.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}
