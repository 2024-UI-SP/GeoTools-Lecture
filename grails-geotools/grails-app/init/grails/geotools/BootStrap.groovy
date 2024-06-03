package grails.geotools

class BootStrap {
    // Injecting beans
    def myFeatureSource 
    def featureService 

    def init = { servletContext ->
        println "\n"
        println "In BootStrap init"

        // Test myFeatureSource
        myFeatureSource.printHi()
        println "source: ${myFeatureSource.getSource()}"
        println "\n"

        // Test FeatureService
        double latitude = 38.0
        double longitude = -77.0
        def countryNames = featureService.getCountryName(latitude, longitude)
        println "\n"
        println "In BootStrap: Country Names: ${countryNames}"
    }
    def destroy = {
    }
}
