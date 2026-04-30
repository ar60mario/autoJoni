package com.ventas.main;

import com.ventas.entities.ArticuloCompra;
import com.ventas.entities.IvaVentas;
import com.ventas.entities.Producto;
import com.ventas.entities.TitularCuit;
import com.ventas.estructuras.Meses;
import com.ventas.frame.AbmArticulosPorMontoFrame;
import com.ventas.frame.AbmClienteFrame;
import com.ventas.frame.AbmFabricantesFrame;
import com.ventas.frame.AbmProductoFrame;
import com.ventas.frame.AbmProductosInactivosFrame;
import com.ventas.frame.AbmProductosTopFrame;
import com.ventas.frame.AbmProductosTopInactivosFrame;
import com.ventas.frame.AbmRubroFrame;
import com.ventas.frame.AbmStockFrame;
import com.ventas.frame.AbmSubRubroFrame;
import com.ventas.frame.AbmTipoDocForm;
import com.ventas.frame.AbmTitularesDeCuitFrame;
import com.ventas.frame.BackupFrame;
import com.ventas.frame.DuplicadoFacturaFrame;
import com.ventas.frame.DuplicadoFacturaPdfFrame;
import com.ventas.frame.FacturaWeb2Frame;
import com.ventas.frame.FacturaWebPanificadosFrame;
import com.ventas.frame.FacturarFrame;
import com.ventas.frame.ArticulosConSaldoPendienteParaAsignarFrame;
import com.ventas.frame.ElegirTitularFrame;
import com.ventas.frame.FacturaWeb3Frame;
import com.ventas.frame.FacturarAutomaticoPorMonto3Frame;
import com.ventas.frame.FacturarAutomaticoPorMontoFrame;
import com.ventas.frame.FacturarMercadoPago2Frame;
import com.ventas.frame.FacturasDeMercadoPagoFrame;
import com.ventas.frame.FacturasMercadoPagoCompletadasFacturarFrame;
import com.ventas.frame.FacturarMercadoPagoFrame;
import com.ventas.frame.FacturarMercadoPagoInscriptosFrame;
import com.ventas.frame.FacturarPorCajasFrame;
import com.ventas.frame.FacturasMercadoPagoPendientesFacturarFrame;
import com.ventas.frame.ImportarClientesMercadoPagoFrame;
import com.ventas.frame.ImportarIvaComprasFrame;
import com.ventas.frame.ImportarProductoFrame;
import com.ventas.frame.InformeConsFinalCortePorDiaFrame;
import com.ventas.frame.InformeMercadoPagoCortePorDiaFrame;
import com.ventas.frame.InformeStockFrame;
import com.ventas.frame.InformeVentasPorPeriodoFrame;
import com.ventas.frame.InformesImpresosFacturasMpFrame;
import com.ventas.frame.ModificarArticuloCompraFrame;
import com.ventas.frame.ModificarConfiguracionTopFrame;
import com.ventas.frame.NotaCreditoFrame;
import com.ventas.frame.NotaCreditoPorGrupoFrame;
import com.ventas.frame.NuevaFacturaCompraFrame;
import com.ventas.frame.ProductoSetearPorcentajeCigVariosFrame;
import com.ventas.frame.ProductosOrdenarFraccionMpFrame;
import com.ventas.frame.ProductosValorizadosFrame;
import com.ventas.frame.ProductosValorizadosMpFrame;
import com.ventas.frame.RecuperarDeAfipFrame;
import com.ventas.frame.RemitoFrame;
import com.ventas.frame.RemitoPanificadosFrame;
import com.ventas.frame.StockPeriodoProductoCompraFrame;
import com.ventas.frame.StockPeriodoProductoFrame;
import com.ventas.frame.VerFacturasByFechaFrame;
import com.ventas.frame.VerFacturasMercadoPagoFrame;
import com.ventas.frame.VerFcPorCajasFrame;
import com.ventas.frame.VerificarAfipFrame;
import com.ventas.services.ArticuloCompraService;
import com.ventas.services.FacturaService;
import com.ventas.services.FcService;
import com.ventas.services.IvaVentasService;
import com.ventas.services.RenglonFcService;
import com.ventas.services.TitularCuitService;
import com.ventas.util.Constantes;
import com.ventas.util.LectorDeExcel;
import com.ventas.util.UtilFrame;
import com.ventas.util.UtilQr;
import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class MainFrame extends javax.swing.JFrame {

    private List<ArticuloCompra> articulos;
    private DecimalFormat df = new DecimalFormat("#0.00");
    private DecimalFormat dfp = new DecimalFormat("#0.000");

    public MainFrame() {
        initComponents();
        
//        duplicadoPdfMnu.setVisible(false);
        recuperarAfipMnu.setVisible(true);
//        clientesMnu.setVisible(false);
        tipoDocMnu.setVisible(false);
        notaCreditoBtn.setVisible(true);
        randomBtn.setVisible(false);
        saldoFacturasCompraPendeintesMnu.setVisible(false);
        facturasMercadoPagoCompletadasMnu.setVisible(false);
        facturaAutomPorImporteBtn.setVisible(true);
//        tabla.setVisible(false);
        modificarTabacaleraBtn.setVisible(false);
        articulosPorMontoMnu.setVisible(false);
        stockMnu.setVisible(false);
        cargarFrame();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        salirBtn = new javax.swing.JButton();
        randomBtn = new javax.swing.JButton();
        notaCreditoBtn = new javax.swing.JButton();
        facturaMercadoPagoBtn = new javax.swing.JButton();
        facturaAutomPorImporteBtn = new javax.swing.JButton();
        cargarFcComprasBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        ultFechaTxt = new javax.swing.JTextField();
        ultNumTxt = new javax.swing.JTextField();
        ultImpoTxt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cuitTxt = new javax.swing.JTextField();
        importarMpBtn = new javax.swing.JButton();
        nombreTxt = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        modificarTabacaleraBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        mostrarTablaBtn = new javax.swing.JButton();
        facturaManualBtn = new javax.swing.JButton();
        tstBtn = new javax.swing.JButton();
        verFcMpBtn = new javax.swing.JButton();
        facturarPorCajasBtn = new javax.swing.JButton();
        verFcPorCajasBtn = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        comprasPorImporteMnu = new javax.swing.JMenuItem();
        clientesMnu = new javax.swing.JMenuItem();
        configuracionMnu = new javax.swing.JMenuItem();
        fabricanteMnu = new javax.swing.JMenuItem();
        rubrosMnu = new javax.swing.JMenuItem();
        subRubrosMnu = new javax.swing.JMenuItem();
        stockMnu = new javax.swing.JMenuItem();
        articulosPorMontoMnu = new javax.swing.JMenuItem();
        tipoDocMnu = new javax.swing.JMenuItem();
        titularesDeCuitMenu = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        verificarAfipMnu = new javax.swing.JMenuItem();
        recuperarAfipMnu = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        productosMnu = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        verInactivosMnu = new javax.swing.JMenuItem();
        productosUtilizadosMnu = new javax.swing.JMenuItem();
        productosTopInactivosMnu = new javax.swing.JMenuItem();
        todasLasAccionesMnu = new javax.swing.JMenuItem();
        productosOrdenarPorFraccionMpMnu = new javax.swing.JMenuItem();
        setearPorcentajeCigVariosMnu = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        backupMnu = new javax.swing.JMenuItem();
        duplicadoPdfMnu = new javax.swing.JMenuItem();
        duplicadoFcPdfPorFechaMnu = new javax.swing.JMenuItem();
        importarMnu = new javax.swing.JMenuItem();
        importarMercadoPagoMnu = new javax.swing.JMenuItem();
        importarIvaComprasMnu = new javax.swing.JMenuItem();
        notaCreditoPorGrupoMnu = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        ventasPorPeriodoMnu = new javax.swing.JMenuItem();
        informeStockMnu = new javax.swing.JMenuItem();
        stockPeriodoProductoVentaMnu = new javax.swing.JMenuItem();
        stockPeriodoProductoCompraMnu = new javax.swing.JMenuItem();
        facturasMercadoPagoPendientesMnu = new javax.swing.JMenuItem();
        saldoFacturasCompraPendeintesMnu = new javax.swing.JMenuItem();
        facturasDeMercadoPagoMnu = new javax.swing.JMenuItem();
        facturasMercadoPagoCompletadasMnu = new javax.swing.JMenuItem();
        mpCortePorDiaMnu = new javax.swing.JMenuItem();
        cfCortePorDiaMnu = new javax.swing.JMenuItem();
        mpFcImpresasMnu = new javax.swing.JMenuItem();
        productosValorizadosMnu = new javax.swing.JMenuItem();
        productosValorizadosMpMnu = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        versionMnu = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("FACTURACION AUTOMATICA");

        salirBtn.setText("Salir");
        salirBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirBtnActionPerformed(evt);
            }
        });

        randomBtn.setText("Fc Automática");
        randomBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                randomBtnActionPerformed(evt);
            }
        });

        notaCreditoBtn.setText("Nota de Crédito");
        notaCreditoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                notaCreditoBtnActionPerformed(evt);
            }
        });

        facturaMercadoPagoBtn.setText("Facturar Mercado Pago");
        facturaMercadoPagoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                facturaMercadoPagoBtnActionPerformed(evt);
            }
        });

        facturaAutomPorImporteBtn.setText("Fc Autom.X Importe");
        facturaAutomPorImporteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                facturaAutomPorImporteBtnActionPerformed(evt);
            }
        });

        cargarFcComprasBtn.setText("Cargar Facturas Compra");
        cargarFcComprasBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargarFcComprasBtnActionPerformed(evt);
            }
        });

        jLabel1.setText("Ultima Fecha:");

        jLabel2.setText("U.Nro.Fc:");

        jLabel3.setText("U.Importe:");

        ultFechaTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ultFechaTxt.setText("U.FECHA");

        ultNumTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ultNumTxt.setText("U.NRO");

        ultImpoTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ultImpoTxt.setText("U.IMPORTE");

        jLabel5.setText("CUIT:");

        cuitTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cuitTxt.setText("CUIT");

        importarMpBtn.setText("Importar Mercado Pago");
        importarMpBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importarMpBtnActionPerformed(evt);
            }
        });

        nombreTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        nombreTxt.setText("NOMBRE");

        jLabel6.setText("Nombre:");

        modificarTabacaleraBtn.setText("Modificar Tabacaleras");
        modificarTabacaleraBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarTabacaleraBtnActionPerformed(evt);
            }
        });

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "MES", "IVA COMP", "TOTAL COMPRAS", "IVA VENT", "TOTAL VENTAS", "DIFERENCIA"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, false, false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabla);
        if (tabla.getColumnModel().getColumnCount() > 0) {
            tabla.getColumnModel().getColumn(0).setPreferredWidth(100);
            tabla.getColumnModel().getColumn(1).setPreferredWidth(200);
            tabla.getColumnModel().getColumn(2).setPreferredWidth(200);
            tabla.getColumnModel().getColumn(3).setPreferredWidth(200);
            tabla.getColumnModel().getColumn(4).setPreferredWidth(200);
            tabla.getColumnModel().getColumn(5).setPreferredWidth(200);
        }

        mostrarTablaBtn.setText("Mostrar Datos Tabla");
        mostrarTablaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrarTablaBtnActionPerformed(evt);
            }
        });

        facturaManualBtn.setText("Factura A Manual");
        facturaManualBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                facturaManualBtnActionPerformed(evt);
            }
        });

        tstBtn.setText("tst");
        tstBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tstBtnActionPerformed(evt);
            }
        });

        verFcMpBtn.setText("Ver Fc Mp");
        verFcMpBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verFcMpBtnActionPerformed(evt);
            }
        });

        facturarPorCajasBtn.setText("Facturar X Cajas");
        facturarPorCajasBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                facturarPorCajasBtnActionPerformed(evt);
            }
        });

        verFcPorCajasBtn.setText("Ver Fc Por Cajas");
        verFcPorCajasBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verFcPorCajasBtnActionPerformed(evt);
            }
        });

        jMenu1.setText("Abm");

        comprasPorImporteMnu.setText("Cargar Facturas Compra");
        comprasPorImporteMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comprasPorImporteMnuActionPerformed(evt);
            }
        });
        jMenu1.add(comprasPorImporteMnu);

        clientesMnu.setText("Clientes");
        clientesMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clientesMnuActionPerformed(evt);
            }
        });
        jMenu1.add(clientesMnu);

        configuracionMnu.setText("Configuración");
        configuracionMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                configuracionMnuActionPerformed(evt);
            }
        });
        jMenu1.add(configuracionMnu);

        fabricanteMnu.setText("Fabricantes");
        fabricanteMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fabricanteMnuActionPerformed(evt);
            }
        });
        jMenu1.add(fabricanteMnu);

        rubrosMnu.setText("Rubros");
        rubrosMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rubrosMnuActionPerformed(evt);
            }
        });
        jMenu1.add(rubrosMnu);

        subRubrosMnu.setText("Sub Rubros");
        subRubrosMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subRubrosMnuActionPerformed(evt);
            }
        });
        jMenu1.add(subRubrosMnu);

        stockMnu.setText("Stock");
        stockMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stockMnuActionPerformed(evt);
            }
        });
        jMenu1.add(stockMnu);

        articulosPorMontoMnu.setText("Saldos a Facturar");
        articulosPorMontoMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                articulosPorMontoMnuActionPerformed(evt);
            }
        });
        jMenu1.add(articulosPorMontoMnu);

        tipoDocMnu.setText("Tipo Documento");
        tipoDocMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoDocMnuActionPerformed(evt);
            }
        });
        jMenu1.add(tipoDocMnu);

        titularesDeCuitMenu.setText("Titulares De Cuit");
        titularesDeCuitMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                titularesDeCuitMenuActionPerformed(evt);
            }
        });
        jMenu1.add(titularesDeCuitMenu);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Verificar");

        verificarAfipMnu.setText("Estado Afip");
        verificarAfipMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verificarAfipMnuActionPerformed(evt);
            }
        });
        jMenu2.add(verificarAfipMnu);

        recuperarAfipMnu.setText("Recuperar de Afip");
        recuperarAfipMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recuperarAfipMnuActionPerformed(evt);
            }
        });
        jMenu2.add(recuperarAfipMnu);

        jMenuBar1.add(jMenu2);

        jMenu6.setText("Productos");

        productosMnu.setText("Actualizar Precios");
        productosMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productosMnuActionPerformed(evt);
            }
        });
        jMenu6.add(productosMnu);

        jMenuItem1.setText("Cargar Stocks");
        jMenu6.add(jMenuItem1);

        jMenuItem2.setText("Desactivar Productos");
        jMenu6.add(jMenuItem2);

        verInactivosMnu.setText("Productos Inactivos");
        verInactivosMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verInactivosMnuActionPerformed(evt);
            }
        });
        jMenu6.add(verInactivosMnu);

        productosUtilizadosMnu.setText("Productos utilizados");
        productosUtilizadosMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productosUtilizadosMnuActionPerformed(evt);
            }
        });
        jMenu6.add(productosUtilizadosMnu);

        productosTopInactivosMnu.setText("Productos Utilizados Eliminados");
        productosTopInactivosMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productosTopInactivosMnuActionPerformed(evt);
            }
        });
        jMenu6.add(productosTopInactivosMnu);

        todasLasAccionesMnu.setText("Todas las Acciones");
        todasLasAccionesMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                todasLasAccionesMnuActionPerformed(evt);
            }
        });
        jMenu6.add(todasLasAccionesMnu);

        productosOrdenarPorFraccionMpMnu.setText("Productos Ordenar Por Fracción MP");
        productosOrdenarPorFraccionMpMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productosOrdenarPorFraccionMpMnuActionPerformed(evt);
            }
        });
        jMenu6.add(productosOrdenarPorFraccionMpMnu);

        setearPorcentajeCigVariosMnu.setText("Setear Porcentaje Cigarrillos Varios");
        setearPorcentajeCigVariosMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setearPorcentajeCigVariosMnuActionPerformed(evt);
            }
        });
        jMenu6.add(setearPorcentajeCigVariosMnu);

        jMenuBar1.add(jMenu6);

        jMenu5.setText("Herramientas");

        backupMnu.setText("Backup");
        backupMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backupMnuActionPerformed(evt);
            }
        });
        jMenu5.add(backupMnu);

        duplicadoPdfMnu.setText("Duplicado Fc en Pdf x Cliente");
        duplicadoPdfMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                duplicadoPdfMnuActionPerformed(evt);
            }
        });
        jMenu5.add(duplicadoPdfMnu);

        duplicadoFcPdfPorFechaMnu.setText("Duplicado Fc en Pdf x Fecha");
        duplicadoFcPdfPorFechaMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                duplicadoFcPdfPorFechaMnuActionPerformed(evt);
            }
        });
        jMenu5.add(duplicadoFcPdfPorFechaMnu);

        importarMnu.setText("Importar");
        importarMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importarMnuActionPerformed(evt);
            }
        });
        jMenu5.add(importarMnu);

        importarMercadoPagoMnu.setText("Importar MP");
        importarMercadoPagoMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importarMercadoPagoMnuActionPerformed(evt);
            }
        });
        jMenu5.add(importarMercadoPagoMnu);

        importarIvaComprasMnu.setText("Importar Iva Compras");
        importarIvaComprasMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importarIvaComprasMnuActionPerformed(evt);
            }
        });
        jMenu5.add(importarIvaComprasMnu);

        notaCreditoPorGrupoMnu.setText("Notas De Crédito por grupo");
        notaCreditoPorGrupoMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                notaCreditoPorGrupoMnuActionPerformed(evt);
            }
        });
        jMenu5.add(notaCreditoPorGrupoMnu);

        jMenuBar1.add(jMenu5);

        jMenu4.setText("Informes");

        ventasPorPeriodoMnu.setText("Ventas X Período");
        ventasPorPeriodoMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ventasPorPeriodoMnuActionPerformed(evt);
            }
        });
        jMenu4.add(ventasPorPeriodoMnu);

        informeStockMnu.setText("Stock Actual");
        informeStockMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                informeStockMnuActionPerformed(evt);
            }
        });
        jMenu4.add(informeStockMnu);

        stockPeriodoProductoVentaMnu.setText("Stock x Período x Producto x Venta");
        stockPeriodoProductoVentaMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stockPeriodoProductoVentaMnuActionPerformed(evt);
            }
        });
        jMenu4.add(stockPeriodoProductoVentaMnu);

        stockPeriodoProductoCompraMnu.setText("Stock x Período x Producto x Compra");
        stockPeriodoProductoCompraMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stockPeriodoProductoCompraMnuActionPerformed(evt);
            }
        });
        jMenu4.add(stockPeriodoProductoCompraMnu);

        facturasMercadoPagoPendientesMnu.setText("FACTURAS MERCADO PAGO PENDIENTES");
        facturasMercadoPagoPendientesMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                facturasMercadoPagoPendientesMnuActionPerformed(evt);
            }
        });
        jMenu4.add(facturasMercadoPagoPendientesMnu);

        saldoFacturasCompraPendeintesMnu.setText("SALDO DE FACTURAS COMPRA PENDIENTES");
        saldoFacturasCompraPendeintesMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saldoFacturasCompraPendeintesMnuActionPerformed(evt);
            }
        });
        jMenu4.add(saldoFacturasCompraPendeintesMnu);

        facturasDeMercadoPagoMnu.setText("FACTURAS CORRESPONDIENTES A MERCADO PAGO");
        facturasDeMercadoPagoMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                facturasDeMercadoPagoMnuActionPerformed(evt);
            }
        });
        jMenu4.add(facturasDeMercadoPagoMnu);

        facturasMercadoPagoCompletadasMnu.setText("FACTURAS MERCADO PAGO COMPLETADAS");
        facturasMercadoPagoCompletadasMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                facturasMercadoPagoCompletadasMnuActionPerformed(evt);
            }
        });
        jMenu4.add(facturasMercadoPagoCompletadasMnu);

        mpCortePorDiaMnu.setText("MP - CORTE POR DIA ENTRE FECHAS");
        mpCortePorDiaMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mpCortePorDiaMnuActionPerformed(evt);
            }
        });
        jMenu4.add(mpCortePorDiaMnu);

        cfCortePorDiaMnu.setText("CF - CORTE POR DIA ENTRE FECHAS");
        cfCortePorDiaMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cfCortePorDiaMnuActionPerformed(evt);
            }
        });
        jMenu4.add(cfCortePorDiaMnu);

        mpFcImpresasMnu.setText("MP - FACTURAS ENTRE FECHAS X CUIT - IMPRESO");
        mpFcImpresasMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mpFcImpresasMnuActionPerformed(evt);
            }
        });
        jMenu4.add(mpFcImpresasMnu);

        productosValorizadosMnu.setText("Productos Valorizados");
        productosValorizadosMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productosValorizadosMnuActionPerformed(evt);
            }
        });
        jMenu4.add(productosValorizadosMnu);

        productosValorizadosMpMnu.setText("Productos Valorizados Mp");
        productosValorizadosMpMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productosValorizadosMpMnuActionPerformed(evt);
            }
        });
        jMenu4.add(productosValorizadosMpMnu);

        jMenuBar1.add(jMenu4);

        jMenu3.setText("?");

        versionMnu.setText("Versión");
        versionMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                versionMnuActionPerformed(evt);
            }
        });
        jMenu3.add(versionMnu);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cargarFcComprasBtn)
                            .addComponent(facturaMercadoPagoBtn))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(importarMpBtn)
                            .addComponent(facturarPorCajasBtn))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(modificarTabacaleraBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(randomBtn))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(facturaAutomPorImporteBtn)
                                .addGap(18, 18, 18)
                                .addComponent(facturaManualBtn)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(5, 5, 5)
                        .addComponent(notaCreditoBtn)
                        .addGap(18, 18, 18)
                        .addComponent(salirBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ultFechaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tstBtn)
                        .addGap(18, 18, 18)
                        .addComponent(verFcMpBtn)
                        .addGap(18, 18, 18)
                        .addComponent(verFcPorCajasBtn)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ultImpoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ultNumTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cuitTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nombreTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(mostrarTablaBtn)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 614, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(ultFechaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tstBtn)
                            .addComponent(verFcMpBtn)
                            .addComponent(verFcPorCajasBtn))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(cuitTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(nombreTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(ultImpoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(ultNumTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(mostrarTablaBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cargarFcComprasBtn)
                    .addComponent(randomBtn)
                    .addComponent(importarMpBtn)
                    .addComponent(modificarTabacaleraBtn))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(salirBtn)
                    .addComponent(facturaMercadoPagoBtn)
                    .addComponent(facturaAutomPorImporteBtn)
                    .addComponent(notaCreditoBtn)
                    .addComponent(facturaManualBtn)
                    .addComponent(facturarPorCajasBtn))
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void randomBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_randomBtnActionPerformed
        facturar();
    }//GEN-LAST:event_randomBtnActionPerformed

    private void productosUtilizadosMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productosUtilizadosMnuActionPerformed
        productosUtilizados();
    }//GEN-LAST:event_productosUtilizadosMnuActionPerformed

    private void salirBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirBtnActionPerformed
