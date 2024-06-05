
import grails.bean.MyBean

/*
 * beans registers and instantiates beans.
 * See https://docs.grails.org/6.2.0/guide/spring.html for simple examples.
 * See https://stackoverflow.com/questions/22400078/inject-constructor-argument-spring-resource-file-with-grails-groovy
 * for how to inject constructor arguments.
 */

beans = {
    // This closure uses Spring Domain Specific Language (DSL). 
    // The first argument is the class name and following argument are the constructor arguments
    myBean(MyBean, "My_Bean_Constructor") {
        // Here public variables are set
        name = "My_Bean"
    }
}

