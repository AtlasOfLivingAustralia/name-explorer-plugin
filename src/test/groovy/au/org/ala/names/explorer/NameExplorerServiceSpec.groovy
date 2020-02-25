package au.org.ala.names.explorer

import au.org.ala.names.model.ErrorType
import au.org.ala.names.model.LinnaeanRankClassification
import au.org.ala.names.model.MatchType
import grails.test.mixin.TestFor
import org.gbif.api.vocabulary.NameType
import org.yaml.snakeyaml.Yaml
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

    void "test soundex 1"() {
        when:
        def soundex = service.soundex("Acacia")
        then:
        soundex.genus == "ACACA"
        soundex.species == null
    }

    void "test soundex 2"() {
        when:
        def soundex = service.soundex("Osphranter rufus")
        then:
        soundex.genus == "OSPRANTIR"
        soundex.species == "RIFA"
    }

    void "test find 1"() {
        when:
        def source = new LinnaeanRankClassification()
        source.scientificName = "Osphranter rufus"
        then:
        def result = service.find(source)
        result != null
        result.nameType == NameType.SCIENTIFIC
        result.errors != null
        result.errors.contains(ErrorType.NONE)
        result.result != null
        result.result.matchType == MatchType.EXACT
        result.result.lsid == 'urn:lsid:biodiversity.org.au:afd.taxon:e6aff6af-ff36-4ad5-95f2-2dfdcca8caff'
    }

    void "test find 2"() {
        when:
        def source = new LinnaeanRankClassification()
        source.scientificName = "Acacia"
        then:
        def result = service.find(source)
        result != null
        result.nameType == NameType.SCIENTIFIC
        result.errors != null
        result.errors.contains(ErrorType.NONE)
        result.result != null
        result.result.matchType == MatchType.EXACT
        result.result.lsid == 'https://id.biodiversity.org.au/taxon/apni/51311124'
    }

    void "test find 3"() {
        when:
        def source = new LinnaeanRankClassification()
        source.scientificName = "Macropus"
        then:
        def result = service.find(source)
        result != null
        result.nameType == NameType.SCIENTIFIC
        result.errors != null
        result.errors.contains(ErrorType.HOMONYM)
        result.result == null
    }
}
