package grails.bean

class BootStrap {
    def myBean // This is injecting myBean 

    def init = { servletContext ->    
        println "In BootStrap init"
        /*
         * Demonstrates how to use a bean in Grails by calling methods.
         */
        myBean.printConstructorName()
        myBean.printName()
        println "\n"
    }
    def destroy = {
    }
}
