package be.lukin.poeditor.gradle.tasks

import be.lukin.poeditor.POEditorClient
import be.lukin.poeditor.gradle.POEditorExtension
import be.lukin.poeditor.models.Project
import be.lukin.poeditor.models.UploadDetails
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

import java.nio.file.Path
import java.nio.file.Paths

class InitTask extends DefaultTask{
    
    @TaskAction
    def initialize(){
        println "Initializing"
        def project = this.getProject()
        POEditorExtension config = project.poeditor;
        POEditorClient client = new POEditorClient(config.apiKey)
        Project details = client.getProject(config.projectId)

        if(details != null){
            // Uploading terms
            if(config.terms != null) {
                Path current = Paths.get("");
                File termsFile = new File(current.toAbsolutePath().toString(), config.terms)
                UploadDetails ud = client.upload(config.projectId, termsFile)
                println "- terms uploaded: " + ud
            } else {
                println "- no terms defined"
            }
            
            // Create languages
            for(String lang : config.map.keySet()){
                client.addProjectLanguage(config.projectId, lang)
                println "- lang added: " + lang
            }
            
            // Upload languages
            /*
            for(Map.Entry<String, String> ke : config.map){
                println "- lang uploaded: " + ke.key
            }
            */
            
        } else {
            println "Project with id '" + config.projectId + "' doesn't exist."
        }
    }
}
