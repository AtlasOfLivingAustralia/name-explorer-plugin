package au.org.ala.names.explorer


import au.org.ala.names.ws.api.NameSearch
import au.org.ala.names.ws.api.NameUsageMatch
import org.apache.commons.lang.StringUtils

class NameExplorerController {
    def nameExplorerService

    def index() {
        NameSearch.NameSearchBuilder builder = new NameSearch.NameSearchBuilder()
        NameSearch source
        NameUsageMatch result = null
        String issues = ""

        builder.kingdom = StringUtils.trimToNull(params.kingdom)
        builder.phylum = StringUtils.trimToNull(params.phylum)
        builder.clazz = StringUtils.trimToNull(params.klass)
        builder.order = StringUtils.trimToNull(params.order)
        builder.family = StringUtils.trimToNull(params.family)
        builder.genus = StringUtils.trimToNull(params.genus)
        builder.specificEpithet = StringUtils.trimToNull(params.specificEpithet) // Not in form, scince it doesn't appear to be used
        builder.infraspecificEpithet = StringUtils.trimToNull(params.infraspecificEpithet) // Not in form, scince it doesn't appear to be used
        builder.scientificName = StringUtils.trimToNull(params.scientificName)
        builder.scientificNameAuthorship = StringUtils.trimToNull(params.authorship)
        builder.rank = StringUtils.trimToNull(params.rank)
        source = builder.build()
        if (builder.scientificName) {
            result = nameExplorerService.find(source)
            issues = result?.issues?.join(', ')
        }
        render(view: "index", model: [source: source, result: result, issues: issues])
    }
}
