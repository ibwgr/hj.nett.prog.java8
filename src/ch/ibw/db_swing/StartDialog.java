package ch.ibw.db_swing;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Set;

/**
 * Created by Nett on 14.01.2017.
 */
public class StartDialog extends JFrame {

    private Container c = null;
    private JTextArea txtfldCmd = null;
    private JComboBox cbxTables = null;
    private JComboBox cbxDb = null;
    private HashMap sqlCmds = null;
    private DbAccess dbAccess = null;
    private JTable table = null;
    private boolean deactivate = false;

    public StartDialog(){

        dbAccess = new DbAccess();
        sqlCmds = fillSqlCommandList();

        c = getContentPane();
        c.add(BorderLayout.EAST,createComboboxPanel());
        c.add(BorderLayout.CENTER,createJTableScoller());
        c.add(BorderLayout.SOUTH, createCommandBox());
    }

    private JPanel createComboboxPanel(){
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(160,450));
        panel.setLayout(new FlowLayout());

        cbxDb = new JComboBox();
        cbxDb.addItem("Pizzakurier");
        cbxDb.addItem("Rollo");
        cbxDb.setPreferredSize(new Dimension(150,30));
        panel.add(cbxDb);

        JButton btnConnect = new JButton("Connect");
        btnConnect.setPreferredSize(new Dimension(150,25));
        btnConnect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deactivate = true;
                String [] tables = dbAccess.getTableNames(cbxDb.getSelectedItem().toString());
                fillTableList(tables);
                deactivate = false;
                refreshJTable();
            }
        });
        panel.add(btnConnect);

        cbxTables = new JComboBox();
        cbxTables.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!deactivate) {
                    refreshJTable();
                }
            }
        });
        cbxTables.setPreferredSize(new Dimension(150,30));
        panel.add(cbxTables);

        JComboBox cbxSqlCmd = new JComboBox(getSqlCmdList());
        cbxSqlCmd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sel = cbxSqlCmd.getSelectedItem().toString();
                String cmd = (String) sqlCmds.get(sel);
                txtfldCmd.setText(cmd);
            }
        });
        cbxSqlCmd.setPreferredSize(new Dimension(150,30));
        panel.add(cbxSqlCmd);

        return panel;
    }

    private Box createCommandBox(){
        Box box = new Box(BoxLayout.X_AXIS);
        txtfldCmd = new JTextArea();
        txtfldCmd.setPreferredSize(new Dimension(500,100));
        box.add(txtfldCmd);
        JButton btnExecute = new JButton("Ausführen");
        btnExecute.setPreferredSize(new Dimension(160,25));
        btnExecute.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                refreshJTable(txtfldCmd.getText());
            }
        });
        box.add(btnExecute);

        return box;
    }

    private JScrollPane createJTableScoller(){
        table = new JTable();
        JScrollPane scroller = new JScrollPane(table,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        return scroller;
    }

    private HashMap fillSqlCommandList(){

        HashMap map = new HashMap();
        map.put("Abfrage 1","SELECT s.vorname, s.nachname, t.zeit\n" +
                "FROM Spieler s\n" +
                "\tJOIN tor t ON(s.id = t.spieler_id)\n" +
                "WHERE t.zeit < 65");
        map.put("Abfrage 2","SELECT s.vorname, s.nachname,s.nation_land, t.zeit AS minute_des_Tores\n" +
                "FROM Spieler s\n" +
                "\tJOIN tor t ON(s.id=t.spieler_id)\n" +
                "\tJOIN spiel sp ON (s.nation_land=sp.team1 OR s.nation_land=sp.team2)\n" +
                "WHERE sp.zuschauer BETWEEN 30000 AND 40000\n" +
                "ORDER BY s.nation_land");

        return map;
    }

    private String[] getSqlCmdList(){

        Set keyset = sqlCmds.keySet();
        String[] keys = new String[keyset.size()];
        int idx = 0;
        for(Object o : keyset){
            keys[idx]= o.toString();
            idx++;
        }
        return keys;
    }

    private void fillTableList(String[] tables){
        cbxTables.removeAllItems();
        for(String table : tables){
            cbxTables.addItem(table);
        }
    }

    private void refreshJTable(){
        TableModel model = dbAccess.getTableModel(cbxDb.getSelectedItem().toString(), cbxTables.getSelectedItem().toString());
        table.setModel(model);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
    }

    private void refreshJTable(String cmd){
        TableModel model = dbAccess.getTableModelFromCmd(cbxDb.getSelectedItem().toString(), cmd);
        table.setModel(model);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
    }


    public static void main(String[] args) {
        StartDialog dlg = new StartDialog();
        dlg.setTitle("Datenbank lesen");
        dlg.setSize(750,500);
        dlg.setVisible(true);
        dlg.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
