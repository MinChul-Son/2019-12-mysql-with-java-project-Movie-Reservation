import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Vector;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.Position;

import se.datadosen.component.RiverLayout;

public class movieGui {
	JFrame mainFrame = new JFrame();
	JFrame joinFrame, findFrame, reservFrame, ticketFrame, updateFrame, adminFrame, addmovieFrame, searchcgvFrame;
	JPanel logInPanel, ticketPanel, updatePanel, adminPanel, addmoviePanel;
	JPanel joinPanel, findPanel;
	JPanel mainPanel, moviePanel, reservPanel, seatingPanel, seatingPanel2, payPanel;
	JPanel moviePanel1, moviePanel2, moviePanel3, moviePanel4, moviePanel5;
	JButton join, login, duplicate, findId, findPw, close, sId, sPw, next, logout, update, update_save, update_delete,
			movie_cancle, mymovie_print, movie_print, bSave, bDelete, bNew, bSearch_cgv2, bSave2, bDelete2, bNew2;
	JButton save = new JButton("저장");
	JLabel title, id, pw, name, tel;
	JList movies = new JList();
	JList movies2 = new JList();
	JList scheduled_movies = new JList();
	JList payments = new JList();
	JList cgvs = new JList();
	JList close_cgvs = new JList();
	Link linker = new Link();
	Image image1, image2, image3;
	JButton reserv_button;
	JButton checkcancle_button;
	JButton r1 = new JButton("11:40");
	JButton r2 = new JButton("14:25");
	JButton r3 = new JButton("12:10");
	JButton r4 = new JButton("18:55");
	JButton r5 = new JButton("15:30");
	JButton r6 = new JButton("15:40");
	JButton r7 = new JButton("17:15");
	JButton r8 = new JButton("16:45");
	JButton l1 = new JButton("예고편");
	JButton l2 = new JButton("예고편");
	JButton l3 = new JButton("예고편");
	JButton l4 = new JButton("예고편");
	JButton l5 = new JButton("예고편");	
	JButton[] seat = new JButton[48];
	JButton mymovie_preview = new JButton();
	JButton bSearch_cgv;
	JLabel error = new JLabel("");
	JLabel s1, s2, s3, s4, s5;
	JLabel p_movie = new JLabel("");
	JLabel p_time = new JLabel("");
	JLabel p_people = new JLabel("");
	JLabel p_seat = new JLabel("");
	JLabel p_price = new JLabel("");
	JLabel p_payment = new JLabel("");
	String m_payment;
	String mymovie_name = "";
	String mymovie_time = "";
	String mymovie_studio = "";
	String mymovie_amount = "";
	String mymovie_payment = "";
	String mymovie_seat = "";
	String mymovie_price = "";
	String blank = " ";
	int myticket_num = 0;
	JLabel mymovie_name_label = new JLabel();
	JLabel mymovie_time_label = new JLabel();
	JLabel mymovie_studio_label = new JLabel();
	JLabel mymovie_amount_label = new JLabel();
	JLabel mymovie_payment_label = new JLabel();
	JLabel mymovie_price_label = new JLabel();
	JLabel mymovie_seat_label = new JLabel();
	JLabel mymovie_num_label = new JLabel();
	JLabel mymovie_date_label = new JLabel();
	int location1, location2, interval1, interval2;
	int number = 1;
	int j = 0;
	int save_num;
	int max_select = 0;
	Calendar oCalendar = Calendar.getInstance();
	private JTextField text_id, text_name, text_name2, text_tel, text_tel2, text_people, text_address;
	private JTextField text_movie_name, text_movie_time, text_movie_studio, text_movie_percent, text_movie_opening;
	private JTextField text_cgv_name, text_cgv_address, cgv_search;
	private JPasswordField text_pw;
	CardLayout card = new CardLayout();
	Connection conn;
	boolean dupCheck = false;
	boolean nextCheck = false;
	boolean adminCheck = false;
	String person_key, movie_key, movie, movie_time;
	String seat_num = "";
	int people;
	JLabel blank1 = new JLabel("   ");
	JLabel blank2 = new JLabel("   ");
	JLabel blank3 = new JLabel("   ");
	JLabel m_name = new JLabel("영화명:  ");
	JLabel m_time = new JLabel("일시:  ");
	JLabel m_people = new JLabel("인원:  ");
	JLabel m_seat = new JLabel("좌석:  ");
	JLabel m_price = new JLabel("결제 금액:  ");
	private final int WIN_WIDTH = 1350;
	private final int WIN_HEIGHT = 900;
	private final String LOGIN_PIC = "/image/login.jpg";
	private final String FIND_PIC = "/image/find.jpg";
	private final String JOIN_PIC = "/image/join.jpg";
	private final String MAIN_PIC = "/image/main.jpg";
	private final String MOVIE1_PIC = "/image/극한직업.jpg";
	private final String MOVIE2_PIC = "/image/어벤져스.jpg";
	private final String MOVIE3_PIC = "/image/베테랑.jpg";
	private final String MOVIE4_PIC = "/image/겨울왕국.jpg";
	private final String MOVIE5_PIC = "/image/아바타.jpg";
	private final String GO_PIC = "/image/go.png";
	private final String LOGOUT_PIC = "/image/logout.png";
	private final String TICKET_PIC = "/image/ticket.png";
	private final String CINEMA_PIC = "/image/cinema.jpg";
	private final String PAY_PIC = "/image/pay.jpg";
	private final String MYTICKET_PIC = "/image/myticket.jpg";
	private final String UPDATE_PIC = "/image/update.jpg";
	private final String UPDATESAVE_PIC = "/image/updatesave.jpg";
	private final String UPDATEDELETE_PIC = "/image/updatedelete.jpg";
	private final String CHECKCANCLE_PIC = "/image/check_cancle.png";
	private final String CANCLE_PIC = "/image/cancle.jpg";
	private final String SELECTCGV_PIC = "/image/selectcgv.jpg";
	private final String MOVIELIST_PIC = "/image/movie_list.jpg";
	private final String SEARCHCGV_PIC = "/image/search_cgv.jpg";
	private final String ADMININFO_PIC = "/image/admin_info.jpg";
	private final String USERINFO_PIC = "/image/user_info.jpg";
	private final String UPDATEMOVIE_PIC = "/image/update_movie.jpg";
	private final String UPDATECGV_PIC = "/image/update_cgv.jpg";
	private final String ADMINLOGIN_PIC = "/image/admin_login.jpg";
	private final String VIEWPRINT_PIC = "/image/view_print.jpg";
	private final String SEARCH_PIC = "/image/search.jpg";
	private final String SAVE_PIC = "/image/save.jpg";
	private final String DELETE_PIC = "/image/delete.jpg";
	private final String NEW_PIC = "/image/new.jpg";
	private final String PAYMENT_PIC = "/image/payment.jpg";
	private final String RESET_PIC = "/image/reset.jpg";
	private final String PEOPLESELECT_PIC = "/image/people_select.jpg";
	private final String PAYSUCCESS_PIC = "/image/pay_success.jpg";
	
	ImageIcon image15 = new ImageIcon(getClass().getResource(MOVIELIST_PIC));
	JButton movie_preview = new JButton(image15);
	JButton movie_preview2 = new JButton(image15);
	ImageIcon image17 = new ImageIcon(getClass().getResource(ADMININFO_PIC));
	JButton bAdminpreview = new JButton(image17);
	ImageIcon image18 = new ImageIcon(getClass().getResource(USERINFO_PIC));
	JButton bPeoplepreview = new JButton(image18);
	ImageIcon image19 = new ImageIcon(getClass().getResource(UPDATEMOVIE_PIC));
	JButton bNewmovie = new JButton(image19);
	ImageIcon image20 = new ImageIcon(getClass().getResource(UPDATECGV_PIC));
	JButton bNew_cgv = new JButton(image20);
	ImageIcon image21 = new ImageIcon(getClass().getResource(ADMINLOGIN_PIC));
	JButton bAdminlogin = new JButton(image21);
	JButton cgv_preview = new JButton("영화관 목록");
	ImageIcon image22 = new ImageIcon(getClass().getResource(VIEWPRINT_PIC));
	ImageIcon image23 = new ImageIcon(getClass().getResource(SEARCH_PIC));
	ImageIcon image24 = new ImageIcon(getClass().getResource(SAVE_PIC));
	ImageIcon image25 = new ImageIcon(getClass().getResource(DELETE_PIC));
	ImageIcon image26 = new ImageIcon(getClass().getResource(NEW_PIC));
	ImageIcon image27 = new ImageIcon(getClass().getResource(PAYMENT_PIC));
	JButton pay_button = new JButton(image27);
	ImageIcon image28 = new ImageIcon(getClass().getResource(RESET_PIC));
	JButton reset_button = new JButton(image28);
	ImageIcon image29 = new ImageIcon(getClass().getResource(PEOPLESELECT_PIC));
	JButton people_button = new JButton(image29);
	ImageIcon image30 = new ImageIcon(getClass().getResource(PAYSUCCESS_PIC));
	JButton paySuccess_button = new JButton(image30);
	
	public static void main(String[] args) {
		movieGui client = new movieGui();
		client.dbConnectionInit();
		client.myGui();
	}

