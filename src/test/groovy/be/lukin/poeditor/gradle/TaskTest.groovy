package be.lukin.poeditor.gradle

import be.lukin.poeditor.gradle.tasks.InitTask
import be.lukin.poeditor.gradle.tasks.PullTask
import be.lukin.poeditor.gradle.tasks.PushTermsTask
import org.junit.Test
import org.gradle.testfixtures.ProjectBuilder
import org.gradle.api.Project
import static org.junit.Assert.*

class TaskTest {
    @Test
    public void canAddTaskToProject() {
        Project project = ProjectBuilder.builder().build()
        
        def task1 = project.task('poeditorInit', type: InitTask)
        assertTrue(task1 instanceof InitTask)
        
        def task2 = project.task('poeditorPushTerms', type: PushTermsTask)
        assertTrue(task2 instanceof PushTermsTask)

        def task3 = project.task('poeditorPull', type: PullTask)
        assertTrue(task3 instanceof PullTask)
    }
}
