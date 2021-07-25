
package com.example.week05.starter;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@EnableAutoConfiguration
@Import(KlassConfiguration.class)
@ConditionalOnMissingBean(Student.class)
public class KlassAutoConfiguration {
}