	private void myGui() {
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.getContentPane().setLayout(card);
		mainFrame.setTitle("영화 예매 프로그램");
		logInPanel = new JPanel() {
			public void paintComponent(Graphics g) {
				Image image = new ImageIcon(getClass().getResource(LOGIN_PIC)).getImage();
				g.drawImage(image, 0, 0, WIN_WIDTH, WIN_HEIGHT, this);
			}
		};
		mainPanel = new MainPanel();
		mainPanel.setLayout(null);
		text_id = new JTextField(15);
		text_id = new JTextField("id를 입력하세요");
		text_id.setFont(new Font("HYPost", Font.PLAIN, 40));
		text_id.selectAll();
		text_id.setEditable(true);
		text_id.setBounds(400, 200, 650, 108);
		logInPanel.add(text_id);
		text_pw = new JPasswordField(15);
		text_pw.setFont(new Font("HYPost", Font.PLAIN, 40));
		text_pw.selectAll();
		text_pw.setEditable(true);
		text_pw.setBounds(400, 340, 650, 108);
		logInPanel.add(text_pw);
		mainFrame.add(logInPanel);
		mainFrame.add(mainPanel);
		join = new JButton();
		join.setBounds(240, 680, 130, 150);
		join.addActionListener(new JoinButtonListener());
		logInPanel.add(join);
		join.setBorderPainted(false);
		join.setContentAreaFilled(false);
		join.setFocusPainted(false);
		login = new JButton();
		login.setBounds(253, 485, 830, 110);
		login.addActionListener(new LoginButtonListener());
		login.setBorderPainted(false);
		login.setContentAreaFilled(false);
		login.setFocusPainted(false);
		logInPanel.add(login);
		findId = new JButton();
		findPw = new JButton();
		findId.setBounds(655, 680, 150, 150);
		findPw.setBounds(900, 680, 180, 150);
		findId.addActionListener(new FindButtonListener());
		findPw.addActionListener(new FindButtonListener());
		findId.setBorderPainted(false);
		findId.setContentAreaFilled(false);
		findId.setFocusPainted(false);
		findPw.setBorderPainted(false);
		findPw.setContentAreaFilled(false);
		findPw.setFocusPainted(false);
		logInPanel.add(findId);
		logInPanel.add(findPw);
		logInPanel.setLayout(null);
		logInPanel.add(bAdminlogin);
		bAdminlogin.setBounds(450, 680, 150, 130);
		bAdminlogin.addActionListener(new AdminListener());
		mainFrame.setSize(WIN_WIDTH - 80, WIN_HEIGHT - 20);
		mainFrame.getContentPane().add(logInPanel, "n1");
		mainFrame.getContentPane().add(mainPanel, "n2");
		mainFrame.setVisible(true);
		mainFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				mainFrame.setVisible(false);
				mainFrame.dispose();
			}
		});

	}

	public class MainPanel extends JPanel {
		public void paintComponent(Graphics g) {
			mainFrame.setSize(1800, 1000);
			Image image = new ImageIcon(getClass().getResource(MAIN_PIC)).getImage();
			g.drawImage(image, 0, 0, 1800, 950, this);
			moviePanel = new JPanel();
			moviePanel.setLayout(null);
			moviePanel1 = new JPanel() {
				public void paintComponent(Graphics g) {
					image1 = new ImageIcon(getClass().getResource(MOVIE1_PIC)).getImage();
					g.drawImage(image1, 0, 0, 300, 380, this);
				}

			};
			moviePanel2 = new JPanel() {
				public void paintComponent(Graphics g) {
					image2 = new ImageIcon(getClass().getResource(MOVIE2_PIC)).getImage();
					g.drawImage(image2, 0, 0, 300, 380, this);
				}
			};
			moviePanel3 = new JPanel() {
				public void paintComponent(Graphics g) {
					image3 = new ImageIcon(getClass().getResource(MOVIE3_PIC)).getImage();
					g.drawImage(image3, 0, 0, 300, 380, this);
				}
			};
			;
			mainPanel.add(moviePanel);
			moviePanel.add(moviePanel1);
			moviePanel.setBounds(264, 132, 1264, 400);
			moviePanel.setBackground(Color.black);
			mainPanel.add(moviePanel);
			moviePanel.add(moviePanel2);
			moviePanel.add(moviePanel3);
			moviePanel1.setBounds(80, 10, 300, 380);
			moviePanel2.setBounds(480, 10, 300, 380);
			moviePanel3.setBounds(880, 10, 300, 380);
			ImageIcon image5 = new ImageIcon(getClass().getResource(GO_PIC));
			next = new JButton(image5);
			moviePanel.add(next);
			next.setBounds(1200, 200, 50, 50);
			next.addActionListener(new ChangeMovieListener());
			ImageIcon image7 = new ImageIcon(getClass().getResource(LOGOUT_PIC));
			logout = new JButton(image7);
			mainPanel.add(logout);
			logout.setBounds(1685, 585, 100, 100);
			logout.addActionListener(new LogoutListener());
			ImageIcon image6 = new ImageIcon(getClass().getResource(TICKET_PIC));
			reserv_button = new JButton(image6);
			mainPanel.add(reserv_button);
			reserv_button.setBounds(1600, 300, 100, 100);
			reserv_button.addActionListener(new ReservationListener());
			ImageIcon image8 = new ImageIcon(getClass().getResource(CHECKCANCLE_PIC));
			checkcancle_button = new JButton(image8);
			mainPanel.add(checkcancle_button);
			checkcancle_button.setBounds(0, 180, 260, 50);
			checkcancle_button.addActionListener(new CheckcancleListener());
			ImageIcon image9 = new ImageIcon(getClass().getResource(UPDATE_PIC));
			update = new JButton(image9);
			mainPanel.add(update);
			update.setBounds(0, 250, 260, 50);
			update.addActionListener(new UpdateListener());
			mainPanel.add(l1);
			mainPanel.add(l2);
			mainPanel.add(l3);
			mainPanel.add(l4);
			mainPanel.add(l5);
			l1.setBounds(680, 600, 100, 30);
			l2.setBounds(680, 650, 100, 30);
			l3.setBounds(680, 695, 100, 30);
			l4.setBounds(680, 740, 100, 30);
			l5.setBounds(680, 790, 100, 30);
			l1.setBackground(Color.pink);
			l2.setBackground(Color.pink);
			l3.setBackground(Color.pink);
			l4.setBackground(Color.pink);
			l5.setBackground(Color.pink);
			l1.addActionListener(new GetLinkListener());
			l2.addActionListener(new GetLinkListener());
			l3.addActionListener(new GetLinkListener());
			l4.addActionListener(new GetLinkListener());
			l5.addActionListener(new GetLinkListener());
			movies.setVisibleRowCount(5);
			movies.setFont(new Font("HYPost", Font.PLAIN, 30));
			mainPanel.add(movies);
			movies.setBounds(280, 600, 400, 300);
			scheduled_movies.setVisibleRowCount(5);
			scheduled_movies.setFont(new Font("HYPost", Font.PLAIN, 30));
			mainPanel.add(scheduled_movies);
			scheduled_movies.setBounds(1150, 600, 400, 300);
			mainPanel.add(movie_preview2);
			movie_preview2.setBounds(800, 600, 150, 80);
			movie_preview2.addActionListener(new DisplayButtonListener());
			ImageIcon image16 = new ImageIcon(getClass().getResource(SEARCHCGV_PIC));
			bSearch_cgv = new JButton(image16);
			mainPanel.add(bSearch_cgv);
			bSearch_cgv.setBounds(960, 600, 150, 80);
			bSearch_cgv.addActionListener(new SearchcgvListener());

		}
	}

	public class SearchcgvListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			searchcgvFrame = new JFrame("영화관 검색");

			JPanel leftTopPanel = new JPanel(new RiverLayout());
			JScrollPane cScroller = new JScrollPane(cgvs);
			cScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			cScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			cgvs.setVisibleRowCount(7);
			cgvs.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			cgvs.setFixedCellWidth(100);
			leftTopPanel.add("br center", new JLabel("영화관 목록"));
			leftTopPanel.add("p center", cScroller);

			JPanel rightTopPanel = new JPanel(new RiverLayout());
			text_cgv_name = new JTextField(20);
			text_cgv_address = new JTextField(20);
			// 표식을 위한 라벨들
			rightTopPanel.add("br center", new JLabel("영 화 관 정 보"));
			rightTopPanel.add("p left", new JLabel("영 화 관 명"));
			rightTopPanel.add("tab", text_cgv_name);
			rightTopPanel.add("br", new JLabel("영 화 관 주 소"));
			rightTopPanel.add("tab", text_cgv_address);
			JPanel leftBottomPanel = new JPanel(new RiverLayout());
			JPanel tmpPanel = new JPanel(new RiverLayout());
			JPanel tmpPanel1 = new JPanel(new RiverLayout());
			JPanel tmpPanel2 = new JPanel(new RiverLayout());
			cgv_search = new JTextField(20);
			bSearch_cgv2 = new JButton(image23);
			bSearch_cgv2.setPreferredSize(new Dimension(120, 60));
			cgv_preview = new JButton(image22);
			cgv_preview.setPreferredSize(new Dimension(120, 60));
			tmpPanel1.add(cgv_search);
			tmpPanel2.add(bSearch_cgv2);
			tmpPanel2.add(cgv_preview);
			tmpPanel.add("center", tmpPanel1);
			tmpPanel.add("br cneter", tmpPanel2);
			leftBottomPanel.add("center", tmpPanel);

			JScrollPane cScroller2 = new JScrollPane(close_cgvs);
			cScroller2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			cScroller2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			close_cgvs.setVisibleRowCount(3);
			close_cgvs.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			close_cgvs.setFixedCellWidth(100);
			JPanel rightBottomPanel = new JPanel(new RiverLayout());
			rightBottomPanel.add("center", new JLabel("가 까 운 C G V"));
			rightBottomPanel.add("p center", cScroller2);
	
			JPanel topPanel = new JPanel(new GridLayout(1, 2));
			topPanel.add(leftTopPanel);
			topPanel.add(rightTopPanel);
			JPanel bottomPanel = new JPanel(new GridLayout(1, 2));
			bottomPanel.add(leftBottomPanel);
			bottomPanel.add(rightBottomPanel);

			JPanel cgvPanel = new JPanel(new BorderLayout());
			cgvPanel.add(topPanel, BorderLayout.CENTER);
			cgvPanel.add(bottomPanel, BorderLayout.SOUTH);

			cgvs.addListSelectionListener(new CgvListListener());
			MySearchListener l = new MySearchListener();
			cgv_search.addActionListener(l);
			bSearch_cgv2.addActionListener(l);
			cgv_preview.addActionListener(new DisplayButtonListener());

			
			searchcgvFrame.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					searchcgvFrame.setVisible(false);
					searchcgvFrame.dispose();
				}
			});
			searchcgvFrame.getContentPane().add(cgvPanel);
			searchcgvFrame.setSize(700, 350);
			searchcgvFrame.setVisible(true);
		}

	}

	public class CgvListListener implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent lse) { 
			if (!lse.getValueIsAdjusting() && !cgvs.isSelectionEmpty()) {
				try {
					Statement stmt = conn.createStatement(); 
					ResultSet rs = stmt.executeQuery(
							"SELECT * FROM cgv WHERE cgv_name = '" + (String) cgvs.getSelectedValue() + "'");
					rs.next(); 
					text_cgv_name.setText(rs.getString("cgv_name")); 
					text_cgv_address.setText(rs.getString("cgv_address"));
					stmt.close();
				} catch (SQLException sqlex) {
					System.out.println("SQL 에러 : " + sqlex.getMessage());
					sqlex.printStackTrace();
				} catch (Exception ex) {
					System.out.println("DB Handling 에러(리스트 리스너) : " + ex.getMessage());
					ex.printStackTrace();
				}
			}
		}
	}

	public class MySearchListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int index = cgvs.getNextMatch(cgv_search.getText().trim(), 0, Position.Bias.Forward);
			if (index != -1) {
				cgvs.setSelectedIndex(index);
			}
			cgv_search.setText("");
		}
	}

	public class AdminListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			int admin_id = 0;
			try {
				String typedId = text_id.getText().trim();
				String typedPw = text_pw.getText().trim();

				Vector<String> list = new Vector<String>();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM admin WHERE admin_loginid = '" + typedId
						+ "' AND admin_loginpw = '" + typedPw + "'");
				while (rs.next()) {
					list.add(rs.getString("admin_loginid"));
					list.add(rs.getString("admin_loginpw"));
					admin_id = rs.getInt("admin_id");

				}
				if (!list.isEmpty()) {
					adminFrame = new JFrame("관리자 프로그램");
					adminFrame.setSize(350, 500);
					adminFrame.setVisible(true);
					adminFrame.addWindowListener(new WindowAdapter() {
						public void windowClosing(WindowEvent e) {
							adminFrame.setVisible(false);
							adminFrame.dispose();
						}
					});
					adminPanel = new JPanel(new RiverLayout());
					adminFrame.add(adminPanel);
					adminPanel.add("br center", movie_preview);
					movie_preview.setPreferredSize(new Dimension(150, 80));
					if (admin_id == 1) {
						adminPanel.add("br center", bAdminpreview);
						bAdminpreview.setPreferredSize(new Dimension(150, 80));
					}
					adminPanel.add("br center", bPeoplepreview);
					bPeoplepreview.setPreferredSize(new Dimension(150, 80));
					adminPanel.add("br center", bNewmovie);
					bNewmovie.setPreferredSize(new Dimension(150, 80));
					adminPanel.add("br center", bNew_cgv);
					bNew_cgv.setPreferredSize(new Dimension(150, 80));
					movie_preview.addActionListener(new DisplayButtonListener());
					bAdminpreview.addActionListener(new DisplayButtonListener());
					bPeoplepreview.addActionListener(new DisplayButtonListener());
					bNewmovie.addActionListener(new AddmovieListener());
					bNew_cgv.addActionListener(new NewcgvListener());

				} else {
					error = new JLabel("관리자 권한이 필요합니다.");
					JOptionPane.showMessageDialog(null, error);
				}

				stmt.close();
			} catch (SQLException sqlex) {
				System.out.println("SQL 에러 : " + sqlex.getMessage());
				sqlex.printStackTrace();
			} catch (Exception ex) {
				System.out.println("DB Handling 에러 : " + ex.getMessage());
				ex.printStackTrace();
			}

		}

	}

	public class NewcgvListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			searchcgvFrame = new JFrame("영화관 검색");

			JPanel leftTopPanel = new JPanel(new RiverLayout());
			JScrollPane cScroller = new JScrollPane(cgvs);
			cScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			cScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			cgvs.setVisibleRowCount(7);
			cgvs.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			cgvs.setFixedCellWidth(100);
			leftTopPanel.add("br center", new JLabel("영화관 목록"));
			leftTopPanel.add("p center", cScroller);

			
			JPanel rightTopPanel = new JPanel(new RiverLayout());
			text_cgv_name = new JTextField(20);
			text_cgv_address = new JTextField(20);
			
			rightTopPanel.add("br center", new JLabel("영 화 관 정 보"));
			rightTopPanel.add("p left", new JLabel("영 화 관 명"));
			rightTopPanel.add("tab", text_cgv_name);
			rightTopPanel.add("br", new JLabel("영 화 관 주 소"));
			rightTopPanel.add("tab", text_cgv_address);
			
			JPanel leftBottomPanel = new JPanel(new RiverLayout());
			JPanel tmpPanel = new JPanel(new RiverLayout());
			JPanel tmpPanel1 = new JPanel(new RiverLayout());
			JPanel tmpPanel2 = new JPanel(new RiverLayout());
			cgv_search = new JTextField(20);
			bSearch_cgv2 = new JButton(image23);
			bSearch_cgv2.setPreferredSize(new Dimension(120, 60));
			cgv_preview = new JButton(image22);
			cgv_preview.setPreferredSize(new Dimension(120, 60));
			tmpPanel1.add(cgv_search);
			tmpPanel2.add(bSearch_cgv2);
			tmpPanel2.add(cgv_preview);
			tmpPanel.add("center", tmpPanel1);
			tmpPanel.add("br cneter", tmpPanel2);
			leftBottomPanel.add("center", tmpPanel);
			JPanel rightBottomPanel = new JPanel(new RiverLayout());
			tmpPanel = new JPanel(new RiverLayout());
			bSave = new JButton(image24);
			bSave.setPreferredSize(new Dimension(100, 60));
			bDelete = new JButton(image25);
			bDelete.setPreferredSize(new Dimension(100, 60));
			bNew = new JButton(image26);
			bNew.setPreferredSize(new Dimension(100, 60));
			tmpPanel.add(bSave);
			tmpPanel.add("tab", bDelete);
			tmpPanel.add("tab", bNew);
			rightBottomPanel.add("center", tmpPanel);
			rightBottomPanel.add("br", Box.createRigidArea(new Dimension(0, 20)));

			
			JPanel topPanel = new JPanel(new GridLayout(1, 2));
			topPanel.add(leftTopPanel);
			topPanel.add(rightTopPanel);
			JPanel bottomPanel = new JPanel(new GridLayout(1, 2));
			bottomPanel.add(leftBottomPanel);
			bottomPanel.add(rightBottomPanel);

			JPanel cgvPanel = new JPanel(new BorderLayout());
			cgvPanel.add(topPanel, BorderLayout.CENTER);
			cgvPanel.add(bottomPanel, BorderLayout.SOUTH);

			cgvs.addListSelectionListener(new CgvListListener());
			MySearchListener l = new MySearchListener();
			cgv_search.addActionListener(l);
			bSearch_cgv2.addActionListener(l);
			cgv_preview.addActionListener(new DisplayButtonListener());

			
			searchcgvFrame.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					searchcgvFrame.setVisible(false);
					searchcgvFrame.dispose();
				}
			});
			searchcgvFrame.getContentPane().add(cgvPanel);
			searchcgvFrame.setSize(700, 350);
			searchcgvFrame.setVisible(true);
		}

	}

	public class AddmovieListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			addmovieFrame = new JFrame("영화등록");
			addmoviePanel = new JPanel(new BorderLayout());
			JPanel leftTopPanel = new JPanel(new RiverLayout());

			JScrollPane cScroller = new JScrollPane(movies2);
			cScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			cScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			movies2.setVisibleRowCount(5);
			movies2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			movies2.setFixedCellWidth(100);
			leftTopPanel.add("br center", new JLabel("영화 제목들"));
			leftTopPanel.add("p center", cScroller);
			JPanel rightTopPanel = new JPanel(new RiverLayout());
			text_movie_name = new JTextField(20);
			text_movie_time = new JTextField(20);
			text_movie_studio = new JTextField(20);
			text_movie_percent = new JTextField(20);
			text_movie_opening = new JTextField(20);
			rightTopPanel.add("br center", new JLabel("영 화 정 보"));
			rightTopPanel.add("p left", new JLabel("제   목"));
			rightTopPanel.add("tab", text_movie_name);
			rightTopPanel.add("br", new JLabel("시   간"));
			rightTopPanel.add("tab", text_movie_time);
			rightTopPanel.add("br", new JLabel("상  영  관"));
			rightTopPanel.add("tab", text_movie_studio);
			rightTopPanel.add("br", new JLabel("예  매  율"));
			rightTopPanel.add("tab", text_movie_percent);
			rightTopPanel.add("br", new JLabel("개  봉  일"));
			rightTopPanel.add("tab", text_movie_opening);
			JPanel bottomPanel = new JPanel(new GridLayout(1, 2));
			JPanel tmpPanel = new JPanel(new RiverLayout());
			bSave = new JButton(image24);
			bSave.setPreferredSize(new Dimension(100, 60));
			bDelete = new JButton(image25);
			bDelete.setPreferredSize(new Dimension(100, 60));
			bNew = new JButton(image26);
			bNew.setPreferredSize(new Dimension(100, 60));
			tmpPanel.add(bSave);
			tmpPanel.add("tab", bDelete);
			tmpPanel.add("tab", bNew);
			bottomPanel.add(tmpPanel);
			JPanel topPanel = new JPanel(new GridLayout(1, 2));
			topPanel.add(leftTopPanel);
			topPanel.add(rightTopPanel);
			addmoviePanel.add(topPanel, BorderLayout.CENTER);
			addmoviePanel.add(bottomPanel, BorderLayout.SOUTH);
			addmovieFrame.getContentPane().add(addmoviePanel);
			movies2.addListSelectionListener(new MovieListListener());
			bSave.addActionListener(new SaveButtonListener());
			bDelete.addActionListener(new DeleteButtonListener());
			bNew.addActionListener(new NewButtonListener());
			addmovieFrame.setSize(700, 300);
			addmovieFrame.setVisible(true);
			addmovieFrame.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					addmovieFrame.setVisible(false);
					addmovieFrame.dispose();
				}
			});

		}
	}

	public class MovieListListener implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent lse) { 
			if (!lse.getValueIsAdjusting() && !movies2.isSelectionEmpty()) { 
				try {
					Statement stmt = conn.createStatement(); 
					ResultSet rs = stmt.executeQuery(
							"SELECT * FROM movie WHERE movie_name = '" + (String) movies2.getSelectedValue() + "'");
					rs.next(); 
					text_movie_name.setText(rs.getString("movie_name")); 
					text_movie_time.setText(rs.getString("movie_time"));
					text_movie_studio.setText(rs.getString("movie_studio"));
					text_movie_percent.setText(rs.getString("movie_percent"));
					text_movie_opening.setText(rs.getString("movie_opening"));
					stmt.close();
				} catch (SQLException sqlex) {
					System.out.println("SQL 에러 : " + sqlex.getMessage());
					sqlex.printStackTrace();
				} catch (Exception ex) {
					System.out.println("DB Handling 에러(리스트 리스너) : " + ex.getMessage());
					ex.printStackTrace();
				}
			}
		}
	}

	public void prepareCloseCgvList() {
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT person_address FROM person WHERE person_id='" + person_key + "'");
			Vector<String> list = new Vector<String>();
			String find_address = "";

			while (rs.next()) {
				find_address = rs.getString("person_address");
			}
			rs = stmt.executeQuery("SELECT cgv_name FROM cgv WHERE cgv_address LIKE '%" + find_address + "%'");
			while (rs.next()) {
				list.add(rs.getString("cgv_name"));
			}
			stmt.close();
			Collections.sort(list);
			close_cgvs.setListData(list);
			if (!list.isEmpty())
				close_cgvs.setSelectedIndex(0);
		} catch (SQLException sqlex) {
			System.out.println("SQL 에러 : " + sqlex.getMessage());
			sqlex.printStackTrace();
		}
	}

	public void prepareList() {
		try {
			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery("SELECT * FROM movie");
			Vector<String> list = new Vector<String>();
			while (rs.next()) {
				list.add(rs.getString("movie_name"));
			}
			stmt.close();
			Collections.sort(list);
			movies2.setListData(list);
			if (!list.isEmpty())
				movies2.setSelectedIndex(0);

			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM cgv");
			list = new Vector<String>();
			while (rs.next()) {
				list.add(rs.getString("cgv_name"));
			}
			stmt.close();
			Collections.sort(list);
			cgvs.setListData(list);
			if (!list.isEmpty())
				movies2.setSelectedIndex(0);
		} catch (SQLException sqlex) {
			System.out.println("SQL 에러 : " + sqlex.getMessage());
			sqlex.printStackTrace();
		}
	}

	public void prepareScheduledList() {
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");//날짜 형식 저장
			Date start = null;//비교할 날짜
			Date now = new Date();
			Date today = null;//현재 날짜
			try {
				today = format.parse(format.format(now));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM movie");
			Vector<String> list = new Vector<String>();
			while (rs.next()) {
				start = rs.getDate("movie_opening");
				if (start.compareTo(now) == 1)
					list.add(rs.getString("movie_name") + "  " + start);
			}
			stmt.close();
			Collections.sort(list);
			scheduled_movies.setListData(list);

		} catch (SQLException sqlex) {
			System.out.println("SQL 에러 : " + sqlex.getMessage());
			sqlex.printStackTrace();
		}
	}

	public class UpdateListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			updateFrame = new JFrame("회원정보 수정");
			updateFrame.setSize(400, 300);
			updateFrame.setVisible(true);
			updateFrame.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					updateFrame.setVisible(false);
					updateFrame.dispose();
				}
			});
			JLabel update_name = new JLabel("이름");
			JLabel update_pw = new JLabel("비밀번호");
			JLabel update_tel = new JLabel("전화번호");
			JLabel update_address = new JLabel("주소");
			update_name.setFont(new Font("HYPost", Font.PLAIN, 25));
			update_pw.setFont(new Font("HYPost", Font.PLAIN, 25));
			update_tel.setFont(new Font("HYPost", Font.PLAIN, 25));
			update_address.setFont(new Font("HYPost", Font.PLAIN, 25));
			updatePanel = new JPanel(new RiverLayout());
			updateFrame.add(updatePanel);
			text_pw = new JPasswordField(15);
			text_pw.setFont(new Font("HYPost", Font.PLAIN, 15));
			text_pw.setEditable(true);
			text_name = new JTextField(15);
			text_name.setFont(new Font("HYPost", Font.PLAIN, 15));
			text_name.selectAll();
			text_name.setEditable(true);
			text_tel = new JTextField(20);
			text_tel.setFont(new Font("HYPost", Font.PLAIN, 15));
			text_tel.selectAll();
			text_tel.setEditable(true);
			text_address = new JTextField(20);
			text_address.setFont(new Font("HYPost", Font.PLAIN, 15));
			text_address.selectAll();
			text_address.setEditable(true);
			updatePanel.add("br left", update_pw);
			updatePanel.add("center", text_pw);
			updatePanel.add("br left", update_name);
			updatePanel.add("center", text_name);
			updatePanel.add("br left", update_tel);
			updatePanel.add("center", text_tel);
			updatePanel.add("br left", update_address);
			updatePanel.add("center", text_address);
			ImageIcon image10 = new ImageIcon(getClass().getResource(UPDATESAVE_PIC));
			update_save = new JButton(image10);
			update_save.setPreferredSize(new Dimension(100, 50));
			update_save.addActionListener(new UpdateButtonListener());
			updatePanel.add("br left", update_save);
			ImageIcon image11 = new ImageIcon(getClass().getResource(UPDATEDELETE_PIC));
			update_delete = new JButton(image11);
			update_delete.setPreferredSize(new Dimension(100, 50));
			update_delete.addActionListener(new UpdateButtonListener());
			updatePanel.add("right", update_delete);

		}

	}

	public class UpdateButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Object o = e.getSource();
			if (o == update_save) {
				try {
					Statement stmt = conn.createStatement();
					stmt.executeUpdate("UPDATE person SET person_password='" + text_pw.getText() + "' , "
							+ "person_name='" + text_name.getText() + "' , " + "person_tel='" + text_tel.getText()
							+ "' ," + "person_address='" + text_address.getText() + "'");
					stmt.close();
					error.setText("회원정보 수정을 완료했습니다.");
					JOptionPane.showMessageDialog(null, error);
					updateFrame.dispose();
				} catch (SQLException sqlex) {
					System.out.println("SQL 에러 : " + sqlex.getMessage());
					sqlex.printStackTrace();
				}
			} else {
				try {
					Statement stmt = conn.createStatement();
					stmt.executeUpdate("DELETE FROM person WHERE person_id='" + person_key + "'");
					stmt.close();
					error.setText("CGV탈퇴를 완료했습니다. 로그인화면으로 돌아갑니다.");
					JOptionPane.showMessageDialog(null, error);
					updateFrame.dispose();
					card.show(mainFrame.getContentPane(), "n1");
					mainFrame.setSize(WIN_WIDTH - 80, WIN_HEIGHT - 20);
				} catch (SQLException sqlex) {
					System.out.println("SQL 에러 : " + sqlex.getMessage());
					sqlex.printStackTrace();
				}
			}
		}
	}

	public class CheckcancleListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			ticketFrame = new JFrame("예매 정보 확인/취소");
			ticketFrame.setSize(800, 750);
			ticketFrame.setVisible(true);
			ticketFrame.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					ticketFrame.setVisible(false);
					ticketFrame.dispose();
				}
			});
			ticketPanel = new JPanel() {
				public void paintComponent(Graphics g) {
					Image image = new ImageIcon(getClass().getResource(MYTICKET_PIC)).getImage();
					g.drawImage(image, 0, 0, 800, 600, this);
				}
			};
			ticketPanel.setLayout(null);
			ticketFrame.add(ticketPanel);
			myticket_num = (int) (Math.random() * 1000000 + 1000000);
			Vector<String> list = new Vector<String>();
			try {
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(
						"SELECT m.movie_name, m.movie_time,m.movie_studio,ri.amount, p.payment, ri.price FROM reservation_info ri "
								+ "NATURAL JOIN movie m NATURAL JOIN payments p " + "WHERE person_id=" + person_key);

				while (rs.next()) {
					mymovie_name = rs.getString("m.movie_name");
					mymovie_time = rs.getString("m.movie_time");
					mymovie_studio = rs.getString("m.movie_studio");
					mymovie_amount = rs.getString("ri.amount");
					mymovie_payment = rs.getString("p.payment");
					mymovie_price = rs.getString("ri.price");
					list.add(rs.getString("m.movie_name"));
				}
				rs = stmt.executeQuery(
						"SELECT s.seat FROM already_reserv NATURAL JOIN seat_number s " + "WHERE person_id="
								+ person_key + " AND movie_id= " + "(SELECT movie_id FROM movie WHERE movie_name='"
								+ mymovie_name + "' " + "AND movie_time='" + mymovie_time + "')");
				while (rs.next()) {
					mymovie_seat = mymovie_seat + rs.getString("s.seat") + "  ";
				}
				stmt.close();
			} catch (SQLException sqlex) {
				System.out.println("SQL 에러 : " + sqlex.getMessage());
				sqlex.printStackTrace();
			}
			mymovie_name_label.setText(mymovie_name);
			mymovie_time_label.setText(mymovie_time);
			mymovie_studio_label.setText("(" + mymovie_studio + ")");
			mymovie_amount_label.setText(mymovie_amount + "명");
			mymovie_payment_label.setText(mymovie_payment);
			mymovie_price_label.setText(mymovie_price);
			mymovie_seat_label.setText(mymovie_seat);
			mymovie_num_label.setText("" + myticket_num);
			mymovie_date_label.setText(oCalendar.get(Calendar.YEAR) + "년 " + (oCalendar.get(Calendar.MONTH) + 1) + "월 "
					+ (oCalendar.get(Calendar.DAY_OF_MONTH) + 1) + "일 ");
			ticketPanel.add(mymovie_name_label);
			ticketPanel.add(mymovie_time_label);
			ticketPanel.add(mymovie_studio_label);
			ticketPanel.add(mymovie_amount_label);
			ticketPanel.add(mymovie_payment_label);
			ticketPanel.add(mymovie_price_label);
			ticketPanel.add(mymovie_seat_label);
			ticketPanel.add(mymovie_num_label);
			ticketPanel.add(mymovie_date_label);
			mymovie_name_label.setBounds(150, 240, 150, 50);
			mymovie_num_label.setBounds(150, 270, 100, 50);
			mymovie_date_label.setBounds(150, 300, 120, 50);
			mymovie_amount_label.setBounds(150, 325, 120, 50);
			mymovie_seat_label.setBounds(150, 355, 120, 50);
			mymovie_studio_label.setBounds(250, 355, 120, 50);
			mymovie_time_label.setBounds(520, 300, 120, 50);
			mymovie_price_label.setBounds(150, 420, 120, 50);
			mymovie_payment_label.setBounds(150, 450, 120, 50);
			if (list.isEmpty()) {
				error.setText("예매하신 정보가 없습니다.");
				JOptionPane.showMessageDialog(null, error);
				ticketFrame.dispose();
			}
			ImageIcon image12 = new ImageIcon(getClass().getResource(CANCLE_PIC));
			movie_cancle = new JButton(image12);
			ticketPanel.add(movie_cancle);
			movie_cancle.setBounds(350, 600, 100, 100);
			movie_cancle.addActionListener(new CancleListener());
			ticketPanel.add(mymovie_preview);
			mymovie_preview.setBounds(630, 25, 140, 60);
			mymovie_preview.addActionListener(new DisplayButtonListener());
			mymovie_preview.setBorderPainted(false);
			mymovie_preview.setContentAreaFilled(false);
			mymovie_preview.setFocusPainted(false);

		}
	}

	public class DisplayButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			ArrayList<RowObjects> rowList = new ArrayList<RowObjects>(); 
			RowObjects line = new RowObjects(); 
			PrintObject word; 
			int i = 0;
			if (e.getSource() == movie_preview ||e.getSource() == movie_preview2) {
				try {
					Statement stmt = conn.createStatement(); 
					ResultSet rs = stmt.executeQuery("SELECT * FROM movie");
					while (rs.next()) {
						line = new RowObjects(); 
						line.add(new PrintObject(rs.getString("movie_name"), 30));
						line.add(new PrintObject(rs.getString("movie_time"), 20));
						line.add(new PrintObject(rs.getString("movie_studio"), 20));
						line.add(new PrintObject(rs.getString("movie_percent"), 20));
						line.add(new PrintObject(rs.getString("movie_opening"), 20));
						rowList.add(line); 
					}
					stmt.close();

					
					line = new RowObjects(); 
					line.add(new PrintObject("영화제목", 30));
					line.add(new PrintObject("영화시간", 20));
					line.add(new PrintObject("상영관", 20));
					line.add(new PrintObject("예매율", 20));
					line.add(new PrintObject("개봉일", 20));

					Preview prv = new Preview(new PrintObject("영화정보", 20), line, rowList, true);
					prv.preview();

				} catch (SQLException sqlex) {
					System.out.println("SQL 에러 : " + sqlex.getMessage());
					sqlex.printStackTrace();
				} catch (Exception ex) {
					System.out.println("DB Handling 에러(리스트 리스너) : " + ex.getMessage());
					ex.printStackTrace();
				}
			} else if (e.getSource() == mymovie_preview) {
				try {
					Statement stmt = conn.createStatement(); 

					ResultSet rs = stmt.executeQuery(
							"SELECT pe.person_name, m.movie_name, m.movie_time,m.movie_studio, p.payment, ri.price,(SELECT seat FROM seat_number WHERE ar.s_id=s_id) seat FROM reservation_info ri "
									+ "NATURAL JOIN movie m NATURAL JOIN payments p NATURAL JOIN person pe NATURAL JOIN already_reserv ar "
									+ "WHERE person_id=" + person_key);
					while (rs.next()) {
						

						line = new RowObjects();
						line.add(new PrintObject(rs.getString("pe.person_name"), 10));
						line.add(new PrintObject(rs.getString("m.movie_name"), 20));
						line.add(new PrintObject(rs.getString("m.movie_time"), 8));
						line.add(new PrintObject(rs.getString("m.movie_studio"), 5));
						line.add(new PrintObject(rs.getString("p.payment"), 8));
						line.add(new PrintObject(rs.getString("ri.price"), 10));
						line.add(new PrintObject(rs.getString("seat"), 10));

						rowList.add(line); 
					}
					stmt.close();

					
					line = new RowObjects();
					line.add(new PrintObject("예매자", 5));
					line.add(new PrintObject("영화제목", 5));
					line.add(new PrintObject("영화시간", 4));
					line.add(new PrintObject("상영관", 4));
					line.add(new PrintObject("결제정보", 8));
					line.add(new PrintObject("좌석", 6));

					Preview prv = new Preview(new PrintObject("예매정보", 20), line, rowList, true);
					prv.preview();
				} catch (SQLException sqlex) {
					System.out.println("SQL 에러 : " + sqlex.getMessage());
					sqlex.printStackTrace();
				} catch (Exception ex) {
					System.out.println("DB Handling 에러(리스트 리스너) : " + ex.getMessage());
					ex.printStackTrace();
				}

			} else if (e.getSource() == bAdminpreview) {
				try {
					Statement stmt = conn.createStatement(); 
					ResultSet rs = stmt.executeQuery(
							"SELECT a.admin_name,a.admin_age,a.admin_position,b.admin_name boss FROM admin a INNER JOIN admin b ON a.boss_id=b.admin_id");
					while (rs.next()) {
						line = new RowObjects(); 
						line.add(new PrintObject(rs.getString("a.admin_name"), 20));
						line.add(new PrintObject(rs.getString("a.admin_age"), 20));
						line.add(new PrintObject(rs.getString("a.admin_position"), 20));
						line.add(new PrintObject(rs.getString("boss"), 5));
						rowList.add(line); 
					}
					stmt.close();

					
					line = new RowObjects(); 
					line.add(new PrintObject("관리자 이름", 20));
					line.add(new PrintObject("관리자 나이", 20));
					line.add(new PrintObject("관리자 역할", 20));
					line.add(new PrintObject("BOSS", 5));
					Preview prv = new Preview(new PrintObject("관리자 정보", 20), line, rowList, true);
					prv.preview();

				} catch (SQLException sqlex) {
					System.out.println("SQL 에러 : " + sqlex.getMessage());
					sqlex.printStackTrace();
				} catch (Exception ex) {
					System.out.println("DB Handling 에러(리스트 리스너) : " + ex.getMessage());
					ex.printStackTrace();
				}
			} else if (e.getSource() == bPeoplepreview) {
				try {
					Statement stmt = conn.createStatement(); 
					ResultSet rs = stmt.executeQuery("SELECT * FROM person");
					while (rs.next()) {
						line = new RowObjects(); 
						line.add(new PrintObject(rs.getString("person_name"), 20));
						line.add(new PrintObject(rs.getString("person_loginid"), 20));
						line.add(new PrintObject(rs.getString("person_password"), 20));
						line.add(new PrintObject(rs.getString("person_tel"), 20));
						line.add(new PrintObject(rs.getString("person_address"), 20));
						rowList.add(line); 
					}
					stmt.close();

					
					line = new RowObjects(); 
					line.add(new PrintObject("회원 이름", 20));
					line.add(new PrintObject("회원 아이디", 20));
					line.add(new PrintObject("회원 비밀번호", 20));
					line.add(new PrintObject("회원 전화번호", 20));
					line.add(new PrintObject("회원 주소", 20));
					Preview prv = new Preview(new PrintObject("회원 정보", 20), line, rowList, true);
					prv.preview();

				} catch (SQLException sqlex) {
					System.out.println("SQL 에러 : " + sqlex.getMessage());
					sqlex.printStackTrace();
				} catch (Exception ex) {
					System.out.println("DB Handling 에러(리스트 리스너) : " + ex.getMessage());
					ex.printStackTrace();
				}
			} else if (e.getSource() == cgv_preview) {
				try {
					Statement stmt = conn.createStatement(); 
					ResultSet rs = stmt.executeQuery("SELECT * FROM cgv");
					while (rs.next()) {
						line = new RowObjects(); 
						line.add(new PrintObject(rs.getString("cgv_name"), 20));
						line.add(new PrintObject(rs.getString("cgv_address"), 20));
						rowList.add(line); 
					}
					stmt.close();

				
					line = new RowObjects(); 
					line.add(new PrintObject("CGV 이름", 20));
					line.add(new PrintObject("CGV 주소", 20));
					Preview prv = new Preview(new PrintObject("CGV 정보", 20), line, rowList, true);
					prv.preview();

				} catch (SQLException sqlex) {
					System.out.println("SQL 에러 : " + sqlex.getMessage());
					sqlex.printStackTrace();
				} catch (Exception ex) {
					System.out.println("DB Handling 에러(리스트 리스너) : " + ex.getMessage());
					ex.printStackTrace();
				}
			}
		}
	}

	public class CancleListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				Statement stmt = conn.createStatement();
				stmt.executeUpdate("DELETE FROM reservation_info WHERE person_id='" + person_key + "' "
						+ "AND movie_id=" + "(SELECT movie_id FROM movie WHERE movie_name='" + mymovie_name + "' "
						+ "AND movie_time='" + mymovie_time + "')");
				stmt.executeUpdate("DELETE FROM already_reserv WHERE person_id='" + person_key + "' AND movie_id="
						+ "(SELECT movie_id FROM movie WHERE movie_name='" + mymovie_name + "' AND movie_time='"
						+ mymovie_time + "')");
				stmt.close();
			} catch (SQLException sqlex) {
				System.out.println("SQL 에러 : " + sqlex.getMessage());
				sqlex.printStackTrace();
			}
			error.setText("예매가 취소되었습니다.");
			JOptionPane.showMessageDialog(null, error);
			ticketFrame.dispose();

		}

	}

	
	public class GetLinkListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Object o = e.getSource();
			if (o == l5)
				System.out.println("asdf");
			if (o == l1)
				linker.link1();
			else if (o == l2)
				linker.link2();
			else if (o == l3)
				linker.link5();
			else if (o == l4)
				linker.link3();
			else
				linker.link4();
		}
	}

	public void getMoviePercent() {
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date start = null;
			Date now = new Date();
			Date today = null;
			try {
				today = format.parse(format.format(now));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT DISTINCT SUBSTRING_INDEX(movie_name,'" + blank
					+ "',1) movie_name, movie_percent,movie_opening FROM movie ORDER BY movie_percent DESC");
			Vector<String> list = new Vector<String>();
			while (rs.next()) {
				start = rs.getDate("movie_opening");
				if (start.compareTo(now) == -1)
					list.add(rs.getString("movie_name") + "  " + rs.getString("movie_percent"));
			}
			stmt.close();
			movies.setListData(list);
		} catch (SQLException sqlex) {
			System.out.println("SQL 에러 : " + sqlex.getMessage());
			sqlex.printStackTrace();
		}
	}

	public void getPayments() {
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM payments ");
			Vector<String> list = new Vector<String>();
			while (rs.next()) {
				list.add(rs.getString("payment"));
			}
			stmt.close();
			payments.setListData(list);
		} catch (SQLException sqlex) {
			System.out.println("SQL 에러 : " + sqlex.getMessage());
			sqlex.printStackTrace();
		}
	}

	public class ReservationListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			reservFrame = new JFrame("영화예매화면");
			reservFrame.setVisible(true);
			reservFrame.getContentPane().setLayout(card);
			reservFrame.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					reservFrame.setVisible(false);
					reservFrame.dispose();
				}
			});
			reservFrame.setSize(500, 400);
			reservPanel = new JPanel(new RiverLayout());
			reservFrame.add(reservPanel);
			s1 = new JLabel("극한직업");
			s1.setFont(new Font("HYPost", Font.PLAIN, 20));
			reservPanel.add("br left", s1);
			reservPanel.add("br left", r1);
			reservPanel.add("tab", r2);
			s2 = new JLabel("어벤져스:엔드게임");
			s2.setFont(new Font("HYPost", Font.PLAIN, 20));
			reservPanel.add("br left", s2);
			reservPanel.add("br left", r3);
			reservPanel.add("tab", r4);
			s3 = new JLabel("베테랑");
			s3.setFont(new Font("HYPost", Font.PLAIN, 20));
			reservPanel.add("br left", s3);
			reservPanel.add("br left", r5);
			s4 = new JLabel("겨울왕국");
			s4.setFont(new Font("HYPost", Font.PLAIN, 20));
			reservPanel.add("br left", s4);
			reservPanel.add("br left", r6);
			reservPanel.add("tab", r7);
			s5 = new JLabel("아바타");
			s5.setFont(new Font("HYPost", Font.PLAIN, 20));
			reservPanel.add("br left", s5);
			reservPanel.add("br left", r8);
			r1.addActionListener(new SeatingListener());
			r2.addActionListener(new SeatingListener());
			r3.addActionListener(new SeatingListener());
			r4.addActionListener(new SeatingListener());
			r5.addActionListener(new SeatingListener());
			r6.addActionListener(new SeatingListener());
			r7.addActionListener(new SeatingListener());
			r8.addActionListener(new SeatingListener());
			seatingPanel = new JPanel() {
				public void paintComponent(Graphics g) {
					Image image = new ImageIcon(getClass().getResource(CINEMA_PIC)).getImage();
					g.drawImage(image, 0, 0, 800, 500, this);
				}
			};
			seatingPanel.setLayout(null);
			JLabel people_Label = new JLabel("인원 수");
			text_people = new JTextField(null);
			text_people.setEditable(true);
			seatingPanel2 = new JPanel(new GridLayout(6, 8, 0, 10));
			for (int i = 0; i < 48; i++) {
				if (number == 9)
					number = 1;
				seat[i] = new JButton("" + number);
				seat[i].setBackground(Color.gray);
				seat[i].addActionListener(new SelectseatListener());
				number++;
				seatingPanel2.add(seat[i]);
				seat[i].setEnabled(false);
			}
			seatingPanel.add(people_button);
			people_button.setBounds(320, 500, 110, 80);
			people_button.addActionListener(new ButtonenableListener());
			seatingPanel.add(reset_button);
			reset_button.setBounds(620, 500, 150, 80);
			reset_button.addActionListener(new SelectseatListener());
			seatingPanel.add(seatingPanel2);
			seatingPanel.add(text_people);
			seatingPanel.add(people_Label);
			seatingPanel.add(pay_button);
			pay_button.setBounds(450, 500, 150, 80);
			pay_button.addActionListener(new PayListener());
			people_Label.setBounds(30, 500, 100, 50);
			text_people.setBounds(100, 500, 200, 50);
			seatingPanel2.setBounds(145, 85, 500, 400);
			Image image9 = new ImageIcon(getClass().getResource(PAY_PIC)).getImage();
			payPanel = new JPanel(new RiverLayout()) {
				public void paintComponent(Graphics g) {
					g.drawImage(image9, 0, 0, 600, 800, this);
				}
			};
			p_movie.setFont(new Font("HYPost", Font.PLAIN, 30));
			p_time.setFont(new Font("HYPost", Font.PLAIN, 30));
			p_people.setFont(new Font("HYPost", Font.PLAIN, 30));
			p_seat.setFont(new Font("HYPost", Font.PLAIN, 30));
			p_price.setFont(new Font("HYPost", Font.PLAIN, 30));
			p_payment.setFont(new Font("HYPost", Font.PLAIN, 30));
			p_payment.setText("결제수단");
			m_name.setFont(new Font("HYPost", Font.PLAIN, 30));
			m_name.setForeground(Color.green);
			m_time.setFont(new Font("HYPost", Font.PLAIN, 30));
			m_time.setForeground(Color.green);
			m_people.setFont(new Font("HYPost", Font.PLAIN, 30));
			m_people.setForeground(Color.green);
			m_seat.setFont(new Font("HYPost", Font.PLAIN, 30));
			m_seat.setForeground(Color.green);
			m_price.setFont(new Font("HYPost", Font.PLAIN, 30));
			m_price.setForeground(Color.MAGENTA);
			p_payment.setForeground(Color.MAGENTA);
			blank1.setFont(new Font("HYPost", Font.PLAIN, 80));
			blank2.setFont(new Font("HYPost", Font.PLAIN, 70));
			blank3.setFont(new Font("HYPost", Font.PLAIN, 50));
			JScrollPane cScroller = new JScrollPane(payments);
			cScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			cScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			payments.addListSelectionListener(new PayListListener());
			payments.setVisibleRowCount(3);
			payments.setFont(new Font("HYPost", Font.PLAIN, 30));
			payPanel.add("br", blank1);
			payPanel.add("br left", m_name);
			payPanel.add("tab", p_movie);
			payPanel.add("br left", m_time);
			payPanel.add("tab", p_time);
			payPanel.add("br left", m_people);
			payPanel.add("tab", p_people);
			payPanel.add("br left", m_seat);
			payPanel.add("tab", p_seat);
			payPanel.add("br", blank2);
			payPanel.add("br left", m_price);
			payPanel.add("tab", p_price);
			payPanel.add("br", p_payment);
			payPanel.add("tab", cScroller);
			payPanel.add("br", blank3);
			payPanel.add("tab", paySuccess_button);
			paySuccess_button.addActionListener(new PaySuccessListener());
			paySuccess_button.setPreferredSize(new Dimension(150, 80));
			reservFrame.getContentPane().add(reservPanel, "n1");
			reservFrame.getContentPane().add(seatingPanel, "n2");
			reservFrame.getContentPane().add(payPanel, "n3");
		}
	}

	public class ButtonenableListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (text_people.getText().trim() != null && text_people.getText() != "0") {
				for (int i = 0; i < 48; i++) {
					seat[i].setEnabled(true);
				}
				people = Integer.parseInt(text_people.getText().trim());// 인원수 string을 int형으로 저장
				p_people.setText("" + people + "명");
				p_price.setText("" + people * 11000+"원");
			}
			try {
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM already_reserv WHERE movie_id="
						+ "(SELECT movie_id FROM movie WHERE movie_name= '" + movie + "' AND movie_time='" + movie_time
						+ "')");
				while (rs.next()) {
					save_num = (rs.getInt("s_id"));
					seat[save_num].setEnabled(false);
				}
				stmt.close();
			} catch (SQLException sqlex) {
				System.out.println("SQL 에러 : " + sqlex.getMessage());
				sqlex.printStackTrace();
			} catch (Exception ex) {
				System.out.println("DB Handling 에러(리스트 리스너) : " + ex.getMessage());
				ex.printStackTrace();
			}

		}

	}

	public void getInformation() {
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM movie WHERE movie_name= '" + movie.trim() + "' "
					+ "AND movie_time= '" + movie_time.trim() + "'");
			rs.next();
			movie_key = (rs.getString("movie_id"));
			stmt.close();
		} catch (SQLException sqlex) {
			System.out.println("SQL 에러 : " + sqlex.getMessage());
			sqlex.printStackTrace();
		} catch (Exception ex) {
			System.out.println("DB Handling 에러(리스트 리스너) : " + ex.getMessage());
			ex.printStackTrace();
		}
	}

	public class PaySuccessListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			getInformation();
			try {
				Statement stmt = conn.createStatement();
				stmt.executeUpdate("INSERT INTO reservation_info (person_id, movie_id, p_id, amount,price) VALUES ('"
						+ person_key + "', '" + movie_key + "', '" + m_payment + "', '" + people + "', '"
						+ p_price.getText() + "')");
				for (int i = 1; i <= people; i++) {
					String[] str = new String[people];
					str[i - 1] = seat_num.substring(0 + j, 2 + j);
					stmt.executeUpdate("INSERT INTO already_reserv (person_id, s_id,movie_id) VALUES ('" + person_key
							+ "', '" + str[i - 1].trim() + "', '" + movie_key + "')");
					j = j + 4;
				}
				stmt.close();
				error.setText("예매에 성공했습니다.");
				JOptionPane.showMessageDialog(null, error);
				reservFrame.dispose();
			} catch (SQLException sqlex) {
				System.out.println("SQL 에러 : " + sqlex.getMessage());
				sqlex.printStackTrace();
			} catch (Exception ex) {
				System.out.println("DB Handling 에러(리스트 리스너) : " + ex.getMessage());
				ex.printStackTrace();
			}

		}
	}

	public class PayListListener implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent lse) {
			if (!lse.getValueIsAdjusting() && !payments.isSelectionEmpty()) {
				try {
					Statement stmt = conn.createStatement();
					ResultSet rs = stmt.executeQuery(
							"SELECT * FROM payments WHERE payment = '" + (String) payments.getSelectedValue() + "'");
					rs.next();
					m_payment = (rs.getString("p_id"));
					stmt.close();
				} catch (SQLException sqlex) {
					System.out.println("SQL 에러 : " + sqlex.getMessage());
					sqlex.printStackTrace();
				} catch (Exception ex) {
					System.out.println("DB Handling 에러(리스트 리스너) : " + ex.getMessage());
					ex.printStackTrace();
				}
			}
		}
	}

	public class SeatingListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Object o = e.getSource();

			if (o == r1) {
				movie_time = "11:40";
				movie = "극한직업 (1)";
				p_movie.setText(movie);
				p_time.setText(oCalendar.get(Calendar.YEAR) + "년 " + (oCalendar.get(Calendar.MONTH) + 1) + "월 "
						+ (oCalendar.get(Calendar.DAY_OF_MONTH) + 1) + "일 " + movie_time);
				System.out.println(movie);
			} else if (o == r2) {
				movie_time = "14:25";
				movie = "극한직업 (2)";
				p_movie.setText(movie);
				p_time.setText(oCalendar.get(Calendar.YEAR) + "년 " + (oCalendar.get(Calendar.MONTH) + 1) + "월 "
						+ (oCalendar.get(Calendar.DAY_OF_MONTH) + 1) + "일 " + movie_time);
				System.out.println(movie);
			} else if (o == r3) {
				movie_time = "12:10";
				movie = "어벤져스:엔드게임 (1)";
				p_movie.setText(movie);
				p_time.setText(oCalendar.get(Calendar.YEAR) + "년 " + (oCalendar.get(Calendar.MONTH) + 1) + "월 "
						+ (oCalendar.get(Calendar.DAY_OF_MONTH) + 1) + "일 " + movie_time);
			} else if (o == r4) {
				movie_time = "18:55";
				movie = "어벤져스:엔드게임 (2)";
				p_movie.setText(movie);
				p_time.setText(oCalendar.get(Calendar.YEAR) + "년 " + (oCalendar.get(Calendar.MONTH) + 1) + "월 "
						+ (oCalendar.get(Calendar.DAY_OF_MONTH) + 1) + "일 " + movie_time);
			} else if (o == r5) {
				movie_time = "15:30";
				movie = "베테랑";
				p_movie.setText(movie);
				p_time.setText(oCalendar.get(Calendar.YEAR) + "년 " + (oCalendar.get(Calendar.MONTH) + 1) + "월 "
						+ (oCalendar.get(Calendar.DAY_OF_MONTH) + 1) + "일 " + movie_time);
			} else if (o == r6) {
				movie_time = "15:40";
				movie = "겨울왕국 (1)";
				p_movie.setText(movie);
				p_time.setText(oCalendar.get(Calendar.YEAR) + "년 " + (oCalendar.get(Calendar.MONTH) + 1) + "월 "
						+ (oCalendar.get(Calendar.DAY_OF_MONTH) + 1) + "일 " + movie_time);
			} else if (o == r7) {
				movie_time = "17:15";
				movie = "겨울왕국 (2)";
				p_movie.setText(movie);
				p_time.setText(oCalendar.get(Calendar.YEAR) + "년 " + (oCalendar.get(Calendar.MONTH) + 1) + "월 "
						+ (oCalendar.get(Calendar.DAY_OF_MONTH) + 1) + "일 " + movie_time);
			} else {
				movie_time = "16:45";
				System.out.println("아바타");
				movie = "아바타";
				p_movie.setText(movie);
				p_time.setText(oCalendar.get(Calendar.YEAR) + "년 " + (oCalendar.get(Calendar.MONTH) + 1) + "월 "
						+ (oCalendar.get(Calendar.DAY_OF_MONTH) + 1) + "일 " + movie_time);
			}
			card.show(reservFrame.getContentPane(), "n2");
			reservFrame.setSize(800, 700);
		}
	}

	public class SelectseatListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Object o = e.getSource();
			if (o == reset_button) {
				max_select = -1;
				seat_num = "";
				for (int i = 0; i < 48; i++) {
					seat[i].setEnabled(true);
				}
			}
			for (int i = 0; i < 48; i++)
				if (o == seat[i] && people > max_select) {
					seat[i].setEnabled(false);
					seat_num = seat_num + (++i) + "  ";
					System.out.println(seat_num);
				}
			p_seat.setText(seat_num.trim());

			max_select++;
			if (people < max_select) {
				error.setText("인원선택 수 " + people + "명을 초과했습니다.");
				JOptionPane.showMessageDialog(error, error);
			}

		}
	}

	public class PayListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			reservFrame.setSize(600, 800);
			reservFrame.setTitle("결제화면");
			if (people == max_select)
				card.show(reservFrame.getContentPane(), "n3");
			else {
				error.setText("인원에 맞게 좌석을 선택하세요!!");
				JOptionPane.showMessageDialog(error, error);
			}

		}
	}

	public class LogoutListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				Statement stmt = conn.createStatement();
				card.show(mainFrame.getContentPane(), "n1");
				mainFrame.setSize(WIN_WIDTH - 80, WIN_HEIGHT - 20);
				stmt.close();

			} catch (SQLException sqlex) {
				System.out.println("SQL 에러 : " + sqlex.getMessage());
				sqlex.printStackTrace();
			} catch (Exception ex) {
				System.out.println("DB Handling 에러(SAVE 리스너) : " + ex.getMessage());
				ex.printStackTrace();
			}
		}
	}

	public class ChangeMovieListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (nextCheck == false) {
				moviePanel1 = new JPanel() {
					public void paintComponent(Graphics g) {
						image1 = new ImageIcon(getClass().getResource(MOVIE4_PIC)).getImage();
						g.drawImage(image1, 0, 0, 300, 380, this);
					}
				};
				moviePanel.add(moviePanel1);
				moviePanel1.setBounds(80, 10, 300, 380);
				moviePanel2 = new JPanel() {
					public void paintComponent(Graphics g) {
						image2 = new ImageIcon(getClass().getResource(MOVIE5_PIC)).getImage();
						g.drawImage(image2, 0, 0, 300, 380, this);
					}
				};
				moviePanel.add(moviePanel2);
				moviePanel2.setBounds(480, 10, 300, 380);
				moviePanel3 = new JPanel();
				moviePanel3.setBackground(Color.black);
				moviePanel.add(moviePanel3);
				moviePanel3.setBounds(880, 10, 300, 380);
				moviePanel1.repaint();
				moviePanel2.repaint();
				moviePanel3.repaint();
				nextCheck = true;

			} else {
				moviePanel1 = new JPanel() {
					public void paintComponent(Graphics g) {
						image1 = new ImageIcon(getClass().getResource(MOVIE1_PIC)).getImage();
						g.drawImage(image1, 0, 0, 300, 380, this);
					}
				};
				moviePanel.add(moviePanel1);
				moviePanel1.setBounds(80, 10, 300, 380);
				moviePanel1.repaint();
				moviePanel2 = new JPanel() {
					public void paintComponent(Graphics g) {
						image2 = new ImageIcon(getClass().getResource(MOVIE2_PIC)).getImage();
						g.drawImage(image2, 0, 0, 300, 380, this);
					}
				};
				moviePanel.add(moviePanel2);
				moviePanel2.setBounds(480, 10, 300, 380);
				moviePanel2.repaint();
				moviePanel3 = new JPanel() {
					public void paintComponent(Graphics g) {
						image3 = new ImageIcon(getClass().getResource(MOVIE3_PIC)).getImage();
						g.drawImage(image3, 0, 0, 300, 380, this);
					}
				};
				moviePanel.add(moviePanel3);
				moviePanel3.setBounds(880, 10, 300, 380);
				moviePanel3.repaint();
				nextCheck = false;

			}
		}
	}

	private void dbConnectionInit() {
		try {
			Class.forName("com.mysql.jdbc.Driver"); 
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pro2", "root", "5236");
			getMoviePercent();
			getPayments();
			prepareList();
			prepareScheduledList();
		} catch (ClassNotFoundException cnfe) {
			System.out.println("JDBC 드라이버 클래스를 찾을 수 없습니다 : " + cnfe.getMessage());
		} catch (Exception ex) {
			System.out.println("DB 연결 에러 : " + ex.getMessage());
		}
	}

	public class JoinButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			joinFrame = new JFrame();
			joinFrame.setTitle("회원가입");
			joinFrame.setSize(800, 700);
			joinFrame.setVisible(true);
			joinFrame.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					joinFrame.setVisible(false);
					joinFrame.dispose();
				}
			});
			joinPanel = new JPanel() {
				public void paintComponent(Graphics g) {
					Image image = new ImageIcon(getClass().getResource(JOIN_PIC)).getImage();
					g.drawImage(image, 0, 0, 800, 700, this);
				}
			};
			joinPanel.setLayout(null);
			joinPanel.setBackground(Color.WHITE);
			text_id = new JTextField(15);
			text_id.setFont(new Font("HYPost", Font.PLAIN, 25));
			text_id.selectAll();
			text_id.setEditable(true);
			text_id.setBounds(200, 130, 200, 60);
			joinPanel.add(text_id);
			text_pw = new JPasswordField(15);
			text_pw.setFont(new Font("HYPost", Font.PLAIN, 25));
			text_pw.setEditable(true);
			text_pw.setBounds(200, 290, 200, 60);
			joinPanel.add(text_pw);
			text_name = new JTextField(15);
			text_name.setFont(new Font("HYPost", Font.PLAIN, 25));
			text_name.selectAll();
			text_name.setEditable(true);
			text_name.setBounds(200, 30, 200, 60);
			joinPanel.add(text_name);
			text_tel = new JTextField(20);
			text_tel.setFont(new Font("HYPost", Font.PLAIN, 25));
			text_tel.selectAll();
			text_tel.setEditable(true);
			text_tel.setBounds(200, 430, 250, 60);
			joinPanel.add(text_tel);
			text_address = new JTextField("Ex)경상남도 창원시");
			text_address.setFont(new Font("HYPost", Font.PLAIN, 25));
			text_address.selectAll();
			text_address.setEditable(true);
			text_address.setBounds(200, 510, 250, 60);
			joinPanel.add(text_address);
			save = new JButton(image24);
			save.setBounds(350, 600, 100, 50);
			save.addActionListener(new SaveButtonListener());
			joinPanel.add(save);
			duplicate = new JButton();
			duplicate.setBounds(400, 135, 80, 50);
			duplicate.addActionListener(new DupButtonListener());
			joinPanel.add(duplicate);
			duplicate.setBorderPainted(false);
			duplicate.setContentAreaFilled(false);
			duplicate.setFocusPainted(false);
			joinFrame.add(joinPanel);

		}
	}

	public class SaveButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Object o = e.getSource();
			if (o == save) {
				try {
					Statement stmt = conn.createStatement();
					stmt.executeUpdate(
							"INSERT INTO person (person_loginid, person_password, person_name, person_tel) VALUES ('"
									+ text_id.getText().trim() + "', '" + text_pw.getText().trim() + "', '"
									+ text_name.getText().trim() + "', '" + text_tel.getText().trim() + "')");
					stmt.close();
					if (dupCheck)//
						joinFrame.setVisible(false);
					else {
						error.setText("아이디 중복 확인을 하세요");
						JOptionPane.showMessageDialog(error, error);
					}
				} catch (SQLException sqlex) {
					System.out.println("SQL 에러 : " + sqlex.getMessage());
					sqlex.printStackTrace();
				} catch (Exception ex) {
					System.out.println("DB Handling 에러(SAVE 리스너) : " + ex.getMessage());
					ex.printStackTrace();
				}
			} else if (o == bSave) {
				try {
					Statement stmt = conn.createStatement(); 
					stmt.executeUpdate("DELETE FROM movie WHERE movie_name = '" + 
							text_movie_name.getText().trim() + "'");

					stmt.executeUpdate(
							"INSERT INTO movie (movie_name, movie_time, movie_studio, movie_percent, movie_opening) VALUES ('"
									+ 
									text_movie_name.getText().trim() + "', '" + text_movie_time.getText().trim()
									+ "', '" + text_movie_studio.getText().trim() + "', '"
									+ text_movie_percent.getText().trim() + "', '" + text_movie_opening.getText().trim()
									+ "')");
					stmt.close();
					prepareList(); 
					int index = movies2.getNextMatch(text_movie_name.getText().trim(), 0, Position.Bias.Forward);
					movies2.setSelectedIndex(index);
				} catch (SQLException sqlex) {
					System.out.println("SQL 에러 : " + sqlex.getMessage());
					sqlex.printStackTrace();
				} catch (Exception ex) {
					System.out.println("DB Handling 에러(SAVE 리스너) : " + ex.getMessage());
					ex.printStackTrace();
				}
			}
		}
	}

	public class NewButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			text_movie_name.setText("");
			text_movie_time.setText("");
			text_movie_studio.setText("");
			text_movie_percent.setText("");
			text_movie_opening.setText("");
			movies2.clearSelection();
		}
	}

	public class DeleteButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				Statement stmt = conn.createStatement(); 
				stmt.executeUpdate("DELETE FROM movie WHERE movie_name = '" + text_movie_name.getText().trim() + "'");
				stmt.close();
				prepareList(); 
			} catch (SQLException sqlex) {
				System.out.println("SQL 에러 : " + sqlex.getMessage());
				sqlex.printStackTrace();
			} catch (Exception ex) {
				System.out.println("DB Handling 에러(DELETE 리스너) : " + ex.getMessage());
				ex.printStackTrace();
			}
		}
	}

	public class LoginButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				String typedId = text_id.getText().trim();
				String typedPw = text_pw.getText().trim();

				Vector<String> list = new Vector<String>();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM person WHERE person_loginid = '" + typedId
						+ "' AND person_password = '" + typedPw + "'");
				while (rs.next()) {
					person_key = (rs.getString("person_id"));
					list.add(rs.getString("person_loginid"));
					list.add(rs.getString("person_password"));
				}
				if (!list.isEmpty()) {
					card.show(mainFrame.getContentPane(), "n2");

				} else {
					error = new JLabel("등록되지 않은 아이디이거나, 잘못된 비밀번호 입니다.");
					JOptionPane.showMessageDialog(error, error);
				}

				stmt.close();
				
			} catch (SQLException sqlex) {
				System.out.println("SQL 에러 : " + sqlex.getMessage());
				sqlex.printStackTrace();
			} catch (Exception ex) {
				System.out.println("DB Handling 에러 : " + ex.getMessage());
				ex.printStackTrace();
			}
			prepareCloseCgvList();
		}
	}

	public class DupButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				String typedId = text_id.getText().trim();
				Vector<String> list = new Vector<String>();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM person WHERE person_loginid = '" + typedId + "'");
				while (rs.next())
					list.add(rs.getString("person_loginid"));
				if (list.isEmpty()) {
					error.setText("사용가능한 아이디입니다.!");
					JOptionPane.showMessageDialog(error, error);
					dupCheck = true;
				} else {
					error.setText("이미 가입된 아이디입니다.");
					JOptionPane.showMessageDialog(error, error);
				}

				stmt.close();
			} catch (SQLException sqlex) {
				System.out.println("SQL 에러 : " + sqlex.getMessage());
				sqlex.printStackTrace();
			} catch (Exception ex) {
				System.out.println("DB Handling 에러 : " + ex.getMessage());
				ex.printStackTrace();
			}

		}
	}

	public class FindButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			findFrame = new JFrame("아이디/비밀번호 찾기");
			findFrame.setSize(700, 1000);
			findFrame.setVisible(true);
			findFrame.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					findFrame.setVisible(false);
					findFrame.dispose();
				}
			});
			findPanel = new JPanel() {
				public void paintComponent(Graphics g) {
					Image image = new ImageIcon(getClass().getResource(FIND_PIC)).getImage();
					g.drawImage(image, -50, 0, 750, 950, this);
				}
			};
			findPanel.setLayout(null);
			findFrame.add(findPanel);
			sId = new JButton();
			sId.setBounds(120, 300, 440, 60);
			findPanel.add(sId);
			sId.setBorderPainted(false);
			sId.setContentAreaFilled(false);
			sId.setFocusPainted(false);
			sId.addActionListener(new SearchIdListener());
			sPw = new JButton();
			sPw.setBounds(120, 760, 440, 60);
			sPw.addActionListener(new SearchPwListener());
			findPanel.add(sPw);
			sPw.setBorderPainted(false);
			sPw.setContentAreaFilled(false);
			sPw.setFocusPainted(false);
			text_name = new JTextField(15);
			text_name.setFont(new Font("HYPost", Font.PLAIN, 20));
			text_name.selectAll();
			text_name.setEditable(true);
			text_name.setBounds(300, 80, 250, 60);
			findPanel.add(text_name);
			name = new JLabel("이름");
			name.setFont(new Font("HYPost", Font.PLAIN, 40));
			name.setBounds(110, 80, 250, 60);
			findPanel.add(name);
			text_tel = new JTextField(20);
			text_tel.setFont(new Font("HYPost", Font.PLAIN, 20));
			text_tel.selectAll();
			text_tel.setEditable(true);
			text_tel.setBounds(300, 180, 250, 60);
			findPanel.add(text_tel);
			tel = new JLabel("전화번호");
			tel.setFont(new Font("HYPost", Font.PLAIN, 40));
			tel.setBounds(110, 180, 250, 60);
			findPanel.add(tel);
			text_id = new JTextField(15);
			text_id.setFont(new Font("HYPost", Font.PLAIN, 20));
			text_id.selectAll();
			text_id.setEditable(true);
			text_id.setBounds(300, 420, 250, 60);
			findPanel.add(text_id);
			id = new JLabel("아이디");
			id.setFont(new Font("HYPost", Font.PLAIN, 40));
			id.setBounds(110, 420, 250, 60);
			findPanel.add(id);
			text_name2 = new JTextField(15);
			text_name2.setFont(new Font("HYPost", Font.PLAIN, 20));
			text_name2.selectAll();
			text_name2.setEditable(true);
			text_name2.setBounds(300, 520, 250, 60);
			findPanel.add(text_name2);
			name = new JLabel("이름");
			name.setFont(new Font("HYPost", Font.PLAIN, 40));
			name.setBounds(110, 520, 250, 60);
			findPanel.add(name);
			text_tel2 = new JTextField(20);
			text_tel2.setFont(new Font("HYPost", Font.PLAIN, 20));
			text_tel2.selectAll();
			text_tel2.setEditable(true);
			text_tel2.setBounds(300, 620, 250, 60);
			findPanel.add(text_tel2);
			tel = new JLabel("전화번호");
			tel.setFont(new Font("HYPost", Font.PLAIN, 40));
			tel.setBounds(110, 620, 250, 60);
			findPanel.add(tel);

		}
	}

	public class SearchIdListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				String typedName = text_name.getText().trim();
				String typedTel = text_tel.getText().trim();
				Vector<String> list = new Vector<String>();
				JLabel success = new JLabel("");
				JLabel success2 = new JLabel("");
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM person WHERE person_name = '" + typedName
						+ "' AND person_tel = '" + typedTel + "'");
				while (rs.next()) {
					success.setText("회원님의 아이디는 " + (rs.getString("person_loginid")) + "입니다.");
					list.add(rs.getString("person_loginid"));
				}
				if (!list.isEmpty())
					JOptionPane.showMessageDialog(null, success);
				else {
					success.setText("가입된 정보가 없습니다.");
					JOptionPane.showMessageDialog(null, success);
				}
				stmt.close();
			} catch (SQLException sqlex) {
				System.out.println("SQL 에러 : " + sqlex.getMessage());
				sqlex.printStackTrace();
			} catch (Exception ex) {
				System.out.println("DB Handling 에러 : " + ex.getMessage());
				ex.printStackTrace();
			}
		}

	}

	public class SearchPwListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				String typedId = text_id.getText().trim();
				String typedName = text_name2.getText().trim();
				String typedTel = text_tel2.getText().trim();
				Vector<String> list = new Vector<String>();
				JLabel success = new JLabel("");
				JLabel success2 = new JLabel("");
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM person WHERE person_name = '" + typedName
						+ "' AND person_tel = '" + typedTel + "' AND person_loginid ='" + typedId + "'");
				while (rs.next()) {
					success.setText("회원님의 비밀번호는 " + (rs.getString("person_password")) + "입니다.");
					list.add(rs.getString("person_password"));
				}
				if (!list.isEmpty())
					JOptionPane.showMessageDialog(null, success);
				else {
					success.setText("가입된 정보가 없습니다.");
					JOptionPane.showMessageDialog(null, success);
				}
				stmt.close();

			} catch (SQLException sqlex) {
				System.out.println("SQL 에러 : " + sqlex.getMessage());
				sqlex.printStackTrace();
			} catch (Exception ex) {
				System.out.println("DB Handling 에러 : " + ex.getMessage());
				ex.printStackTrace();
			}
		}

	}

}
