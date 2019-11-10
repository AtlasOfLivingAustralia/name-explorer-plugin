package au.org.ala.names.explorer

import grails.test.mixin.TestFor
import org.yaml.snakeyaml.Yaml
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.GroovyPageUnitTestMixin} for usage instructions
 */
@TestFor(NameExplorerTagLib)
class NameExplorerTagLibSpec extends Specification {

    def setup() {
        def config = new Yaml().load(this.class.getResourceAsStream('test.yml'))
        grailsApplication.config.merge(config)
        tagLib.setConfiguration(grailsApplication.config)
    }

    def cleanup() {
    }

    void "test no link 1"() {
        expect:
        applyTemplate('<ne:nameLink name="Acacia"/>') == 'Acacia'
    }

    void "test no link 2"() {
        expect:
        applyTemplate('<ne:nameLink name="Osphranter rufus"/>') == 'Osphranter rufus'
    }

    void "test link 1"() {
        expect:
        applyTemplate('<ne:nameLink name="Acacia" id="http://id.biodiversity.org.au/node/apni/6719673"/>') == '<a href="https://bie-test.ala.org.au/species/http://id.biodiversity.org.au/node/apni/6719673">Acacia</a>'
    }

    void "test link 2"() {
        expect:
        applyTemplate('<ne:nameLink name="Osphranter rufus" id="urn:lsid:biodiversity.org.au:afd.taxon:e6aff6af-ff36-4ad5-95f2-2dfdcca8caff"/>') == '<a href="https://bie-test.ala.org.au/species/urn:lsid:biodiversity.org.au:afd.taxon:e6aff6af-ff36-4ad5-95f2-2dfdcca8caff">Osphranter rufus</a>'
    }

}
