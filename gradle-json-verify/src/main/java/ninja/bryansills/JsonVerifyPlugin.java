package ninja.bryansills;

import groovy.lang.Closure;
import org.gradle.api.Action;
import org.gradle.api.Project;
import org.gradle.api.Plugin;
import org.gradle.api.Task;

import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;

public class JsonVerifyPlugin implements Plugin<Project> {
    @Override
    public void apply(Project target) {
        Task jsonVerifyTask = target.getTasks().create("jsonVerify", JsonVerifyTask.class);
//
//        Map<Project, Set<Task>> tasks2 = target.getAllTasks(true);
//
//        for (Map.Entry<Project, Set<Task>> entry : tasks2.entrySet()) {
//            Project entryProject = entry.getKey();
//            Set<Task> entryTasks = entry.getValue();
//
//            System.out.println("dunno" + entryProject.getName());
//
//            for (Task singleTask : entryTasks) {
//                if (!singleTask.getName().equals("jsonVerify")) {
//                    singleTask.dependsOn(jsonVerifyTask);
//                }
//                System.out.println("wat" + singleTask.getName());
//            }
//        }

        target.afterEvaluate(project -> {
            Set<Task> tasks = target.getTasksByName("preBuild", true);

            if (tasks.isEmpty()) {
                throw new RuntimeException("No tasks!!!");
            } else {
                tasks.forEach(task -> task.dependsOn(jsonVerifyTask));
            }

            Map<Project, Set<Task>> tasks2 = target.getAllTasks(true);

            for (Map.Entry<Project, Set<Task>> entry : tasks2.entrySet()) {
                Project entryProject = entry.getKey();
                Set<Task> entryTasks = entry.getValue();

                System.out.println("dunno" + entryProject.getName());

                for (Task singleTask : entryTasks) {
                    if (!singleTask.getName().equals("jsonVerify")) {
                        singleTask.dependsOn(jsonVerifyTask);
                    }
                    System.out.println("wat" + singleTask.getName());
                }
            }

        });
    }
}
