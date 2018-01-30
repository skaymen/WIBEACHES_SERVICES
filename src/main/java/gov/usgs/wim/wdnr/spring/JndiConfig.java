package gov.usgs.wim.wdnr.spring;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;

public class JndiConfig {

    private final Context ctx;

    public JndiConfig() throws NamingException {
        ctx = new InitialContext();
    }

    @Bean
    public DataSource dataSource() throws Exception {
        return (DataSource) ctx.lookup("java:comp/env/jdbc/wibeaches_services_beachhealth_dataDS");
    }

    @Bean
    public String displayHost() throws NamingException {
        return (String) ctx.lookup("java:comp/env/wibeachesServices/displayHost");
    }

    @Bean
    public String displayPath() throws NamingException {
        return (String) ctx.lookup("java:comp/env/wibeachesServices/displayPath");
    }

}
