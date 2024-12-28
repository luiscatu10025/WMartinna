<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html"/>
    <xsl:template match="/">
        <html>
            <header>
                <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"></link>
            </header>
            <body>
                <div class="container">
                <h2>Retención: <xsl:value-of select="comprobanteRetencion/infoTributaria/estab"/>-
                    <xsl:value-of select="comprobanteRetencion/infoTributaria/ptoEmi"/>-
                    <xsl:value-of select="comprobanteRetencion/infoTributaria/secuencial"/>
                </h2>
                <h2>
                    <xsl:value-of select="comprobanteRetencion/infoTributaria/nombreComercial"/>
                </h2>
                <table>
                    <tr>
                        <td>Razon Social: </td>
                        <td>
                            <xsl:value-of select="comprobanteRetencion/infoTributaria/razonSocial"/>
                        </td>
                    </tr>
                    <tr>
                        <td>Ruc: </td>
                        <td>
                            <xsl:value-of select="comprobanteRetencion/infoTributaria/ruc"/>
                        </td>
                    </tr>
                    <tr>
                        <td>Autorización: </td>
                        <td>
                            <xsl:value-of select="comprobanteRetencion/infoTributaria/claveAcceso"/>
                        </td>
                    </tr>
                    
                </table>
                <br/>
                <table>
                    <tr>
                        <td>Fecha Emision: </td>
                        <td>
                            <xsl:value-of select="comprobanteRetencion/infoCompRetencion/fechaEmision"/>
                        </td>
                    </tr>
                    <tr>
                        <td>Direccion Establecimiento: </td>
                        <td>
                            <xsl:value-of select="comprobanteRetencion/infoCompRetencion/dirEstablecimiento"/>
                        </td>
                    </tr>
                    <tr>
                        <td>Contribuyente Especial: </td>
                        <td>
                            <xsl:value-of select="comprobanteRetencion/infoCompRetencion/contribuyenteEspecial"/>
                        </td>
                    </tr>
                    <tr>
                        <td>Obligado Contabilidad: </td>
                        <td>
                            <xsl:value-of select="comprobanteRetencion/infoCompRetencion/obligadoContabilidad"/>
                        </td>
                    </tr>
                    <tr>
                        <td>Tipo Identificacion Sujeto Retenido: </td>
                        <td>
                            <xsl:value-of select="comprobanteRetencion/infoCompRetencion/tipoIdentificacionSujetoRetenido"/>
                        </td>
                    </tr>
                    <tr>
                        <td>Razon Social Sujeto Retenido: </td>
                        <td>
                            <xsl:value-of select="comprobanteRetencion/infoCompRetencion/razonSocialSujetoRetenido"/>
                        </td>
                    </tr>
                    <tr>
                        <td>Identificacion Sujeto Retenido: </td>
                        <td>
                            <xsl:value-of select="comprobanteRetencion/infoCompRetencion/identificacionSujetoRetenido"/>
                        </td>
                    </tr>
                    <tr>
                        <td>Periodo Fiscal </td>
                        <td>
                            <xsl:value-of select="comprobanteRetencion/infoCompRetencion/periodoFiscal"/>
                        </td>
                    </tr>
                    
                        
                </table>
                <table class="table table-bordered">
                    <tr>
                        <th align="left">Codigo </th>
                        <th align="left">Codigo Retencion</th>
                        <th align="left">Base Imponible</th>
                        <th align="left">Porcentaje Retener</th>
                        <th align="left">Valor Retenido</th>
                        <th align="left">Cod. Doc. Sustento</th>
                        <th align="left">Num. Doc. Sustento</th>
                        <th align="left">Fecha Emision Doc. Sustento</th>
                    </tr>
                    <xsl:for-each select="comprobanteRetencion/impuestos/impuesto">
                        <tr>
                            <td>
                                <xsl:value-of select="codigo"/>
                            </td>
                            <td>
                                <xsl:value-of select="codigoRetencion"/>
                            </td>
                            <td>
                                <xsl:value-of select="baseImponible"/>
                            </td>
                            <td>
                                <xsl:value-of select="porcentajeRetener"/>
                            </td>
                            <td>
                                <xsl:value-of select="valorRetenido"/>
                            </td>
                            <td>
                                <xsl:value-of select="codDocSustento"/>
                            </td>
                            <td>
                                <xsl:value-of select="numDocSustento"/>
                            </td>
                            <td>
                                <xsl:value-of select="fechaEmisionDocSustento"/>
                            </td>
                            
                        </tr>
                    </xsl:for-each>
                </table>
                
                </div>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>

