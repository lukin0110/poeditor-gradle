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
