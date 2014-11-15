package ru.qatools.school.switter;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.mvc.freemarker.FreemarkerMvcFeature;
import ru.qatools.school.switter.service.DatabaseProvider;

import javax.ws.rs.container.DynamicFeature;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.FeatureContext;

/**
 * eroshenkoam
 * 15/11/14
 */
public class Server extends ResourceConfig {

    public Server() {
        register(FreemarkerMvcFeature.class);

        register(new DynamicFeature() {
            @Override
            public void configure(ResourceInfo resourceInfo, FeatureContext context) {
                context.register(DatabaseProvider.class);
            }
        });

        packages(Server.class.getPackage().getName());
    }
}
