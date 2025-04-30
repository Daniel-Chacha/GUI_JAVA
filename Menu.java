//Java program that create a command menu siimilar to the one in Microsoft word
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import  javax.swing.JMenuItem;
import java.awt.FlowLayout;


public class  Menu extends  JFrame{
    private JMenuBar menuBar;
    private JMenu fileMenu, editMenu, insertMenu, layoutMenu, helpMenu,externalMenu;
    private JMenuItem mniNew, mniOpen, mniSaveAs, mniSave , mniExport, mniImport, mniPrint, mniShare, mniClose, mniCopy,mniCut, mniPaste, mniDelete, mniShapes, mniPictures, mniIcons, mniCharts, mniVideos, mniPage, mniMargins, mniOrientation, mniColumn, mniSize, mniUserManual, mniReddit, mniContact ;


    public Menu(){
        super();
        
        menuBar = new JMenuBar();
        fileMenu = new JMenu("File");
        editMenu = new JMenu("Edit");
        insertMenu = new JMenu("Insert");
        layoutMenu = new JMenu("Layout");
        helpMenu = new JMenu("Help");
        externalMenu = new JMenu("External");

        mniNew =new JMenuItem("New");               mniOpen  = new JMenuItem("Open");      
        mniSave = new JMenuItem("Save");            mniSaveAs = new JMenuItem("Save As");       
        mniImport = new JMenuItem("Import");        mniExport = new JMenuItem("Export");        
        mniPrint = new JMenuItem("Print");          mniShare = new JMenuItem("Share");      
        mniClose = new JMenuItem("Close");          mniCopy= new JMenuItem("Copy");     
        mniPaste = new JMenuItem("Paste");          mniDelete = new JMenuItem("Delete");        
        mniShapes = new JMenuItem("Shapes");        mniPictures = new JMenuItem("Pictures");        
        mniIcons = new JMenuItem("Icons");          mniCharts = new JMenuItem("Charts");        
        mniVideos = new JMenuItem("Videos");        mniPage = new JMenuItem("Page");        
        mniMargins = new JMenuItem("Margins");      mniOrientation = new JMenuItem("Orientation");      
        mniColumn = new JMenuItem("Columns");       mniSize = new JMenuItem("Size");        
        mniUserManual = new JMenuItem("User Manual");       mniReddit = new JMenuItem("Reddit");        
        mniContact = new JMenuItem("Contact");

        setJMenuBar(menuBar);
        menuBar.add(fileMenu);      menuBar.add(editMenu);      menuBar.add(insertMenu);
        menuBar.add(layoutMenu);    menuBar.add(helpMenu);      

        fileMenu.add(mniNew);       fileMenu.add(mniOpen);      fileMenu.add(mniSave);
        fileMenu.add(mniSaveAs);    fileMenu.add(mniImport);    fileMenu.add(mniExport);
        fileMenu.add(mniPrint);     fileMenu.add(mniShare);     fileMenu.add(mniClose);

        editMenu.add(mniCopy);      editMenu.add(mniPaste);     editMenu.add(mniDelete);

        insertMenu.add(mniShapes);  insertMenu.add(mniPictures);    insertMenu.add(mniIcons);
        insertMenu.add(mniCharts);  insertMenu.add(mniVideos);      insertMenu.add(mniPage);

        layoutMenu.add(mniMargins); layoutMenu.add(mniOrientation);     layoutMenu.add(mniColumn);
        layoutMenu.add(mniSize);    layoutMenu.add(mniUserManual);     

        externalMenu.add(mniReddit);        externalMenu.add(mniContact);

        helpMenu.add(mniUserManual);    helpMenu.add(externalMenu);

        setVisible(true);
        setSize(300,200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Dashboard");
        setLayout(new FlowLayout());
    }

    public static void main(String[] args) {
        new Menu();
    }
}