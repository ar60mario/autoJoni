package com.ventas.util;

import com.ventas.entities.AlicuotaIva;
import com.ventas.entities.Cliente;
import com.ventas.entities.CompraClienteMercadoPago;
import com.ventas.entities.ConfiguracionTop;
import com.ventas.entities.Domicilio;
import com.ventas.entities.IvaCompras;
import com.ventas.entities.IvaVentas;
import com.ventas.entities.Producto;
import com.ventas.entities.ProductoIntercambio;
import com.ventas.entities.ProductoTop;
import com.ventas.entities.Rubro;
import com.ventas.entities.SubRubro;
import com.ventas.services.AlicuotaIvaService;
import com.ventas.services.ClienteService;
import com.ventas.services.ConfiguracionTopService;
import com.ventas.services.ProductoService;
import com.ventas.services.ProductoTopService;
import com.ventas.services.RubroService;
import com.ventas.services.SubRubroService;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class LectorDeExcel {

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public static List<IvaVentas> importarIvaVentas(File file) throws IOException, BiffException, Exception {
        Workbook archivoExcel = Workbook.getWorkbook(file);
        int cantidadFilas = archivoExcel.getSheet(0).getRows();
        Sheet hoja = archivoExcel.getSheet(0);
        List<IvaVentas> libroIva = new ArrayList<IvaVentas>();
        for (int i = 1; i < cantidadFilas; i++) {
            try {
                IvaVentas iv = new IvaVentas();
                iv.setLetra(hoja.getCell(0, i).getContents());
                iv.setNumeroSucursal(Integer.valueOf(hoja.getCell(1, i).getContents()));
                iv.setNumeroFactura(Integer.valueOf(hoja.getCell(2, i).getContents()));
                iv.setFecha(sdf.parse(hoja.getCell(3, i).getContents()));
                String cui = hoja.getCell(4, i).getContents();
                Cliente cli = null;
                if (cui != "00-00000000-0") {
                    cli = new ClienteService().getClienteByCuit(cui);
                } else {
                    String cod = "1";
                    cli = new ClienteService().getClienteByCodigo(cod);
                }
                System.out.println(cli);
                if (cli != null) {
                    iv.setCliente(cli);
                } else {
                    iv.setCliente(null);
                }
                iv.setCae(Long.valueOf(hoja.getCell(5, i).getContents()));
                iv.setFechaCae(sdf.parse(hoja.getCell(6, i).getContents()));
                iv.setTotal(Double.valueOf(hoja.getCell(7, i).getContents()));
                iv.setImpuesto(Double.valueOf(hoja.getCell(8, i).getContents()));
                iv.setGravado(Double.valueOf(hoja.getCell(9, i).getContents()));
                iv.setIva(Double.valueOf(hoja.getCell(10, i).getContents()));
                libroIva.add(iv);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error en linea: " + String.valueOf(i + 1));
                throw new Exception(ex);
            }
        }
        return libroIva;
    }

    public static List<IvaCompras> importarIvaCompras(File file) throws IOException, BiffException, Exception {
        Workbook archivoExcel = Workbook.getWorkbook(file);
        int cantidadFilas = archivoExcel.getSheet(0).getRows();
        Sheet hoja = archivoExcel.getSheet(0);
        List<IvaCompras> libroIva = new ArrayList<>();

        for (int i = 1; i < cantidadFilas; i++) {
            try {
                IvaCompras iv = new IvaCompras();
//                iv.set
//                iv.setNumeroSucursal(Integer.valueOf(hoja.getCell(1, i).getContents()));
//                iv.setNumeroFactura(Integer.valueOf(hoja.getCell(2, i).getContents()));
//                iv.setFecha(sdf.parse(hoja.getCell(3, i).getContents()));
//                String cui = hoja.getCell(4, i).getContents();
//                Cliente cli = null;
//                if (cui != "00-00000000-0") {
//                    cli = new ClienteService().getClienteByCuit(cui);
//                } else {
//                    String cod = "1";
//                    cli = new ClienteService().getClienteByCodigo(cod);
//                }
//                System.out.println(cli);
//                if (cli != null) {
//                    iv.setCliente(cli);
//                } else {
//                    iv.setCliente(null);
//                }
//                iv.setCae(Long.valueOf(hoja.getCell(5, i).getContents()));
//                iv.setFechaCae(sdf.parse(hoja.getCell(6, i).getContents()));
//                iv.setTotal(Double.valueOf(hoja.getCell(7, i).getContents()));
//                iv.setImpuesto(Double.valueOf(hoja.getCell(8, i).getContents()));
//                iv.setGravado(Double.valueOf(hoja.getCell(9, i).getContents()));
//                iv.setIva(Double.valueOf(hoja.getCell(10, i).getContents()));
                libroIva.add(iv);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error en linea: " + String.valueOf(i + 1));
                throw new Exception(ex);
            }
        }
        return libroIva;
    }

    public static ProductoIntercambio leerExcelProducto(File file) throws IOException, BiffException, Exception {
        Workbook archivoExcel = Workbook.getWorkbook(file);
        int cantidadFilas = archivoExcel.getSheet(0).getRows();
        Sheet hoja = archivoExcel.getSheet(0);
        AlicuotaIva alicuotaIva;
        ProductoIntercambio pi = new ProductoIntercambio();
        alicuotaIva = new AlicuotaIvaService().getAlicuotaIvaByCodigo(5);
        List<Producto> listaProductos = new ArrayList<>();
        List<ProductoTop> listaProdTop = new ArrayList<>();
        Boolean salir = false;
        Integer codigo = UtilProducto.getUltimoCodigoProducto();
        for (int i = 1; i < cantidadFilas; i++) {
            try {
                Producto prod = new Producto();
                ProductoTop prodTop = new ProductoTop();
                codigo += 1;
                String detalle = hoja.getCell(0, i).getContents();
                Integer rubro_codigo = Integer.valueOf(hoja.getCell(4, i).getContents());
                Integer subRubro_codigo = Integer.valueOf(hoja.getCell(5, i).getContents());
                Double neto = Double.valueOf(hoja.getCell(1, i).getContents().replaceAll("\\,", "\\."));
                Float impuesto = Float.valueOf(hoja.getCell(2, i).getContents().replaceAll("\\,", "\\."));
                Integer cantidad = 20;
//                Float stock = Float.valueOf(hoja.getCell(6, i).getContents().replaceAll("\\,", "\\."));
                Rubro rubro = null;
                rubro = new RubroService().getRubroByCodigo(rubro_codigo);
                SubRubro subRubro = null;
                subRubro = new SubRubroService().getSubRubroByCodigo(subRubro_codigo);
                neto = UtilFactura.calcularRedondeo(neto);
                impuesto = UtilFactura.calcularRedondeoF(impuesto);
                Integer cantidadFraccion = Integer.valueOf(hoja.getCell(7, i).getContents());
                Integer prodPorcentaje = Integer.valueOf(hoja.getCell(6, i).getContents());
                Float porcentajePrecio = Float.valueOf(hoja.getCell(8, i).getContents().replace(",", "."));
                if(prodPorcentaje.equals(1)){
                    prod.setPrecioPorPorcentaje(true);
                } else {
                    prod.setPrecioPorPorcentaje(false);
                }
                prod.setPorcentajePrecio(porcentajePrecio);
                prodTop.setFraccionMp(cantidadFraccion);
                /*
                0- Detalle
                1- neto
                2- Impuesto
                3- Final (se ignora)
                3- Rubro - código
                4- Sub Rubro - código
                5- cant vta
                 */
                prod.setAlicuotaIva(alicuotaIva);
                prod.setAuto(true);
                prod.setCodigo(codigo);
                prod.setCodigoBarras(0L);
                prod.setCostoI(0.0);
                prod.setCostoP(0.0);
                prod.setDetalle(detalle);
                prod.setEsLogistica(false);
                prod.setFabricado(false);
                prod.setImpuesto(impuesto);
                prod.setInactivo(false);
                prod.setPanificado(false);
                prod.setPrecio(neto);
                prod.setRubro(rubro);
                prod.setStock(0F);
                prod.setStockMinimo(0F);
                prod.setSubRubro(subRubro);
                prod.setSugerido(0.0);
                prodTop.setActivo(true);
                prodTop.setCantidad(cantidad);
                prodTop.setCantidadMaximaVenta(200);
                prodTop.setCantidadMinimaVenta(5);
                prodTop.setCodigo(codigo);
                prodTop.setDetalle(detalle);
                prodTop.setFraccion(5);
                prodTop.setFraccionMp(cantidadFraccion);
                prodTop.setImpuesto(impuesto);
                prodTop.setOrden(i);
                prodTop.setPanificado(false);
                prodTop.setPorcentualMaximoVentaAutomatica(100F);
                prodTop.setPrecio(neto);
                prodTop.setRubro(rubro);
                prodTop.setStock(0F);
                prodTop.setSubRubro(subRubro);
                prodTop.setUsado(false);
                prodTop.setVentaSinStock(true);
                listaProductos.add(prod);
                listaProdTop.add(prodTop);
                salir = false;
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error en linea: " + String.valueOf(i + 1));
                throw new Exception(ex);
            }
            if (salir) {
                break;
            }
        }
        pi.setProductos(listaProductos);
        pi.setProductosTop(listaProdTop);
        if (salir) {
            pi = null;
        }
        return pi;
    }

    public static ProductoIntercambio leerExcelParaActualizPrecios(File file) throws IOException, BiffException, Exception {
        Workbook archivoExcel = Workbook.getWorkbook(file);
        int cantidadFilas = archivoExcel.getSheet(0).getRows();
        Sheet hoja = archivoExcel.getSheet(0);
        AlicuotaIva alicuotaIva;
        ProductoIntercambio pi = new ProductoIntercambio();
        alicuotaIva = new AlicuotaIvaService().getAlicuotaIvaByCodigo(5);
        List<Producto> listaProductos = new ArrayList<>();
        List<ProductoTop> listaProdTop = new ArrayList<>();
        List<Producto> productosConError = new ArrayList<>();
        Boolean salir = false;
        for (int i = 1; i < cantidadFilas; i++) {
            try {
                String detalle = hoja.getCell(0, i).getContents();
                System.out.println(detalle);
                Producto prod = new ProductoService().getProductoByDetalle(detalle);
                System.out.println(prod);
                System.out.println(prod.getDetalle());
                System.out.println(prod.getCodigo());
                Integer codigo = prod.getCodigo();
                ProductoTop prodTop = new ProductoTopService().getProductoTopByCodigo(codigo);
                System.out.println(prodTop);
                Double neto = Double.valueOf(hoja.getCell(1, i).getContents().replaceAll("\\,", "\\."));
                Float impuesto = Float.valueOf(hoja.getCell(2, i).getContents().replaceAll("\\,", "\\."));
                neto = UtilFactura.calcularRedondeo(neto);
                impuesto = UtilFactura.calcularRedondeoF(impuesto);
                /*
                0- Detalle
                1- neto
                2- impuesto
                 */
                prod.setImpuesto(impuesto);
                prod.setPrecio(neto);
                prodTop.setImpuesto(impuesto);
                prodTop.setPrecio(neto);
                listaProductos.add(prod);
                listaProdTop.add(prodTop);
                salir = false;
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error en linea: " + String.valueOf(i + 1));
                throw new Exception(ex);
            }
            if (salir) {
                break;
            }
        }
        pi.setProductos(listaProductos);
        pi.setProductosTop(listaProdTop);
        if (salir) {
            pi = null;
        }
        return pi;
    }

    public static ProductoIntercambio leerExcelParaActualizStocks(File file) throws IOException, BiffException, Exception {
        Workbook archivoExcel = Workbook.getWorkbook(file);
        int cantidadFilas = archivoExcel.getSheet(0).getRows();
        Sheet hoja = archivoExcel.getSheet(0);
        ProductoIntercambio pi = new ProductoIntercambio();
        List<Producto> listaProductos = new ArrayList<>();
        List<ProductoTop> listaProdTop = new ArrayList<>();
        Boolean salir = false;
        for (int i = 1; i < cantidadFilas; i++) {
            try {
                String detalle = hoja.getCell(0, i).getContents();
                System.out.println(detalle);
                Producto prod = new ProductoService().getProductoByDetalle(detalle);
                System.out.println(prod);
                System.out.println(prod.getDetalle());
                System.out.println(prod.getCodigo());
                Integer codigo = prod.getCodigo();
                ProductoTop prodTop = new ProductoTopService().getProductoTopByCodigo(codigo);
                Float cantidadComprada = Float.valueOf(hoja.getCell(1, i).getContents().replaceAll("\\,", "\\."));
                System.out.println(prodTop.getStock());
                System.out.println(prodTop.getActivo());
                System.out.println(prodTop.getDetalle());
//                
                /*
                0- Detalle
                1- cantidad comprada
                 */
                Float stockExistente = prod.getStock();
                Float nuevoStock = stockExistente + cantidadComprada;
                nuevoStock=UtilFactura.calcularRedondeoF(nuevoStock);
                prod.setStock(nuevoStock);
                prodTop.setStock(nuevoStock);
                listaProductos.add(prod);
                listaProdTop.add(prodTop);
//                JOptionPane.showMessageDialog(null, "VER");
                salir = false;
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error en linea: " + String.valueOf(i + 1));
                throw new Exception(ex);
            }
            if (salir) {
                break;
            }
        }
        pi.setProductos(listaProductos);
        pi.setProductosTop(listaProdTop);
        if (salir) {
            pi = null;
        }
        return pi;
    }

    public static List<CompraClienteMercadoPago> leerExcelCompraClientesMP(File file) throws IOException, BiffException, Exception {
        ConfiguracionTop cf = null;
        cf = new ConfiguracionTopService().getConfigTopById(1);
        Double maximo = cf.getImporteMaximo();
        Workbook archivoExcel = Workbook.getWorkbook(file);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sdf_2 = new SimpleDateFormat("dd/MM/yy");
        int cantidadFilas = archivoExcel.getSheet(0).getRows();
        Sheet hoja = archivoExcel.getSheet(0);
        List<CompraClienteMercadoPago> listaClientes = new ArrayList<>();
        Boolean salir = false;
        for (int i = 1; i < cantidadFilas; i++) {
//            int pri2 = 0;
//            int cou = 0;
//            int pos = 0;
            try {
                CompraClienteMercadoPago compra = new CompraClienteMercadoPago();
                /*
                0 FECHA
                1 CUIT
                2 NOMBRE
                3 IMPORTE
                4 UBICACION
                5 LETRA
                 */
                String fecha = hoja.getCell(0, i).getContents();//ok

                compra.setFecha(fecha);
                System.out.println(hoja.getCell(0, i).getContents());
                System.out.println(hoja.getCell(1, i).getContents());
                System.out.println(hoja.getCell(2, i).getContents());
                System.out.println(hoja.getCell(3, i).getContents());
                System.out.println(hoja.getCell(4, i).getContents());
                System.out.println(hoja.getCell(5, i).getContents());
//                System.out.println(hoja.getCell(6, i).getContents());
                System.out.println("xxxxx");
                compra.setNombre(hoja.getCell(2, i).getContents());//ok
                compra.setOrigen(hoja.getCell(4, i).getContents());
//                        + " " + hoja.getCell(5, i).getContents());//ok
//                compra.setLetra(hoja.getCell(6, i).getContents());
                compra.setOperacion(hoja.getCell(5, i).getContents());
                String cui = hoja.getCell(1, i).getContents();//ok
                int largo = cui.length();
                System.out.println(cui);
                System.out.println(largo);
//                System.exit(0);
                String pri;
                String med;
                String fin;
                if (largo != 11) {
                    if (largo != 0) {
                        JOptionPane.showMessageDialog(null, "ERROR EN LARGO CUIT " + i + " " + largo);
                        salir = true;
                    } else {
                        if (!cui.equals("")) {
                            JOptionPane.showMessageDialog(null, "ERROR EN LARGO CUIT " + i + " _ " + largo);
                            salir = true;
                        }
                    }
                }
                //cuiCli.substring(0, 2) + cuiCli.substring(3, 11) + cuiCli.substring(12, 13);
                if (cui.equals("")) {
                    pri = "00";
                    med = "00000000";
                    fin = "0";
                } else {
                    pri = cui.substring(0, 2);
                    med = cui.substring(2, 10);
                    fin = cui.substring(10, 11);
                }
                Double importeMP = Double.valueOf(hoja.getCell(3, i).getContents().replaceAll("\\,", "\\."));
                compra.setCuit(pri + "-" + med + "-" + fin);
                compra.setImporte(importeMP);
                compra.setProcesado(false);
                compra.setImporteUtilizado(0.0);

                if (cui.equals("")) {
                    if (importeMP > maximo) {
                        JOptionPane.showMessageDialog(null, "CONSUMIDOR FINAL CON IMPORTE MAYOR AL MAXIMO" + i);
                    } else {
                        listaClientes.add(compra);
                    }
                } else {
                    listaClientes.add(compra);
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error en linea: " + String.valueOf(i + 1));
                salir = true;
                throw new Exception(ex);
            }
            if (salir) {
                break;
            }
        }
        if (salir) {
            listaClientes = null;
        }
        return listaClientes;
    }

    public static boolean validarExtension(File archivo) {
        String[] splitNombreArchivo = archivo.getName().split("\\.");
        String extension = splitNombreArchivo[splitNombreArchivo.length - 1];
        if (extension.equalsIgnoreCase(Constantes.EXTENSION_EXCEL_1)) {
            return true;
        } else {
            return false;
        }
    }

    public static List<Cliente> leerExcelCliente(File file) throws IOException, BiffException, Exception {
        Workbook archivoExcel = Workbook.getWorkbook(file);
        int cantidadFilas = archivoExcel.getSheet(0).getRows();
        Sheet hoja = archivoExcel.getSheet(0);
        List<Cliente> listaClientes = new ArrayList<>();
        for (int i = 1; i < cantidadFilas; i++) {
            try {
                Cliente cliente = new Cliente();
                cliente.setCodigo(hoja.getCell(0, i).getContents());
                cliente.setRazonSocial(hoja.getCell(1, i).getContents());
                cliente.setCuit(hoja.getCell(2, i).getContents());
                cliente.setDomicilio(new Domicilio());
                cliente.getDomicilio().setCalle(hoja.getCell(3, i).getContents());
                cliente.getDomicilio().setNumero(hoja.getCell(4, i).getContents());
                cliente.getDomicilio().setPiso(hoja.getCell(5, i).getContents());
                cliente.getDomicilio().setDepartamento(hoja.getCell(6, i).getContents());
                cliente.getDomicilio().setCodigoPostal(hoja.getCell(7, i).getContents());
                cliente.getDomicilio().setLocalidad(hoja.getCell(8, i).getContents());
                cliente.setTelefono(hoja.getCell(9, i).getContents());
                cliente.setMail(hoja.getCell(10, i).getContents());
                cliente.setFormaDePago(Integer.valueOf(hoja.getCell(11, i).getContents()));
                cliente.setCategoriaDeIva(Integer.valueOf(hoja.getCell(12, i).getContents()));
                cliente.setDescuento((float) 0);
                cliente.setTieneDescuento(false);
                cliente.setSaldo(0.0);
                cliente.setActivo(true);
                cliente.setTipo("80");
                listaClientes.add(cliente);
            } catch (Exception ex) {
                throw new Exception(ex);
            }
        }
        return listaClientes;
    }

}
