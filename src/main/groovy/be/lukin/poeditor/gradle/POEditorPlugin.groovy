package be.lukin.poeditor.gradle

import be.lukin.poeditor.gradle.tasks.InitTask
import be.lukin.poeditor.gradle.tasks.PullTask
import be.lukin.poeditor.gradle.tasks.PushTermsTask
import org.gradle.api.Plugin
import org.gradle.api.Project;

class POEditorPlugin implements Plugin<Project> {
    public static final String GROUP = 'POEditor translations'
    
    @Override
    void apply(Project project) {
        //project.setGroup()
        project.setDescription("Manage translations from POEditor (http://poeditor.com)")

        // Define extension
        project.extensions.create("poeditor", POEditorExtension)
        
        // Define tasks
        project.task("poeditorInit", 
                type: InitTask, 
                group: GROUP,
                description: "Initialization: create terms & languages")
        project.task("poeditorPushTerms",
                type: PushTermsTask, 
                group: GROUP, 
                description: "Upload terms")
        project.task("poeditorPull",
                type: PullTask, 
                group: GROUP, 
                description: "Download translations")
    }
}
