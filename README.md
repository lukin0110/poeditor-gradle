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
  <version>0.2.0</version>
</dependency>
```
or gradle:
```groovy
compile 'be.lukin.poeditor:gradle:0.2.0'
```

Usage
-----

Download translations:
```
gradle poeditorPull
```

Add terms:
```
gradle poeditorPushTerms
```

Configuration
=============

Example configuration:

```groovy
poeditor {
    apikey 'your api key here'
    projectId 'your project id here'
    type 'android_strings'

    terms 'App/src/main/res/values/strings.xml'
    trans 'en', 'App/src/main/res/values/strings.xml'
    trans 'nl', 'App/src/main/res/values-nl/strings.xml'
    trans 'fr', 'App/src/main/res/values-fr/strings.xml'
}
```
