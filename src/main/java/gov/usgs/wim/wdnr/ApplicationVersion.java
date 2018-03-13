package gov.usgs.wim.wdnr;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;
import java.util.Properties;

@Component
public class ApplicationVersion implements ServletContextAware {

    private static final Logger LOG = LoggerFactory.getLogger(ApplicationVersion.class);

    private static ServletContext servletContext;

    public static String getVersion() {
        StringBuilder currentVersion = new StringBuilder("Application Version: ");
        try {
            String name = "/META-INF/MANIFEST.MF";
            Properties props = new Properties();
            props.load(servletContext.getResourceAsStream(name));
            String projectVersion = (String) props.get("Project-Version");
            if (null == projectVersion) {
                currentVersion.append("Unavailable");
            } else {
                currentVersion.append(projectVersion);
                if (projectVersion.endsWith("-SNAPSHOT")) {
                    currentVersion.append(" Built at: ").append((String) props.get("BuildTime"));
                    currentVersion.append(" From commit: ").append((String) props.get("Implementation-Build"));
                }
            }
        } catch (Exception e) {
            LOG.info("unable to get application version", e);
            currentVersion.append(" Error Encountered");
        }
        return currentVersion.toString();
    }

    public void setServletContext(final ServletContext inServletContext) {
        servletContext = inServletContext;
    }

}