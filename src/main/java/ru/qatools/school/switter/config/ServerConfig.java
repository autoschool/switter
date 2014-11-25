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
    private String dbPath;

    @Property("db.name")
    private String dbName = "default";

    ServerConfig() {
        PropertyLoader.populate(this);
    }

    public String getDbPath() {
        return dbPath;
    }

    public void setDbPath(String dbPath) {
        this.dbPath = dbPath;
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
