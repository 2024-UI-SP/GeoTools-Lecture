package grails.bean // Don't forget!


/*
 * A simple bean to demonstrate instantiation, injection and use in Grails. 
 * See conf/spring/resources.groovy for instantiation.
 * See BootStrap.groovy for injection and use.
 */
class MyBean {
    String name
    private String constructorName

    MyBean(String constructorName) {
        println "In MyBean constructor"
        this.constructorName = constructorName 
    }

    void printName() {
        println "MyBean name: ${name}"
    }

    void printConstructorName() {
        println "MyBean constructorName: ${constructorName}"
    }
}
