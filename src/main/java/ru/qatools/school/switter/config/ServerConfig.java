package ru.qatools.school.switter.config;

import ru.yandex.qatools.properties.PropertyLoader;
import ru.yandex.qatools.properties.annotations.Property;
import ru.yandex.qatools.properties.annotations.Resource;
import ru.yandex.qatools.properties.annotations.With;
import ru.yandex.qatools.properties.providers.MapOrSyspropPathReplacerProvider;

/**
 * @author Dmitry Baev charlie@yandex-team.ru
 *         Date: 17.11.14
 */

@With(MapOrSyspropPathReplacerProvider.class)
@Resource.Classpath("${system.environment}.properties")
public class ServerConfig {

    @Property("db.path")
    private String dbLocation = "mem";

    @Property("db.name")
    private String dbName = "switter";

    ServerConfig() {
        PropertyLoader.populate(this);
    }

    public String getDbLocation() {
        return dbLocation;
    }

    public void setDbLocation(String dbLocation) {
        this.dbLocation = dbLocation;
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public static ServerConfig newInstance() {
        return new ServerConfig();
    }
}
