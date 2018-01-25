package gov.usgs.wim.wdnr.swagger;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;

import springfox.documentation.PathProvider;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.paths.AbstractPathProvider;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
public class SwaggerConfig {

    public static final String VERSION_TAG_NAME = "Application Version";

    @Autowired
    @Qualifier("displayHost")
    private String displayHost;

    @Autowired
    @Qualifier("displayPath")
    private String displayPath;

    @Bean
    public Docket servicesApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .tags(new Tag(VERSION_TAG_NAME, VERSION_TAG_NAME)
                .protocols(new HashSet<>(Arrays.asList("https")))
                .host(displayHost)
                .pathProvider(pathProvider())
                .useDefaultResponseMessages(false)
                ;
    }

    @Bean
    public PathProvider pathProvider() {
        PathProvider rtn = new ProxyPathProvider();
        return rtn;
    }

    public class ProxyPathProvider extends AbstractPathProvider {
        @Override
        protected String applicationPath() {
            return displayPath;
        }

        @Override
        protected String getDocumentationPath() {
            return displayPath;
        }
    }

}