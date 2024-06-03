package grails.geotools

// For Query
import org.geotools.filter.text.cql2.CQL
import org.geotools.api.data.Query
import org.geotools.api.filter.Filter

// For Features
import org.geotools.data.simple.SimpleFeatureCollection
import org.geotools.data.simple.SimpleFeatureIterator
import org.geotools.api.feature.simple.SimpleFeature


import grails.gorm.transactions.Transactional

@Transactional
class FeatureService {
    // FeatureService needs a FeatureSource
    def myFeatureSource // from src/main/groovy/geotools/MyFeatureSource.groovy

    def getCountryName(double latitude, double longitude) { 
        println "\n" 
        println "In FeatureService getCountryName"
        // Get Source      
        def source = myFeatureSource.getSource()

        // Make Query
        String filterString = "contains(the_geom, POINT(${longitude} ${latitude}))"
        Filter filter = CQL.toFilter(filterString)
        String typeName = source.getSchema().getTypeName()
        String [] propertyNames = new String[] { "CNTRY_NAME" }
        Query query = new Query(typeName, filter, propertyNames)

        // Get Features and Collect Country Names
        SimpleFeatureCollection features = source.getFeatures(query)
        def countryNames = []
        try (SimpleFeatureIterator iterator = features.features()) {
            while (iterator.hasNext()) {
                SimpleFeature feature = iterator.next()
                println "Feature: ${feature}"
                println "Feature Attribute CNTRY_NAME: ${feature.getAttribute("CNTRY_NAME")}"

                countryNames << feature.getAttribute("CNTRY_NAME")
            }
        }

        return countryNames
    }
}
