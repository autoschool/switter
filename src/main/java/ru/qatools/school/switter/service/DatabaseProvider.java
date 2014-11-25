package ru.qatools.school.switter.service;

import org.flywaydb.core.Flyway;
import org.javalite.activejdbc.Base;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.qatools.school.switter.config.ServerConfig;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

import static java.lang.String.format;

/**
 * eroshenkoam
 * 15/11/14
 */
@Provider
public class DatabaseProvider implements ContainerRequestFilter {
    private static final String DBUSER = "sa";
    private final static Logger logger = LoggerFactory.getLogger(DatabaseProvider.class);
    private static String dbUrl;

    static {
        try {
            ServerConfig config = ServerConfig.newInstance();
            dbUrl = format("jdbc:h2:file:%s/%s,user=%s", config.getDbPath(), config.getDbName(), DBUSER);
            logger.info(format("Starting embedded database with url '%s' ...", dbUrl));
            openConnection();
            Flyway flyway = new Flyway();
            flyway.setDataSource(dbUrl, DBUSER, null);
            flyway.migrate();
        } catch (Exception e) {
            logger.error("Failed to start embedded database", e);
        }
    }

    public static void openConnection() {
        if (!Base.hasConnection()) {
            Base.open(org.h2.Driver.class.getName(), dbUrl, DBUSER, "");
        }
    }

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        openConnection();
    }
}
