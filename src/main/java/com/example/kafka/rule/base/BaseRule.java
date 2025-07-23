package com.example.kafka.rule.base;

import com.example.kafka.stream.model.InitAlert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public abstract class BaseRule<W extends InitAlert> implements Rule<T>{

    protected AlertConfigService alertConfigService;

    protected CustomerService customerService;

    protected Integer alertCode;

    @Autowired
    protected BaseRule() {

    }

    public List<Alert> resolveAlerts(W candidate) {

    }
}
