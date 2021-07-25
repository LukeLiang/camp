
package com.example.week05.starter;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Properties;

@ConfigurationProperties(prefix = "klass")
public class KlassProperties {

    private Properties properties;
}
