package com.example.kafka.rule.other;

import com.example.kafka.stream.model.MSOCandidate;

public class FRLRule extends AbstractFRLRule {

    protected FRLRule() {}

    @Override
    public boolean isApplicable() {
        return true;
    }

    @Override
    public void populateContext(MSOCandidate candidate, Alert alert) {

    }


}
