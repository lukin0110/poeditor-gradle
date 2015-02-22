package be.lukin.poeditor.gradle

import org.gradle.api.Plugin
import org.gradle.api.Project;

/**
 */
class POEditorPlugin implements Plugin<Project> {
    @Override
    void apply(Project project) {
        //c4rTask task has been defined below.
        project.task('c4rTask') << {
            println 'Hi from Code4Reference plugin!'
        }
    }
}


/*
[main]
apikey = 14f85092c9332318b89ff22731f8a702

[project.vikingsapp]
project_id = 29135
type = android_strings
trans.en = App/src/main/res/values/strings.xml
trans.nl = App/src/main/res/values-nl/strings.xml
trans.fr = App/src/main/res/values-fr/strings.xml
trans.pl = App/src/poland/res/values-pl/strings.xml
 */
