package be.lukin.poeditor.gradle

import be.lukin.poeditor.tasks.PullTask
import be.lukin.poeditor.tasks.PushTermsTask
import be.lukin.poeditor.tasks.InitTask
import be.lukin.poeditor.tasks.StatusTask;
import org.gradle.api.DefaultTask
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.tasks.TaskAction;

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
                type: InitTaskGradle,
                group: GROUP,
                description: "Initialization: create terms & languages")
        project.task("poeditorPushTerms",
                type: PushTermsTaskGradle,
                group: GROUP, 
                description: "Upload terms")
        project.task("poeditorPull",
                type: PullTaskGradle,
                group: GROUP, 
                description: "Download translations")
        project.task("poeditorStatus",
                type: StatusTaskGradle,
                group: GROUP,
                description: "Existing project configuration in a more human readable format")
    }
}

class InitTaskGradle extends DefaultTask {
    @TaskAction
    def initialize() {
        def project = this.getProject();
        POEditorExtension extension = project.poeditor;
        new InitTask().configure(extension.toConfig()).handle();
    }
}

class PullTaskGradle extends DefaultTask {
    @TaskAction
    def initialize() {
        def project = this.getProject();
        POEditorExtension extension = project.poeditor;
        new PullTask().configure(extension.toConfig()).handle();
    }
}

class PushTermsTaskGradle extends DefaultTask {
    @TaskAction
    def initialize() {
        def project = this.getProject();
        POEditorExtension extension = project.poeditor;
        new PushTermsTask().configure(extension.toConfig()).handle();
    }
}

class StatusTaskGradle extends DefaultTask {
    @TaskAction
    def initialize() {
        def project = this.getProject();
        POEditorExtension extension = project.poeditor;
        new StatusTask().configure(extension.toConfig()).handle();
    }
}
