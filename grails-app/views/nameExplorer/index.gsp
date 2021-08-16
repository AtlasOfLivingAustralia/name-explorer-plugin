<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="${grailsApplication.config.skin.layout}"/>
    <title>Name Index Explorer</title>
    <asset:stylesheet src="explorer.css"/>
</head>

<body>
<div class="${grailsApplication.config.skin.fluidLayout.toBoolean() ? 'container-fluid' : 'container'}" role="main">
    <header>
        <h1><g:message code="page.nameExplorer.index.title"/></h1>
    </header>

    <div class="row">
        <div id="name-query" class="col-md-8">
            <div class="panel panel-default">
                <div class="panel-heading"><h3 class="panel-title"><g:message code="page.label.name"/></h3></div>

                <div class="panel-body">
                    <g:form controller="nameExplorer">
                        <fieldset>
                            <div class="form-group row">
                                <label class="form-label col-sm-4 col-md-3" for="scientificName"><g:message
                                        code="page.label.scientificName"/><sup><span class="required glyphicon glyphicon-star" title="${message(code: 'page.label.required')}">&nbsp;</span></sup></label>

                                <div class="col-sm-4 col-md-5"><g:textField id="scientificName" name="scientificName"
                                                                            class="form-control col-sm-8 col-md-10"
                                                                            value="${source?.scientificName}"
                                                                            title="${message(code: 'page.label.scientificName.detail')}"
                                                                            placeholder="${message(code: 'page.label.scientificName.placeholder')}"/></div>

                                <div class="col-sm-4 col-md-4">
                                    <ne:nameLink name="${result?.scientificName}" id="${result?.taxonConceptID}"/>
                                    <g:if test="${result && !result.success}"><g:message code="page.message.notFound"/></g:if>
                                </div>
                            </div>

                            <div class="form-group row">
                                <label class="form-label col-sm-4 col-md-3" for="scientificNameAuthorship"><g:message
                                        code="page.label.scientificNameAuthorship"/></label>

                                <div class="col-sm-4 col-md-5"><g:textField id="scientificNameAuthorship" name="scientificNameAuthorshipp"
                                                                            class="form-control col-sm-8 col-md-10"
                                                                            value="${source?.scientificNameAuthorship}"
                                                                            title="${message(code: 'page.label.scientificNameAuthorship.detail')}"
                                                                            placeholder="${message(code: 'page.label.scientificNameAuthorship.placeholder')}"/></div>

                                <div class="col-sm-4 col-md-4">${result?.scientificNameAuthorship}</div>
                            </div>

                            <div class="form-group row">
                                <label class="form-label col-sm-4 col-md-3" for="kingdom"><g:message
                                        code="page.label.kingdom"/></label>

                                <div class="col-sm-4 col-md-5"><g:textField id="kingdom" name="kingdom"
                                                                            class="form-control col-sm-8 col-md-10"
                                                                            value="${source?.kingdom}"
                                                                            placeholder="${g.message(code: 'page.label.kingdom.placeholder')}"/></div>

                                <div class="col-sm-4 col-md-4"><ne:nameLink name="${result?.kingdom}"
                                                                            id="${result?.kingdomID}"/></div>
                            </div>

                            <div class="form-group row">
                                <label class="form-label col-sm-4 col-md-3" for="phylum"><g:message
                                        code="page.label.phylum"/></label>

                                <div class="col-sm-4 col-md-5"><g:textField id="phylum" name="phylum"
                                                                            class="form-control col-sm-8 col-md-10"
                                                                            value="${source?.phylum}"
                                                                            placeholder="${g.message(code: 'page.label.phylum.placeholder')}"/></div>

                                <div class="col-sm-4 col-md-4"><ne:nameLink name="${result?.phylum}" id="${result?.phylumID}"/></div>
                            </div>

                            <div class="form-group row">
                                <label class="form-label col-sm-4 col-md-3" for="clazz"><g:message
                                        code="page.label.class"/></label>

                                <div class="col-sm-4 col-md-5"><g:textField id="clazz" name="clazz"
                                                                            class="form-control col-sm-8 col-md-10"
                                                                            value="${source?.clazz}"
                                                                            placeholder="${g.message(code: 'page.label.class.placeholder')}"/></div>

                                <div class="col-sm-4 col-md-4"><ne:nameLink name="${result?.classs}" id="${result?.classID}"/></div>
                            </div>

                            <div class="form-group row">
                                <label class="form-label col-sm-4 col-md-3" for="order"><g:message
                                        code="page.label.order"/></label>

                                <div class="col-sm-4 col-md-5"><g:textField id="order" name="order"
                                                                            class="form-control col-sm-8 col-md-10"
                                                                            value="${source?.order}"
                                                                            placeholder="${g.message(code: 'page.label.order.placeholder')}"/></div>

                                <div class="col-sm-4 col-md-4"><ne:nameLink name="${result?.order}" id="${result?.orderID}"/></div>
                            </div>

                            <div class="form-group row">
                                <label class="form-label col-sm-4 col-md-3" for="family"><g:message
                                        code="page.label.family"/></label>

                                <div class="col-sm-4 col-md-5"><g:textField id="family" name="family"
                                                                            class="form-control col-sm-8 col-md-10"
                                                                            value="${source?.family}"
                                                                            placeholder="${g.message(code: 'page.label.family.placeholder')}"/></div>

                                <div class="col-sm-4 col-md-4"><ne:nameLink name="${result?.family}" id="${result?.familyID}"/></div>
                            </div>

                            <div class="form-group row">
                                <label class="form-label col-sm-4 col-md-3" for="genus"><g:message
                                        code="page.label.genus"/></label>

                                <div class="col-sm-4 col-md-5"><g:textField id="genus" name="genus"
                                                                            class="form-control col-sm-8 col-md-10"
                                                                            value="${source?.genus}"
                                                                            placeholder="${g.message(code: 'page.label.genus.placeholder')}"/></div>

                                <div class="col-sm-4 col-md-4"><ne:nameLink name="${result?.genus}" id="${result?.genusID}"/></div>
                            </div>

                            <div class="form-group row">
                                <label class="form-label col-sm-4 col-md-3" for="rank"><g:message
                                        code="page.label.rank"/></label>

                                <div class="col-sm-4 col-md-5"><g:textField id="rank" name="rank"
                                                                            class="form-control col-sm-8 col-md-10"
                                                                            value="${source?.rank}"
                                                                            placeholder="${g.message(code: 'page.label.rank.placeholder')}"/></div>

                                <div class="col-sm-4 col-md-4"><g:fieldValue bean="${result}"
                                                                             field="rank"/></div>
                            </div>
                        </fieldset>
                        <fieldset>
                            <div class="form-submit">
                                <g:actionSubmit class="btn btn-primary" action="index"
                                                value="${message(code: 'page.label.check')}"/>
                            </div>
                        </fieldset>
                    </g:form>
                </div>
            </div>
        </div>

        <div id="metrics" class="col-md-4">
            <g:if test="${result}">
                <div class="panel panel-default">
                    <div class="panel-heading"><h3 class="panel-title"><g:message code="page.label.metrics"/></h3></div>

                    <div class="panel-body">
                        <div class="row">
                            <div class="col-md-4"><label><g:message code="page.label.nameType"/></label></div>

                            <div class="col-md-8">${result?.nameType}</div>
                        </div>

                        <div class="row">
                            <div class="col-md-4"><label><g:message code="page.label.matchType"/></label></div>

                            <div class="col-md-8">${result?.matchType}</div>
                        </div>
                        <div class="row">
                            <div class="col-md-4"><label><g:message code="page.label.synonymType"/></label></div>

                            <div class="col-md-8">${result?.synonymType}</div>
                        </div>
                        <div class="row">
                            <div class="col-md-4"><label><g:message code="page.label.left"/></label></div>

                            <div class="col-md-8 issues">${result?.lft}</div>
                        </div>
                        <div class="row">
                            <div class="col-md-4"><label><g:message code="page.label.right"/></label></div>

                            <div class="col-md-8 issues">${result?.rgt}</div>
                        </div>
                        <div class="row">
                            <div class="col-md-4"><label><g:message code="page.label.notes"/></label></div>

                            <div class="col-md-8 issues">${issues}</div>
                        </div>
                    </div>
                </div>
            </g:if>
        </div>
    </div>
</div>
</body>
</html>
