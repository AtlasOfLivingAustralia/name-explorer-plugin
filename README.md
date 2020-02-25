# Name Explorer Plugin [![Build Status](https://travis-ci.org/AtlasOfLivingAustralia/name-explorer-plugin.svg?branch=master)](https://travis-ci.org/AtlasOfLivingAustralia/name-explorer-plugin)

A plugin that can be used to provide a user interface to the underlying
ALA name matching system.
This is useful if you want to find out why certain combinations of
names are or are not working and what taxon they match.

## Inclusion

To include it in a grails project, use `compile 'au.org.ala.plugins.grails:name-explorer-plugin:version` in the `gradle.build`

The plugin expects a `ala-name-matching` implementation, so  include something like

```
compile('au.org.ala:ala-name-matching:3.4') {
  exclude group: 'org.apache.bval', module: 'org.apache.bval.bundle'
  exclude group: 'org.slf4j', module: 'slf4j-log4j12'
}
```
     
as well.
You'll need to exclude the slf4j-logj12 to allow grails to use logback.                              

## Usage

To get the name explorer, go to `/nameExplorer` on the application of
your choice.

## Configuration

* `bie.baseURL` The URL of the BIE system for lookup links to matched taxa. Defaults to `https://bie.ala.org.au`
* `explorer.index` The name index to use. Defaults to `/data/lucene/namematching`