poeditor-gradle
===============

Plugin for Gradle to download translations from [POEditor API](https://poeditor.com/).

Download
--------

Grab via maven:
```xml
<dependency>
  <groupId>be.lukin.poeditor</groupId>
  <artifactId>gradle</artifactId>
  <version>0.1.0</version>
</dependency>
```
or gradle:
```groovy
compile 'be.lukin.poeditor:gradle:0.1.0'
```

Usage
-----

Download translations:
```
gradle poeditorDownload
```

Sync terms:
```
gradle poeditorSyncTerms
```

Configuration
=============

Example configuration:

```groovy
poeditor {
    apikey 'apikey here'

    projects {
        androidApp {
            projectId 'project id here'
            type 'android_strings'
            terms 'App/src/main/res/values/strings.xml'
            trans 'en', 'App/src/main/res/values/strings.xml'
            trans 'nl', 'App/src/main/res/values-nl/strings.xml'
            trans 'fr', 'App/src/main/res/values-fr/strings.xml'
        }
    }
}
```
