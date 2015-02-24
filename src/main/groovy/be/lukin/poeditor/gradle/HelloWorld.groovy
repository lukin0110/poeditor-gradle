package be.lukin.poeditor.gradle

import java.nio.file.Path
import java.nio.file.Paths

//import be.lukin.poeditor.POEditorClient;

class HelloWorld {
    HelloWorld() {
    }
    
    def sayHello(){
        println 'Hello World'
    }
    
    static main(args) {
        // Say Hello
        def hw = new HelloWorld()
        hw.sayHello()
        
        // Print current directory
        Path current = Paths.get("");
        System.out.println("Current dir: " + current.toAbsolutePath().toString());
        
        /*
        http://stackoverflow.com/questions/4871051/getting-the-current-working-directory-in-java
        Paths.get(".").toAbsolutePath().normalize().toString()
        this.getClass().getClassLoader().getResource("").getPath()
         */
    }
}
