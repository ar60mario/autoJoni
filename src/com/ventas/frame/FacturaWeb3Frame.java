package com.ventas.frame;

import com.ventas.entities.Configuracion;
import com.ventas.entities.Cliente;
import com.ventas.entities.Domicilio;
import com.ventas.entities.FacturaIvaIntercambio;
import com.ventas.entities.IvaVentas;
import com.ventas.entities.Producto;
import com.ventas.entities.RenglonFactura;
import com.ventas.entities.TitularCuit;
import com.ventas.main.MainFrame;
import com.ventas.services.ClienteService;
import com.ventas.services.ProductoService;
import com.ventas.util.UtilFrame;
import com.ventas.estructuras.Constante;
import com.ventas.services.ConfiguracionService;
import com.ventas.services.IvaVentasService;
import com.ventas.services.TitularCuitService;
import com.ventas.util.Constantes;
import com.ventas.util.UtilAfip;
import com.ventas.util.UtilFactura;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class FacturaWeb3Frame extends javax.swing.JFrame {

    private Double totalImpuestoFc;
    private Double totalIvaFc;
    private Double totalNetoFc;
    private Double diferenciaPorDescuentoUnitario;
    private Double finalCalculado;
    private Float impuestoTotal;
    private List<RenglonFactura> renglones = new ArrayList<>();
    private Double nuevoPrec;
    private Float porcentajeDescuentoVolumen = 0F;
    private Integer cantidad;
    private Double totalFinalFactura = 0.0;
    private Double descuentoVolumen = 0.0;
    private List<Cliente> clientes;
    private Double totalSaldo = 0.0;
    private Double totalFactura = 0.0;
    private Cliente cliente;
    private List<Producto> productos;
    private Producto producto;
    private Float dtoLinea = 0F;
    private Double subto = 0.0;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private final DecimalFormat dfL = new DecimalFormat("0");
    private final DecimalFormat dfD = new DecimalFormat("0");
    private final DecimalFormat df_separador_miles = new DecimalFormat("#,##0.00");
    private final Integer maxNro = 15; //44
    private final Integer maxNroHojaEntera = 15;
    private Integer nro = 0;
    private JPanel contentPanel;
    private String porcentajeDescuentoVolumen_str = "0.00";
    private String nombreClienteABuscar = "";
    private String lista_str = "0";
    private Integer indexComboClientes = 0;
    private String saldo_str = "0";
    private Integer cantidadCajas = 0;
    private Integer cantidadItems = 0;
    private Float porceIva;
    private Date fechaFactura;
    private TitularCuit titular;

    public FacturaWeb3Frame() {
        initComponents();
        limpiarCampos();
        limpiarAbajo();
        bloquearAbajo();
        habilitarArriba();
        UtilFrame.limpiarTabla(tabla);
        fechaTxt.requestFocus();
        fechaTxt.selectAll();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        nombreClienteABuscarTxt = new javax.swing.JTextField();
        comboClientes = new javax.swing.JComboBox();
        descuentoGlobalLbl = new javax.swing.JLabel();
        listaTxt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        volverBtn = new javax.swing.JButton();
        saldoTxt = new javax.swing.JTextField();
        nombreProductoABuscarTxt = new javax.swing.JTextField();
        comboProductos = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        cantidadTxt = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        cancelarBtn = new javax.swing.JButton();
        totalTxt = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        subtotalTxt = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        porcentajeDescuentoVolumenTxt = new javax.swing.JTextField();
        descuentoVolumenTxt = new javax.swing.JTextField();
        eliminarItemBtn = new javax.swing.JButton();
        leerCantidadBtn = new javax.swing.JButton();
        nuevaCantidadTxt = new javax.swing.JTextField();
        grabarCantidadBtn = new javax.swing.JButton();
        terminarBtn = new javax.swing.JButton();
        labelPrecioTxt = new javax.swing.JLabel();
        nuevoPrecioTxt = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        descuentoLineaTxt = new javax.swing.JTextField();
        resultadoTxt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        netoTxt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        ivaTxt = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        impuestoTxt = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        fechaTxt = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("GENERAR COMPROBANTE DE VENTA");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel2.setText("Nombre:");

        nombreClienteABuscarTxt.setText("FILTRO");
        nombreClienteABuscarTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nombreClienteABuscarTxtKeyPressed(evt);
            }
        });

        comboClientes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboClientesActionPerformed(evt);
            }
        });
        comboClientes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                comboClientesKeyPressed(evt);
            }
        });

        descuentoGlobalLbl.setText("Lista:");

        listaTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        listaTxt.setText("LISTA");
        listaTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                listaTxtKeyPressed(evt);
            }
        });

        jLabel3.setText("Saldo Anterior:");

        volverBtn.setText("Volver");
        volverBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverBtnActionPerformed(evt);
            }
        });

        saldoTxt.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        saldoTxt.setForeground(new java.awt.Color(0, 0, 153));
        saldoTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        saldoTxt.setText("SALDO");

        nombreProductoABuscarTxt.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        nombreProductoABuscarTxt.setText("PRODUCTO A BUSCAR");
        nombreProductoABuscarTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nombreProductoABuscarTxtKeyPressed(evt);
            }
        });

        comboProductos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboProductosActionPerformed(evt);
            }
        });
        comboProductos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                comboProductosKeyPressed(evt);
            }
        });

        jLabel7.setText("Cantidad:");

        cantidadTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        cantidadTxt.setText("CANT");
        cantidadTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cantidadTxtKeyPressed(evt);
            }
        });

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nro.", "Cant", "Detalle", "Neto", "Iva", "Impuesto", "Precio", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla);
        if (tabla.getColumnModel().getColumnCount() > 0) {
            tabla.getColumnModel().getColumn(0).setPreferredWidth(10);
            tabla.getColumnModel().getColumn(1).setPreferredWidth(10);
            tabla.getColumnModel().getColumn(2).setPreferredWidth(300);
            tabla.getColumnModel().getColumn(3).setPreferredWidth(30);
            tabla.getColumnModel().getColumn(4).setPreferredWidth(30);
            tabla.getColumnModel().getColumn(5).setPreferredWidth(30);
            tabla.getColumnModel().getColumn(6).setPreferredWidth(20);
            tabla.getColumnModel().getColumn(7).setPreferredWidth(30);
        }

        cancelarBtn.setText("Cancelar");
        cancelarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarBtnActionPerformed(evt);
            }
        });

        totalTxt.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        totalTxt.setForeground(new java.awt.Color(204, 0, 0));
        totalTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        totalTxt.setText("TOTAL");

        jLabel8.setText("Total:");

        jLabel10.setText("Subtotal:");

        subtotalTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        subtotalTxt.setText("SUBTO");

        jLabel11.setText("Dto.:");

        porcentajeDescuentoVolumenTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        porcentajeDescuentoVolumenTxt.setText("0");
        porcentajeDescuentoVolumenTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                porcentajeDescuentoVolumenTxtKeyPressed(evt);
            }
        });

        descuentoVolumenTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        descuentoVolumenTxt.setText("DESCU");

        eliminarItemBtn.setText("Eliminar Item seleccionado");
        eliminarItemBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarItemBtnActionPerformed(evt);
            }
        });

        leerCantidadBtn.setText("Editar Cantidad");
        leerCantidadBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leerCantidadBtnActionPerformed(evt);
            }
        });

        nuevaCantidadTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        nuevaCantidadTxt.setText("N C");
        nuevaCantidadTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nuevaCantidadTxtKeyPressed(evt);
            }
        });

        grabarCantidadBtn.setText("Grabar Cantidad");
        grabarCantidadBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                grabarCantidadBtnActionPerformed(evt);
            }
        });

        terminarBtn.setText("Terminar");
        terminarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                terminarBtnActionPerformed(evt);
            }
        });
        terminarBtn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                terminarBtnKeyPressed(evt);
            }
        });

        labelPrecioTxt.setText("Precio:");

        nuevoPrecioTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        nuevoPrecioTxt.setText("PRECIO");
        nuevoPrecioTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nuevoPrecioTxtKeyPressed(evt);
            }
        });

        jLabel1.setText("Dto.:");

        descuentoLineaTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        descuentoLineaTxt.setText("DTO");
        descuentoLineaTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                descuentoLineaTxtKeyPressed(evt);
            }
        });

        resultadoTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        resultadoTxt.setText("RESULTADO");
        resultadoTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                resultadoTxtKeyPressed(evt);
            }
        });

        jLabel4.setText("Neto Total:");

        netoTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        netoTxt.setText("NETO");

        jLabel5.setText("Iva Total:");

        ivaTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        ivaTxt.setText("IVA");

        jLabel6.setText("Impuesto Total:");

        impuestoTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        impuestoTxt.setText("IMPUESTO");

        fechaTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fechaTxt.setText("FECHA");
        fechaTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fechaTxtKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(cantidadTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(nombreProductoABuscarTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(comboProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(labelPrecioTxt)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(nuevoPrecioTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(descuentoLineaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelLayout.createSequentialGroup()
                                .addComponent(fechaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nombreClienteABuscarTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(comboClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(descuentoGlobalLbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(listaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(saldoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(volverBtn))
                            .addComponent(resultadoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(netoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ivaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(impuestoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelLayout.createSequentialGroup()
                                .addComponent(eliminarItemBtn)
                                .addGap(18, 18, 18)
                                .addComponent(leerCantidadBtn)
                                .addGap(18, 18, 18)
                                .addComponent(nuevaCantidadTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(grabarCantidadBtn)))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                                .addComponent(cancelarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(terminarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18)
                                .addComponent(subtotalTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(porcentajeDescuentoVolumenTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(descuentoVolumenTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(totalTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(19, 19, 19))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nombreClienteABuscarTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(descuentoGlobalLbl)
                    .addComponent(listaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(volverBtn)
                    .addComponent(saldoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fechaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombreProductoABuscarTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(cantidadTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelPrecioTxt)
                    .addComponent(nuevoPrecioTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(descuentoLineaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(resultadoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(subtotalTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel4)
                    .addComponent(netoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(ivaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(impuestoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(descuentoVolumenTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(porcentajeDescuentoVolumenTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(totalTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(eliminarItemBtn)
                    .addComponent(leerCantidadBtn)
                    .addComponent(nuevaCantidadTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(grabarCantidadBtn)
                    .addComponent(terminarBtn)
                    .addComponent(cancelarBtn))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarBtnActionPerformed
        volver();
    }//GEN-LAST:event_cancelarBtnActionPerformed

    private void comboClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboClientesActionPerformed
        if (evt.getModifiers() == 16) {
            int row = comboClientes.getSelectedIndex();
            if (row > 0) {
                cargarCliente();
            }
        }
    }//GEN-LAST:event_comboClientesActionPerformed

    private void comboProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboProductosActionPerformed
        if (evt.getModifiers() == 16) {
            int row = comboProductos.getSelectedIndex();
            if (row > 0) {
                Producto p = productos.get(row - 1);
                buscarProductoPorCodigo(p.getCodigo());
            }
        }
    }//GEN-LAST:event_comboProductosActionPerformed

    private void terminarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_terminarBtnActionPerformed
        int a = JOptionPane.showConfirmDialog(this, "VERIFICO LA FECHA DEL COMPROBANTE?", "Atenci n", JOptionPane.YES_NO_OPTION);
        if (a == 0) {
            terminarComprobante();
        } else {
            fechaTxt.setEditable(true);
            fechaTxt.requestFocus();
            fechaTxt.selectAll();
        }
    }//GEN-LAST:event_terminarBtnActionPerformed

    private void volverBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverBtnActionPerformed
        volver();
    }//GEN-LAST:event_volverBtnActionPerformed

    private void cantidadTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cantidadTxtKeyPressed
        if (evt.getKeyCode() == 10) {
            if (!cantidadTxt.getText().isEmpty()) {
                nombreProductoABuscarTxt.requestFocus();
            }
        }

    }//GEN-LAST:event_cantidadTxtKeyPressed

    private void eliminarItemBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarItemBtnActionPerformed
        int row = tabla.getSelectedRow();
        int rows = tabla.getRowCount();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "SELECCIONE ITEM A ELIMINAR");
            return;
        }
        if (rows == 1) {
            subtotalTxt.setText("");
            nro -= 1;
            cantidadItems -= 1;
            descuentoVolumenTxt.setText("");
            totalTxt.setText("");
//            renglones = new ArrayList<>();
            cantidadTxt.requestFocus();
            DefaultTableModel tbl = (DefaultTableModel) tabla.getModel();
            tbl.removeRow(0);
            tabla.setModel(tbl);
            return;
        }
        DefaultTableModel tbl = (DefaultTableModel) tabla.getModel();
        tbl.removeRow(row);
        nro -= 1;
        tabla.setModel(tbl);
//        renglones.remove(row);
        calcularTotal();
    }//GEN-LAST:event_eliminarItemBtnActionPerformed

    private void nombreClienteABuscarTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombreClienteABuscarTxtKeyPressed
        if (evt.getKeyCode() == 10) {
            if (!nombreClienteABuscarTxt.getText().isEmpty()) {
                buscarClientePorNombre();
            }
        }
    }//GEN-LAST:event_nombreClienteABuscarTxtKeyPressed

    private void nombreProductoABuscarTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombreProductoABuscarTxtKeyPressed
        if (evt.getKeyCode() == 10) {
            if (nombreProductoABuscarTxt.getText().isEmpty()) {
            } else {
                buscarProductoPorNombre();
            }
        }
    }//GEN-LAST:event_nombreProductoABuscarTxtKeyPressed


    private void leerCantidadBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leerCantidadBtnActionPerformed
//        int lin = tablaFactura.getSelectedRow();
//        tablaFactura.setEnabled(false);
//        if (lin > -1) {
//            ActivityRow rf = renglonFactura.get(lin);
//            if (rf.getDescuento() > 0.0) {
//                JOptionPane.showMessageDialog(this, "NO PERMITIDO CAMBIAR CANTIDAD");
//                tablaFactura.setEnabled(true);
//                agregarBtn.requestFocus();
//                return;
//            }
//            nuevaCantidadTxt.setEditable(true);
//            nuevaCantidadTxt.setText(String.valueOf(rf.getCantidad().intValue()));
//            leerCantidadBtn.setEnabled(false);
//            grabarCantidadBtn.setEnabled(true);
//            leerPrecioBtn.setEnabled(false);
//            grabarPrecioBtn.setEnabled(false);
//            tablaFactura.setEnabled(false);
//            agregarBtn.setEnabled(false);
//            eliminarItemBtn.setEnabled(false);
//            terminarBtn.setEnabled(false);
//            nuevoPrecioTxt.setEnabled(false);
//            recalcularBtn.setEnabled(false);
//        }
    }//GEN-LAST:event_leerCantidadBtnActionPerformed

    private void grabarCantidadBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_grabarCantidadBtnActionPerformed
//        int lin = tablaFactura.getSelectedRow();
//        tablaFactura.setEnabled(true);
//        if (lin > -1) {
//            if (!nuevaCantidadTxt.getText().isEmpty()) {
//                leerCantidadBtn.setEnabled(true);
//                leerPrecioBtn.setEnabled(true);
//                nuevoPrecioTxt.setEnabled(true);
//                grabarCantidadBtn.setEnabled(false);
//                ActivityRow rf = renglonFactura.get(lin);
//                cantidad = Float.valueOf(nuevaCantidadTxt.getText());
//                if (!(cantidad > 0.0)) {
//                    JOptionPane.showMessageDialog(this, "Debe colocar cantidad mayor que cero");
//                    return;
//                }
//                int cp = rf.getCodigoProducto();
//                Producto pro = null;
//                try {
//                    pro = new ProductoService().getProductoByCodigo(cp);
//                } catch (Exception ex) {
//                    Logger.getLogger(FacturaFrame.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                Double prex = rf.getPrecioUnitario();
//                //prex = prex / (1 + porcentualIva / 100);
//                calcularLinea(pro, prex, cantidad);
//                rf.setCantidad(cantidad);
//                rf.setDescripcion(pro.getDetalle());
//                rf.setDescuento(descuento);
//                rf.setExento(0.0);
//                rf.setGravado(gravado);
//                rf.setImpuesto(impuesto);
//                rf.setIva(iva);
//                rf.setNoGravado(noGravado);
//                rf.setCodigoProducto(pro.getCodigo());
//                rf.setSugerido(pro.getSugerido());
//                rf.setTotal(totalLinea);
//                renglonFactura.set(lin, rf);
//                tablaFactura.setValueAt(cantidad.intValue(), lin, 1);
//                // en unidad
//                tablaFactura.setValueAt(df.format(precioFinal), lin, 3);
//                nuevaCantidadTxt.setText("");
//
//                // por cantidad
//                tablaFactura.setValueAt(df.format(gravado), lin, 4);
//                tablaFactura.setValueAt(df.format(impuesto), lin, 5);
//                tablaFactura.setValueAt(df.format(iva), lin, 6);
//                tablaFactura.setValueAt(df.format(totalLinea), lin, 8);
//                tablaFactura.setEnabled(true);
//                agregarBtn.setEnabled(true);
//                eliminarItemBtn.setEnabled(true);
//                terminarBtn.setEnabled(true);
//                nuevoPrecioTxt.setEnabled(true);
//                leerPrecioBtn.setEnabled(true);
//                recalcularBtn.setEnabled(true);
//                calcularTotales();
//            }
//            agregarBtn.requestFocus();
//        }
    }//GEN-LAST:event_grabarCantidadBtnActionPerformed

    private void comboClientesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_comboClientesKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (comboClientes.getSelectedIndex() > 0) {
                cargarCliente();
            }
        }
    }//GEN-LAST:event_comboClientesKeyPressed

    private void comboProductosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_comboProductosKeyPressed
        if (evt.getKeyCode() == 10) {
            int row = comboProductos.getSelectedIndex();
            if (row > 0) {
                Producto p = productos.get(row - 1);
                Integer codigo = p.getCodigo();
                buscarProductoPorCodigo(codigo);
            }
        }
    }//GEN-LAST:event_comboProductosKeyPressed


    private void nuevaCantidadTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nuevaCantidadTxtKeyPressed
//        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
//            int lin = tablaFactura.getSelectedRow();
//            tablaFactura.setEnabled(true);
//            if (lin > -1) {
//                if (!nuevaCantidadTxt.getText().isEmpty()) {
//                    leerCantidadBtn.setEnabled(true);
//                    leerPrecioBtn.setEnabled(true);
//                    nuevaCantidadTxt.setEditable(false);
//                    grabarCantidadBtn.setEnabled(false);
//                    ActivityRow rf = renglonFactura.get(lin);
//                    cantidad = Float.valueOf(nuevaCantidadTxt.getText());
//                    if (!(cantidad > 0.0)) {
//                        JOptionPane.showMessageDialog(this, "Debe colocar cantidad mayor que cero");
//                        return;
//                    }
//                    int cp = rf.getCodigoProducto();
//                    Producto pro = null;
//                    try {
//                        pro = new ProductoService().getProductoByCodigo(cp);
//                    } catch (Exception ex) {
//                        Logger.getLogger(FacturaFrame.class.getName()).log(Level.SEVERE, null, ex);
//                    }
////                    System.out.println(rf.getPrecioUnitario());
////                    JOptionPane.showMessageDialog(this, pro);
//                    Double prex = rf.getPrecioUnitario();
//                    //prex = prex / (1 + porcentualIva / 100);
//                    calcularLinea(pro, prex, cantidad);
//                    rf.setCantidad(cantidad);
//                    rf.setDescripcion(pro.getDetalle());
//                    rf.setDescuento(descuento);
//                    rf.setExento(0.0);
//                    rf.setGravado(gravado);
//                    rf.setImpuesto(impuesto);
//                    rf.setIva(iva);
//                    rf.setNoGravado(noGravado);
//                    rf.setCodigoProducto(pro.getCodigo());
//                    rf.setSugerido(pro.getSugerido());
//                    rf.setTotal(totalLinea);
//                    renglonFactura.set(lin, rf);
//                    tablaFactura.setValueAt(cantidad.intValue(), lin, 1);
//                    // en unidad
//                    tablaFactura.setValueAt(df.format(precioFinal), lin, 3);
//                    nuevaCantidadTxt.setText("");
//
//                    // por cantidad
//                    tablaFactura.setValueAt(df.format(gravado), lin, 4);
//                    tablaFactura.setValueAt(df.format(impuesto), lin, 5);
//                    tablaFactura.setValueAt(df.format(iva), lin, 6);
//                    tablaFactura.setValueAt(df.format(totalLinea), lin, 8);
//                    tablaFactura.setEnabled(true);
//                    agregarBtn.setEnabled(true);
//                    eliminarItemBtn.setEnabled(true);
//                    terminarBtn.setEnabled(true);
//                    nuevoPrecioTxt.setEnabled(true);
//                    leerPrecioBtn.setEnabled(true);
//                    recalcularBtn.setEnabled(true);
//                    calcularTotales();
//                }
//            }
//            agregarBtn.requestFocus();
//        }
    }//GEN-LAST:event_nuevaCantidadTxtKeyPressed

    private void listaTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_listaTxtKeyPressed
//        if (evt.getKeyCode() == 10) {
//            if (listaTxt.getText().isEmpty()) {
//                listaTxt.setText("1");
//            }
//            lista = Integer.valueOf(listaTxt.getText());
//            bloquearArriba();
//            habilitarAbajo();
//        }
    }//GEN-LAST:event_listaTxtKeyPressed

    private void terminarBtnKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_terminarBtnKeyPressed
        if (evt.getKeyCode() == 10) {
            terminarComprobante();
        }
    }//GEN-LAST:event_terminarBtnKeyPressed

    private void porcentajeDescuentoVolumenTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_porcentajeDescuentoVolumenTxtKeyPressed
        if (evt.getKeyCode() == 10) {
            if (!porcentajeDescuentoVolumenTxt.getText().isEmpty()) {
                porcentajeDescuentoVolumen = Float.valueOf(porcentajeDescuentoVolumenTxt.getText().replace(",", "."));
                calcularTotal();
                descuentoVolumen = subto * (porcentajeDescuentoVolumen / 100);
                totalFinalFactura = subto - descuentoVolumen;
                descuentoVolumenTxt.setText(df_separador_miles.format(descuentoVolumen));
                totalTxt.setText(df_separador_miles.format(totalFinalFactura));
            }
        }
    }//GEN-LAST:event_porcentajeDescuentoVolumenTxtKeyPressed

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
        if (evt.getButton() == 3) {
            int row = tabla.getSelectedRow();
            if (!(row < 0)) {
//                CambiarCantidadPrecioDescuentoFrame ccpdf
//                        = new CambiarCantidadPrecioDescuentoFrame(renglones,
//                                porcentajeDescuentoVolumen,
//                                nombreClienteABuscarTxt.getText(),
//                                clientes,
//                                listaTxt.getText(),
//                                comboClientes.getSelectedIndex(),
//                                saldoTxt.getText(),
//                                cliente,
//                                row);
//                ccpdf.setVisible(true);
//                this.dispose();
            }
        }
    }//GEN-LAST:event_tablaMouseClicked

    private void nuevoPrecioTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nuevoPrecioTxtKeyPressed
        if (evt.getKeyCode() == 10) {
            if (!nuevoPrecioTxt.getText().isEmpty()) {
                String np = nuevoPrecioTxt.getText().replace("$", "");
                np = np.replace(".", "");
                np = np.replace(",", ".");
                nuevoPrec = Double.valueOf(np);
                calcular_2();
//                resultadoTxt.setText(nuevoPrecioTxt.getText());
//                resultadoTxt.requestFocus();
            }
        }
    }//GEN-LAST:event_nuevoPrecioTxtKeyPressed

    private void descuentoLineaTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_descuentoLineaTxtKeyPressed
        if (evt.getKeyCode() == 10) {
//            calcularConDescuento();
//            calcularConPrecioCero();
        }
    }//GEN-LAST:event_descuentoLineaTxtKeyPressed

    private void resultadoTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_resultadoTxtKeyPressed

    }//GEN-LAST:event_resultadoTxtKeyPressed

    private void fechaTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fechaTxtKeyPressed
        if (evt.getKeyCode() == 10) {
            String fe = fechaTxt.getText();
            int largo = fe.length();
            if (largo == 10) {
                try {
                    fechaFactura = sdf.parse(fe);
                    if (verificarFecha(fechaFactura)) {
                        nombreClienteABuscarTxt.requestFocus();
                    }
                } catch (ParseException ex) {
                    JOptionPane.showMessageDialog(this, "ERROR EN FECHA");
                    fechaTxt.requestFocus();
                    return;
                }
            } else {
                if (largo > 10) {
                    JOptionPane.showMessageDialog(this, "ERROR EN LARGO DE FECHA");
                    return;
                }
            }
            fe = UtilFrame.fecha(fe);
            fechaTxt.setText(fe);
        }
    }//GEN-LAST:event_fechaTxtKeyPressed

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
            java.util.logging.Logger.getLogger(FacturaWeb3Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FacturaWeb3Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FacturaWeb3Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FacturaWeb3Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new FacturaWeb3Frame().setVisible(true);//null, null, null, null, null, null, null, null
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelarBtn;
    private javax.swing.JTextField cantidadTxt;
    private javax.swing.JComboBox comboClientes;
    private javax.swing.JComboBox comboProductos;
    private javax.swing.JLabel descuentoGlobalLbl;
    private javax.swing.JTextField descuentoLineaTxt;
    private javax.swing.JTextField descuentoVolumenTxt;
    private javax.swing.JButton eliminarItemBtn;
    private javax.swing.JTextField fechaTxt;
    private javax.swing.JButton grabarCantidadBtn;
    private javax.swing.JTextField impuestoTxt;
    private javax.swing.JTextField ivaTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel labelPrecioTxt;
    private javax.swing.JButton leerCantidadBtn;
    private javax.swing.JTextField listaTxt;
    private javax.swing.JTextField netoTxt;
    private javax.swing.JTextField nombreClienteABuscarTxt;
    private javax.swing.JTextField nombreProductoABuscarTxt;
    private javax.swing.JTextField nuevaCantidadTxt;
    private javax.swing.JTextField nuevoPrecioTxt;
    private javax.swing.JPanel panel;
    private javax.swing.JTextField porcentajeDescuentoVolumenTxt;
    private javax.swing.JTextField resultadoTxt;
    private javax.swing.JTextField saldoTxt;
    private javax.swing.JTextField subtotalTxt;
    private javax.swing.JTable tabla;
    private javax.swing.JButton terminarBtn;
    private javax.swing.JTextField totalTxt;
    private javax.swing.JButton volverBtn;
    // End of variables declaration//GEN-END:variables

    private void limpiarCampos() {
        String str0 = "FACTURA A"; // + " " + str1;
        fechaTxt.setText(sdf.format(new Date()));
        netoTxt.setText("");
        ivaTxt.setText("");
        impuestoTxt.setText("");
        resultadoTxt.setVisible(false);
        contentPanel = panel;
        contentPanel.setBackground(new java.awt.Color(Constante.getR(), Constante.getG(), Constante.getB()));
        JFrame jFrame = FacturaWeb3Frame.this;
        jFrame.setLocationRelativeTo(null);
        contentPanel.setBorder(new EmptyBorder(5, 5, 100, 5));
        contentPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED),
                str0, TitledBorder.LEFT, TitledBorder.BELOW_BOTTOM));
        jFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        jFrame.setTitle("GENERAR FACTURA DE VENTA A");
        setContentPane(contentPanel);
        jFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                volver();
            }
        });
        leerCantidadBtn.setVisible(false);
        nuevaCantidadTxt.setVisible(false);
        grabarCantidadBtn.setVisible(false);
        eliminarItemBtn.setVisible(true);
        descuentoLineaTxt.setText("0");
        resultadoTxt.setText("");
        nuevoPrecioTxt.setText("");
        descuentoGlobalLbl.setVisible(false);
        listaTxt.setVisible(false);
        jLabel1.setVisible(false);
        descuentoLineaTxt.setVisible(false);
        Configuracion cfg = null;
        try {
            cfg = new ConfiguracionService().getFacturas(1L);
        } catch (Exception ex) {
            Logger.getLogger(FacturaWeb3Frame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "ERROR 921 - CARGANDO PARAMETROS");
            return;
        }
        porceIva = cfg.getIva();
        try {
            titular = new TitularCuitService().getTitularCuitByCuit("20300377425");
        } catch (Exception ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "ERROR Nro.1035");
            return;
        }
        limpiarCliente();
        limpiarProducto();
        limpiarTabla();
    }

    private Boolean verificarFecha(Date fecha) {
        Date hoy = new Date();
        if (fecha.after(hoy)) {
            JOptionPane.showMessageDialog(this, "NO PUEDE FACTURAR CON FECHA POSTERIOR A HOY");
            fechaTxt.requestFocus();
            return false;
        }
        try {
            String ultimaFecha = UtilFrame.ultimaFecha(titular.getCuit());//
            Date ulti = sdf.parse(ultimaFecha);
            if (fecha.before(ulti)) {
                JOptionPane.showMessageDialog(this, "NO PUEDE FACTURAR CON FECHA ANTERIOR A ULTIMA");
                fechaTxt.requestFocus();
                return false;
            }
            Date f5d = new Date();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(f5d);
            calendar.add(Calendar.DATE, -6);
            f5d = calendar.getTime();
            if (fecha.before(f5d)) {
                JOptionPane.showMessageDialog(this, "NO DEBE SUPERAR 5 DIAS ATRAS");
                return false;
            }
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, "ERROR EN FECHAS");
            fechaTxt.requestFocus();
            return false;
        }
        return true;
    }

    private void limpiarCliente() {
        listaTxt.setText("");
        nombreClienteABuscarTxt.setText("");
        saldoTxt.setText("");
        comboClientes.removeAllItems();
        comboClientes.addItem("");
        clientes = null;
        try {
//            clientes = new ClienteService().getAllClientesActivos();
        } catch (Exception ex) {
            Logger.getLogger(FacturaWeb3Frame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "ERROR Nro. 909 - CLIENTES");
            return;
        }
        if (clientes != null && !clientes.isEmpty()) {
            for (Cliente c : clientes) {
                comboClientes.addItem(c.getRazonSocial());
            }
        }
    }

    private void limpiarProducto() {
        cantidadTxt.setText("");
        nombreProductoABuscarTxt.setText("");
        descuentoVolumenTxt.setText("");
        totalTxt.setText("");
        subtotalTxt.setText("");
        nuevaCantidadTxt.setText("");
        comboProductos.removeAllItems();
    }

    private void limpiarTabla() {
        UtilFrame.limpiarTabla(tabla);
    }

    private void buscarClientePorNombre() {
        String filtro = nombreClienteABuscarTxt.getText();
        comboClientes.removeAllItems();
        comboClientes.addItem("");
        clientes = null;
        try {
            clientes = new ClienteService().getClientesByFiltroFacturaA(filtro);
        } catch (Exception ex) {
            Logger.getLogger(FacturaWeb3Frame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "ERROR 1000 - CLIENTES");
            return;
        }
        if (clientes != null && !clientes.isEmpty()) {
            for (Cliente c : clientes) {
                comboClientes.addItem(c.getRazonSocial());
            }
            comboClientes.addFocusListener(null);
            comboClientes.showPopup();
            comboClientes.requestFocus();
        }
    }

    private void volver() {
        MainFrame mf = new MainFrame();
        mf.setVisible(true);
        this.dispose();
    }

    private void buscarProductoPorCodigo(Integer cod) {
        producto = null;
        try {
            producto = new ProductoService().getProductoByCodigo(cod);
//            System.out.println(producto.getCodigo());
//            System.out.println(producto.getDetalle());
//            System.out.println(producto.getImpuesto());
//            System.exit(0);
        } catch (Exception ex) {
            Logger.getLogger(FacturaWeb3Frame.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
        if (producto != null) {
            if (existeProducto(producto)) {
                JOptionPane.showMessageDialog(this, "PRODUCTO DUPLICADO");
                return;
            }
            dtoLinea = 0F;
            cantidad = Integer.valueOf(cantidadTxt.getText().replace(",", "."));
            nombreProductoABuscarTxt.setText(producto.getDetalle());
            Integer resultado = calcular();
            if (resultado.equals(0)) {
                cantidadTxt.requestFocus();
            }
            if (resultado.equals(3)) {
                nuevoPrecioTxt.setText("");
                descuentoLineaTxt.setText("0");
                resultadoTxt.setText("");
                comboProductos.removeAllItems();
                comboProductos.addItem("");
                cantidadTxt.setText("");
                nombreProductoABuscarTxt.setText("");
                cantidadTxt.requestFocus();
                return;
            }
//            costoTxt.setText(df_separador_miles.format(producto.getPrecio().getPrecioCosto()));
            nuevoPrecioTxt.requestFocus();
        }
    }

    private void buscarProductoPorNombre() {
        String filtro = nombreProductoABuscarTxt.getText();
        comboProductos.removeAllItems();
        comboProductos.addItem("");
        productos = null;
        try {
            productos = new ProductoService().getProductosByFiltro2(filtro);
        } catch (Exception ex) {
            Logger.getLogger(FacturaWeb3Frame.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (productos != null && !productos.isEmpty()) {
            productos.forEach((p) -> { // es for(Producto p:productos)
                comboProductos.addItem(p.getCodigo() + " " + p.getDetalle());
            });
            comboProductos.addFocusListener(null);
            comboProductos.showPopup();
            comboProductos.requestFocus();
        }
    }

    private void calcular_2() {
        Double precioUnitario = nuevoPrec;
        Double gravado = producto.getPrecio() * cantidad;
        Double precioTotal = precioUnitario * cantidad;
        impuestoTotal = producto.getImpuesto() * cantidad;
        precioTotal = UtilFactura.calcularRedondeo(precioTotal);
        impuestoTotal = UtilFactura.calcularRedondeoF(impuestoTotal);
        gravado = UtilFactura.calcularRedondeo(gravado);
        Double ivaCalc = precioTotal - impuestoTotal - gravado;
        ivaCalc = UtilFactura.calcularRedondeo(ivaCalc);
        cantidad = Integer.valueOf(cantidadTxt.getText());
        nro += 1;
        DefaultTableModel tbl = (DefaultTableModel) tabla.getModel();
        RenglonFactura rf = new RenglonFactura();
        rf.setCantidad(cantidad.floatValue());
        rf.setCostoG(0.0);
        rf.setCostoI(0.0);
        rf.setDescripcion(producto.getDetalle());
        rf.setDescuento(0.0);
        rf.setExento(0.0);
        rf.setFabricacion(false);
        rf.setGravado(gravado);
        rf.setGravado0(0.0);
        rf.setGravado10_5(0.0);
        rf.setGravado27(0.0);
        rf.setImpuesto(impuestoTotal.doubleValue());
        rf.setItemNro(nro);
        rf.setIva(ivaCalc);
        rf.setIva0(0.0);
        rf.setIva10_5(0.0);
        rf.setIva27(0.0);
        rf.setNoGravado(0.0);
        rf.setProducto(producto);
        rf.setSugerido(0.0);
        rf.setTotal(precioTotal);
        renglones.add(rf);
        Object o[] = new Object[8];
        o[0] = nro;
        o[1] = cantidad;
        o[2] = producto.getDetalle();
        o[3] = df_separador_miles.format(gravado);
        o[4] = df_separador_miles.format(ivaCalc);
        o[5] = df_separador_miles.format(impuestoTotal);
        o[6] = df_separador_miles.format(precioUnitario);
        o[7] = df_separador_miles.format(precioTotal);
        tbl.addRow(o);
        cantidadCajas += cantidad;
        cantidadItems += 1;
        Rectangle rect = tabla.getCellRect(cantidadItems - 1, 0, true);
        tabla.scrollRectToVisible(rect);
        tabla.clearSelection();
        tabla.setRowSelectionInterval(cantidadItems - 1, cantidadItems - 1);
        tabla.setModel(tbl);
        calcularTotal();
        limpiarCargaAbajo();
        if (cantidadItems > maxNroHojaEntera) {
            JOptionPane.showMessageDialog(this, "LLEGO AL MAXIMO DE PRODUCTOS");
            terminarBtn.requestFocus();
            bloquearAbajoFinal();
        }
    }

    private Integer calcular() {
        Double precio = producto.getPrecio();
        Float impuesto = producto.getImpuesto();
        precio = precio * (1 + porceIva / 100) + impuesto;
        precio = UtilFactura.calcularRedondeo(precio);
        nuevoPrecioTxt.setText(df_separador_miles.format(precio));
        nuevoPrecioTxt.setVisible(true);
        nuevoPrecioTxt.requestFocus();
        nuevoPrecioTxt.selectAll();
        return 0;
    }

    private void bloquearAbajo() {
        cantidadTxt.setEnabled(false);
        nombreProductoABuscarTxt.setEnabled(false);
        comboProductos.setEnabled(false);
        nuevaCantidadTxt.setEnabled(false);
        descuentoVolumenTxt.setEnabled(false);
        totalTxt.setEnabled(false);
        eliminarItemBtn.setEnabled(false);
        leerCantidadBtn.setEnabled(false);
        grabarCantidadBtn.setEnabled(false);
        cancelarBtn.setEnabled(false);
        terminarBtn.setEnabled(false);
    }

    private void bloquearArriba() {
        nombreClienteABuscarTxt.setEnabled(false);
        saldoTxt.setEnabled(false);
        listaTxt.setEnabled(false);
        comboClientes.setEnabled(false);
        volverBtn.setEnabled(false);
        habilitarAbajo();
    }

    private void habilitarAbajo() {
        cantidadTxt.setEnabled(true);
        nombreProductoABuscarTxt.setEnabled(true);
        comboProductos.setEnabled(true);
        descuentoVolumenTxt.setEnabled(true);
        descuentoVolumenTxt.setEditable(false);
        totalTxt.setEnabled(true);
        totalTxt.setEditable(false);
        eliminarItemBtn.setEnabled(true);
        cancelarBtn.setEnabled(true);
        terminarBtn.setEnabled(true);
    }

    private void limpiarAbajo() {
        cantidadTxt.setText("");
        nro = 0;
        nombreProductoABuscarTxt.setText("");
        comboProductos.removeAllItems();
        comboProductos.addItem("");
        nuevaCantidadTxt.setText("");
        descuentoVolumenTxt.setText("");
        totalTxt.setText("");
    }

    private void habilitarArriba() {
        nombreClienteABuscarTxt.setEnabled(true);
        saldoTxt.setEnabled(true);
        listaTxt.setEnabled(true);
        comboClientes.setEnabled(true);
        volverBtn.setEnabled(true);
    }

    private void limpiarCargaAbajo() {
        cantidadTxt.setText("");
        nombreProductoABuscarTxt.setText("");
        comboProductos.removeAllItems();
        comboProductos.addItem("");
        nuevoPrecioTxt.setText("");
        descuentoLineaTxt.setText("0");
        resultadoTxt.setText("");
        cantidadTxt.requestFocus();
    }

    private void terminarComprobante() {
        terminarBtn.setEnabled(false);
//        JOptionPane.showMessageDialog(this, "TERMINAR COMPROBANTE");
        porcentajeDescuentoVolumen = Float.valueOf(porcentajeDescuentoVolumenTxt.getText().replace(",", "."));
        Date fecha = new Date();
        try {
            fecha = sdf.parse(fechaTxt.getText());
        } catch (ParseException ex) {
            Logger.getLogger(FacturaWeb3Frame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "ERROR Nro. 1359");
            return;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(fecha);
//        Integer nroComprob;
//        Configuracion cnf;
////        List<StockCuentaCorriente> listaStockCtaCte = new ArrayList<>();
//        try {
//            cnf = new ConfiguracionService().getFacturas(1L);
//            if (cnf.getNumeroFacturaA() != null) {
//                nroComprob = cnf.getNumeroFacturaA();
//                nroComprob += 1;
//            } else {
//                nroComprob = 1;
//            }
//        } catch (Exception ex) {
//            Logger.getLogger(FacturaWeb3Frame.class.getName()).log(Level.SEVERE, null, ex);
//            nroComprob = 1;
//        }

        String cuitTitular = Constantes.cuitTitular;
        String tipoDocTit = Constantes.tipoDocTit;
        String puntoVenta = Constantes.puntoVenta;
        String cuitCli = cliente.getCuit();
        String pri;// = cui.substring(0, 2);
        String med;// = cui.substring(3, 11);
        String fin;// = cui.substring(12, 13);
        pri = cuitCli.substring(0, 2);
        med = cuitCli.substring(3, 11);
        fin = cuitCli.substring(12, 13);
        String cuitCliente = pri + med + fin;
        String tipoDocCli = "80";
//        System.out.println(fecha);
//        System.exit(0);
        FacturaIvaIntercambio fii = UtilAfip.presentarArcaFcA(cuitTitular, tipoDocTit, cuitCliente,
                tipoDocCli, totalNetoFc, totalImpuestoFc, totalIvaFc,
                totalFinalFactura, fecha, puntoVenta);

        if (fii != null) {
            IvaVentas iv = new IvaVentas();
            Domicilio dmc = cliente.getDomicilio();
            iv.setCae(fii.getCae());
            iv.setCalleNroCliente(dmc.getCalle() + " "
                    + dmc.getNumero());
            iv.setCalleNroTitular(titular.getCalleNroPisoDto());
            iv.setCliente(cliente);
            iv.setCpLocalidadProvinciaCliente(dmc.getCodigoPostal()
                    + " " + dmc.getLocalidad()
                    + " " + dmc.getProvincia());
            iv.setCpLocalidadProvinciaTitular(titular.getCpLocalidadProvincia());
            iv.setCuitCliente(pri + "-" + med + "-" + fin);
            iv.setCuitTitular(titular.getCuit());
            iv.setDescripcion("Manual");
            iv.setDescuentoGlobal(descuentoVolumen);
            iv.setExento(0.0);
            iv.setFecha(fecha);
            iv.setFechaCae(fii.getFechaVencimientoCae());
            iv.setGravado(totalNetoFc);
            iv.setGravado0(0.0);
            iv.setGravado10_5(0.0);
            iv.setGravado27(0.0);
            iv.setIibbTitular(Constantes.iibbTitular);
            iv.setImpuesto(totalImpuestoFc);
            iv.setInicioActividades(Constantes.inicioActividades);
            iv.setIva(totalIvaFc);
            iv.setIva0(0.0);
            iv.setIva10_5(0.0);
            iv.setIva27(0.0);
            iv.setLetra("A");
            iv.setLetraReferencia("x");
            iv.setNoGravado(0.0);
            iv.setNumeroFactura(fii.getNumero());
            iv.setNumeroFacturaReferencia(0);
            iv.setNumeroSucursal(fii.getSucursal());
            iv.setNumeroSucursalReferencia(0);
            iv.setOperacion("");
            iv.setRazonSocialTitular(titular.getRazonSocial());
            iv.setRazonSocialCliente(cliente.getRazonSocial());
            iv.setTipoDoc(1);
            iv.setTotal(totalFinalFactura);
            try {
                new IvaVentasService().saveIvaVentasCompleto(iv, renglones);
            } catch (Exception ex) {
                Logger.getLogger(FacturaWeb3Frame.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "ERROR Nro.1415");
                return;
            }
            for (RenglonFactura rf : renglones) {
                Producto pro = rf.getProducto();
                Float st = pro.getStock();
                Float newStock = st - rf.getCantidad();
                pro.setStock(newStock);
                try {
                    new ProductoService().updateProducto(producto);
                } catch (Exception ex) {
                    Logger.getLogger(FacturaWeb3Frame.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(this, "ERROR Nro. 1443");
                    return;
                }
            }
            JOptionPane.showMessageDialog(this, "FACTURA GENERADA");
            volver();
        }
    }

//                for(StockCuentaCorriente scc_a :listaStockCtaCte){
//                    System.out.println(scc_a.getProducto().getDetalle());
//                    System.out.println(scc_a.getRenglonesVenta().getProducto().getDetalle());
//                    JOptionPane.showMessageDialog(this, "M VER M");
//                }
//                try {
//                    new ComprobanteService().saveComprobanteCompleto(saldo, comp, cliente, cnf, renglones,
//                            ccc, stocks, renglonesToActualizar, listaStockCtaCte, prodPrecioActualizar);
//                } catch (Exception ex) {
//                    Logger.getLogger(FacturaWeb3Frame.class.getName()).log(Level.SEVERE, null, ex);
//                    JOptionPane.showMessageDialog(this, "ERROR 1329 - COMPROBANTE");
//                    return;
//                }
//            } else {
//                ProveedorCuentaCorriente ccc = new ProveedorCuentaCorriente();
//                Proveedor proveedor = cliente.getProveedor();
//                SaldoProveedor saP = proveedor.getSaldoProveedor();
//                Double saldoAnterior = saP.getSaldo();
//                Double sal = saldoAnterior - subto;
//                comp.setSaldoAnterior(saldoAnterior);
//                saP.setSaldo(sal);
//                proveedor.setSaldoProveedor(saP);
//                saP.setUltimaFecha(fecha);
//                ccc.setProveedor(proveedor);
//                ccc.setDebe(0.0);
//                ccc.setFecha(fecha);
//                ccc.setHaber(totalFactura);
//                ccc.setComprobante(comp);
//                ccc.setSaldo(sal);
//                ccc.setTipoComprobante(11);
//                List<ProductoPrecio> prodPrecioActualizar = new ArrayList<>();
//                List<ProductoStock> stocks = new ArrayList<>();
//                List<ComprobanteCompraRenglones> renglonesToActualizar = new ArrayList<>();
//                for (ComprobanteRenglones cr : renglones) {
//                    ProductoStock ps = cr.getProducto().getStock();
//                    Integer stkAnterior = ps.getStock();
//                    Integer stk = stkAnterior - cr.getCantidad();
//                    ps.setStock(stk);
//                    stocks.add(ps);
//
//                    StockCuentaCorriente scc = new StockCuentaCorriente();
//                    scc.setCliente(cliente);
//                    scc.setCodigoTipoComprobante(1);
//                    scc.setEgreso(cr.getCantidad());
//                    scc.setFecha(fecha);
//                    scc.setIngreso(0);
//                    scc.setProducto(cr.getProducto());
//                    scc.setRenglonesVenta(cr);
//                    scc.setSaldo(stk);
//                    listaStockCtaCte.add(scc);
//
//                    ProductoPrecio precioAnterior = cr.getProducto().getPrecio();
//                    Double precioActualizar = precioAnterior.getPrecioCostoCalculado();
//                    Double unitario = precioActualizar / stkAnterior;
//                    precioActualizar = UtilFrame.redondearDouble(precioActualizar);
//                    Double total = unitario * stk;
//                    total = UtilFrame.redondearDouble(total);
//                    precioAnterior.setPrecioCostoCalculado(total);
//                    prodPrecioActualizar.add(precioAnterior);
//
//                    List<ComprobanteCompraRenglones> ccr;
//                    try {
//                        ccr = new ComprobanteComprasRenglonesService().getRenglonByProducto(producto);
//                    } catch (Exception ex) {
//                        Logger.getLogger(FacturaWeb3Frame.class.getName()).log(Level.SEVERE, null, ex);
//                        JOptionPane.showMessageDialog(this, "ERROR Nro. 1358 - RENGLONES FACTURA COMPRA");
//                        return;
//                    }
//                    Integer nuevaCantidadDisponible = 0;
//                    for (ComprobanteCompraRenglones comprCompras : ccr) {
//                        if (cr.getCantidad() <= comprCompras.getCantidadDisponible()) {
//                            nuevaCantidadDisponible = comprCompras.getCantidadDisponible()
//                                    - cr.getCantidad();
//                            comprCompras.setCantidadDisponible(nuevaCantidadDisponible);
//                            renglonesToActualizar.add(comprCompras);
//                            break;
//                        }
//                    }
//                }
//                try {
//                    new ComprobanteService().saveComprobanteCompletoClienteProveedor(saP, comp, cliente, cnf, renglones,
//                            ccc, stocks, renglonesToActualizar, listaStockCtaCte, prodPrecioActualizar);
//                } catch (Exception ex) {
//                    Logger.getLogger(FacturaWeb3Frame.class.getName()).log(Level.SEVERE, null, ex);
//                    JOptionPane.showMessageDialog(this, "ERROR 1376 - COMPROBANTE");
//                    return;
//                }
//
//            }
//        } else {
//            Saldo saldo = cliente.getSaldo();
//            Double saldoAnterior = saldo.getSaldo();
//            Double sal = saldoAnterior + subto;
//            comp.setSaldoAnterior(saldoAnterior);
//            saldo.setSaldo(sal);
//            cliente.setSaldo(saldo);
//            saldo.setFecha(fecha);
//            CCCliente ccc = new CCCliente();
//            ccc.setCliente(cliente);
//            ccc.setComprobante(comp);
//            ccc.setDebe(totalFactura);
//            ccc.setFecha(fecha);
//            ccc.setHaber(0.0);
//            ccc.setRecibo(null);
//            ccc.setSaldo(sal);
//            ccc.setTipoComprobante(1);
//            List<ProductoStock> stocks = new ArrayList<>();
//            List<ProductoPrecio> prodPrecioActualizar = new ArrayList<>();
//            List<ComprobanteCompraRenglones> renglonesToActualizar = new ArrayList<>();
//            for (ComprobanteRenglones cr : renglones) {
//                ProductoStock ps = cr.getProducto().getStock();
//                Integer stkAnterior = ps.getStock();
//                Integer stk = stkAnterior - cr.getCantidad();
//                ps.setStock(stk);
//                stocks.add(ps);
//                StockCuentaCorriente scc = new StockCuentaCorriente();
//                scc.setCliente(cliente);
//                scc.setCodigoTipoComprobante(1);
//                scc.setEgreso(cr.getCantidad());
//                scc.setFecha(fecha);
//                scc.setIngreso(0);
//                scc.setProducto(cr.getProducto());
//                scc.setRenglonesVenta(cr);
//                scc.setSaldo(stk);
//                listaStockCtaCte.add(scc);
//                List<ComprobanteCompraRenglones> ccr;
//
//                ProductoPrecio precioAnterior = cr.getProducto().getPrecio();
//                Double precioActualizar = precioAnterior.getPrecioCostoCalculado();
//                Double unitario = precioActualizar / stkAnterior;
//                precioActualizar = UtilFrame.redondearDouble(precioActualizar);
//                Double total = unitario * stk;
//                total = UtilFrame.redondearDouble(total);
//                precioAnterior.setPrecioCostoCalculado(total);
//
//                try {
//                    ccr = new ComprobanteComprasRenglonesService().getRenglonByProducto(producto);
//                } catch (Exception ex) {
//                    Logger.getLogger(FacturaWeb3Frame.class.getName()).log(Level.SEVERE, null, ex);
//                    JOptionPane.showMessageDialog(this, "ERROR Nro. 1405 - RENGLONES FACTURA COMPRA");
//                    return;
//                }
//                Integer nuevaCantidadDisponible = 0;
//                for (ComprobanteCompraRenglones comprCompras : ccr) {
//                    if (cr.getCantidad() <= comprCompras.getCantidadDisponible()) {
//                        nuevaCantidadDisponible = comprCompras.getCantidadDisponible()
//                                - cr.getCantidad();
//                        comprCompras.setCantidadDisponible(nuevaCantidadDisponible);
//                        renglonesToActualizar.add(comprCompras);
//                        break;
//                    }
//                }
//            }
//            try {
//                new ComprobanteService().saveComprobanteCompleto(saldo, comp, cliente, cnf, renglones,
//                        ccc, stocks, renglonesToActualizar,
//                        listaStockCtaCte, prodPrecioActualizar);
//            } catch (Exception ex) {
//                Logger.getLogger(FacturaWeb3Frame.class.getName()).log(Level.SEVERE, null, ex);
//                JOptionPane.showMessageDialog(this, "ERROR 1423 - COMPROBANTE");
//                return;
//            }
//        }
//        try {
//            File ps1 = new PDFBuilder().generaPdf2(comp);
//            DesktopApi.open(ps1);
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(FacturaWeb3Frame.class.getName()).log(Level.SEVERE, null, ex);
//            System.out.println("err1");
//            JOptionPane.showMessageDialog(this, "ERROR FILE 3212");
//        } catch (DocumentException ex) {
//            Logger.getLogger(FacturaWeb3Frame.class.getName()).log(Level.SEVERE, null, ex);
//            System.out.println("err2");
//            JOptionPane.showMessageDialog(this, "ERROR DOCUMENT 3216");
//        } catch (Exception ex) {
//            Logger.getLogger(FacturaWeb3Frame.class.getName()).log(Level.SEVERE, null, ex);
//            JOptionPane.showMessageDialog(this, "ERROR EXCEPTION 3219");
//            System.out.println("err3");
//        }
//        volver();
//    }
//    private void listaProducto() {
//        listx = null;
//        try {
//            listx = new ClienteListaProductoService().getByClienteAndProducto(cliente, producto);
//        } catch (Exception ex) {
////                Logger.getLogger(FacturaFrame.class.getName()).log(Level.SEVERE, null, ex);
//            listx = null;
//        }
////        System.out.println(listx);
////        System.out.println(cliente);
////        System.out.println(producto);
////        System.exit(0);
//        if (listx != null) {
////            listaProductoTxt.setText(listx.toString());
//        } else {
////            listaProductoTxt.setText(lista.toString());
//            listx = lista;
//        }
////        listaProductoTxt.requestFocus();
//    }
    private void bloquearAbajoFinal() {
//        codigoProductoTxt.setEnabled(false);

        cantidadTxt.setEnabled(false);
//        gananciaTxt.setEnabled(false);
        nombreProductoABuscarTxt.setEnabled(false);
//        texto1PieFacturaTxt.setEnabled(true);
//        texto2PieFacturaTxt.setEnabled(true);
        comboProductos.setEnabled(false);
        nuevaCantidadTxt.setEnabled(false);
//        nuevoPrecioTxt.setEnabled(false);
        descuentoVolumenTxt.setEnabled(false);
        totalTxt.setEnabled(false);

        eliminarItemBtn.setEnabled(true);
//        imprimeChk.setEnabled(true);
//        pdfChk.setEnabled(true);
        leerCantidadBtn.setEnabled(false);
        grabarCantidadBtn.setEnabled(false);
//        leerPrecioBtn.setEnabled(false);
//        grabarPrecioBtn.setEnabled(false);
        cancelarBtn.setEnabled(true);
        terminarBtn.setEnabled(true);
    }

    private void calcularTotal() {
        subto = 0.0;
        totalImpuestoFc = 0.0;
        totalIvaFc = 0.0;
        totalNetoFc = 0.0;
        if (renglones != null && !renglones.isEmpty()) {
            for (RenglonFactura cr : renglones) {
                subto += cr.getTotal();
                subto = UtilFactura.calcularRedondeo(subto);
                totalImpuestoFc += cr.getImpuesto();
                totalImpuestoFc = UtilFactura.calcularRedondeo(totalImpuestoFc);
                totalIvaFc += cr.getIva();
                totalIvaFc = UtilFactura.calcularRedondeo(totalIvaFc);
                totalNetoFc += cr.getGravado();
                totalNetoFc = UtilFactura.calcularRedondeo(totalNetoFc);
            }
            netoTxt.setText(df_separador_miles.format(totalNetoFc));
            ivaTxt.setText(df_separador_miles.format(totalIvaFc));
            impuestoTxt.setText(df_separador_miles.format(totalImpuestoFc));

            subtotalTxt.setText(df_separador_miles.format(subto));
            totalTxt.setText(df_separador_miles.format(subto));
            totalFinalFactura = subto;
        }
    }

//    private void calcularTotal2() {
//        subto = 0.0;
//        if (renglones != null && !renglones.isEmpty()) {
//            for (ComprobanteRenglones cr : renglones) {
//                subto += cr.getTotal();
//                subto = UtilFrame.redondearDouble(subto);
//            }
//            Float pd = Float.valueOf(porcentajeDescuentoVolumenTxt.getText().replace(",", "."));
//            Double comision = subto * (pd / 100);
//            comision = UtilFrame.redondearDouble(comision);
//            descuentoVolumenTxt.setText(df_separador_miles.format(comision));
//            Double totalFinal = subto - comision;
//            totalFinal = UtilFrame.redondearDouble(totalFinal);
//            subtotalTxt.setText(df_separador_miles.format(subto));
//            totalTxt.setText(df_separador_miles.format(totalFinal));
//        }
//    }
    private boolean existeProducto(Producto pro) {
        Boolean existe = false;
//        if (renglones.size() < 1) {
//            return existe;
//        }
//        for (ComprobanteRenglones cr1 : renglones) {
//            Long id1 = pro.getId();
//            Long id2 = cr1.getProducto().getId();
//            if (id1.equals(id2)) {
//                existe = true;
//            }
//        }
        return existe;
    }

    private void llenarFrame() {
        comboClientes.removeAllItems();
        comboClientes.addItem("");
        for (Cliente cli : clientes) {
            comboClientes.addItem(cli.getRazonSocial());
        }
        cliente = clientes.get(indexComboClientes - 1);
        comboClientes.setSelectedIndex(indexComboClientes);
        cargarCliente();
        porcentajeDescuentoVolumenTxt.setText(porcentajeDescuentoVolumen_str.toString());
        porcentajeDescuentoVolumen = Float.valueOf(porcentajeDescuentoVolumenTxt.getText().replace(",", "."));
        nombreClienteABuscarTxt.setText(nombreClienteABuscar);
        nombreProductoABuscarTxt.setText("");
        comboProductos.removeAllItems();
        comboProductos.addItem("");
        cantidadTxt.setText("");
        listaTxt.setText(lista_str);
        saldoTxt.setText(saldo_str);
//        lista = cliente.getListaPrecios();
        llenarTabla();

//        JOptionPane.showMessageDialog(this, "aqui carga el frame");
        bloquearArriba();
        nombreProductoABuscarTxt.requestFocus();

//        System.exit(0);
    }

    private void llenarTabla() {
//        System.out.println(renglones);
//        System.exit(0);
        DefaultTableModel tbl = (DefaultTableModel) tabla.getModel();
        nro = 1;
//        for (ComprobanteRenglones cr : renglones) {
//            Object o[] = new Object[7];
//            nro += 1;
//
//            o[0] = nro;
//            o[1] = cr.getCantidad();
//            o[2] = cr.getDetalle();
//            o[3] = df_separador_miles.format(cr.getPrecioVentaUnitario());
//            o[4] = df_separador_miles.format(cr.getPorcentajeDescuento());
//            o[5] = df_separador_miles.format(cr.getPrecioVentaTotalUnitario());
//            o[6] = df_separador_miles.format(cr.getTotal());
//            tbl.addRow(o);
//        }
        tabla.setModel(tbl);
        calcularTotal();
    }

    private void cargarCliente() {
        Integer seleccion = comboClientes.getSelectedIndex();
        cliente = clientes.get(seleccion - 1);
        nombreClienteABuscarTxt.setText(cliente.getRazonSocial());
        Double saldo = cliente.getSaldo();
        saldoTxt.setText(df_separador_miles.format(saldo));
        bloquearArriba();
    }

    private boolean hayStock(Integer cant) {
//        ProductoStock ps = producto.getStock();
//        Integer stock = ps.getStock();
//        if (cant > stock) {
//            return false;
//        }
        return true;
    }

//    private void calcularConDescuento() {
////        nuevoPrecio = Double.valueOf(nuevoPrecioTxt.getText().replace(",", "."));
////        Integer dtoLinea = Integer.valueOf(descuentoLineaTxt.getText().replace(",", "."));
////        diferenciaPorDescuentoUnitario = nuevoPrecio * dtoLinea / 100;
////        diferenciaPorDescuentoUnitario = UtilFrame.redondearDouble(diferenciaPorDescuentoUnitario);
////        finalCalculado = nuevoPrecio - diferenciaPorDescuentoUnitario;
////        finalCalculado = UtilFrame.redondearDouble(finalCalculado);
////        resultadoTxt.setText(df_separador_miles.format(finalCalculado));
////        resultadoTxt.requestFocus();
//    }
}
