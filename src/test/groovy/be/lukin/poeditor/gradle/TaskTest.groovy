package be.lukin.poeditor.gradle

import org.junit.Test
import org.gradle.testfixtures.ProjectBuilder
import org.gradle.api.Project
import static org.junit.Assert.*

class TaskTest {
    @Test
    public void canAddTaskToProject() {
        Project project = ProjectBuilder.builder().build()
        
        def task1 = project.task('poeditorInit', type: InitTaskGradle)
        assertTrue(task1 instanceof InitTaskGradle)
        
        def task2 = project.task('poeditorPushTerms', type: PushTermsTaskGradle)
        assertTrue(task2 instanceof PushTermsTaskGradle)

        def task3 = project.task('poeditorPull', type: PullTaskGradle)
        assertTrue(task3 instanceof PullTaskGradle)

        def task4 = project.task('poeditorStatus', type: StatusTaskGradle)
        assertTrue(task4 instanceof StatusTaskGradle)
    }
}
