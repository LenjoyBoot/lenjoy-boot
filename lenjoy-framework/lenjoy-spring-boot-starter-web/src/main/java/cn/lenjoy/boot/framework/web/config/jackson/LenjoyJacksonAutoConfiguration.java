package cn.lenjoy.boot.framework.web.config.jackson;

import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @description:
 * @author: lenjoy's bincloud,mvpzhou
 * @date: Create By lenjoy's bincloud,mvpzhou on 2022 04 20 星期三
 * @version: 1.0.0
 */
@Slf4j
@Configuration
public class LenjoyJacksonAutoConfiguration {

    @Bean
    @ConditionalOnProperty("spring.jackson.date-format")
    Jackson2ObjectMapperBuilderCustomizer customizeLocalDateTimeFormat(@Value("${spring.jackson.date-format}") String dateFormat) {
        // jsr310 LocalDateTime 配置序列化格式
        return jacksonObjectMapperBuilder -> {
            DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern(dateFormat);
            jacksonObjectMapperBuilder.serializerByType(LocalDateTime.class, new LocalDateTimeSerializer(dateTimeFormat));
            jacksonObjectMapperBuilder.deserializerByType(LocalDateTime.class, new LocalDateTimeDeserializer(dateTimeFormat));
        };
    }

}
