grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"

grails.project.fork = [

        // configure settings for the test-app JVM, uses the daemon by default
        test   : [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256, daemon: true],
        // configure settings for the run-app JVM
        run    : [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256, forkReserve: false],
        // configure settings for the run-war JVM
        war    : [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256, forkReserve: false],
        // configure settings for the Console UI JVM
        console: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256]
]

grails.project.dependency.resolver = "maven" // or ivy
grails.project.dependency.resolution = {

    inherits("global") {
        // uncomment to disable ehcache
        // excludes 'ehcache'
    }
    log "warn"
    repositories {
        grailsCentral()
        mavenLocal()
        mavenCentral()

    }
    dependencies {
        compile 'org.jadira.usertype:usertype.extended:3.2.0.GA'
    }

    plugins {


        build(":release:3.0.1") {
            export = false
        }


        provided ":hibernate4:4.3.5.4"
    }
}

grails.gorm.default.mapping = {
    "user-type" type: org.jadira.usertype.dateandtime.threeten.PersistentLocalDate, class: java.time.LocalDate
    "user-type" type: org.jadira.usertype.dateandtime.threeten.PersistentLocalTime, class: java.time.LocalTime
    "user-type" type: org.jadira.usertype.dateandtime.threeten.PersistentLocalDateTime, class: java.time.LocalDateTime
    "user-type" type: org.jadira.usertype.dateandtime.threeten.PersistentInstantAsTimestamp, class: java.time.Instant
    "user-type" type: org.jadira.usertype.dateandtime.threeten.PersistentYearAsString, class: java.time.Year
    "user-type" type: org.jadira.usertype.dateandtime.threeten.PersistentYearMonthAsString, class: java.time.YearMonth


}