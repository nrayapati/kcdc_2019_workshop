#!/usr/bin/env groovy
import hudson.markup.RawHtmlMarkupFormatter
import jenkins.model.*

def instance = Jenkins.getInstance()
if (instance.markupFormatter.class != RawHtmlMarkupFormatter) {
    instance.markupFormatter = new RawHtmlMarkupFormatter(false)
    instance.save()
    println 'Markup Formatter configuration has changed.  Configured Markup Formatter.'
} else {
    println 'Nothing changed.  Markup Formatter already configured.'
}