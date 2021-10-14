package au.org.ala.names.explorer


import au.org.ala.names.ws.api.NameSearch
import grails.test.mixin.TestFor
import org.yaml.snakeyaml.Yaml
import spock.lang.Ignore
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 *
 * Note that this expects the 20190213 name matching library
 */
@TestFor(NameExplorerService)
class NameExplorerServiceSpec extends Specification {

    def setup() {
        def config = new Yaml().load(this.class.getResourceAsStream('test.yml'))
        grailsApplication.config.merge(config)
        service.setConfiguration(grailsApplication.config)
    }

    def cleanup() {
    }

    @Ignore // Redo when soundex reintroduced
    void "test soundex 1"() {
        when:
        def soundex = service.soundex("Acacia")
        then:
        soundex.genus == "ACACA"
        soundex.species == null
    }

    @Ignore
    void "test soundex 2"() {
        when:
        def soundex = service.soundex("Osphranter rufus")
        then:
        soundex.genus == "OSPRANTIR"
        soundex.species == "RIFA"
    }

    void "test find 1"() {
        when:
        def source = new NameSearch.NameSearchBuilder()
        source.scientificName = "Osphranter rufus"
        then:
        def result = service.find(source.build())
        result != null
        result.nameType == "SCIENTIFIC"
        result.issues != null
        result.issues.contains("noIssue")
        result.matchType == "exactMatch"
        result.taxonConceptID == 'urn:lsid:biodiversity.org.au:afd.taxon:e6aff6af-ff36-4ad5-95f2-2dfdcca8caff'
    }

    void "test find 2"() {
        when:
        def source = new NameSearch.NameSearchBuilder()
        source.scientificName = "Acacia"
        then:
        def result = service.find(source.build())
        result != null
        result.nameType == "SCIENTIFIC"
        result.issues != null
        result.issues.contains("noIssue")
        result.matchType == "exactMatch"
        result.taxonConceptID == 'https://id.biodiversity.org.au/taxon/apni/51311124'
    }

    void "test find 3"() {
        when:
        def source = new NameSearch.NameSearchBuilder()
        source.scientificName = "Macropus"
        then:
        def result = service.find(source.build())
        result != null
        result.nameType == "SCIENTIFIC"
        result.issues != null
        result.issues.contains("homonym")
        result.success == false
    }
}
