package com.gavin.atguigu.pattern.factory.absfactory.order;


import com.gavin.atguigu.pattern.factory.absfactory.pizza.Pizza;

// 一个抽象工厂模式的抽象层接口
public interface AbsFactory {

  Pizza createPizza(String orderType);

}
