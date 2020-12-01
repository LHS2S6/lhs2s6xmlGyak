<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <body>
                <table>
                    <th>Tipus</th>
                    <th>Darab</th>

                    <xsl:for-each select="autok/auto">
                        <xsl:sort select="count(group-by='tipus')" order="descending"/>
                        <tr>
                            <td>
                                <xsl:value-of select="tipus" />
                            </td>
                            <td>
                                <xsl:value-of select="count(group-by='tipus')" />
                            </td>
                        </tr>
                    </xsl:for-each>

                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>