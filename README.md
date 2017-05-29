poeditor-gradle
===============

Gradle plugin to manage translations easily within a [POEditor][1] project. The plugin enables you
to include downloading and uploading of translations in your Gradle build file.

This gradle plugin depends on [poeditor-java][4], a java client for the POEditor API.

1. Install
----------
Add the following 2 lines of code to your `gradle.build` file. 

In the `buildscript dependencies` section:

```groovy
     maven { url = 'https://jitpack.io' }
```

In the `dependencies` section:

```groovy
classpath "com.github.vimn-north:poeditor-gradle:-SNAPSHOT"
```

Include the plugin:
```groovy
apply plugin: 'poeditor'
```

The plugin requires at minimum Java 7 and Gradle 2.x.

2. Configure (without flavors)
------------------------------
Add configuration about your POEditor project to the `gradle.build` file. You need an api key and project id from 
POEditor.

Example configuration:

```groovy
poeditor {
    apikey 'your api key here'
    projectId 'your project id here'
    type 'android_strings'
    tagsNew '1.0'

    terms 'App/src/main/res/values/strings.xml'
    trans 'en', 'App/src/main/res/values/strings.xml'
    trans 'nl', 'App/src/main/res/values-nl/strings.xml'
    trans 'fr', 'App/src/main/res/values-fr/strings.xml'
    
    filters 'nl', 'translated'
    filters 'fr', 'translated, automatic'
}
```

Parameter    | Description
------------ | --------------------
apiKey       | api key to access the api, can be obtained in your [Account][account]
projectId    | id of the project on POEditor
type         | file format: po, pot, mo, xls, apple_strings, xliff, android_strings, resx, resw, properties, json
terms        | point to the file that contains all the terms, probably this is your default language
trans        | receives 2 parameters: language code & file path of a translation
filters      | receives 2 parameters: language code & comma separated list of filters. Check the [API Reference][reference] for all available filters 

Now you're all set to manage your translations.


2. Configure (with flavors)
---------------------------
If you need flavor depending values, the setup is similar

configure the shared values:

```groovy
poeditor {
    apikey 'your api key here'
    projectId 'your project id here'
    type 'android_strings'
    tagsNew '1.0'
}
```

and keep the translation values in the flavors:

    productFlavors {
        'myflavor' {
            ...
            project.poeditor {
                    variant 'myflavor'
                    projectId 'your project id here'
                    terms 'App/src/main/res/values/strings.xml'
                    trans 'en', 'App/src/myflavor/res/values/strings.xml'
                    trans 'nl', 'App/src/myflavor/res/values-nl/strings.xml'
                    trans 'fr', 'App/src/myflavor/res/values-fr/strings.xml'

                    filters 'nl', 'translated'
                    filters 'fr', 'translated, automatic'
            }
       }
    }



3. Usage
--------
After your have created your translation project on POEditor you can can initialize your project based on your c
onfiguration.

### Initialize
```
gradle poeditorInit
```
This will create terms and add languages to your project.

### Download translations
```
gradle poeditorPull
```

### Upload translations
```
gradle poeditorPush
```

Argument        | Description
--------------- | ----------------------------------------------------------------------
languages       | specify the languages that you want to upload, by default everything is uploaded
override        | force to override the translation on POEditor

Example:
```
gradle poeditorPush -Planguages=nl,fr -Poverride=true
```

### Add terms
```
gradle poeditorPushTerms
```

A few example configurations can be found in the [example projects][3] folder.


For flavors use the same tasks but add the flavor name:

Example:
```
gradle poeditorPushmyflavor
```


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
 [2]: http://search.maven.org/remotecontent?filepath=be/lukin/poeditor/poeditor-client/0.3.3/poeditor-client-0.3.3.jar
 [3]: https://github.com/lukin0110/poeditor-gradle/blob/master/example-project/
 [snap]: https://oss.sonatype.org/content/repositories/snapshots/
 [4]: https://github.com/lukin0110/poeditor-java
 [reference]:   https://poeditor.com/api_reference/
 [account]:     https://poeditor.com/account/api
 
