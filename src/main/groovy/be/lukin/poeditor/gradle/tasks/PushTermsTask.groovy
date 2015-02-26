package be.lukin.poeditor.gradle.tasks

import be.lukin.poeditor.POEditorClient
import be.lukin.poeditor.gradle.POEditorExtension
import be.lukin.poeditor.models.UploadDetails
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

import java.nio.file.Path
import java.nio.file.Paths

class PushTermsTask extends DefaultTask {
    
    @TaskAction
    def push(){
        println 'Pushing terms'
        def project = this.getProject()
        POEditorExtension config = project.poeditor;
        POEditorClient client = new POEditorClient(config.apiKey)
        
        if(config.terms != null) {
            Path current = Paths.get("");
            File termsFile = new File(current.toAbsolutePath().toString(), config.terms)
            UploadDetails details = client.upload(config.projectId, termsFile)
            println "Synced: " + details
        } else {
            println "No terms defined"
        }
    }
}
