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
                <h2>Nota de Crédito: <xsl:value-of select="notaCredito/infoTributaria/estab"/>-
                    <xsl:value-of select="notaCredito/infoTributaria/ptoEmi"/>-
                    <xsl:value-of select="notaCredito/infoTributaria/secuencial"/>
                </h2>
                <h2>
                    <xsl:value-of select="notaCredito/infoTributaria/nombreComercial"/>
                </h2>
                <table>
                    <tr>
                        <td>Razon Social: </td>
                        <td>
                            <xsl:value-of select="notaCredito/infoTributaria/razonSocial"/>
                        </td>
                    </tr>
                    <tr>
                        <td>Ruc: </td>
                        <td>
                            <xsl:value-of select="notaCredito/infoTributaria/ruc"/>
                        </td>
                    </tr>
                    <tr>
                        <td>Autorización: </td>
                        <td>
                            <xsl:value-of select="notaCredito/infoTributaria/claveAcceso"/>
                        </td>
                    </tr>
                    
                </table>
                <br/>
                <table>
                    <tr>
                        <td>Fecha Emision: </td>
                        <td>
                            <xsl:value-of select="notaCredito/infoNotaCredito/fechaEmision"/>
                        </td>
                    </tr>
                    <tr>
                        <td>Direccion Establecimiento: </td>
                        <td>
                            <xsl:value-of select="notaCredito/infoNotaCredito/dirEstablecimiento"/>
                        </td>
                    </tr>
                    <tr>
                        <td>Contribuyente Especial: </td>
                        <td>
                            <xsl:value-of select="notaCredito/infoNotaCredito/contribuyenteEspecial"/>
                        </td>
                    </tr>
                    <tr>
                        <td>Obligado Contabilidad: </td>
                        <td>
                            <xsl:value-of select="notaCredito/infoNotaCredito/obligadoContabilidad"/>
                        </td>
                    </tr>
                    <tr>
                        <td>Tipo Identificacion Comprador: </td>
                        <td>
                            <xsl:value-of select="notaCredito/infoNotaCredito/tipoIdentificacionComprador"/>
                        </td>
                    </tr>
                    <tr>
                        <td>Razon Social Comprador: </td>
                        <td>
                            <xsl:value-of select="notaCredito/infoNotaCredito/razonSocialComprador"/>
                        </td>
                    </tr>
                    <tr>
                        <td>Identificacion Comprador: </td>
                        <td>
                            <xsl:value-of select="notaCredito/infoNotaCredito/identificacionComprador"/>
                        </td>
                    </tr>
                    <tr>
                        <td>Motivo: </td>
                        <td>
                            <xsl:value-of select="notaCredito/infoNotaCredito/motivo"/>
                        </td>
                    </tr>
                    
                        
                </table>
                <table class="table table-bordered">
                    <tr>
                        <th align="left">Codigo Interno</th>
                        <th align="left">Codigo Adicional</th>
                        <th align="left">Descripcion</th>
                        <th align="left">Cantidad</th>
                        <th align="left">Precio Unitario</th>
                        <th align="left">Precio Total Sin Impuesto</th>
                        <th align="left">Impuesto</th>
                    </tr>
                    <xsl:for-each select="notaCredito/detalles/detalle">
                        <tr>
                            <td>
                                <xsl:value-of select="codigoInterno"/>
                            </td>
                            <td>
                                <xsl:value-of select="codigoAdicional"/>
                            </td>
                            <td>
                                <xsl:value-of select="descripcion"/>
                            </td>
                            <td>
                                <xsl:value-of select="cantidad"/>
                            </td>
                            <td>
                                <xsl:value-of select="precioUnitario"/>
                            </td>
                            <td>
                                <xsl:value-of select="precioTotalSinImpuesto"/>
                            </td>
                            <td>
                                <table border="1">
                                    <tr>
                                        <td>Codigo</td>
                                        <td>Codigo Porcentaje</td>
                                        <td>Tarifa</td>
                                        <td>Base Imponible</td> 
                                        <td>Valor</td> 
                                    </tr>
                                    <xsl:for-each select="impuestos/impuesto">
                                        <tr>
                                            <td>
                                                <xsl:value-of select="codigo"/>
                                            </td>
                                            <td>
                                                <xsl:value-of select="codigoPorcentaje"/>
                                            </td>
                                            <td>
                                                <xsl:value-of select="tarifa"/>
                                            </td>
                                            <td>
                                                <xsl:value-of select="baseImponible"/>
                                            </td>
                                            <td>
                                                <xsl:value-of select="valor"/>
                                            </td>
                                        </tr>
                                    </xsl:for-each>
                                    
                                </table>

                            </td>
                        </tr>
                    </xsl:for-each>
                </table>
                <table border="1">
                    <tr>
                        <td>Total Sin Impuestos: </td>
                        <td>
                            <xsl:value-of select="notaCredito/infoNotaCredito/totalSinImpuestos"/>
                        </td>
                    </tr>
                    <tr>
                        <td>Valor Modificacion: </td>
                        <td>
                            <xsl:value-of select="notaCredito/infoNotaCredito/valorModificacion"/>
                        </td>
                    </tr>
                    
                    <tr>                    
                        <td>Impuestos: </td>
                        <td>
                            <table border="1">
                                <xsl:for-each select="notaCredito/infoNotaCredito/totalConImpuestos/totalImpuesto">
                                    <tr>
                                        <td>Codigo</td>
                                        <td>
                                            <xsl:value-of select="codigo"/>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>Codigo Porcentaje</td>
                                        <td>
                                            <xsl:value-of select="codigoPorcentaje"/>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>Base Imponible</td>
                                        <td>
                                            <xsl:value-of select="baseImponible"/>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>Valor</td>
                                        <td>
                                            <xsl:value-of select="valor"/>
                                        </td>
                                    </tr>
                       
                                </xsl:for-each>
                            </table>
                
                        </td>
                    </tr>
                </table>
                </div>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>

