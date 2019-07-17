#!/usr/bin/env groovy
import hudson.security.*
import jenkins.model.*

def instance = Jenkins.getInstance()

def strategy = new FullControlOnceLoggedInAuthorizationStrategy()
strategy.setAllowAnonymousRead(true)
instance.setAuthorizationStrategy(strategy)
instance.save()
