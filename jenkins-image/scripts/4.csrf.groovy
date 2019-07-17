#!/usr/bin/env groovy
import hudson.security.csrf.DefaultCrumbIssuer
import jenkins.model.*

def instance = Jenkins.getInstance()

if (!instance.isQuietingDown()) {
    if (instance.getCrumbIssuer() == null) {
        instance.setCrumbIssuer(new DefaultCrumbIssuer(true))
        instance.save()
        println 'CSRF Protection configuration has changed. Enabled CSRF Protection.'
    } else {
        println 'Nothing changed. CSRF Protection already configured.'
    }
} else {
    println "Shutdown mode enabled. Configure CSRF protection SKIPPED."
}
