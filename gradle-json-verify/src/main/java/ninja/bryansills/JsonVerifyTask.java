package ninja.bryansills;

import org.gradle.api.DefaultTask;
import org.gradle.api.file.ConfigurableFileCollection;
import org.gradle.api.file.ConfigurableFileTree;
import org.gradle.api.tasks.Input;
import org.gradle.api.tasks.TaskAction;

import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;

public class JsonVerifyTask extends DefaultTask {
    @Input
    ConfigurableFileTree configFiles = getProject().fileTree(getProject().getProjectDir() + "/json/");

    @TaskAction
    public void jsonVerify() {
        configFiles.forEach(file -> {
            if (".json".equals(getFileExtension(file))) {
                System.out.println("yay");
            }
            System.out.println(file.getPath());
        });
    }

    private String getFileExtension(File file) {
        String name = file.getName();
        try {
            return name.substring(name.lastIndexOf("."));
        } catch (Exception e) {
            return "";
        }
    }
}