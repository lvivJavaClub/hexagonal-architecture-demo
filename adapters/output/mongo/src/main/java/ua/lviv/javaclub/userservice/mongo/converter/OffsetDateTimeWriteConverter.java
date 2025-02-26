package ua.lviv.javaclub.userservice.mongo.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Date;

@Component
public class OffsetDateTimeWriteConverter implements Converter<OffsetDateTime, Date> {

  @Override
  public Date convert(OffsetDateTime source) {
    return source == null ? null : Date.from(source.toInstant().atZone(ZoneOffset.UTC).toInstant());
  }
}
