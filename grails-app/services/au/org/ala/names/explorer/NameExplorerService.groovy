package au.org.ala.names.explorer

import au.org.ala.names.model.LinnaeanRankClassification
import au.org.ala.names.model.MetricsResultDTO
import au.org.ala.names.search.ALANameSearcher
import au.org.ala.names.util.TaxonNameSoundEx
import grails.config.Config
import grails.core.support.GrailsConfigurationAware
import org.gbif.api.model.checklistbank.ParsedName
import org.gbif.nameparser.PhraseNameParser

class NameExplorerService implements GrailsConfigurationAware {
    private ALANameSearcher searcher;

    @Override
    void setConfiguration(Config config) {
        this.searcher = new ALANameSearcher(config.getProperty("explorer.index"))
    }

    MetricsResultDTO find(LinnaeanRankClassification cl) {
        MetricsResultDTO results = searcher.searchForRecordMetrics(cl, true, true)
        if (results.result?.isSynonym()) {
            def ansr = searcher.searchForRecordByLsid(results.result.acceptedLsid)
            if(ansr != null) {
                ansr.setMatchType(results.result.matchType)
                ansr.synonymType = results.result.synonymType
                results.setResult(ansr)
            }
        }
        return results
    }

    def soundex(String name) {
        try {
            PhraseNameParser parser = new PhraseNameParser()
            ParsedName pn = parser.parse(name)
            String genus = TaxonNameSoundEx.treatWord(pn.genusOrAbove, "genus")
            String species = pn.isBinomial() ? TaxonNameSoundEx.treatWord(pn.specificEpithet, "species") : null
            return [genus: genus, species: species]
        } catch (Exception ex) { // Usuablly a name parsing error but who cares
            return [:]
        }
    }
}
