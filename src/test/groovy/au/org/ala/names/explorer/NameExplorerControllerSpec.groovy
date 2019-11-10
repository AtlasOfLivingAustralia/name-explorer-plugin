package au.org.ala.names.explorer

import au.org.ala.names.model.ErrorType
import grails.test.mixin.TestFor
import org.yaml.snakeyaml.Yaml
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 *
 * Uses the 20190213 name index via a build service
 */
@TestFor(NameExplorerController)
class NameExplorerControllerSpec extends Specification {

    def setup() {
        def config = new Yaml().load(this.class.getResourceAsStream('test.yml'))
        grailsApplication.config.merge(config)
        def service = new NameExplorerService()
        service.setConfiguration(grailsApplication.config)
        controller.nameExplorerService = service
    }

    def cleanup() {
    }

    void "test index 1"() {
        when:
        params.scientificName = "Acacia"
        controller.index()
        then:
        model.source != null
        model.source.scientificName == "Acacia"
        model.source.kingdom == null
        model.result != null
        model.result.result != null
        model.result.result.rankClassification != null
        def rc = model.result.result.rankClassification
        rc.scientificName == "Acacia"
        rc.kingdom == "Plantae"
        model.result.result.lsid == "http://id.biodiversity.org.au/node/apni/6719673"
        model.soundex != null
        model.soundex.genus == "ACACA"
        model.matchErrors == "NONE"
        model.issues == ""
    }

    void "test index 2"() {
        when:
        params.scientificName = "Osphranter rufus"
        controller.index()
        then:
        model.source != null
        model.source.scientificName == "Osphranter rufus"
        model.source.kingdom == null
        model.source.genus == null
        model.result != null
        model.result.result != null
        model.result.result.rankClassification != null
        def rc = model.result.result.rankClassification
        rc.scientificName == "Osphranter rufus"
        rc.kingdom == "Animalia"
        rc.genus == "Osphranter"
        model.result.result.lsid == "urn:lsid:biodiversity.org.au:afd.taxon:e6aff6af-ff36-4ad5-95f2-2dfdcca8caff"
        model.soundex != null
        model.soundex.genus == "OSPRANTIR"
        model.matchErrors == "NONE"
        model.issues == ""
    }

    void "test index 3"() {
        when:
        params.scientificName = "Macropus"
        controller.index()
        then:
        model.source != null
        model.source.scientificName == "Macropus"
        model.source.kingdom == null
        model.result != null
        model.result.result == null
        model.matchErrors == "HOMONYM"
        model.issues.startsWith("Warning an unresolved homonym has been detected.")
    }
}