//        int a = JOptionPane.showConfirmDialog(this, "Desea Salir del programa?", "Atención", JOptionPane.YES_NO_OPTION);
//        if (a == 0) {
        salir();
//        }
    }//GEN-LAST:event_salirBtnActionPerformed

    private void configuracionMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_configuracionMnuActionPerformed
        configuracion();
    }//GEN-LAST:event_configuracionMnuActionPerformed

    private void verInactivosMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verInactivosMnuActionPerformed
        verProductosInactivos();
    }//GEN-LAST:event_verInactivosMnuActionPerformed

    private void verificarAfipMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verificarAfipMnuActionPerformed
        verificarAfip();
    }//GEN-LAST:event_verificarAfipMnuActionPerformed

    private void versionMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_versionMnuActionPerformed
        versionFrm();
    }//GEN-LAST:event_versionMnuActionPerformed

    private void productosMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productosMnuActionPerformed
        productos();
    }//GEN-LAST:event_productosMnuActionPerformed

    private void rubrosMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rubrosMnuActionPerformed
        rubros();
    }//GEN-LAST:event_rubrosMnuActionPerformed

    private void subRubrosMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subRubrosMnuActionPerformed
        subRubros();
    }//GEN-LAST:event_subRubrosMnuActionPerformed

    private void clientesMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientesMnuActionPerformed
        clientes();
    }//GEN-LAST:event_clientesMnuActionPerformed

    private void tipoDocMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoDocMnuActionPerformed
        documento();
    }//GEN-LAST:event_tipoDocMnuActionPerformed

    private void ventasPorPeriodoMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ventasPorPeriodoMnuActionPerformed
        informeVXP();
    }//GEN-LAST:event_ventasPorPeriodoMnuActionPerformed

    private void stockMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stockMnuActionPerformed
        abmStock();

    }//GEN-LAST:event_stockMnuActionPerformed

    private void informeStockMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_informeStockMnuActionPerformed
        informeStock();
    }//GEN-LAST:event_informeStockMnuActionPerformed

    private void duplicadoPdfMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_duplicadoPdfMnuActionPerformed
        duplicadoPdf();
    }//GEN-LAST:event_duplicadoPdfMnuActionPerformed

    private void backupMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backupMnuActionPerformed
        backup();
    }//GEN-LAST:event_backupMnuActionPerformed

    private void recuperarAfipMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recuperarAfipMnuActionPerformed
        recuperar();
    }//GEN-LAST:event_recuperarAfipMnuActionPerformed

    private void productosTopInactivosMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productosTopInactivosMnuActionPerformed
        verProductoTopInactivos();
    }//GEN-LAST:event_productosTopInactivosMnuActionPerformed

    private void stockPeriodoProductoVentaMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stockPeriodoProductoVentaMnuActionPerformed
        stockPeriodoProductoVenta();
    }//GEN-LAST:event_stockPeriodoProductoVentaMnuActionPerformed

    private void stockPeriodoProductoCompraMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stockPeriodoProductoCompraMnuActionPerformed
        stockPeriodoProductoCompra();
    }//GEN-LAST:event_stockPeriodoProductoCompraMnuActionPerformed

    private void notaCreditoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_notaCreditoBtnActionPerformed
        notaCreditoGrupo();
    }//GEN-LAST:event_notaCreditoBtnActionPerformed

    private void importarMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_importarMnuActionPerformed
        importar();
    }//GEN-LAST:event_importarMnuActionPerformed

    private void importarMercadoPagoMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_importarMercadoPagoMnuActionPerformed
        importarMercadoPago();
    }//GEN-LAST:event_importarMercadoPagoMnuActionPerformed

    private void facturaMercadoPagoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_facturaMercadoPagoBtnActionPerformed
        facturaMercadoPago();
    }//GEN-LAST:event_facturaMercadoPagoBtnActionPerformed

    private void comprasPorImporteMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comprasPorImporteMnuActionPerformed
        abmStock();
    }//GEN-LAST:event_comprasPorImporteMnuActionPerformed

    private void saldoFacturasCompraPendeintesMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saldoFacturasCompraPendeintesMnuActionPerformed
        saldoPendienteFacturasCompra();
    }//GEN-LAST:event_saldoFacturasCompraPendeintesMnuActionPerformed

    private void facturasMercadoPagoPendientesMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_facturasMercadoPagoPendientesMnuActionPerformed
        facturasMercadoPagoPendientes();
    }//GEN-LAST:event_facturasMercadoPagoPendientesMnuActionPerformed

    private void facturasDeMercadoPagoMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_facturasDeMercadoPagoMnuActionPerformed
        facturasDeMercadoPago();
    }//GEN-LAST:event_facturasDeMercadoPagoMnuActionPerformed

    private void facturasMercadoPagoCompletadasMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_facturasMercadoPagoCompletadasMnuActionPerformed
        facturasMercadoPagoCompletadas();
    }//GEN-LAST:event_facturasMercadoPagoCompletadasMnuActionPerformed

    private void articulosPorMontoMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_articulosPorMontoMnuActionPerformed
        abmArticulosPorMonto();
    }//GEN-LAST:event_articulosPorMontoMnuActionPerformed

    private void facturaAutomPorImporteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_facturaAutomPorImporteBtnActionPerformed
        facturaAutomPorImporte();
    }//GEN-LAST:event_facturaAutomPorImporteBtnActionPerformed

    private void cargarFcComprasBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargarFcComprasBtnActionPerformed
        abmStock();
    }//GEN-LAST:event_cargarFcComprasBtnActionPerformed

    private void mpCortePorDiaMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mpCortePorDiaMnuActionPerformed
        informeMercadoPagoCortePorDia();
    }//GEN-LAST:event_mpCortePorDiaMnuActionPerformed

    private void cfCortePorDiaMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cfCortePorDiaMnuActionPerformed
        informeConsFinalCortePorDia();
    }//GEN-LAST:event_cfCortePorDiaMnuActionPerformed

    private void mpFcImpresasMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mpFcImpresasMnuActionPerformed
        informeFacturasMpImpreso();
    }//GEN-LAST:event_mpFcImpresasMnuActionPerformed

    private void importarMpBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_importarMpBtnActionPerformed
        importarMercadoPago();
    }//GEN-LAST:event_importarMpBtnActionPerformed

    private void modificarTabacaleraBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarTabacaleraBtnActionPerformed
        modificarTabacalera();
    }//GEN-LAST:event_modificarTabacaleraBtnActionPerformed

    private void fabricanteMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fabricanteMnuActionPerformed
        abmFabricante();
    }//GEN-LAST:event_fabricanteMnuActionPerformed

    private void productosValorizadosMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productosValorizadosMnuActionPerformed
        productosValoridados1();
    }//GEN-LAST:event_productosValorizadosMnuActionPerformed

    private void productosValorizadosMpMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productosValorizadosMpMnuActionPerformed
        productosValoridados2();
    }//GEN-LAST:event_productosValorizadosMpMnuActionPerformed

    private void importarIvaComprasMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_importarIvaComprasMnuActionPerformed
        importarIvaCompras();
    }//GEN-LAST:event_importarIvaComprasMnuActionPerformed

    private void mostrarTablaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrarTablaBtnActionPerformed
        llenarTabla();
    }//GEN-LAST:event_mostrarTablaBtnActionPerformed

    private void notaCreditoPorGrupoMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_notaCreditoPorGrupoMnuActionPerformed
        notaCreditoGrupo();
    }//GEN-LAST:event_notaCreditoPorGrupoMnuActionPerformed

    private void facturaManualBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_facturaManualBtnActionPerformed
        facturaManual();
    }//GEN-LAST:event_facturaManualBtnActionPerformed

    private void todasLasAccionesMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_todasLasAccionesMnuActionPerformed
        todasLasAccionesProductos();
    }//GEN-LAST:event_todasLasAccionesMnuActionPerformed

    private void tstBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tstBtnActionPerformed
        IvaVentas iv = null;
        try {
            iv = new IvaVentasService().getUltimaFactura(6);
        } catch (Exception ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
        Date fechaCmpbte = iv.getFecha();
        String cuitTitular = Constantes.cuitTitular;
        String cuitT = "";
        String pri = "";
        String med = "";
        String fin = "";
        String priR = "";
        String medR = "";
        String finR = "";
        String ptoVta = iv.getNumeroSucursal().toString();
        Integer nroCpbte = iv.getNumeroFactura();
        String tipoCompr = iv.getTipoDoc().toString();
        Double totalFc = iv.getTotal();
        String tipoDocumReceptor = iv.getCliente().getTipo();
        String nroDocumReceptor;
        String cuitReceptor = iv.getCliente().getCuit();
        String caeNro = iv.getCae().toString();
        if (tipoDocumReceptor.equals("80")
                || tipoDocumReceptor.equals("86")) {
            int largo = cuitReceptor.length();
            if (largo == 13) {
                priR = cuitReceptor.substring(0, 2);
                medR = cuitReceptor.substring(3, 11);
                finR = cuitReceptor.substring(12, 13);
                nroDocumReceptor = priR + medR + finR;
            } else {
                if (largo != 11) {
                    JOptionPane.showMessageDialog(this, "ERROR EN CUIT");
                    return;
                } else {
                    nroDocumReceptor = cuitReceptor;
                }
            }
        } else {
            if (tipoDocumReceptor.equals("96")) {
                nroDocumReceptor = cuitReceptor;
            } else {
                if (tipoDocumReceptor.equals("99")) {
                    nroDocumReceptor = "0";
                } else {
                    JOptionPane.showMessageDialog(this, "ERROR EN TIPO DOCUMENTO CLIENTE");
                    return;
                }
            }
        }

        int largo = cuitTitular.length();
        if (largo == 13) {
            pri = cuitTitular.substring(0, 2);
            med = cuitTitular.substring(3, 11);
            fin = cuitTitular.substring(12, 13);
            cuitT = priR + medR + finR;
        } else {
            cuitT = cuitTitular;
        }
        DecimalFormat df_nf = new DecimalFormat("00000000");
        String nombreArchivo = "Qr_" + tipoCompr + "_" + ptoVta + "_" + df_nf.format(nroCpbte);
        String data = UtilQr.crearDataQr(fechaCmpbte, cuitT, ptoVta, nroCpbte, tipoCompr, totalFc,
                tipoDocumReceptor, nroDocumReceptor, caeNro);
        try {
            UtilQr.generarPngQr(data, nombreArchivo);
        } catch (Exception ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
        JOptionPane.showMessageDialog(this, "QR LISTO");
    }//GEN-LAST:event_tstBtnActionPerformed

    private void verFcMpBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verFcMpBtnActionPerformed
        verFcMp();
    }//GEN-LAST:event_verFcMpBtnActionPerformed

    private void titularesDeCuitMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_titularesDeCuitMenuActionPerformed
        abmTitulares();
    }//GEN-LAST:event_titularesDeCuitMenuActionPerformed

    private void productosOrdenarPorFraccionMpMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productosOrdenarPorFraccionMpMnuActionPerformed
        productosOrdenarPorFraccion();
    }//GEN-LAST:event_productosOrdenarPorFraccionMpMnuActionPerformed

    private void duplicadoFcPdfPorFechaMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_duplicadoFcPdfPorFechaMnuActionPerformed
        duplicadoPdfPorFecha();
    }//GEN-LAST:event_duplicadoFcPdfPorFechaMnuActionPerformed

    private void setearPorcentajeCigVariosMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setearPorcentajeCigVariosMnuActionPerformed
        setearPorcentajeCigVarios();
    }//GEN-LAST:event_setearPorcentajeCigVariosMnuActionPerformed

    private void facturarPorCajasBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_facturarPorCajasBtnActionPerformed
        facturarPorCajas();
    }//GEN-LAST:event_facturarPorCajasBtnActionPerformed

    private void verFcPorCajasBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verFcPorCajasBtnActionPerformed
        verFcPorCajas();
    }//GEN-LAST:event_verFcPorCajasBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem articulosPorMontoMnu;
    private javax.swing.JMenuItem backupMnu;
    private javax.swing.JButton cargarFcComprasBtn;
    private javax.swing.JMenuItem cfCortePorDiaMnu;
    private javax.swing.JMenuItem clientesMnu;
    private javax.swing.JMenuItem comprasPorImporteMnu;
    private javax.swing.JMenuItem configuracionMnu;
    private javax.swing.JTextField cuitTxt;
    private javax.swing.JMenuItem duplicadoFcPdfPorFechaMnu;
    private javax.swing.JMenuItem duplicadoPdfMnu;
    private javax.swing.JMenuItem fabricanteMnu;
    private javax.swing.JButton facturaAutomPorImporteBtn;
    private javax.swing.JButton facturaManualBtn;
    private javax.swing.JButton facturaMercadoPagoBtn;
    private javax.swing.JButton facturarPorCajasBtn;
    private javax.swing.JMenuItem facturasDeMercadoPagoMnu;
    private javax.swing.JMenuItem facturasMercadoPagoCompletadasMnu;
    private javax.swing.JMenuItem facturasMercadoPagoPendientesMnu;
    private javax.swing.JMenuItem importarIvaComprasMnu;
    private javax.swing.JMenuItem importarMercadoPagoMnu;
    private javax.swing.JMenuItem importarMnu;
    private javax.swing.JButton importarMpBtn;
    private javax.swing.JMenuItem informeStockMnu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton modificarTabacaleraBtn;
    private javax.swing.JButton mostrarTablaBtn;
    private javax.swing.JMenuItem mpCortePorDiaMnu;
    private javax.swing.JMenuItem mpFcImpresasMnu;
    private javax.swing.JTextField nombreTxt;
    private javax.swing.JButton notaCreditoBtn;
    private javax.swing.JMenuItem notaCreditoPorGrupoMnu;
    private javax.swing.JMenuItem productosMnu;
    private javax.swing.JMenuItem productosOrdenarPorFraccionMpMnu;
    private javax.swing.JMenuItem productosTopInactivosMnu;
    private javax.swing.JMenuItem productosUtilizadosMnu;
    private javax.swing.JMenuItem productosValorizadosMnu;
    private javax.swing.JMenuItem productosValorizadosMpMnu;
    private javax.swing.JButton randomBtn;
    private javax.swing.JMenuItem recuperarAfipMnu;
    private javax.swing.JMenuItem rubrosMnu;
    private javax.swing.JMenuItem saldoFacturasCompraPendeintesMnu;
    private javax.swing.JButton salirBtn;
    private javax.swing.JMenuItem setearPorcentajeCigVariosMnu;
    private javax.swing.JMenuItem stockMnu;
    private javax.swing.JMenuItem stockPeriodoProductoCompraMnu;
    private javax.swing.JMenuItem stockPeriodoProductoVentaMnu;
    private javax.swing.JMenuItem subRubrosMnu;
    private javax.swing.JTable tabla;
    private javax.swing.JMenuItem tipoDocMnu;
    private javax.swing.JMenuItem titularesDeCuitMenu;
    private javax.swing.JMenuItem todasLasAccionesMnu;
    private javax.swing.JButton tstBtn;
    private javax.swing.JTextField ultFechaTxt;
    private javax.swing.JTextField ultImpoTxt;
    private javax.swing.JTextField ultNumTxt;
    private javax.swing.JMenuItem ventasPorPeriodoMnu;
    private javax.swing.JButton verFcMpBtn;
    private javax.swing.JButton verFcPorCajasBtn;
    private javax.swing.JMenuItem verInactivosMnu;
    private javax.swing.JMenuItem verificarAfipMnu;
    private javax.swing.JMenuItem versionMnu;
    // End of variables declaration//GEN-END:variables

    private void salir() {
        System.exit(0);
    }

    private void configuracion() {
        ModificarConfiguracionTopFrame mctf = new ModificarConfiguracionTopFrame();
        mctf.setVisible(true);
        this.dispose();
    }

    private void facturar() {
        FacturarFrame ff = new FacturarFrame();
        ff.setVisible(true);
        this.dispose();
    }

    private void facturaWebUnica() {
        FacturaWeb2Frame fwf = new FacturaWeb2Frame();
        fwf.setVisible(true);
        this.dispose();
    }

    private void productos() {

    }

    private void rubros() {
        AbmRubroFrame arf = new AbmRubroFrame();
        arf.setVisible(true);
        this.dispose();
    }

    private void subRubros() {
        AbmSubRubroFrame arf = new AbmSubRubroFrame();
        arf.setVisible(true);
        this.dispose();
    }

    private void clientes() {
        AbmClienteFrame acf = new AbmClienteFrame();
        acf.setVisible(true);
        this.dispose();
    }

    private void documento() {
        AbmTipoDocForm atdf = new AbmTipoDocForm();
        atdf.setVisible(true);
        this.dispose();
    }

    private void informeVXP() {
        InformeVentasPorPeriodoFrame ivppf = new InformeVentasPorPeriodoFrame(null, null, null, null);
        ivppf.setVisible(true);
        this.dispose();
    }

    private void recuperar() {
        RecuperarDeAfipFrame ivppf = new RecuperarDeAfipFrame();
        ivppf.setVisible(true);
        this.dispose();
    }

    private void informeStock() {
        InformeStockFrame isf = new InformeStockFrame();
        isf.setVisible(true);
        this.dispose();
    }

    private void duplicadoFc() {
        DuplicadoFacturaFrame dff = new DuplicadoFacturaFrame();
        dff.setVisible(true);
        this.dispose();
    }

    private void facturaPanificados() {
        FacturaWebPanificadosFrame fwpf = new FacturaWebPanificadosFrame();
        fwpf.setVisible(true);
        this.dispose();
    }

