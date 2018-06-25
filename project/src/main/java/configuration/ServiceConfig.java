package configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import services.ProductService;
import services.ProductServiceImpl;
import services.UserService;
import services.UserServiceImpl;

@Configuration
public class ServiceConfig {

    @Bean
    public ProductService productService() {
        return new ProductServiceImpl();
    }

    @Bean
    public UserService userService() {
        return new UserServiceImpl();
    }

}
