package be.lukin.poeditor.gradle

import org.gradle.api.Plugin
import org.gradle.api.Project;

class ExamplePlugin implements Plugin<Project> {
    @Override
    void apply(Project project) {
        project.task('poeditorExample') << {
            println 'Example task'
        }
    }
}
