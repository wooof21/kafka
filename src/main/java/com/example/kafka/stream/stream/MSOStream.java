package com.example.kafka.stream.stream;

import com.example.kafka.stream.config.MSOConfig;
import com.example.kafka.stream.mapper.MSOMapper;
import com.example.kafka.stream.model.MSOCandidate;
import org.apache.kafka.common.serialization.Serdes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.EnableKafkaStreams;
import org.springframework.stereotype.Component;

@Component
@EnableKafkaStreams
@ConditionalOnProperty(value = "kafka.business-event.managed-servicing-order-request.enable", havingValue = "true")
public class MSOStream extends BaseAlertStream {

    private final Serde<MSOEvent> serde;

    private final MSOConfig config;

    private final MSOMapper mapper;


    @Autowired
    public MSOStream(MSOConfig config, MSOMapper mapper, Serde<MSOEvent> serde) {
        this.serde = serde;
        this.config = config;
        this.mapper = mapper;
    }

    @Bean
    public KStream<String, MSOEvent> msoStream(StreamsBuilder sb) {
        KStream<String, MSOEvent> stream = sb.stream("topic name", Consumed.with(Serdes.String(), serde));

        initializeEvenetStatistics("topic name");
        stream
                .peek((k, v) -> updateEventStatistics())
                .filter((k, v) -> event != null)
                .filter((k, v) -> config.getSupportedCategories().contains(event.getCategory()))
                .filter(this::hasSupportedEventType)
                .mapValues(this::mapToCandidate)
                .filter((k, initAlert) -> initAlert != null)
                .forEach(this::processCandidate);

        return stream;
    }

    private boolean hasSupportedEventType(String key, MSOEvent event) {
        return true;
    }

    private MSOCandidate mapToCandidate(String key, MSOEvent event) {
        return candidate;
    }



}
