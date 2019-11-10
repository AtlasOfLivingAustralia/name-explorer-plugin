<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="${grailsApplication.config.skin.layout}"/>
    <title>Name Index Explorer</title>
</head>

<body>
<div class="${grailsApplication.config.skin.fluidLayout.toBoolean() ? 'container-fluid' : 'container'}" role="main">
    <header>
        <h1><g:message code="page.nameExplorer.index.title"/></h1>
    </header>

    <g:set var="cl" value="${result?.result?.rankClassification}"/>
    <div class="row">
        <div id="name-query" class="col-md-8">
            <div class="panel panel-default">
                <div class="panel-heading"><h3 class="panel-title"><g:message code="page.label.name"/></h3></div>

                <div class="panel-body">
                    <g:form controller="nameExplorer">
                        <fieldset>
                            <div class="form-group row">
                                <label class="form-label col-sm-4 col-md-2" for="scientificName"><g:message
                                        code="page.label.scientificName"/></label>

                                <div class="col-sm-4 col-md-4"><g:textField id="scientificName" name="scientificName"
                                                                            class="form-control col-sm-8 col-md-10"
                                                                            value="${source?.scientificName}"
                                                                            title="${message(code: 'page.label.scientificName.detail')}"
                                                                            placeholder="${message(code: 'page.label.scientificName.placeholder')}"/></div>

                                <div class="col-sm-4 col-md-6"><ne:nameLink name="${cl?.scientificName}"
                                                                            id="${result?.result?.lsid}"/></div>
                            </div>

                            <div class="form-group row">
                                <label class="form-label col-sm-4 col-md-2" for="authorship"><g:message
                                        code="page.label.authorship"/></label>

                                <div class="col-sm-4 col-md-4"><g:textField id="authorship" name="authorship"
                                                                            class="form-control col-sm-8 col-md-10"
                                                                            value="${source?.authorship}"
                                                                            title="${message(code: 'page.label.authorship.detail')}"
                                                                            placeholder="${message(code: 'page.label.authorship.placeholder')}"/></div>

                                <div class="col-sm-4 col-md-6">${cl?.authorship}</div>
                            </div>

                            <div class="form-group row">
                                <label class="form-label col-sm-4 col-md-2" for="kingdom"><g:message
                                        code="page.label.kingdom"/></label>

                                <div class="col-sm-4 col-md-4"><g:textField id="kingdom" name="kingdom"
                                                                            class="form-control col-sm-8 col-md-10"
                                                                            value="${source?.kingdom}"
                                                                            placeholder="${g.message(code: 'page.label.kingdom.placeholder')}"/></div>

                                <div class="col-sm-4 col-md-6"><ne:nameLink name="${cl?.kingdom}"
                                                                            id="${cl?.kid}"/></div>
                            </div>

                            <div class="form-group row">
                                <label class="form-label col-sm-4 col-md-2" for="phylum"><g:message
                                        code="page.label.phylum"/></label>

                                <div class="col-sm-4 col-md-4"><g:textField id="phylum" name="phylum"
                                                                            class="form-control col-sm-8 col-md-10"
                                                                            value="${source?.phylum}"
                                                                            placeholder="${g.message(code: 'page.label.phylum.placeholder')}"/></div>

                                <div class="col-sm-4 col-md-6"><ne:nameLink name="${cl?.phylum}" id="${cl?.pid}"/></div>
                            </div>

                            <div class="form-group row">
                                <label class="form-label col-sm-4 col-md-2" for="klass"><g:message
                                        code="page.label.class"/></label>

                                <div class="col-sm-4 col-md-4"><g:textField id="klass" name="klass"
                                                                            class="form-control col-sm-8 col-md-10"
                                                                            value="${source?.klass}"
                                                                            placeholder="${g.message(code: 'page.label.class.placeholder')}"/></div>

                                <div class="col-sm-4 col-md-6"><ne:nameLink name="${cl?.klass}" id="${cl?.cid}"/></div>
                            </div>

                            <div class="form-group row">
                                <label class="form-label col-sm-4 col-md-2" for="order"><g:message
                                        code="page.label.order"/></label>

                                <div class="col-sm-4 col-md-4"><g:textField id="order" name="order"
                                                                            class="form-control col-sm-8 col-md-10"
                                                                            value="${source?.order}"
                                                                            placeholder="${g.message(code: 'page.label.order.placeholder')}"/></div>

                                <div class="col-sm-4 col-md-6"><ne:nameLink name="${cl?.order}" id="${cl?.oid}"/></div>
                            </div>

                            <div class="form-group row">
                                <label class="form-label col-sm-4 col-md-2" for="family"><g:message
                                        code="page.label.family"/></label>

                                <div class="col-sm-4 col-md-4"><g:textField id="family" name="family"
                                                                            class="form-control col-sm-8 col-md-10"
                                                                            value="${source?.family}"
                                                                            placeholder="${g.message(code: 'page.label.family.placeholder')}"/></div>

                                <div class="col-sm-4 col-md-6"><ne:nameLink name="${cl?.family}" id="${cl?.fid}"/></div>
                            </div>

                            <div class="form-group row">
                                <label class="form-label col-sm-4 col-md-2" for="genus"><g:message
                                        code="page.label.genus"/></label>

                                <div class="col-sm-4 col-md-4"><g:textField id="genus" name="genus"
                                                                            class="form-control col-sm-8 col-md-10"
                                                                            value="${source?.genus}"
                                                                            placeholder="${g.message(code: 'page.label.genus.placeholder')}"/></div>

                                <div class="col-sm-4 col-md-6"><ne:nameLink name="${cl?.genus}" id="${cl?.gid}"/></div>
                            </div>

                            <div class="form-group row">
                                <label class="form-label col-sm-4 col-md-2" for="rank"><g:message
                                        code="page.label.rank"/></label>

                                <div class="col-sm-4 col-md-4"><g:textField id="rank" name="rank"
                                                                            class="form-control col-sm-8 col-md-10"
                                                                            value="${source?.rank}"
                                                                            placeholder="${g.message(code: 'page.label.rank.placeholder')}"/></div>

                                <div class="col-sm-4 col-md-6"><g:fieldValue bean="${result?.result}"
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

                            <div class="col-md-8">${result.result?.matchType}</div>
                        </div>

                        <div class="row">
                            <div class="col-md-4"><label><g:message code="page.label.errors"/></label></div>

                            <div class="col-md-8">${matchErrors}</div>
                        </div>

                        <div class="row">
                            <div class="col-md-4"><label><g:message code="page.label.synonymType"/></label></div>

                            <div class="col-md-8">${result?.result?.synonymType}</div>
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
