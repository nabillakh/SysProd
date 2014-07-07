grails.servlet.version = "3.0" // Change depending on target container compliance (2.5 or 3.0)
grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
grails.project.work.dir = "target/work"
grails.project.target.level = 1.6
grails.project.source.level = 1.6
//grails.project.war.file = "target/${appName}-${appVersion}.war"

grails.project.fork = [
    // configure settings for compilation JVM, note that if you alter the Groovy version forked compilation is required
    //  compile: [maxMemory: 256, minMemory: 64, debug: false, maxPerm: 256, daemon:true],

    // configure settings for the test-app JVM, uses the daemon by default
    test: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256, daemon:true],
    // configure settings for the run-app JVM
    run: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256, forkReserve:false],
    // configure settings for the run-war JVM
    war: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256, forkReserve:false],
    // configure settings for the Console UI JVM
    console: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256]
]

grails.project.dependency.resolver = "maven" // or ivy
grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits("global") {
        // specify dependency exclusions here; for example, uncomment this to disable ehcache:
        // excludes 'ehcache'
    }
    log "error" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    checksums true // Whether to verify checksums on resolve
    legacyResolve false // whether to do a secondary resolve on plugin installation, not advised and here for backwards compatibility

      repositories {
        inherits true // Whether to inherit repository definitions from plugins

        grailsPlugins()
        grailsHome()
        mavenLocal()
        grailsCentral()
        mavenCentral()
        
        mavenRepo 'http://dist.gemstone.com/maven/release'
        
        mavenRepo "http://repo.grails.org/grails/core"
       
        // pour activeMQ
        mavenRepo "http://download.java.net/maven/2/"
        mavenRepo "http://repository.jboss.org/nexus/content/groups/public-jboss/"
        
        // Spring security
        mavenRepo "http://repo.spring.io/milestone/"
        
        // functional test
        mavenRepo "http://repository.codehaus.org/"
        mavenRepo "http://repository.jboss.org/maven2/"
                // gestion calendaire
        mavenRepo "http://repo.grails.org/grails/libs-releases/"
        mavenRepo "http://m2repo.spockframework.org/ext/"
        mavenRepo "http://m2repo.spockframework.org/snapshots/"
        mavenRepo "http://snapshots.repository.codehaus.org"
        mavenRepo "http://maven.springframework.org/milestone/"
        //import excel
        mavenRepo "http://m2repo.spockframework.org/ext/"
        
        // uncomment these (or add new ones) to enable remote dependency resolution from public Maven repositories
        //mavenRepo "http://repository.codehaus.org"
        //mavenRepo "http://download.java.net/maven/2/"
        //mavenRepo "http://repository.jboss.com/maven2/"
    }

    dependencies {
        
        
        compile 'org.springframework:spring-jms:3.2.7.RELEASE'        
        
        runtime "joda-time:joda-time:1.6.2"
        // specify dependencies here under either 'build', 'compile', 'runtime', 'test' or 'provided' scopes e.g.
        runtime 'mysql:mysql-connector-java:5.1.27'
        runtime 'net.sourceforge.jtds:jtds:1.2.6' 
        // runtime 'org.postgresql:postgresql:9.3-1100-jdbc41'
    }

    plugins {
        // plugins for the build system only
        build ":tomcat:7.0.50.1"
        // build "org.fusesource.jansi:jansi:1.11" 
        // plugins for the compile step
        compile ":scaffolding:2.0.2"
        compile ':cache:1.1.1'

        // plugins needed at runtime but not for compilation
        runtime ":hibernate:3.6.10.8" // or ":hibernate4:4.3.1.1"
        runtime ":database-migration:1.3.8"
        runtime ":jquery:1.11.0"
        runtime ":resources:1.2.1"
        runtime ':twitter-bootstrap:3.0.3'
        // Uncomment these (or add new ones) to enable additional resources capabilities
        //runtime ":zipped-resources:1.0.1"
        //runtime ":cached-resources:1.1"
        //runtime ":yui-minify-resources:0.1.5"

        // An alternative to the default resources plugin is the asset-pipeline plugin
        //compile ":asset-pipeline:1.5.0"

        // Uncomment these to enable additional asset-pipeline capabilities
        //compile ":sass-asset-pipeline:1.5.1"
        //compile ":less-asset-pipeline:1.5.0"
        //compile ":coffee-asset-pipeline:1.5.0"
        //compile ":handlebars-asset-pipeline:1.0.0.3"

        compile ':activemq:0.4.1'
        
        compile ':jms:1.1' 
        
        compile ':searchable:0.6.8'
        compile ':spring-security-core:1.2.7.3'
        test ':geb:0.9.2'
        test ':spock:0.7'
        test ':functional-test:2.0.RC1'
        
        compile ":excel-import:1.0.0"
    }
}
