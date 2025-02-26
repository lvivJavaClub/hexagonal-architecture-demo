package ua.lviv.javaclub.userservice.mongo;

import ua.lviv.javaclub.userservice.mongo.converter.OffsetDateTimeReadConverter;
import ua.lviv.javaclub.userservice.mongo.converter.OffsetDateTimeWriteConverter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;

import java.util.List;

@Configuration
public class MongoConfig {

  @Bean
  public MongoCustomConversions customConversions(OffsetDateTimeWriteConverter offsetDateTimeWriteConverter,
                                                  OffsetDateTimeReadConverter offsetDateTimeReadConverter) {
    return new MongoCustomConversions(List.of(
        offsetDateTimeWriteConverter,
        offsetDateTimeReadConverter
    ));
  }
}
