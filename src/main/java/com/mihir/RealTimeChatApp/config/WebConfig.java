package com.mihir.RealTimeChatApp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Allow all origins for API requests (you can be more restrictive as needed)
        registry.addMapping("/api/**")
                .allowedOrigins("http://localhost:3000")  // Add your React app's URL
                .allowedMethods("GET", "POST", "PUT", "DELETE")  // Allow the necessary HTTP methods
                .allowedHeaders("*")  // Allow all headers
                .allowCredentials(true);  // Allow credentials if needed (e.g., cookies or authentication)
    }
}
