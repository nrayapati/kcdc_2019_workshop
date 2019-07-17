#!/usr/bin/env groovy
import jenkins.model.*

def instance = Jenkins.getInstance()

def rule = instance.getExtensionList(jenkins.security.s2m.MasterKillSwitchConfiguration.class)[0].rule
if (!rule.getMasterKillSwitch()) {
    rule.setMasterKillSwitch(true)
    instance.getExtensionList(jenkins.security.s2m.MasterKillSwitchWarning.class)[0].disable(true)
    instance.save()
    println 'Disabled agent -> master security for cobertura.'
} else {
    instance.getExtensionList(jenkins.security.s2m.MasterKillSwitchWarning.class)[0].disable(true)
    instance.save()
    println 'Nothing changed.  Agent -> master security already disabled.'
}
