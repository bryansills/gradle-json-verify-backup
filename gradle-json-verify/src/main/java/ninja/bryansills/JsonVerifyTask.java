package ninja.bryansills;

import com.squareup.moshi.Moshi;
import org.gradle.api.DefaultTask;
import org.gradle.api.file.ConfigurableFileTree;
import org.gradle.api.tasks.Input;
import org.gradle.api.tasks.TaskAction;

import java.io.File;

public class JsonVerifyTask extends DefaultTask {
    @Input
    ConfigurableFileTree configFiles = getProject().fileTree(getProject().getProjectDir() + "/json/");

    @TaskAction
    public void jsonVerify() {
        configFiles.forEach(file -> {
            if (".json".equals(getFileExtension(file))) {
                verifyJsonFile(file);
            }
        });
    }

    private boolean verifyJsonFile(File file) {
        System.out.println(file.getPath());
        Moshi moshi = new Moshi.Builder().build();

        return true;
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