//    private void facturarPanificados() {
//        FacturarPanificadosFrame ff = new FacturarPanificadosFrame();
//        ff.setVisible(true);
//        this.dispose();
//    }
    private void duplicadoPdf() {
        DuplicadoFacturaPdfFrame dff = new DuplicadoFacturaPdfFrame();
        dff.setVisible(true);
        this.dispose();
    }

//    private void borrarTemporales() {
//        int a = JOptionPane.showConfirmDialog(this, "CONFIRME ELIMINAR TEMPORALES", "Atención", JOptionPane.YES_NO_OPTION);
//        if (a == 0) {
//            List<RenglonFc> renglones = null;
//            try {
//                renglones = new RenglonFcService().getAllrenglones();
//            } catch (Exception ex) {
//                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            if (renglones != null && !renglones.isEmpty()) {
//                for (RenglonFc r : renglones) {
//                    try {
//                        new RenglonFcService().deleteRenglon(r);
//                    } catch (Exception ex) {
//                        Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                }
//            }
//            List<Factura> facturas = null;
//            try {
//                facturas = new FcService().getAllFacturas();
//            } catch (Exception ex) {
//                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            if (facturas != null && !facturas.isEmpty()) {
//                for (Factura fc : facturas) {
//                    try {
//                        new FcService().deleteFactura(fc);
//                    } catch (Exception ex) {
//                        Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                }
//            }
//            JOptionPane.showMessageDialog(this, "PROCESO TERMINADO");
//        }
//    }
    private void backup() {
        BackupFrame bf = new BackupFrame();
        bf.setVisible(true);
        this.dispose();
    }

    private void verProductoTopInactivos() {
        AbmProductosTopInactivosFrame apt = new AbmProductosTopInactivosFrame();
        apt.setVisible(true);
        this.dispose();
    }

    private void verProductosInactivos() {
        AbmProductosInactivosFrame aptif = new AbmProductosInactivosFrame(null);
        aptif.setVisible(true);
        this.dispose();
    }

    private void stockPeriodoProductoVenta() {
        StockPeriodoProductoFrame sppf = new StockPeriodoProductoFrame();
        sppf.setVisible(true);
        this.dispose();
    }

    private void stockPeriodoProductoCompra() {
        StockPeriodoProductoCompraFrame sppcf = new StockPeriodoProductoCompraFrame();
        sppcf.setVisible(true);
        this.dispose();
    }

    private void notaCredito() {
        NotaCreditoFrame ncf = new NotaCreditoFrame();
        ncf.setVisible(true);
        this.dispose();
    }

    private void productosUtilizados() {
        AbmProductosTopFrame apt = new AbmProductosTopFrame();
        apt.setVisible(true);
        this.dispose();
    }

    private void verificarAfip() {
        VerificarAfipFrame vaf = new VerificarAfipFrame();
        vaf.setVisible(true);
        this.dispose();
    }

    private void abmStock() {
        AbmStockFrame asf = new AbmStockFrame();
        asf.setVisible(true);
        this.dispose();
    }

    private void versionFrm() {
        VersionFrame vf = new VersionFrame();
        vf.setVisible(true);
        this.dispose();
    }

    private void importar() {
        JFileChooser selector = new JFileChooser();
        selector.showOpenDialog(this);
        File archivo = selector.getSelectedFile();
        if (archivo != null) {
            ImportarProductoFrame ipf = new ImportarProductoFrame(archivo);
            ipf.setVisible(true);
            this.dispose();
        }
    }

    private void importarMercadoPago() {
        JFileChooser selector = new JFileChooser();
        selector.showOpenDialog(this);
        File archivo = selector.getSelectedFile();
        if (archivo != null) {
            ImportarClientesMercadoPagoFrame ipf = new ImportarClientesMercadoPagoFrame(archivo);
            ipf.setVisible(true);
            this.dispose();
        }
    }

    private void facturaMercadoPago() {
//        ElegirTitularFrame etf = new ElegirTitularFrame();
        TitularCuit tf2;
        try {
            tf2 = new TitularCuitService().getTitularCuitByCuit("20300377425");
        } catch (Exception ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
        FacturarMercadoPago2Frame etf = new FacturarMercadoPago2Frame("M", tf2);
        etf.setVisible(true);
        this.dispose();
    }

    private void comprasPorImporte() {
        NuevaFacturaCompraFrame nfcf = new NuevaFacturaCompraFrame(2);
        nfcf.setVisible(true);
        this.dispose();
    }

    private void saldoPendienteFacturasCompra() {
        ArticulosConSaldoPendienteParaAsignarFrame fccsppaf = new ArticulosConSaldoPendienteParaAsignarFrame();
        fccsppaf.setVisible(true);
        this.dispose();
    }

    private void facturasMercadoPagoPendientes() {
        FacturasMercadoPagoPendientesFacturarFrame fmppff = new FacturasMercadoPagoPendientesFacturarFrame();
        fmppff.setVisible(true);
        this.dispose();
    }

    private void facturasDeMercadoPago() {
        FacturasDeMercadoPagoFrame fdmpf = new FacturasDeMercadoPagoFrame(null, null, null, null);
        fdmpf.setVisible(true);
        this.dispose();
    }

    private void facturasMercadoPagoCompletadas() {
        FacturasMercadoPagoCompletadasFacturarFrame fmppff = new FacturasMercadoPagoCompletadasFacturarFrame();
        fmppff.setVisible(true);
        this.dispose();
    }

    private void abmArticulosPorMonto() {
        AbmArticulosPorMontoFrame aapmf = new AbmArticulosPorMontoFrame();
        aapmf.setVisible(true);
        this.dispose();
    }

    private void facturaAutomPorImporte() {
        FacturarAutomaticoPorMonto3Frame fapmf = new FacturarAutomaticoPorMonto3Frame();
        fapmf.setVisible(true);
        this.dispose();
    }

    private void informeMercadoPagoCortePorDia() {
        InformeMercadoPagoCortePorDiaFrame impcpdf = new InformeMercadoPagoCortePorDiaFrame();
        impcpdf.setVisible(true);
        this.dispose();
    }

    private void informeConsFinalCortePorDia() {
        InformeConsFinalCortePorDiaFrame icfcpdf = new InformeConsFinalCortePorDiaFrame();
        icfcpdf.setVisible(true);
        this.dispose();
    }

    private void informeFacturasMpImpreso() {
        InformesImpresosFacturasMpFrame iifmf = new InformesImpresosFacturasMpFrame();
        iifmf.setVisible(true);
        this.dispose();
    }

    private void cargarFrame() {
        getContentPane().setBackground(new java.awt.Color(100, 100, 255));
        this.setLocationRelativeTo(null);
        tstBtn.setVisible(false);
        try {
            ultFechaTxt.setText(new IvaVentasService().getUltimaFechaFactura("20300377425"));
            cuitTxt.setText(new IvaVentasService().getUltimoCuitEnFactura());
            nombreTxt.setText(new IvaVentasService().getUltimaNombreEnFactura());
            ultImpoTxt.setText(new IvaVentasService().getUltimoImporteFactura("20300377425"));
            ultNumTxt.setText(new IvaVentasService().getUltimoNumeroFactura("20300377425").toString());
        } catch (Exception ex) {
            ultFechaTxt.setText("");
            ultNumTxt.setText("");
            ultImpoTxt.setText("");
            cuitTxt.setText("");
            nombreTxt.setText("");
        }
        buscarArticulos();
        limpiarTabla();
        salirBtn.requestFocus();
    }

    private void buscarArticulos() {
        articulos = null;
        try {
            articulos = new ArticuloCompraService().getAllArticulosCompra();
        } catch (Exception ex) {
            articulos = new ArrayList<>();
            ArticuloCompra av = new ArticuloCompra();
            Producto prod = new Producto();
            prod.setDetalle("NO HAY ARTICULOS PARA MOSTRAR");
            prod.setCodigo(0);
            av.setProducto(prod);
            av.setTotal(0.0);
            av.setActivo(false);
        }
    }

    private void llenarTabla() {
        UtilFrame.limpiarTabla(tabla);
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        Integer mesX = cal.get(Calendar.MONTH);
        Integer anio = cal.get(Calendar.YEAR);
        DefaultTableModel tbl = (DefaultTableModel) tabla.getModel();
        String mes[] = new String[12];
        int i = 0;
        for (Meses m : Meses.values()) {
            mes[i] = m.getDetalle();
            i += 1;
        }

        for (i = 0; i < mesX + 1; i++) {
            Double imp = 0.0;
            try {
                imp = new IvaVentasService().getFacturasByPeriodo(i + 1, anio);
            } catch (Exception ex) {
                imp = 0.0;
            }
            Object o[] = new Object[4];
            o[0] = mes[i];
            o[2] = df.format(imp);
            tbl.addRow(o);
        }
        tabla.setModel(tbl);
    }

//    private void abmComprasPorImporte() {
//        AbmFacturasComprasFrame afcf = new AbmFacturasComprasFrame();
//        afcf.setVisible(true);
//        this.dispose();
//    }
    private void modificarTabacalera() {
//        int row = tabla.getSelectedRow();
//        if (row < 0) {
//            JOptionPane.showMessageDialog(this, "SELECCIONE UNA TABACALERA PARA MODIFICAR");
//            return;
//        }
//        ArticuloCompra art = articulos.get(row);
//        ModificarArticuloCompraFrame macf = new ModificarArticuloCompraFrame(art, 2);
//        macf.setVisible(true);
//        this.dispose();
    }

    private void facturarInscriptos() {
        FacturarMercadoPagoInscriptosFrame fmpif = new FacturarMercadoPagoInscriptosFrame();
        fmpif.setVisible(true);
        this.dispose();
    }

    private void abmFabricante() {
        AbmFabricantesFrame aff = new AbmFabricantesFrame();
        aff.setVisible(true);
        this.dispose();
    }

    private void productosValoridados2() {
        ProductosValorizadosMpFrame pvf = new ProductosValorizadosMpFrame();
        pvf.setVisible(true);
        this.dispose();
    }

    private void productosValoridados1() {
        ProductosValorizadosFrame pvf = new ProductosValorizadosFrame();
        pvf.setVisible(true);
        this.dispose();
    }

    private void importarIvaCompras() {
        importarCompras();
    }

    private void limpiarTabla() {
        UtilFrame.limpiarTabla(tabla);
    }

    private void notaCreditoGrupo() {
        NotaCreditoPorGrupoFrame ncxgf = new NotaCreditoPorGrupoFrame();
        ncxgf.setVisible(true);
        this.dispose();
    }

    private void facturaManual() {
        FacturaWeb3Frame fw2f = new FacturaWeb3Frame();
        fw2f.setVisible(true);
        this.dispose();
    }

    private void todasLasAccionesProductos() {
        AbmProductoFrame apf = new AbmProductoFrame(null);
        apf.setVisible(true);
        this.dispose();
    }

    private void verFcMp() {
        VerFacturasMercadoPagoFrame vfmpf = new VerFacturasMercadoPagoFrame();
        vfmpf.setVisible(true);
        this.dispose();
    }

    private void abmTitulares() {
        AbmTitularesDeCuitFrame atcf = new AbmTitularesDeCuitFrame();
        atcf.setVisible(true);
        this.dispose();
    }

    private void productosOrdenarPorFraccion() {
        ProductosOrdenarFraccionMpFrame popff = new ProductosOrdenarFraccionMpFrame();
        popff.setVisible(true);
        this.dispose();
    }

    private void duplicadoPdfPorFecha() {
        VerFacturasByFechaFrame vfpff = new VerFacturasByFechaFrame();
        vfpff.setVisible(true);
        this.dispose();
    }

    private void setearPorcentajeCigVarios() {
        ProductoSetearPorcentajeCigVariosFrame pspcvf = new ProductoSetearPorcentajeCigVariosFrame();
        pspcvf.setVisible(true);
        this.dispose();
    }

    private void importarCompras() {
        JFileChooser selector = new JFileChooser();
        selector.showOpenDialog(this);
        File archivo = selector.getSelectedFile();
        if (archivo != null) {
            if (LectorDeExcel.validarExtension(archivo)) {
                ImportarIvaComprasFrame inf = new ImportarIvaComprasFrame(archivo);
                inf.setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "El formato elegido no está soportado.",
                        "Atencion",
                        JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "ARCHIVO EXCEL CON ERROR.",
                    "Atencion",
                    JOptionPane.WARNING_MESSAGE);
        }
    }
    
    private void facturarPorCajas() {
        FacturarPorCajasFrame fxcf = new FacturarPorCajasFrame();
        fxcf.setVisible(true);
        this.dispose();
    }

    private void verFcPorCajas() {
        VerFcPorCajasFrame cfxcf = new VerFcPorCajasFrame();
        cfxcf.setVisible(true);
        this.dispose();
    }
}
