package be.lukin.poeditor.gradle

import org.junit.Test
import org.gradle.testfixtures.ProjectBuilder
import org.gradle.api.Project
import static org.junit.Assert.*

class PluginTest {
    
    @Test
    public void poeditorPluginAddsTasksToProject() {
        
        Project project = ProjectBuilder.builder().build()
        project.apply plugin: 'poeditor'
        
        def container = project.tasks
        assertEquals(4, container.size())
        
        // Random task
        assertTrue(container.findByName('poeditor42') == null)
        
        assertTrue(container.findByName('poeditorInit') != null)
        assertTrue(project.tasks.poeditorInit instanceof InitTaskGradle)
        
        assertTrue(container.findByName('poeditorPushTerms') != null)
        assertTrue(project.tasks.poeditorPushTerms instanceof PushTermsTaskGradle)

        assertTrue(container.findByName('poeditorPull') != null)
        assertTrue(project.tasks.poeditorPull instanceof PullTaskGradle)

        assertTrue(container.findByName('poeditorStatus') != null)
        assertTrue(project.tasks.poeditorStatus instanceof StatusTaskGradle)
    }
}
