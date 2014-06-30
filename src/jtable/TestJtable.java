package jtable;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;


public class TestJtable {
    private JFrame frame;
    private JPanel panel;
    private JButton addButton,totalSelectedButton;
    private JTable table;
    private TableModel model;
 
 
    public TestJtable(){
        frame = new JFrame("表格测试");
        panel = new JPanel();
        addButton = new JButton("添加");
        totalSelectedButton = new JButton("选中的条目");
        
        //给按钮添加监听器
        addButton.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		// TODO Auto-generated method stub
        		Object[] data = {"张三","zhangsan","column2",false};
        		model.addRow(data);
        		//强制刷新界面
        		table.updateUI();
        	}
        });
        
        //给按钮totalSelectedButton添加监听器
        totalSelectedButton.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		int c=model.getRowCount();
        		System.out.println("被选中的行为：");
        		for(int i=0;i<c;i++) {
        			if((boolean)model.getValueAt(i, 3)==true) {
        				System.out.println(i+1);
        			}
        		}
        	}
        });
        
        model = new TableModel();
        table = new JTable(model);
        
        /*
        table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);;

        table.getColumnModel().getColumn(3).setCellRenderer(new TableCellRenderer(){	 
            //(non-Javadoc)
            //此方法用于向方法调用者返回某一单元格的渲染器（即显示数据的组建--或控件）
            //可以为JCheckBox JComboBox JTextArea 等
            //@see javax.swing.table.TableCellRenderer#getTableCellRendererComponent(javax.swing.JTable, java.lang.Object, boolean, boolean, int, int)
            
            @Override
            public Component getTableCellRendererComponent(JTable table,
                Object value, boolean isSelected, boolean hasFocus,
                int row, int column) {
                // 创建用于返回的渲染组件
                JCheckBox ck = new JCheckBox();
                // 使具有焦点的行对应的复选框选中
                ck.setSelected(isSelected);
                // 设置单选box.setSelected(hasFocus);
                // 使复选框在单元格内居中显示
                ck.setHorizontalAlignment((int) 0.5f);
                return ck;
            }
        });
        */

        /*
        String[]d = {"张三","李四","王五"};
        JComboBox com = new JComboBox(d);
        TableColumnModel tcm = table.getColumnModel();//得到TableModel()
        
        tcm.getColumn(0).setCellEditor(new DefaultCellEditor(com));
        tcm.getColumn(0).setPreferredWidth(50);
        tcm.getColumn(1).setPreferredWidth(100);
        tcm.getColumn(2).setPreferredWidth(50);
        */
        
        JScrollPane pane = new JScrollPane(table);
        panel.add(addButton);
        panel.add(totalSelectedButton);
        panel.add(pane);
        frame.add(panel);
        frame.setVisible(true);
        frame.setBounds(400,200,500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //model.addRow("1","zhangsan", true, "19");
        //table.updateUI();
    }
    /*
    AbstractTableModel:中的抽象方法：
    getColumnCount(),getRowCount(),getValueAt()：
    JTable调用方法updateUI()时，就会执行这些方法。
    updateUI()会把父类中的方法全部执行一遍 
    @author Administrator
    */
    public class TableModel extends AbstractTableModel{
    	private Vector vector = new Vector();
    	private String[] columnNames = {"用户名","密码","是否可用"};
    	private String newColumn="newColumn";
    	
    	@Override
    	public int getColumnCount() {
    		// TODO Auto-generated method stub
    		System.out.println("getColumnCount()");
    		return columnNames.length+1;
    	}
    	
    	@Override
    	public int getRowCount() {
    		// TODO Auto-generated method stub
    		System.out.println("getRowCount()");
    		return vector.size();
    	}
    	
    	@Override
    	public Object getValueAt(int rowIndex, int columnIndex) {
    		// TODO Auto-generated method stub
    		//vector.get(rowIndex);得到的是Object的对象
    		System.out.println("getValueAt()");
    		//System.out.println(((Vector)vector.get(rowIndex)).get(columnIndex));
    		if (columnIndex==3) {
    			return ((Vector)vector.get(rowIndex)).get(columnIndex);
    		}
    		else {
    			return ((Vector)vector.get(rowIndex)).get(columnIndex);
    		}
    	}
    	
    	@Override
    	public String getColumnName(int columnIndex) {
    		System.out.println("getColumnName");
    		if (columnIndex==3) {
    			return newColumn;
    		} else {
    		    return columnNames[columnIndex];
    		}
    	}
 
    	
    	@Override
    	public Class getColumnClass(int columnIndex){
    		return getValueAt(0,columnIndex).getClass();
    	}
    	
    	
    	@Override
    	public boolean isCellEditable(int rowIndex, int columnIndex) {
    		return true;
    	}
 
    	@Override
    	public void setValueAt(Object value, int rowIndex, int columnIndex) {
    		//先删除，在添加
    		System.out.println("setValueAt()");
    		((Vector) vector.get(rowIndex)).remove(columnIndex);
    		((Vector) vector.get(rowIndex)).add(columnIndex,value);
    		this.fireTableCellUpdated(rowIndex, columnIndex);
    	}
    	
    	public TableModel(){
    	
    	}
    	
    	//往行中添加数据----这个方法名可以随意，由用户进行自行调用，否则table.updateUI()是不会自动调用的
    	public void addRow(Object[] data){
    		int size = data.length;
    		Vector v = new Vector();
    		for(int i=0; i<size; i++){
    			v.add(data[i]);
    		}
    		vector.add(v);
    	}
    }
    
    //程序的入口
    public static void main(String[] args){
    	new TestJtable();
    }
}
