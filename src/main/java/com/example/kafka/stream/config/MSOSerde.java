package com.example.kafka.stream.config;

import org.apache.kafka.common.serialization.Serdes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MSOSerde {

    @Autowired
    protected EncryptionPropertiesConfig encrypionConfig;

    public Serde<MSORequest> serde() {
        try(Serde<MSORequest> serde = Serdes.serdeFrom(new SecuredSpecificAvroSerializer<>(), new SercuredSpecificAvroDeserializer<>())) {
            serde.configur(encrypionConfig.getFromValueSerdeConfig(), false);
            return serde;
        }
    }
}
