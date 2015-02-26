package be.lukin.poeditor.gradle.tasks

/**
 * Created by maartenhuijsmans on 26/2/15.
 */
class StatusTask {
    // Show project info
    // Show languages info
}


/*
tx status is a simple command that displays the existing project configuration in a more human readable format. It lists all resources that have been initialized under the local project and all their associated translation files:

$ tx status
myproject -> default (1 of 1)
Translation Files:
 - en: po/smolt.pot (source)
 - ar: po/ar.po
 - as: po/as.po
 - bg: po/bg.po
 - bn_IN: po/bn_IN.p
 ...
 */