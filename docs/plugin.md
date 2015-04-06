Gradle Plugin
=============

Create a gradle plugin:
http://www.javacodegeeks.com/2012/08/gradle-custom-plugin.html

Publish to local repo:
```
gradle publishToMavenLocal
```

Run tests
---------
```
gradle test
```

Using travis: http://docs.travis-ci.com/user/languages/groovy/

Check compile version used
--------------------------
```
javap -verbose build/classes/main/be/lukin/poeditor/gradle/POEditorPlugin.class | grep major
```
