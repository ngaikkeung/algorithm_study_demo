package com.example.demo.designPattern;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class StrategyContext {
    private static final Map<String, Strategy> registerMap = new HashMap<>();

    public static void registerStrategy(String rewardType, Strategy strategy) {
        registerMap.putIfAbsent(rewardType, strategy);
    }

    public static Strategy getStrategy(String rewardType) {
        return registerMap.get(rewardType);
    }
}
