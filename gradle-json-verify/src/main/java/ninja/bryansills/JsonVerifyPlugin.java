package ninja.bryansills;

import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.Task;

import java.util.Set;

public class JsonVerifyPlugin implements Plugin<Project> {
    @Override
    public void apply(Project target) {
        Task jsonVerifyTask = target.getTasks().create("jsonVerify", JsonVerifyTask.class);

        Set<Task> tasks = target.getTasksByName("preBuild", true);
        if (tasks.isEmpty()) {
            throw new RuntimeException("I cannot find the preBuild task to hook into.");
        } else {
            tasks.forEach(task -> task.dependsOn(jsonVerifyTask));
        }
    }
}
