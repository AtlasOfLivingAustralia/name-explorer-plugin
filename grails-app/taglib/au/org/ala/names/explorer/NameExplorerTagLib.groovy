package au.org.ala.names.explorer

import grails.config.Config
import grails.core.support.GrailsConfigurationAware

class NameExplorerTagLib implements GrailsConfigurationAware {
    static defaultEncodeAs = [taglib:'raw']
    static namespace = 'ne'

    private String bieBaseUrl

    @Override
    void setConfiguration(Config config) {
        this.bieBaseUrl = config.getProperty("bie.baseURL")
    }

    def nameLink = { attrs ->
        def name = attrs.name
        def id = attrs.id

        if (id)
            out << "<a href=\"${this.bieBaseUrl}/species/${id}\">${name}</a>"
        else
            out << name
    }
}
