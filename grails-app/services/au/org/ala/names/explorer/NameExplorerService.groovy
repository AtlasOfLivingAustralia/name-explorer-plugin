package au.org.ala.names.explorer

import au.org.ala.names.ws.api.NameMatchService
import au.org.ala.names.ws.api.NameSearch
import au.org.ala.names.ws.api.NameUsageMatch
import au.org.ala.names.ws.client.ALANameUsageMatchServiceClient
import au.org.ala.ws.ClientConfiguration
import grails.config.Config
import grails.core.support.GrailsConfigurationAware

class NameExplorerService implements GrailsConfigurationAware {
    private NameMatchService nameMatchService

    @Override
    void setConfiguration(Config config) {
        URL service = new URL(config.getProperty("namematching.serviceURL"))
        ClientConfiguration cc = ClientConfiguration.builder().baseUrl(service).build()
        this.nameMatchService = new ALANameUsageMatchServiceClient(cc)
    }

    NameUsageMatch find(NameSearch search) {
        return this.nameMatchService.match(search)
    }
}
