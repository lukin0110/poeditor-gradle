poeditor-gradle
===============
[![Build Status](https://travis-ci.org/lukin0110/poeditor-gradle.svg)](https://travis-ci.org/lukin0110/poeditor-gradle)

Gradle plugin to manage translations easily within a [POEditor][1] project. The plugin enables you
to include downloading and uploading of translations in your Gradle build file.

1. Install
----------
Add the following 2 lines of code to your `gradle.build` file. 

In the `dependencies` section:
```groovy
classpath 'be.lukin.poeditor:gradle:0.2.0'
```

Include the plugin:
```groovy
apply plugin: 'poeditor'
```

The plugin requires at minimum Java 7 and Gradle 2.x.

2. Configure
-------------
Add configuration about your POEditor project to the `gradle.build` file. You need an api key and project id from 
POEditor.

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

Parameter    | Description
------------ | --------------------
type         | file format: po, pot, mo, xls, apple_strings, xliff, android_strings, resx, resw, properties, json

Now you're all set to manage your translations.

3. Usage
--------
After your have created your translation project on POEditor you can can initialize your project based on your c
onfiguration.

Initialize:
```
gradle poeditorInit
```
This will create terms and add languages to your project.


Download translations:
```
gradle poeditorPull
```

Add terms:
```
gradle poeditorPushTerms
```

A few example configurations can be found in the [example projects][3] folder.

License
=======

    Copyright 2015 Maarten Huijsmans

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.


 [1]: https://poeditor.com/
 [2]: http://search.maven.org/remotecontent?filepath=be/lukin/poeditor/poeditor-client/0.1.1/poeditor-client-0.1.1.jar
 [3]: https://github.com/lukin0110/poeditor-gradle/blob/master/example-project/
 [snap]: https://oss.sonatype.org/content/repositories/snapshots/