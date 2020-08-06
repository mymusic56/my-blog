package com.zsj.blog.common.framework.property;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "admin")
@Data
public class AdminProperty {
    @Value("${custom-properties.admin.enableKaptcha}")
    public boolean enableKaptcha;
}
