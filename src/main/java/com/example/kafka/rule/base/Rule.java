package com.example.kafka.rule.base;

import com.example.kafka.stream.model.InitAlert;

public interface Rule<T extends InitAlert> {

    boolean isApplicable(InitAlert initAlert);

    void populateContext(T candidate, Alert alert);

    List<Alert> resolveAlerts(T candidate);

    String getCandidateName();
}
