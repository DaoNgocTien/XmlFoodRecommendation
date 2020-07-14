<?xml version="1.0" encoding="UTF-8"?>

<!--
    Document   : material.xsl
    Created on : July 9, 2020, 8:34 AM
    Author     : Admin
    Description:
        Purpose of transformation follows.
-->

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="xml" indent="yes" version="1.0"/>

    <!-- TODO customize transformation rules 
         syntax recommendation http://www.w3.org/TR/xslt 
    -->
    <xsl:template match="/">
        <materials xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
                   xmlns="http://xml.netbeans.org/schema/materials"
                   xsi:schemaLocation="http://xml.netbeans.org/schema/materials material.xsd">
            <xsl:for-each select="tbody/tr">
                <material>
                    <foodname>
                        <xsl:value-of select="td[1]"/>
                    </foodname>
                    <carbonhydrate>
                        <xsl:value-of select="td[2]"/>
                    </carbonhydrate>
                    <fiber>
                        <xsl:value-of select="td[3]"/>
                    </fiber>
                    <fat>
                        <xsl:value-of select="td[4]"/>
                    </fat>
                    <protein>
                        <xsl:value-of select="td[5]"/>
                    </protein>
                    <calories>
                        <xsl:value-of select="td[6]"/>
                    </calories>
                </material>
            </xsl:for-each>
        </materials>
    </xsl:template>

</xsl:stylesheet>
