package com.example.kafka.stream.mapper;

import com.example.kafka.stream.model.MSOCandidate;
import org.springframework.stereotype.Component;

@Component
public class MSOMapper {

    public MSOCandidate map(MSOEvent event) {
        return new MSOCandidate();
    }
}
