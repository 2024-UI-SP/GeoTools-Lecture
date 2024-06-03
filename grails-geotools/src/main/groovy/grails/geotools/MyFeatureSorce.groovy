package grails.geotools

// For working with files
import java.io.File
import java.net.URL

// For making the data store and source 
import org.geotools.api.data.FileDataStore
import org.geotools.api.data.FileDataStoreFinder
import org.geotools.api.data.SimpleFeatureSource

/*
 * A bean generating a SimpleFeatureSource from a shapefile.
 * See conf/spring/resources.groovy for registrating.
 * See BootStrap.groovy and CountryController for use.
 */
class MyFeatureSource {
    private String shapefileName
    private SimpleFeatureSource source

    MyFeatureSource(String shapefileName) {
        this.shapefileName = shapefileName  
        println "\n"     
        println "In MyFeatureSource constructor"

        // Make File
        URL url = MyFeatureSource.class.getResource("shapefiles/${shapefileName}")
        File file = new File(url.toURI())
        println("File: " + file)

        // Make DataStore
        FileDataStore store = FileDataStoreFinder.getDataStore(file)
        println("Type Names: " + store.getTypeNames())
        source = store.getFeatureSource()
    }

    // Just for development
    void printHi() {
        println "\n"
        println "Hi from MyFeatureSource!"
        println "MyFeatureSource shapefileName: ${shapefileName}"
    }

    SimpleFeatureSource getSource() {
        return source
    }
}
