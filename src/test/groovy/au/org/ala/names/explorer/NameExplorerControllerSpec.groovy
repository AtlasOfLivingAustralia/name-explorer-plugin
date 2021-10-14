package au.org.ala.names.explorer

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
        def rc = model.result
        rc.scientificName == "Acacia"
        rc.kingdom == "Plantae"
        rc.taxonConceptID == "https://id.biodiversity.org.au/taxon/apni/51311124"
        //model.soundex != null
        //model.soundex.genus == "ACACA"
        model.issues == "noIssue"
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
        def rc = model.result
        rc.scientificName == "Osphranter rufus"
        rc.kingdom == "Animalia"
        rc.genus == "Osphranter"
        rc.taxonConceptID == "urn:lsid:biodiversity.org.au:afd.taxon:e6aff6af-ff36-4ad5-95f2-2dfdcca8caff"
        //model.soundex != null
        //model.soundex.genus == "OSPRANTIR"
        model.issues == "noIssue"
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
        model.issues == "homonym"
    }
}
