/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nancyin.martinna.wmartinna.control;

import com.nancyin.martinna.wmartinna.beans.Autorizacion;
import com.nancyin.martinna.wmartinna.utils.NancysException;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 *
 * @author Luis C.
 */
public class Processor {

//    private Logger LOG = LoggerFactory.getLogger(Processor.class);
    private String xml;
    private String outputFileName;

    public Autorizacion procesar(InputStream inputStream) throws NancysException {

        try {
//            Autorizaciones resultado = new Autorizaciones();
            Document doc = uParcer(inputStream);
            NodeList autorizaciones = doc.getElementsByTagName("autorizaciones");
            Autorizacion obj1 = new Autorizacion();
            for (int i = 0; i < autorizaciones.getLength(); i++) {
                Document autorizacion = uParcer(autorizaciones.item(i));
                String estado = autorizacion.getElementsByTagName("estado").item(0).getTextContent();
                if (!estado.equalsIgnoreCase("AUTORIZADO")) {
                    return null;
                }

                try {
                    obj1.setEstado(estado);
                } catch (NullPointerException e) {
                }
                try {
                    obj1.setFechaAutorizacion(autorizacion.getElementsByTagName("fechaAutorizacion").item(0).getTextContent());
                } catch (NullPointerException e) {
                }
                try {
                    obj1.setNumeroAutorizacion(autorizacion.getElementsByTagName("numeroAutorizacion").item(0).getTextContent());
                } catch (NullPointerException e) {
                }
                try {
                    obj1.setAmbiente(autorizacion.getElementsByTagName("ambiente").item(0).getTextContent());
                } catch (NullPointerException e) {
                }

                InputStream stream;
                String comXml = autorizacion.getElementsByTagName("comprobante").item(0).getTextContent();
                obj1.setXml(comXml);
                Document docComprobante = null;

                if (comXml.toUpperCase().contains("ENCODING=\"UTF-8\"")) {
                    stream = new ByteArrayInputStream(comXml.getBytes(StandardCharsets.UTF_8));
                    docComprobante = uParcerUTF(stream);
                } else {
                    stream = new ByteArrayInputStream(comXml.getBytes(StandardCharsets.ISO_8859_1));
                    docComprobante = uParcerISO(stream);
                }

                Document infoTributaria = uParcer(docComprobante.getElementsByTagName("infoTributaria").item(0));
                try {
                    obj1.setRazonSocialEmisor(infoTributaria.getElementsByTagName("razonSocial").item(0).getTextContent());
                } catch (NullPointerException e) {
                }
                try {
                    obj1.setTipoComprobante(infoTributaria.getElementsByTagName("codDoc").item(0).getTextContent());
                } catch (NullPointerException e) {
                }

                try {
                    obj1.setRucEmisor(infoTributaria.getElementsByTagName("ruc").item(0).getTextContent());
                } catch (NullPointerException e) {
                }
                try {
                    String estab = infoTributaria.getElementsByTagName("estab").item(0).getTextContent();
                    String ptoEmi = infoTributaria.getElementsByTagName("ptoEmi").item(0).getTextContent();
                    String secuencial = infoTributaria.getElementsByTagName("secuencial").item(0).getTextContent();
                    obj1.setSerieComprobante(estab + "-" + ptoEmi + "-" + secuencial);
                } catch (NullPointerException e) {
                }

                switch (obj1.getTipoComprobante()) {
                    case "01":

                        Document infoFactura = uParcer(docComprobante.getElementsByTagName("infoFactura").item(0));
                        try {
                            obj1.setFechaEmision(infoFactura.getElementsByTagName("fechaEmision").item(0).getTextContent());
                        } catch (NullPointerException e) {
                        }
                        try {
                            obj1.setTotalSinImpuestos(infoFactura.getElementsByTagName("totalSinImpuestos").item(0).getTextContent());
                        } catch (NullPointerException e) {
                        }
                        try {
                            obj1.setImporteTotal(infoFactura.getElementsByTagName("importeTotal").item(0).getTextContent());
                        } catch (NullPointerException e) {
                        }

                        Document totalConImpuestos = uParcer(docComprobante.getElementsByTagName("totalConImpuestos").item(0));
                        NodeList totalImpuesto = totalConImpuestos.getElementsByTagName("totalImpuesto");

                        for (int imp = 0; imp < totalImpuesto.getLength(); imp++) {
                            Document iitm = uParcer(totalImpuesto.item(imp));

                            try {
                                String codigoPorcentaje = iitm.getElementsByTagName("codigoPorcentaje").item(0).getTextContent();
                                if (codigoPorcentaje.equals("2")) {
                                    obj1.setBaseIva(iitm.getElementsByTagName("baseImponible").item(0).getTextContent());
                                    obj1.setIva(iitm.getElementsByTagName("valor").item(0).getTextContent());
                                } else if (codigoPorcentaje.equals("0")) {
                                    obj1.setBaseCero(iitm.getElementsByTagName("baseImponible").item(0).getTextContent());
                                }

                            } catch (NullPointerException e) {
                                e.printStackTrace();
                            }

                        }
                        break;
                    case "04":
                        Document infoNotaCredito = uParcer(docComprobante.getElementsByTagName("infoNotaCredito").item(0));
                        try {
                            obj1.setFechaEmision(infoNotaCredito.getElementsByTagName("fechaEmision").item(0).getTextContent());
                        } catch (NullPointerException e) {
                        }
                        try {
                            obj1.setTotalSinImpuestos(infoNotaCredito.getElementsByTagName("totalSinImpuestos").item(0).getTextContent());
                        } catch (NullPointerException e) {
                        }
                        try {
                            obj1.setNumDocModificado(infoNotaCredito.getElementsByTagName("numDocModificado").item(0).getTextContent());
                        } catch (NullPointerException e) {
                        }
                        try {
                            obj1.setValorModificacion(infoNotaCredito.getElementsByTagName("valorModificacion").item(0).getTextContent());
                        } catch (NullPointerException e) {
                        }
                        try {
                            obj1.setMotivo(infoNotaCredito.getElementsByTagName("motivo").item(0).getTextContent());
                        } catch (NullPointerException e) {
                        }
                        break;
                    case "07":
                        Document infoCompRetencion = uParcer(docComprobante.getElementsByTagName("infoCompRetencion").item(0));
                        try {
                            obj1.setFechaEmision(infoCompRetencion.getElementsByTagName("fechaEmision").item(0).getTextContent());
                        } catch (NullPointerException e) {
                        }
                        try {
                            obj1.setPeriodoFiscal(infoCompRetencion.getElementsByTagName("periodoFiscal").item(0).getTextContent());
                        } catch (NullPointerException e) {
                        }
                        break;
                    default:
//                        resultado.getAutorizaciones().add(obj1);
                        return obj1;

                }

//                resultado.getAutorizaciones().add(obj1);
            }

            return obj1;
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            throw new NancysException("Error al procesar XML", ex);
        }
    }

