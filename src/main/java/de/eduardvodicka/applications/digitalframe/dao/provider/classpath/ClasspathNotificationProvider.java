package de.eduardvodicka.applications.digitalframe.dao.provider.classpath;

import de.eduardvodicka.applications.digitalframe.dao.provider.NotificationProvider;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by evodicka on 02.01.2016.
 */
public class ClasspathNotificationProvider implements NotificationProvider {

    private String filePath;

    public ClasspathNotificationProvider(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<String> loadLines() {
        try (InputStream resource = getClass().getResourceAsStream(filePath)) {
            return new BufferedReader(new InputStreamReader(resource,
                    StandardCharsets.UTF_8)).lines().collect(Collectors.toList());
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }
}