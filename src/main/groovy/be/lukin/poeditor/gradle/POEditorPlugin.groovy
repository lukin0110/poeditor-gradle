package be.lukin.poeditor.gradle

import be.lukin.poeditor.FileTypeEnum
import org.gradle.api.Plugin
import org.gradle.api.Project;
import be.lukin.poeditor.POEditorClient

import java.nio.file.Path
import java.nio.file.Paths;

class POEditorProject {
    final String name;
    String projectId;
    String type;
    Map<String, String> map;
    
    POEditorProject(String name){
        this.name = name;
        this.map = new HashMap<>();
    }

    void projectId(String projectId){
        this.projectId = projectId;
    }
    
    void type(String type){
        this.type = type;
    }
    
    void trans(String language, String path){
        this.map.put(language, path);
        
    }

    @Override
    public String toString() {
        return "POEditorProject{" +
                "name='" + name + '\'' +
                ", projectId='" + projectId + '\'' +
                ", type='" + type + '\'' +
                ", map=" + map +
                '}';
    }
}

class ConfigExtension {
    def String apiKey;
    
    void apikey(String apiKey){
        this.apiKey = apiKey
    }
}

class POEditorPlugin implements Plugin<Project> {
    @Override
    void apply(Project project) {
        def projects = project.container(POEditorProject)
        project.extensions.create("poeditor", ConfigExtension)
        project.poeditor.extensions.projects = projects
        
        project.task('poeditorExample') << {
            println 'Example task'
            println project.poeditor.apiKey
            println project.poeditor.projects
        }
        project.task('poeditorDownload') << {
            println 'Downloading translations'
            Path current = Paths.get("");
            
            POEditorClient client = new POEditorClient(project.poeditor.apiKey)
            
            for(POEditorProject p : project.poeditor.projects){
                println "Project: " + p
                println "Details: " + client.getProject(p.projectId)
                
                for(Map.Entry<String, String> ke : p.map){
                    File exportFile = new File(current.toAbsolutePath().toString(), ke.value)
                    exportFile.getParentFile().mkdirs();
                    File f = client.export(p.projectId, ke.key, FileTypeEnum.ANDROID_STRINGS, null, exportFile)
                    println "File: " + f.getAbsolutePath()
                }
            }
        }
    }
}