    private Document uParcer(InputStream inputStream) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        InputSource is = new InputSource(inputStream);
        is.setEncoding("ISO-8859-1");
        Document doc = db.parse(is);
        return doc;
    }

    private Document uParcerUTF(InputStream inputStream) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        InputSource is = new InputSource(inputStream);
        is.setEncoding("UTF-8");
        Document doc = db.parse(is);
        return doc;
    }

    private Document uParcerISO(InputStream inputStream) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        InputSource is = new InputSource(inputStream);
        is.setEncoding("ISO-8859-1");
        Document doc = db.parse(is);
        return doc;
    }

    private Document uParcer(Node node) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document newDocument = db.newDocument();
        Node importedNode = newDocument.importNode(node, true);
        newDocument.appendChild(importedNode);
        return newDocument;
    }

    private void toFile(Document document) throws NancysException {
        FileWriter writer = null;
        try {
            DOMSource source = new DOMSource(document);
            writer = new FileWriter(new File(this.outputFileName));
            StreamResult result = new StreamResult(writer);
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.ENCODING, "ISO-8859-1");
            transformer.transform(source, result);
        } catch (IOException | TransformerException ex) {
            throw new NancysException("No se puede guardar el archivo", ex);
        } finally {
            try {
                writer.close();
            } catch (IOException ex) {

            }
        }

    }

    private void toStringXml(Document document) throws NancysException {
        try {
            DOMSource domSource = new DOMSource(document);
            StringWriter writer = new StringWriter();
            StreamResult result = new StreamResult(writer);
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();
            transformer.setOutputProperty(OutputKeys.ENCODING, "ISO-8859-1");
            transformer.transform(domSource, result);
            this.xml = writer.toString();
        } catch (TransformerException ex) {
            throw new NancysException("No se puede guardar el archivo", ex);
        }

    }

    public void setOutputFileName(String outputFileName) {
        File f = new File(outputFileName);
        this.outputFileName = f.getName();
    }

    public String getOutputFileName() {
        return outputFileName;
    }

    public String getXml() {
        return xml;
    }

}
