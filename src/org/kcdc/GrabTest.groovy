package org.kcdc

@Grab(group='org.apache.commons', module='commons-lang3', version='3.4')
import org.apache.commons.lang3.SystemUtils

def printInfo(script) {
    script.node {
        println "hello"
    }
    println 'We are ready to use packages from commons'
    if (SystemUtils.isJavaVersionAtLeast(8)) {
        println 'And there we go, and on Java 8'
    }
}