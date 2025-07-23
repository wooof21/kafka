package com.example.kafka.rule.other;

import com.example.kafka.stream.model.MSOCandidate;
import com.example.kafka.rule.base.BaseRule;

public class AbstractFRLRule extends BaseRule<MSOCandidate> {

    protected AbstractFRLRule() {}

    @Override
    public void populateContext(MSOCandidate candidate, Alert alert) {

    }

    @Override
    public String getCandidateName() {return MSOCandidate.class.getSimpleName(); }
}
