package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.AbstractButton;
import javax.swing.AbstractListModel;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

import entity.DocGia;
import entity.NhanVien;
import iRemote.DocGiaDao;
import iRemote.NhanVienDao;
import view.util.HeaderRenderer;

import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;

public class DSNhanVien extends JPanel implements ActionListener,MouseListener, KeyListener{
	private DefaultTableModel modelSach;
	private JTextField textTen;
	private JButton btnSua;
	private JButton btnDangKy;
	private JTable table;
	private JTable table_1;
	private AbstractButton btnXoa;
	private JButton btnLamMoi;
	private JButton btnDau;
	private AbstractButton btnCong1;
	private AbstractButton btnTru1;
	private AbstractButton btnCuoi;
	private JLabel txtPage;
	private NhanVienDao nhanVienDao;
	private int limit = 20;
	private JLabel txtTongTrang;

	/**
	 * Create the panel.
	 */
	public DSNhanVien() {
		
		try {
			nhanVienDao = (NhanVienDao) Naming.lookup("rmi://192.168.1.3:2910/nhanVienDao");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setPreferredSize(new Dimension(1920, 918));
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(DSNhanVien.class.getResource("/img/employee (9).png")));
		lblNewLabel.setBounds(10, 11, 128, 137);
		add(lblNewLabel);
		
		JLabel lblDanhSchBn = new JLabel("   Danh S??ch Nh??n Vi??n");
		lblDanhSchBn.setOpaque(true);
		lblDanhSchBn.setHorizontalAlignment(SwingConstants.LEFT);
		lblDanhSchBn.setForeground(new Color(204, 102, 51));
		lblDanhSchBn.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblDanhSchBn.setBackground(Color.WHITE);
		lblDanhSchBn.setBounds(147, 55, 384, 54);
		add(lblDanhSchBn);
		
		JPanel panel1 = new JPanel();
		panel1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Ch\u1EE9c n\u0103ng", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel1.setBounds(10, 147, 1902, 80);
		add(panel1);
		
		 btnDangKy = new JButton("????ng k??");
		 btnDangKy.setIcon(new ImageIcon(DSNhanVien.class.getResource("/img/plus_24.png")));
		btnDangKy.setForeground(Color.BLACK);
		btnDangKy.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnDangKy.setBackground(Color.LIGHT_GRAY);
		
		 btnSua = new JButton("S???a");
		 btnSua.setIcon(new ImageIcon(DSNhanVien.class.getResource("/img/cap_nhat.png")));
		btnSua.setForeground(Color.BLACK);
		btnSua.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSua.setBorder(new LineBorder(new Color(255, 255, 255), 0, true));
		btnSua.setBackground(Color.LIGHT_GRAY);
		
		 btnXoa = new JButton("X??a");
		btnXoa.setIcon(new ImageIcon(DSNhanVien.class.getResource("/img/negative.png")));
		btnXoa.setForeground(Color.BLACK);
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnXoa.setBorder(new LineBorder(new Color(255, 255, 255), 0, true));
		btnXoa.setBackground(Color.LIGHT_GRAY);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1_1_1_1_1_1_1 = new JLabel("T??n:");
		lblNewLabel_1_1_1_1_1_1_1_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		textTen = new JTextField();
		textTen.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textTen.setColumns(10);
		
		 btnLamMoi = new JButton("L??m m???i");
		btnLamMoi.setIcon(new ImageIcon(DSNhanVien.class.getResource("/img/exchange (1).png")));
		btnLamMoi.setForeground(Color.BLACK);
		btnLamMoi.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnLamMoi.setBorder(new LineBorder(new Color(255, 255, 255), 0, true));
		btnLamMoi.setBackground(Color.LIGHT_GRAY);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(DSNhanVien.class.getResource("/img/search (1).png")));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout gl_panel1 = new GroupLayout(panel1);
		gl_panel1.setHorizontalGroup(
			gl_panel1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel1.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnDangKy, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
					.addGap(12)
					.addComponent(btnSua, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnXoa, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
					.addGap(13)
					.addComponent(btnLamMoi, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 763, Short.MAX_VALUE)
					.addComponent(lblNewLabel_1_1_1_1_1_1_1_1_1_1_1_1_1, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
					.addGap(2)
					.addComponent(textTen, GroupLayout.PREFERRED_SIZE, 421, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
					.addGap(2))
		);
		gl_panel1.setVerticalGroup(
			gl_panel1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel1.createSequentialGroup()
					.addGroup(gl_panel1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel1.createSequentialGroup()
							.addGap(6)
							.addComponent(btnDangKy, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel1.createSequentialGroup()
							.addGap(7)
							.addGroup(gl_panel1.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnSua, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnXoa, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel1.createSequentialGroup()
							.addGap(8)
							.addGroup(gl_panel1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel1.createSequentialGroup()
									.addGap(2)
									.addComponent(lblNewLabel_1_1_1_1_1_1_1_1_1_1_1_1_1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel1.createParallelGroup(Alignment.TRAILING)
									.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
									.addComponent(textTen, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_panel1.createSequentialGroup()
							.addGap(8)
							.addComponent(btnLamMoi, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(8, Short.MAX_VALUE))
		);
		panel1.setLayout(gl_panel1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(52, 223, 1902, 625);
		add(scrollPane);
		table = new JTable();
		table.setRowHeight(30);
		modelSach=new DefaultTableModel(
				new String[] {"M?? nh??n vi??n", "H??? t??n", "S??? ??i???n tho???i", "Ng??y sinh","Gi???i t??nh","?????a ch???","Ch???c v???"},50) {

					@Override
					public boolean isCellEditable(int row, int column) {
						return false;
					}
			
		};
		
//		table_1 = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 16));
		table.setModel(modelSach);
		JTableHeader headerTable = table.getTableHeader();
		headerTable.setFont(new Font("Tahoma", Font.PLAIN, 18));
		headerTable.setBackground(new Color(160,227,242));
		scrollPane.setViewportView(table);

		JTableHeader h = table.getTableHeader();
		h.setPreferredSize(new Dimension(35, 35));
		((DefaultTableCellRenderer) h.getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);

		HeaderRenderer renderer = new HeaderRenderer();
		// center
		JLabel headerLabel = (JLabel) renderer;
		headerLabel.setHorizontalAlignment(JLabel.CENTER);
		headerLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		// set color Header Table
		TableColumnModel columnmodel ;

		for (int i = 0; i < table.getColumnCount(); i++) {
			table.getColumnModel().getColumn(i).setHeaderRenderer(renderer);
			renderer.setBackgroundColor(Color.black);
			renderer.setForegroundColor(Color.white);
			renderer.setBorder(new LineBorder(Color.gray));
		}
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(11, 851, 1902, 54);
		add(panel_2);
		
		 btnDau = new JButton("");
		btnDau.setIcon(new ImageIcon(DSNhanVien.class.getResource("/img/previousEnd.png")));
		btnDau.setFont(new Font("Arial", Font.PLAIN, 16));
		
		 btnTru1 = new JButton("");
		btnTru1.setIcon(new ImageIcon(DSNhanVien.class.getResource("/img/rewind-button.png")));
		btnTru1.setFont(new Font("Arial", Font.PLAIN, 16));
		
		 txtPage = new JLabel("1");
		txtPage.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel txtPage_1 = new JLabel("/");
		txtPage_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		 txtTongTrang = new JLabel("1");
		txtTongTrang.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		 btnCong1 = new JButton("");
		btnCong1.setIcon(new ImageIcon(DSNhanVien.class.getResource("/img/nextbutton.png")));
		btnCong1.setFont(new Font("Arial", Font.PLAIN, 16));
		
		 btnCuoi = new JButton("");
		btnCuoi.setIcon(new ImageIcon(DSNhanVien.class.getResource("/img/nextEnd.png")));
		btnCuoi.setFont(new Font("Arial", Font.PLAIN, 16));
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGap(0, 1848, Short.MAX_VALUE)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(676)
					.addComponent(btnDau, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addGap(16)
					.addComponent(btnTru1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addGap(23)
					.addComponent(txtPage)
					.addGap(13)
					.addComponent(txtPage_1, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
					.addGap(3)
					.addComponent(txtTongTrang, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
					.addGap(21)
					.addComponent(btnCong1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addGap(16)
					.addComponent(btnCuoi, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(657, Short.MAX_VALUE))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 54, Short.MAX_VALUE)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(9)
							.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
								.addComponent(btnDau, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
									.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
										.addComponent(btnCong1, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_panel_2.createSequentialGroup()
											.addGap(1)
											.addComponent(btnCuoi, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)))
									.addComponent(btnTru1, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(17)
							.addComponent(txtTongTrang, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(16)
							.addComponent(txtPage)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap(19, Short.MAX_VALUE)
					.addComponent(txtPage_1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
					.addGap(16))
		);
		panel_2.setLayout(gl_panel_2);
		
		ButtonGroup buttonGroup = new ButtonGroup();

		try {
			docDuLieuVaoBang();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		btnSua.addActionListener(this);
		btnDangKy.addActionListener(this);
		btnCong1.addActionListener(this);
		btnTru1.addActionListener(this);
		btnDau.addActionListener(this);
		btnCuoi.addActionListener(this);
		table.addMouseListener(this);
		btnLamMoi.addActionListener(this);
		btnXoa.addActionListener(this);
		textTen.addKeyListener(this);

		
	}
	
	
	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setSize(1920,918);
		f.getContentPane().add(new DSNhanVien());
		f.setVisible(true);
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
	}
	private void xoaALLDuLieuTable() {
		for (int i = modelSach.getRowCount(); i > 0; i--) {
			modelSach.removeRow(0);
		}

	}
public void docDuLieuVaoBang() throws RemoteException{
	int page= Integer.parseInt( txtPage.getText());

	System.out.println(page);
	List<NhanVien> dsNV= null;
	dsNV = nhanVienDao.layDanhSachNhanVien(page - 1, textTen.getText().trim(), limit);

	if(dsNV == null) {
		JOptionPane.showMessageDialog(this, "rong");
		txtPage.setText("1");
		return;
	}
System.out.println(dsNV);
	SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	xoaALLDuLieuTable();
	for (NhanVien nhanVien : dsNV) {
		modelSach.addRow(new Object[] { nhanVien.getMaNhanVien(), nhanVien.getTenNhanVien(),nhanVien.getSoDienThoai(),df.format(nhanVien.getNgaySinh()), nhanVien.isGioiTinh() ? "Nam" : "N???",
				nhanVien.getDiaChi(),nhanVien.isChucVu()?"Qu???n l??" :"Nh??n vi??n" });
	}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object object = e.getSource();
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		System.err.println("Page " + txtPage.getText());
		int tongPage = 1;
		
		try {
			tongPage = nhanVienDao.tongTrang(textTen.getText().trim(),limit);
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		if (object.equals(btnCong1)) { // next page table
			System.out.println("Cong 1 -----------------------------");
			// next table
			int page = Integer.parseInt(txtPage.getText()) + 1;
			System.err.println("Page" + page);
//			System.err.println(page);
			if (page <= tongPage) {
				txtTongTrang.setText(Integer.toString(tongPage));
				txtPage.setText(Integer.toString(page));
				xoaALLDuLieuTable();
				try {
					
					docDuLieuVaoBang();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		} else if (object.equals(btnTru1)) { // Lui page table

			int page = Integer.parseInt(txtPage.getText()) - 1;

			if (page >= 1) {
				txtTongTrang.setText(Integer.toString(tongPage));
				txtPage.setText(Integer.toString(page));
				xoaALLDuLieuTable();
				try {
					docDuLieuVaoBang();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		} else if (object.equals(btnCuoi)) { // Cuoi page table
			int page = Integer.parseInt(txtPage.getText());
			System.err.println(tongPage);
			if (page <= tongPage) {
				txtTongTrang.setText(Integer.toString(tongPage));
				txtPage.setText(Integer.toString(tongPage));
				xoaALLDuLieuTable();
				try {
					docDuLieuVaoBang();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		} else if (object.equals(btnDau)) { // Dau page table

			int page = Integer.parseInt(txtPage.getText());

			if (page != 0) {
				txtTongTrang.setText(Integer.toString(tongPage));
				txtPage.setText("1");
				xoaALLDuLieuTable();
				try {
					docDuLieuVaoBang();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		}
		
		else	if(object.equals(btnDangKy)) {
			new ThemNhanVien().setVisible(true);
		}
		else if(object.equals(btnSua)) {
			int selectRow = table.getSelectedRow();
			if (selectRow == -1) {
				JOptionPane.showMessageDialog(this, "B???n ch??a ch???n ?????c gi???!");
				return;
			}
			String ma = (String) table.getValueAt(table.getSelectedRow(), 0);
			System.out.println(ma);
			SuaNhanVien dialogSuaK= new SuaNhanVien(ma);
			try {
				NhanVien nhanVien= nhanVienDao.layNhanVienTheoMa(ma);
				System.out.println("Ma nhanvien");
				System.out.println(ma);
				
				dialogSuaK.loadDuLieu(nhanVien);
				
			} catch (RemoteException e1) {
				e1.printStackTrace();
			}
			dialogSuaK.setVisible(true);
		
			
			
			xoaChon();
		}
		else if(object.equals(btnLamMoi)) {

			int page = Integer.parseInt(txtPage.getText());

			if (page != 0) {
				txtTongTrang.setText(Integer.toString(tongPage));
				txtPage.setText("1");
				xoaALLDuLieuTable();
				try {
					docDuLieuVaoBang();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		else if(object.equals(btnXoa)) {
			int selectRow = table.getSelectedRow();
			if (selectRow == -1) {
				JOptionPane.showMessageDialog(this, "B???n ch??a ch???n ?????c gi???!");
				return;
			}
			String ma = (String) table.getValueAt(table.getSelectedRow(), 0);
			try {
				nhanVienDao.xoaNhanVien(ma);
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println(ma);
			xoaChon();
		
		}
		
	}
	public void xoaChon() {
		textTen.setText("");
		xoaALLDuLieuTable();
		try {
			docDuLieuVaoBang();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyReleased(KeyEvent e) {
		Object object = e.getSource();
		if (object.equals(textTen)) {
			String ten = textTen.getText().toString();
			if (ten.equalsIgnoreCase("")) {
				xoaALLDuLieuTable();
				try {
					docDuLieuVaoBang();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} else {

				xoaALLDuLieuTable();
				table.clearSelection();
				
				List<NhanVien> dsnv;
				try {
					dsnv = nhanVienDao.layNhanVienTheoTen(textTen.getText());
					for (NhanVien docGia : dsnv) {
						modelSach.addRow(new Object[] { docGia.getMaNhanVien(), docGia.getTenNhanVien(), docGia.getSoDienThoai(),docGia.getNgaySinh(),docGia.isGioiTinh() ? "Nam" : "N???",docGia.getDiaChi()
								,docGia.isChucVu() ? "Quan l??" : "Nh??n vi??n"});
					}
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		}
		
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
