package com.example.demo.designPattern;

import javax.annotation.PostConstruct;

public abstract class AbstractStrategy implements Strategy{

    @PostConstruct
    public void register() {
        StrategyContext.registerStrategy(getClass().getSimpleName(), this);
    }
}
