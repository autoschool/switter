package ru.qatools.school.switter;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ProvideSystemProperty;
import ru.qatools.school.switter.config.ServerConfig;

import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * eroshenkoam
 * 25/11/14
 */
public class SimpleTest {

    @Rule
    public ProvideSystemProperty systemProperty =
            new ProvideSystemProperty("environment", "test");

    @Test
    public void testEnvironmentConfigTest() {
        ServerConfig config = ServerConfig.newInstance();
        assertThat(config.getDbPath(), notNullValue());

    }
}
