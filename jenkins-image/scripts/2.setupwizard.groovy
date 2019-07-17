#!/usr/bin/env groovy
import hudson.util.PluginServletFilter
import jenkins.model.*

def instance = Jenkins.getInstance()
legacySetupWizard = ('getSetupWizard' in instance.metaClass.methods*.name)
newSetupWizard = (('getInstallState' in instance.metaClass.methods*.name) && ('isSetupComplete' in instance.installState.metaClass.methods*.name))

if ((!newSetupWizard && legacySetupWizard) || (newSetupWizard && !instance.installState.isSetupComplete())) {
    def w = instance.setupWizard
    if (w != null) {
        try {
            //pre Jenkins 2.6
            w.completeSetup(instance)
            PluginServletFilter.removeFilter(w.FORCE_SETUP_WIZARD_FILTER)
        }
        catch (Exception e) {
            w.completeSetup()
        }
        instance.save()
        println 'Jenkins 2.0 wizard skipped.'
    }
}
