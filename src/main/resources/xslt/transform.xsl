<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:xs="http://www.w3.org/2001/XMLSchema"
	xmlns:fn="http://www.w3.org/2005/xpath-functions" xmlns:xdt="http://www.w3.org/2005/xpath-datatypes"
	xmlns:err="http://www.w3.org/2005/xqt-errors" exclude-result-prefixes="xs xdt err fn">

	<xsl:output method="xml" indent="yes" omit-xml-declaration="yes" />

	<xsl:template match="/">
		<ns2:person xmlns:ns2="http://www.redhat.com/empowered/businessService">
			<id>
 				<xsl:value-of select="/*:queryPerson/*:id" />
			</id>
			<name>John Doe</name>
			<xsl:variable name="curtm" select="xs:string(fn:current-dateTime())" />
			<xsl:variable name="ttime" select="fn:current-dateTime()" />
			<age>
				<xsl:value-of select="fn:substring-before(xs:string(fn:seconds-from-dateTime($ttime)),'.')" />
			</age>
		</ns2:person>
	</xsl:template>
</xsl:stylesheet>