package de.eduardvodicka.applications.digitalframe.dao.provider.filesystem;

import de.eduardvodicka.applications.digitalframe.dao.provider.FileBasedNotificationProvider;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

/**
 * Created by evodicka on 02.01.2016.
 */
public class FilesystemNotificationProvider extends FileBasedNotificationProvider {

    private String filePath;

    public FilesystemNotificationProvider(String filePath) {
        this.filePath = filePath;
    }

    @Override
    protected List<String> loadLines() {
        try {
            return Files.readAllLines(new File(filePath).toPath());
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }
}
