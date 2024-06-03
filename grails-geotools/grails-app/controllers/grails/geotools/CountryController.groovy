package grails.geotools
/*
 * A controller demonstrating FeatureService.
 * See grails-app/services/geotools/FeatureService.groovy for the service.
 */
class CountryController {
    // Inject FeatureService
    def featureService

    def index() { 
        // Use FeatureService
        double latitude = 38.0
        double longitude = -77.0
        def countryNames = featureService.getCountryName(latitude, longitude)

        // render the view
        render "In CountryController: Country Names: ${countryNames}"
    }
}
