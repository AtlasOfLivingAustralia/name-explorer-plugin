# Name Explorer Plugin [![Build Status](https://travis-ci.org/AtlasOfLivingAustralia/name-explorer-plugin.svg?branch=master)](https://travis-ci.org/AtlasOfLivingAustralia/name-explorer-plugin)

A plugin that can be used to provide a user interface to the underlying
ALA name matching system.
This is useful if you want to find out why certain combinations of
names are or are not working and what taxon they match.

## Usage

To get the name explorer, go to `/nameExplorer` on the application of
your choice.

## Configuration

* `bie.baseURL` The URL of the BIE system for lookup links to matched taxa. Defaults to `https://bie.ala.org.au`
* `explorer.index` The name index to use. Defaults to `/data/lucene/namematching`