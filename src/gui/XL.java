package gui;

import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.NORTH;
import static java.awt.BorderLayout.SOUTH;
import gui.menu.XLMenuBar;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JPanel;

import util.XLException;
import model.Sheet;

@SuppressWarnings("serial")
public class XL extends JFrame implements Printable {
	private static final int ROWS = 10, COLUMNS = 8;
	private XLCounter counter;
	private StatusLabel statusLabel = new StatusLabel();
	private XLList xlList;
	private Sheet sheet;
	private SheetPanel sheetPanel;
	private CurrentSlot currentSlot;

	public XL(XL oldXL) {
		this(oldXL.xlList, oldXL.counter);
	}

	public XL(XLList xlList, XLCounter counter) {
		super("Untitled-" + counter);
		sheet = new Sheet();
		this.xlList = xlList;
		this.counter = counter;
		xlList.add(this);
		counter.increment();
		currentSlot = new CurrentSlot();
		JPanel statusPanel = new StatusPanel(statusLabel, currentSlot);
		sheetPanel = new SheetPanel(ROWS, COLUMNS, currentSlot);
		Editor editor = new Editor(this, currentSlot);
		currentSlot.addObserver(editor);
		currentSlot.addObserver(statusLabel);
		add(NORTH, statusPanel);
		add(CENTER, editor);
		add(SOUTH, sheetPanel);
		setJMenuBar(new XLMenuBar(this, xlList, statusLabel));
		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}

	public int print(Graphics g, PageFormat pageFormat, int page) {
		if (page > 0)
			return NO_SUCH_PAGE;
		Graphics2D g2d = (Graphics2D) g;
		g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
		printAll(g2d);
		return PAGE_EXISTS;
	}

	public void rename(String title) {
		setTitle(title);
		xlList.setChanged();
	}

	public static void main(String[] args) {
		new XL(new XLList(), new XLCounter());
	}

	public void saveToFile(String path) throws FileNotFoundException {
		sheet.saveSheetToFile(path);
	}

	public void loadFromFile(String path) throws IOException {
		try {
			sheet.loadSheetFromFile(path);
		} catch(XLException e) {
			statusLabel.setText(e.getMessage());
		}
		
		updateGui();
	}

	public void clearSelectedSlot() {
		try {
			sheet.remove(currentSlot.getAddress());
			updateGui();
		} catch (XLException e) {
			statusLabel.setText(currentSlot.getAddress() + " referas till av en annan ruta! Ändra den först");
		}
	}

	public void clearAllSlots() {
		sheet.clear();
		updateGui();
	}

	public void updateGui() {
		for(SlotLabel slotLabel : sheetPanel.getSlots().getLabeList()) {
			String address = slotLabel.getAddress();
			if(sheet.isComment(address))
				slotLabel.setText(sheet.toString(address).substring(1));
			else {
				try {
					slotLabel.setText(String.valueOf(sheet.value(address)));
				} catch (XLException e) {
					slotLabel.setText("");
				}
			}
		}
	}
	
	public void add(String address, String text) {
		try {
			sheet.add(address, text);
			updateGui();
		} catch (XLException e) {
			statusLabel.updateStatus(e.getMessage());
		}
	}

	public String getStringOfAddress(String address) {
		return sheet.toString(address);
	}
}
