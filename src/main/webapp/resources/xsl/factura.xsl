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
                <h2>Factura: <xsl:value-of select="factura/infoTributaria/estab"/>-
                    <xsl:value-of select="factura/infoTributaria/ptoEmi"/>-
                    <xsl:value-of select="factura/infoTributaria/secuencial"/>
                </h2>
                <h2>
                    <xsl:value-of select="factura/infoTributaria/nombreComercial"/>
                </h2>
                <table>
                    <tr>
                        <td>Razon Social: </td>
                        <td>
                            <xsl:value-of select="factura/infoTributaria/razonSocial"/>
                        </td>
                    </tr>
                    <tr>
                        <td>Ruc: </td>
                        <td>
                            <xsl:value-of select="factura/infoTributaria/ruc"/>
                        </td>
                    </tr>
                    <tr>
                        <td>Autorización: </td>
                        <td>
                            <xsl:value-of select="factura/infoTributaria/claveAcceso"/>
                        </td>
                    </tr>
                    
                </table>
                <br/>
                <table>
                    <tr>
                        <td>Fecha Emision: </td>
                        <td>
                            <xsl:value-of select="factura/infoFactura/fechaEmision"/>
                        </td>
                    </tr>
                    <tr>
                        <td>Direccion Establecimiento: </td>
                        <td>
                            <xsl:value-of select="factura/infoFactura/dirEstablecimiento"/>
                        </td>
                    </tr>
                    <tr>
                        <td>Contribuyente Especial: </td>
                        <td>
                            <xsl:value-of select="factura/infoFactura/contribuyenteEspecial"/>
                        </td>
                    </tr>
                    <tr>
                        <td>Obligado Contabilidad: </td>
                        <td>
                            <xsl:value-of select="factura/infoFactura/obligadoContabilidad"/>
                        </td>
                    </tr>
                    <tr>
                        <td>Tipo Identificacion Comprador: </td>
                        <td>
                            <xsl:value-of select="factura/infoFactura/tipoIdentificacionComprador"/>
                        </td>
                    </tr>
                    <tr>
                        <td>Razon Social Comprador: </td>
                        <td>
                            <xsl:value-of select="factura/infoFactura/razonSocialComprador"/>
                        </td>
                    </tr>
                    <tr>
                        <td>Identificacion Comprador: </td>
                        <td>
                            <xsl:value-of select="factura/infoFactura/identificacionComprador"/>
                        </td>
                    </tr>
                    
                        
                </table>
                <table class="table table-bordered">
                    <tr>
                        <th align="left">Codigo Principal</th>
                        <th align="left">Descripcion</th>
                        <th align="left">Cantidad</th>
                        <th align="left">Precio Unitario</th>
                        <th align="left">Descuento</th>
                        <th align="left">Precio Total Sin Impuesto</th>
                        <th align="left">Impuesto</th>
                    </tr>
                    <xsl:for-each select="factura/detalles/detalle">
                        <tr>
                            <td>
                                <xsl:value-of select="codigoPrincipal"/>
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
                                <xsl:value-of select="descuento"/>
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
                            <xsl:value-of select="factura/infoFactura/totalSinImpuestos"/>
                        </td>
                    </tr>
                    <tr>
                        <td>Total Descuento: </td>
                        <td>
                            <xsl:value-of select="factura/infoFactura/totalDescuento"/>
                        </td>
                    </tr>
                    <tr>
                        <td>Propina: </td>
                        <td>
                            <xsl:value-of select="factura/infoFactura/propina"/>
                        </td>
                    </tr>
                    <tr>                    
                        <td>Impuestos: </td>
                        <td>
                            <table border="1">
                                <xsl:for-each select="factura/infoFactura/totalConImpuestos/totalImpuesto">
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

                    <tr>
                        <th>Importe Total: </th>
                        <th>
                            <xsl:value-of select="factura/infoFactura/importeTotal"/>
                        </th>
                    </tr>
                </table>
                </div>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>

