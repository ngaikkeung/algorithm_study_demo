package com.example.demo.designPattern;

import org.springframework.stereotype.Service;

@Service
public class RewardService {

    public void issueReward(String rewardType, Object... params) {
        Strategy strategy = StrategyContext.getStrategy(rewardType);

        strategy.issue(params);
    }
}
