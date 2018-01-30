package gov.usgs.wim.wdnr.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Import(MybatisConfig.class)
@ComponentScan(basePackages="gov.usgs.wim.wdnr")
@EnableWebMvc
public class SpringConfig implements WebMvcConfigurer {

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        //This should make the url case insensitive
        AntPathMatcher matcher = new AntPathMatcher();
        matcher.setCaseSensitive(false);
        configurer.setPathMatcher(matcher);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html", "webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/", "classpath:/META-INF/resources/webjars/");
        registry.setOrder(-1);
    }

}
