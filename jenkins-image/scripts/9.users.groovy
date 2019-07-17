#!/usr/bin/env groovy
import hudson.security.HudsonPrivateSecurityRealm
import jenkins.model.*

def instance = Jenkins.getInstance()

def realm = new HudsonPrivateSecurityRealm(false, false, null)
instance.setSecurityRealm(realm)

realm.createAccount("admin", "kcdc2019")

instance.save()
