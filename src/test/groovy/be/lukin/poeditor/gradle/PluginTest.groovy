package be.lukin.poeditor.gradle

import be.lukin.poeditor.gradle.tasks.InitTask
import be.lukin.poeditor.gradle.tasks.PullTask
import be.lukin.poeditor.gradle.tasks.PushTermsTask
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
        assertEquals(3, container.size())
        
        // Random task
        assertTrue(container.findByName('poeditor42') == null)
        
        assertTrue(container.findByName('poeditorInit') != null)
        assertTrue(project.tasks.poeditorInit instanceof InitTask)
        
        assertTrue(container.findByName('poeditorPushTerms') != null)
        assertTrue(project.tasks.poeditorPushTerms instanceof PushTermsTask)
        
        assertTrue(container.findByName('poeditorPull') != null)
        assertTrue(project.tasks.poeditorPull instanceof PullTask)
    }
}
