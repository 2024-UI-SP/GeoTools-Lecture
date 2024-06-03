
import grails.geotools.MyFeatureSource

/*
 * beans resigisters and instantiates beans.
 * See https://docs.grails.org/6.2.0/guide/spring.html for simple examples.
 * See https://stackoverflow.com/questions/22400078/inject-constructor-argument-spring-resource-file-with-grails-groovy
 * for how to inject constructor arguments.
 */
beans = {
    // The first argument is the constructor, the second is the argument.
    myFeatureSource(MyFeatureSource, "countries.shp")
}
