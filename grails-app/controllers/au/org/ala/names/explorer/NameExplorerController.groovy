package au.org.ala.names.explorer

import au.org.ala.names.model.LinnaeanRankClassification
import au.org.ala.names.model.MetricsResultDTO
import org.apache.commons.lang.StringUtils

class NameExplorerController {
    def nameExplorerService

    def index() {
        LinnaeanRankClassification source = new LinnaeanRankClassification();
        MetricsResultDTO result = null
        String errors = "", issues = ""
        def soundex;

        source.kingdom = StringUtils.trimToNull(params.kingdom)
        source.phylum = StringUtils.trimToNull(params.phylum)
        source.klass = StringUtils.trimToNull(params.klass)
        source.order = StringUtils.trimToNull(params.order)
        source.family = StringUtils.trimToNull(params.family)
        source.genus = StringUtils.trimToNull(params.genus)
        source.species = StringUtils.trimToNull(params.species)
        source.infraspecificEpithet = StringUtils.trimToNull(params.infraspecificEpithet)
        source.scientificName = StringUtils.trimToNull(params.scientificName)
        source.authorship = StringUtils.trimToNull(params.authorship)
        source.rank = StringUtils.trimToNull(params.rank)
        if (source.scientificName) {
            result = nameExplorerService.find(new LinnaeanRankClassification(source))
            errors = result?.errors?.inject("", { acc, val -> acc + (acc.isEmpty() ? "" : ", ") + val.name()})
            issues = result.lastException?.message ?: ""
            soundex = nameExplorerService.soundex(source.scientificName)
        }
        render(view: "index", model: [source: source, result: result, soundex: soundex, matchErrors: errors, issues: issues])
    }
}
