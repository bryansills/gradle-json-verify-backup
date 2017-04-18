package ninja.bryansills;

import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.Input;
import org.gradle.api.tasks.TaskAction;

public class JsonVerifyTask extends DefaultTask {
    @Input
    public String who = "mate";

    @TaskAction
    public void jsonVerify() {
        System.out.println("Hi " + who + "!!!");
    }
}