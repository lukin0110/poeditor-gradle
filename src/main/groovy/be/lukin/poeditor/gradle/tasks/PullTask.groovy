package be.lukin.poeditor.gradle.tasks

import be.lukin.poeditor.FileTypeEnum
import be.lukin.poeditor.POEditorClient
import be.lukin.poeditor.gradle.POEditorExtension
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

import java.nio.file.Path
import java.nio.file.Paths

class PullTask extends DefaultTask {
    
    @TaskAction
    def pull(){
        println 'Downloading translations'
        def project = this.getProject()
        POEditorExtension config = project.poeditor;
        POEditorClient client = new POEditorClient(config.apiKey)
        Path current = Paths.get("");
        def details = client.getProject(config.projectId)
        
        println "Project: " + details.name + " (id:" + details.id + ", type:" + config.type + ")"
        FileTypeEnum fte = FileTypeEnum.valueOf(config.type.toUpperCase());

        for(Map.Entry<String, String> ke : config.map){
            File exportFile = new File(current.toAbsolutePath().toString(), ke.value)
            exportFile.getParentFile().mkdirs();
            File f = client.export(config.projectId, ke.key, fte, null, exportFile)
            println " - Trans " + ke.key + ": " + ke.value
        }
    }
}
